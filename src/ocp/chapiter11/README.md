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
![Alt text](figure 11.png?raw=true "Title")  
![Alt text](https://github.com/zyedtu/OCP_1Z0_815/blob/master/src/ocp/chapiter11/figure%2011.png?raw=true "Title")      
Passons maintenant à l’un de ces modules. La figure ci-dessous montre ce qu'il y a à l'intérieur du module zoo.animals.talks. Il existe trois packages avec deux classes chacun. (C'est un petit zoo.) Il existe également un fichier étrange appelé module-info.java. Ce fichier doit être à l'intérieur de tous les modules. Nous expliquerons cela plus en détail plus loin dans le chapitre.    
![Alt text](figure 12.png?raw=true "Title")   
### Benefits of Modules:
# Creating and Running a Modular Program:
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