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
### Creating the Files:    
### Compiling Our First Module:   
### Running Our First Module:
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