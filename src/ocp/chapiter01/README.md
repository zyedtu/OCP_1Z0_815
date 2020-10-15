										WELCOME TO JAVA
# JRE n'existe plus:
Dans java 11, le JRE n'est plus disponible en tant que sous-r�pertoire du JDK. Les gens peuvent utiliser le JDK complet lors de l'ex�cution d'un programme java. JRE permet d'excuter un programme java mais pas de le compliler.   
le JRE est un subset du JDK.

# TLS: (Long Time Support)
Oracle a annonc� un changement radical dans le cycle de release de Java. Il y aura dor�navant une release majeure tous les 6 mois, une mineure tous les 2 mois et une LTS (Long Time Support) tous les 3 ans

#Ecrire le m�thdde main():
- Pour v�rifier le version du java, on lance cette commande: **java -version**   
-  On �crit cette m�thode dans un fichier Zoo.java:   

			public class Zoo {    
				public static void main(String[] args) {    
			       System.out.println("Hello Zoo");   
				}    
			}  
    
Le mot cl� 'public'est ce qu'on appelle un modificateur d'acc�s. Il d�clare le niveau d'exposition de cette m�thode aux acteurs potentiels du programme.   
			 
le mot cl� 'static' lie une m�thode � sa classe afin qu'elle puisse �tre appel�e uniquement par le nom de la classe, comme dans, par exemple, Zoo.main (). 
    
La m�thode main() permet � la JVM d'appeler notre code.

Le m�thode main(), recoit une liste de param, represent�e sous forme d'un tableau de string (String[]).  

# Passing param to a java Program:  

	 public class Zoo {    
			public static void main(String[] args) {    
		       System.out.println(args[0]);     
			   System.out.println(args[1]);   
			}    
		}    

javac Zoo.java    
java Zoo "San Diego" Zoo   
=> Cela affiche :   
 "San Diego"    
 Zoo    
 
# Lancer un programme sur une seule ligne:  
� partir de java 11, vous pouvez ex�cuter un programme sans compiler, c-a-d sans taper la commande javac.  
 
	public class Zoo {    
			public static void main(String[] args) {    
		       System.out.println(args[0]);     
			}    
		}   	
On peut ex�cuter note programme Zoo sans le compil�.  
java Zoo.java Cleveland    

cette fonctionnalit� (one-liner), ex�cute le programmes de code source � un seul fichier.  

# Comprendre la declaration des package et les imports:
Java a besoin d'un moyen d'organiser les classes.Il g�re cela d'une mani�re similaire � un classeur. Vous mettez tous vos morceaux de papier dans un dossier. Java met des classes dans des packages. Ce sont des regroupements logiques pour les classes.
   
*import* java.util.Random; //import nous indique o� trouver Random   

**Wildcards**:  
les classes d'un m�me package sont souvent import�es ensemble. Vous pouvez utiliser un raccourci pour importer toutes les classes du package. 
 
	import java.util.*; // import la class Random ainsi que toutes les classes de ce packages.  

On a ces imports:  

	import java.nio.file.Files;   
	import java.nio.file.Paths;   

* Certaines importations qui ne **fonctionnent** pas:  

	 import java.nio.*; // le Wildcard correspond q'avec le nom de la classe.  
	 import java.nio.*.*; // on peut avoir qu'un seul Wildcard et doit etre � la fin de l'import.  
	 import java.nio.file.Paths.*; // On peut pas importer des m�thode que des classes.  
 
**Redundant Import**:  
java.lang est un package sp�cial il est automatiqument import�, donc c'est redondant de l'importer. 
  
	import java.util.Random;  
	import java.util.*; // ici c'est redondant parce que la class Random est import� avec le premier import.  

** Naming Conflicts:**   

Parmis les raison d'utiliser les packages est le nom de la classe ne soit pas unique dans un projet !ajva. Par exemple:  

	import java.util.Date; // ou java.util.*;    
	import java.sql.Date;  // ou java.sql.*;   
	
	public class Conflicts {  
	   Date date;  
	}  

Ce code **ne compile pas**, on a un conflit, en fait le compilateur java ne peut pas deviner quelle classe va utiliser, pour remidier a ce probl�me on deux solution:
* Soit on supprime un des deux imports.  
* Soit on garde une seule declaration explicite de classe:  
	
	import java.util.Date;  
	import java.sql.*;   
=>Ah, maintenant �a marche. Si vous importez explicitement un nom de classe, il est **prioritaire** sur tous les caract�res g�n�riques pr�sents. Java pense: "Le programmeur veut vraiment que j'assume l'utilisation de la classe java.util.Date."   

# Cr�er un nouveau package:  
Vous apprendrez java beaucoup plus facilement en utilisant la ligne de commande pour compiler et tester vos exemples.   
Une fois que vous connaissez bien la syntaxe Java, vous pouvez passer � un IDE.  

Nous cr�ons deux fichier ClassA.java et ClassB.java sur ce chemin:   
C:\temp\packagea\ClassA.java et C:\temp\packageb\ClassB.java   
on va sous le repertoir C:\tmp    

	package packagea;       
	public class ClassA {   
		public static void main(String[] args) {     
			System.out.println(args[0]);    
		}   
	}    
	
	package packageB;
	import packagea.ClassA;       
	public class ClassB {   
		public static void main(String[] args) {     
			ClassA a;    
		}   
	} 
 
* Pour compiler:   
**javac** packagea/ClassA packageb/ClassB   

* Pour ex�cuter: (nous sous dans le r�petoire C:\temp\ un cran avant le package)    
**java** packagea.ClassA packageb.ClassB   

* Si on va sous le repertoir C:\temp\packagea et on essaye d'ex�cuter le programme de la classA on aura une erreure d'ex�cution: "   java.lang.NoClassDefFoundError: packagea\ClassA  "   
   
**Exemple 2:** (Account.java)

	package ocp.chapiter1;
	public class Account {
		public static void main(String[] args) {
			System.out.println("Hello 1 2 3 testing...");
		}
	}

	/OCP-EXAMS-1Z0-815/src/ocp/chapiter1/> javac Account.java
Un fichier Account.class est cr�e dans le meme repertoire.

	/OCP-EXAMS-1Z0-815/src/ocp/chapiter1/> java Account
R�sultat:
*Error: Could not find or load main class Account*
*Caused by: java.lang.NoClassDefFoundError: ocp/chapiter1/Account (wrong name: Account)*
Par d�faut, le compilateur Java compile le fichier source java et place le fichier classe dans le meme dossier que le fichier source. Mais le commande que lance la JVM s'attend que le fichier .class se trouvedans un chemin de repertoire qui imite le nom de package.

Pour que cet exemple compile il faut se deplacer dans: 

	/OCP-EXAMS-1Z0-815/src/> java ocp.chapiter1.Account   
R�sultat: *Hello 1 2 3 testing...*
     
#####Utilisation d'un autre r�pertoire:  

Par d�faut la commande javac place les classes compil�es dans leurs repertoires sources, en revanche il existe une option pour placer le fichiers class complil�s dans un repertoire diff�rent, -d demande au compilateur de cr�er la structure de repertoires selon le nom du package de la classe et de placer  le fichier dans repertoir cible (targer directory) c'est pour �a -d (directory).   

	javac -d classes packagea/ClassA packageb/ClassB   

L� on a comme r�sultat:  
*C:\temp\classes\packagea\ClassA.class* **et** *C:\temp\classes\packageb\ClassB.class*   

pour ex�cuter le programme, vous sp�cifiez le chemin d'acc�s aux classes (classpath) pour que Java sache o� trouver les classes.    

	java -cp classes packageb.ClassB //on met la classe qui a la m�thode main()
		OU
	java -classpath classes packageb.ClassB
		OU
	java --class-path classes packageb.ClassB

Exemple2: 

	$ javac -d . Account.java
cette commande copie *Account.class* **sous**  *ocp/chapiter1*, pour ex�cute le programme en fait:

	java -cp . ocp.chapiter1.Account
	
# Compiling with JAR Files:  

	java -cp "c:\tmp\maJarFile.jar" MyPackage.MyClass    
##### Creating Jar File:   
On peut cr�er une jar par nous meme, en utilisant la commande jar avec deux fa�on:
  
	jar -cvf myNewFile.jar <=> jar --create --verbose --file myNewFile.jar  

##### How run a Jar file: 

	java -jar file.jar

# Order elements in a Class:
____________________________________________________________________________
|				    |					 |					 |							    |   
| **Element**		|   **Exemple** 	 |	 **Obligatoire** | **ordere dans la classe**	|   
|___________________|____________________|___________________|______________________________|    
|				    |					 |					 |								|
| package		    | package abc;	     | Non				 | premier �l�ment	            |
|___________________|____________________|___________________|______________________________|
|					|					 |					 |                              |	
| import			| import java.util.*;| Non				 | juste ap�s le package        |
|					|				     |			         | s'il est present	            |
|___________________|____________________|___________________|______________________________|
|					|				     |					 |								|
| class			    | puplic class A	 | Oui               |juste ap�s l'import  			|
|					|				     |			         | s'il est present				|
|___________________|____________________|___________________|______________________________|   
|					|				     |					 |								|
| champs et		    | int a;			 |  Non 	         | Dans la classe				|
| m�thodes		    | void method(){}	 |					 |								|
|___________________|____________________|___________________|______________________________|
 

