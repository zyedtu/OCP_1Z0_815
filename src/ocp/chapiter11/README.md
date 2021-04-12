						MODULES
			

Depuis **Java 9**, les packages peuvent être regroupés **en modules**. Dans ce chapitre, nous expliquerons le but des modules et comment créer les vôtres. Nous montrerons également comment les exécuter et comment découvrir les modules existants. Ce livre ne couvre que les bases des modules que vous devez connaître pour le 1Z0-815.    		
# Introducing Modules:    
Lors de la rédaction du code pour l'examen, vous voyez généralement de petites classes. Après tout, les questions d'examen doivent tenir sur un seul écran! Lorsque vous travaillez sur de vrais programmes, ils sont beaucoup plus gros. Un vrai projet sera composé de centaines ou de milliers de classes regroupées en packages. Ces packages sont regroupés dans des fichiers d'archive Java (JAR). Un JAR est un fichier zip avec des informations supplémentaires, et l'extension est ".jar".     
En plus du code écrit par votre équipe, la plupart des applications utilisent également du code écrit par d'autres. L'open source est un logiciel avec le code fourni et son utilisation est souvent gratuite. Java possède une communauté de logiciels open source (OSS) dynamique, et ces bibliothèques sont également fournies sous forme de fichiers JAR. Par exemple, il existe des bibliothèques pour lire des fichiers, se connecter à une base de données et bien plus encore.    

Certains projets open source dépendent même des fonctionnalités d'autres projets open source. Par exemple, Spring est un framework couramment utilisé et JUnit est une bibliothèque de test couramment utilisée. Pour utiliser l'un ou l'autre, vous devez vous assurer que vous disposiez de versions compatibles de tous les JAR pertinents disponibles au moment de l'exécution. Cette chaîne complexe de dépendances et de versions minimales est souvent appelée par la communauté l'enfer JAR. Hell est un excellent moyen de décrire la mauvaise version d'une classe en cours de chargement ou même une exception ClassNotFoundException au moment de l'exécution.     	

Le Java Platform Module System **(JPMS)** a été introduit dans Java 9 pour regrouper le code à un niveau supérieur et tente de résoudre les problèmes auxquels Java est confronté depuis le début. L'objectif principal d'un module est de fournir des groupes de packages associés pour offrir un ensemble particulier de fonctionnalités aux développeurs. C’est comme un fichier JAR, sauf qu’un développeur choisit les packages accessibles en dehors du module. Voyons ce que sont les modules et quels problèmes ils sont conçus pour résoudre.     

Le système de module de plate-forme Java comprend les éléments suivants:    
* Un format pour les fichiers JAR du module.  
* Partitionnement du JDK en modules.   
* Options de ligne de commande supplémentaires pour les outils Java.  

### Exploring a Module:     
Dans le chapitre 1, «Bienvenue dans Java», nous avions une petite application Zoo. Il n'y avait qu'une seule classe et affiche qu'une seule chose. Imaginez maintenant que nous avions toute une équipe de programmeurs et que nous automatisions les opérations du zoo. De nombreux éléments doivent être codés, notamment les interactions avec les animaux, les visiteurs, le site Web public et la sensibilisation.     
Un *module* est un groupe d'un ou plusieurs packages plus un fichier spécial appelé *module-info .java*. La Figure ci-dessous ne répertorie que quelques-uns des modules dont un zoo peut avoir besoin. Nous avons décidé de nous concentrer sur les interactions animales dans notre exemple. Le zoo complet pourrait facilement avoir une douzaine de modules. Dans la figure ci-dessous, notez qu'il y a des flèches entre de nombreux modules. Ceux-ci représentent des dépendances où un module s'appuie sur du code dans un autre. Le personnel doit nourrir les animaux pour conserver leur emploi. La ligne allant de zoo.staff à zoo.animal.feeding montre que le premier dépend du second.    
![Alt text](https://github.com/zyedtu/OCP_1Z0_815/blob/master/src/ocp/chapiter11/figure%2011.png?raw=true "Title")        
Passons maintenant à l’un de ces modules. La figure ci-dessous montre ce qu'il y a à l'intérieur du module zoo.animals.talks. Il existe trois packages avec deux classes chacun. (C'est un petit zoo.) Il existe également un fichier étrange appelé module-info.java. Ce fichier doit être à l'intérieur de tous les modules. Nous expliquerons cela plus en détail plus loin dans le chapitre.    
![Alt text](https://github.com/zyedtu/OCP_1Z0_815/blob/master/src/ocp/chapiter11/figure%2012.png?raw=true "Title")     
### Benefits of Modules:   
Les modules ressemblent à une autre couche de choses que vous devez savoir pour programmer. Bien que l'utilisation des modules soit facultative, il est important de comprendre les problèmes qu'ils sont censés résoudre. De plus, il faut savoir pourquoi les modules sont utiles pour l'examen !   
##### Better Access Control : (Meilleur contrôle d'accès)    
Dans le chapitre 7, «Méthodes et encapsulation», vous avez vu les quatre niveaux traditionnels de contrôle d'accès disponibles dans Java 8: accès privé, privé, protégé et public. Ces niveaux de contrôle d'accès vous permettaient de restreindre l'accès à une certaine classe ou package. Vous pouvez même autoriser l'accès aux sous-classes sans les exposer au monde.   

Cependant, que se passerait-il si nous écrivions une logique complexe que nous voulions restreindre à quelques paquets seulement? Par exemple, nous aimerions que les packages du module zoo.animal.talks soient uniquement disponibles pour les packages du module zoo.staff sans les rendre disponibles pour aucun autre code. Nos modificateurs d'accès traditionnels ne peuvent pas gérer ce scénario.    

Les développeurs auraient recours à des hacks comme nommer un paquet zoo.animal.internal. Cela n'a cependant pas fonctionné, car d'autres développeurs pouvaient toujours appeler le code "interne". Il y avait une classe nommée sun.misc.Unsafe, et elle a été utilisée par endroits. Et cette classe avait Unsafe dans le nom. De toute évidence, s'appuyer sur les conventions de dénomination était insuffisant pour empêcher les développeurs de l'appeler dans le passé.    

Les modules résolvent ce problème en agissant comme un cinquième niveau de contrôle d'accès. Ils peuvent exposer des packages du JAR modulaire à d'autres packages spécifiques. Cette forme d'encapsulation plus forte crée vraiment des packages internes. Vous verrez comment le coder lorsque nous parlerons du fichier module-info.java plus loin dans ce chapitre.  
##### Clearer Dependency Management: (Gestion plus claire des dépendances)     
Il est courant que les bibliothèques dépendent d'autres bibliothèques. Par exemple, la bibliothèque de test JUnit 4 dépend de la bibliothèque Hamcrest pour la logique de correspondance. Les développeurs devraient le découvrir en lisant la documentation ou les fichiers du projet lui-même.   
Si vous avez oublié d'inclure Hamcrest dans votre chemin de classe, votre code fonctionnera correctement jusqu'à ce que vous utilisiez une classe Hamcrest. Ensuite, il exploserait au moment de l'exécution avec un message indiquant que vous ne trouviez pas une classe requise. (Nous avons mentionné l'enfer de JAR, non ?)     
Dans un environnement entièrement modulaire, chacun des projets open source spécifierait ses dépendances dans le fichier module-info.java. Lors du lancement du programme, Java se plaindrait que Hamcrest ne se trouve pas dans le chemin du module et que vous le saviez tout de suite.    
##### Custom Java Builds: (Constructions Java personnalisées)   
Le kit de développement Java (JDK) fait plus de 150 Mo. Même l'environnement d'exécution Java (JRE) était assez volumineux lorsqu'il était disponible en téléchargement séparé. Dans le passé, Java a tenté de résoudre ce problème avec un profil compact. Les trois profils compacts fournissaient un sous-ensemble des classes Java intégrées, de sorte qu'il y aurait un package plus petit pour les appareils mobiles et embarqués.   

Cependant, les profils compacts manquaient de flexibilité. De nombreux packages ont été inclus que les développeurs étaient peu susceptibles d'utiliser, tels que Java Native Interface (JNI), qui permet de travailler avec des programmes spécifiques au système d'exploitation. Dans le même temps, l'utilisation d'autres packages comme Image I/O nécessitait le JRE complet.      

Le Java Platform Module System permet aux développeurs de spécifier les modules dont ils ont réellement besoin. Cela permet de créer une image d'exécution plus petite qui est personnalisée en fonction des besoins de l'application et rien de plus. Les utilisateurs peuvent exécuter cette image sans avoir installé Java du tout.   

Un outil appelé jlink est utilisé pour créer cette image d'exécution. Heureusement, il vous suffit de savoir que des temps d'exécution plus petits personnalisés sont possibles. La façon de les créer est hors de portée de l'examen.
En plus du package à plus petite échelle, cette approche améliore la sécurité. Si vous n'utilisez pas AWT et qu'une faille de sécurité est signalée pour AWT, les applications qui ont empaqueté une image d'exécution sans AWT ne sont pas affectées.   
##### Improved Performance: (Performance améliorée)    
Puisque Java sait maintenant quels modules sont requis, il lui suffit de les regarder au moment du chargement de la classe. Cela améliore le temps de démarrage des gros programmes et nécessite moins de mémoire pour s'exécuter.    
Bien que ces avantages ne semblent pas significatifs pour les petits programmes que nous écrivons, ils sont bien plus importants pour les grandes applications. Une application Web peut facilement prendre une minute pour démarrer. De plus, pour certaines applications financières, chaque milliseconde de performance est importante.     
##### Unique Package Enforcement: (Application de paquet unique)    
Une autre manifestation de l'enfer JAR est lorsque le même package est dans deux JAR. Il existe un certain nombre de causes à ce problème, notamment le changement de nom des JAR, les développeurs intelligents utilisant un nom de package déjà pris et le fait d'avoir deux versions du même JAR sur le chemin de classe.    
Le système de module de plate-forme Java empêche ce scénario. Un package ne peut être fourni que par un seul module. Fini les mauvaises surprises sur un package au moment de l'exécution.       
# Creating and Running a Modular Program:   
Dans cette section, nous allons créer, construire et exécuter le module zoo.animal.feeding. Nous avons choisi celui-ci pour commencer car tous les autres modules en dépendent. La figure ci-dessous montre la conception de ce module. En plus du fichier module-info.java, il contient un package avec une classe à l'intérieur.    
![Alt text](https://github.com/zyedtu/OCP_1Z0_815/blob/master/src/ocp/chapiter11/figure%2013.png?raw=true "Title")  

Dans la section suivante, nous allons créer, compiler, exécuter et empaqueter le module zoo.animal.feeding.   
### Creating the Files:    
Tout d'abord, nous avons une classe très simple qui affiche une ligne dans une méthode main(). Nous savons que ce n’est pas vraiment une mise en œuvre. Tous ces programmeurs que nous avons embauchés peuvent le remplir avec une logique métier. Dans ce livre, nous nous concentrerons sur ce que vous devez savoir pour l'examen. Alors, créons une classe simple.    

	package ocp.chapiter11.feeding.zoo.animal.feeding;
	
	public class Task {
		public static void main(String[] args) {
			System.out.println("All fed!");
		}
	
	}

Vient ensuite le fichier *module-info.java*. C'est la version la plus simple possible.   

	module zoo.animal.feeding {
	}  
Il existe quelques différences clés entre un fichier d'informations de module et une classe Java standard:   
* Le fichier module-info doit se trouver dans le répertoire racine de votre module. Les classes Java standard doivent être dans des packages.   
* Le fichier module-info doit utiliser le mot-clé module au lieu de class, interface ou enum.    
* Le nom du module suit les règles de dénomination des noms de package. Il comprend souvent des points (.) Dans son nom. Les noms de classe et de package normaux ne sont pas autorisés à avoir des tirets (-). Les noms de module suivent la même règle.   

C'est beaucoup de règles pour le fichier le plus simple possible. Il y aura beaucoup plus de règles lorsque nous étofferons ce fichier plus tard dans le chapitre.
* Remarque: (Un fichier module-info.java peut-il être vide ?) Oui. Pour simplifier, il était légal de compiler n'importe quel fichier vide avec une extension .java avant même les modules. Le compilateur voit qu'il n'y a pas de classe là-dedans et quitte sans créer de fichier .class.    

L'étape suivante consiste à vous assurer que les fichiers sont dans la bonne structure de répertoires. La figure ci-dessous montre la structure de répertoires attendue.  
![Alt text](https://github.com/zyedtu/OCP_1Z0_815/blob/master/src/ocp/chapiter11/figure%2014.png?raw=true "Title")

En particulier, alimentation est le répertoire du module, et le fichier info-module se trouve directement en dessous. Tout comme avec un fichier JAR normal, nous avons aussi le paquet zoo.animal.feeding avec un sous-dossier par portion du nom. La classe Task se trouve dans le sous-dossier approprié pour son package.    
Notez également que nous avons créé un répertoire appelé mods au même niveau que le module. Nous l'utiliserons pour stocker les artefacts du module un peu plus loin dans le chapitre. Ce répertoire peut être nommé n'importe quoi, mais mods est un nom courant. Si vous suivez l'exemple de code en ligne, notez que le répertoire mods n'est pas inclus, car il est vide.   
### Compiling Our First Module:    
Avant de pouvoir exécuter du code modulaire, nous devons le compiler. Autre que l'option module-path, ce code devrait vous sembler familier à partir du chapitre 1:   

	javac --module-path mods 
		 -d feeding 
		 feeding/zoo/animal/feeding/*.java 
		 feeding/module-info.java
En guise de révision, l'option -d spécifie le répertoire dans lequel placer les fichiers de classe. La fin de la commande est une liste des fichiers .java à compiler. Vous pouvez répertorier les fichiers individuellement ou utiliser un caractère générique pour tous les fichiers .java d'un sous-répertoire.   
La nouvelle partie est le chemin du module. Cette option indique l'emplacement de tous les fichiers de module personnalisé. Dans cet exemple, module-path pourrait avoir été omis car il n'y a pas de dépendances. Vous pouvez penser que module-path remplace l'option classpath lorsque vous travaillez sur un programme modulaire.  
* What Happened to the Classpath ? (Qu'est-il arrivé au Classpath): Dans le passé, vous référençiez les fichiers JAR à l'aide de l'option classpath. Il avait trois formes possibles: -cp, -class-path et -classpath. Vous pouvez toujours utiliser ces options dans Java 11. En fait, il est courant de le faire lors de l'écriture de programmes non modulaires.     

Tout comme classpath, vous pouvez utiliser une abréviation dans la commande. La syntaxe --module-path et -p sont équivalentes. Cela signifie que nous aurions pu écrire de nombreuses autres commandes à la place de la commande précédente. Les quatre commandes suivantes affichent l'option -p:   

	javac -p mods -d feeding feeding/zoo/animal/feeding/*.java feeding/*.java
	
	javac -p mods -d feeding feeding/zoo/animal/feeding/*.java feeding/module-info.java
	
	javac -p mods -d feeding feeding/zoo/animal/feeding/Task.java feeding/module-info.java
	
	javac -p mods -d feeding feeding/zoo/animal/feeding/Task.java feeding/*.java
Bien que vous puissiez utiliser celui que vous préférez, assurez-vous de pouvoir reconnaître tous les formulaires valides pour l'examen. Le tableau ci-dessous répertorie les options que vous devez bien connaître lors de la compilation de modules. Il existe de nombreuses autres options que vous pouvez passer à la commande javac, mais ce sont celles sur lesquelles vous pouvez vous attendre à être testées.       

|        Utiliser pour              |      Abréviation      |  Forme longue        |
|-----------------------------------|:---------------------:|---------------------:|
| Répertoire des fichiers de classe |  -d <dir>             | n/a                  |
| Chemin du module                  |  -p <path>            | --module-path <path> |   
### Running Our First Module: (Exécuter notre premier module)  
Avant de conditionner notre module, nous devons nous assurer qu'il fonctionne en l'exécutant. Pour ce faire, nous devons apprendre la syntaxe complète. Supposons qu'il existe un module nommé book.module. À l'intérieur de ce module se trouve un package nommé com.sybex, qui a une classe nommée OCP avec une méthode main(). La Figure ci-dessous montre la syntaxe pour exécuter un module. Faites particulièrement attention à la partie book.module/com.sybex.OCP. Il est important de se rappeler que vous spécifiez le nom du module suivi d'une barre oblique (/) suivie du nom de classe complet.  
![Alt text](https://github.com/zyedtu/OCP_1Z0_815/blob/master/src/ocp/chapiter11/figure%20145.png?raw=true "Title")  

Maintenant que nous avons vu la syntaxe, nous pouvons écrire la commande pour exécuter la classe Task dans le package zoo.animal.feeding. Dans l'exemple suivant, le nom du package et le nom du module sont identiques. Il est courant que le nom du module corresponde au nom complet du package ou au début de celui-ci.   
### Packaging Our First Module:
# Updating Our example for Multiple Modules:
### Updating the Feeding Module:
### Creating a Care Module:
### Creating the talks Module:
### Creating the Staff Module:
# Diving into the module-info File:  
### export:
### requires transitive: 
### provides, uses, and opens
# Discovering Modules:
### The java Command:
### The jar Command:
### The jdeps Command:
### The jmod Command:
# Reviewing Command-Line Options: