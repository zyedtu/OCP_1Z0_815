								JAVA BUILDING BLOCKS 
								
# Creating object:  
Pour cr�er une instance de classe, il suffit d'ecrire le mot **new <nom_de_classe>()**, comme ci-dessous:   
Park p = new Park();  
Park est le type de variable, p une referance sur un objet de type Park et Park() le constructeur. 

#####Ex�cution de blocs d'initialisation d'instance:   

Lorsque vous avez d�couvert les m�thodes, vous avez vu des accolades ({}) le code entre les accolades s'appelle un bloc de code. Partout o� vous voyez des accolades se trouve un bloc de code.   
Parfois le bloc de code (*code block*) est dans une m�thode, il sera ex�cut� quand on appelle la m�thode, autre moment en dehors de la m�thode, il s'appelle  initialiseur d'instance **instance initializer**.   

##### Suite � l'ordre d'initialisation: (Following Order of initialisation) (voir code  OcpTest1)  
 
Quand on ecrit ce code ci-dessous:

		public class OcpTest1 {
			private String name = "fluffy";
			{System.out.println("setting field " + name);}
			
			public OcpTest1() {
				name = "Tiny";
				System.out.println("setting constructor");
			}
		
			public static void main(String[] args) {
				OcpTest1 ocpTest1 = new OcpTest1();
				System.out.println(ocpTest1.name);
			}
		}
Ex�cutant ce code:

	setting field fluffy
	setting constructor
	Tiny
losqu'on cr�e l'objet avec *new OcpTest1()*, java intialise l'attribut name = "fulffy" en premier lieu, epr�s ex�cute le bloc d'initialisation et � la fin il appelle constructure et set name="Tiny".  

#Understing data type:  

Dans les applications java, il y a deux types de variable, type primitive et type de r�f�rance:

##### Type Primitive: (voir code  OcpTest2)   

* boolean: peut avoir deux valeurs true ou false.
* type num�ric sans floating-point (d�cimal): byte, short, int et long (123L) 
* type num�ric avec floating_point (d�cimal): float(123.45f), double 
* char: 'a'

Tous les type num�ric sont sign�s peuvent avoir une valuer n�gative, int x = -128   

Pour l'**examen**, sachez que short et char sont �troitement li�s, les deux type sont sur 16-bit, la difference entre les deux que short est sign� mais char non sign�. 

##### Ecrire les Literals:

il y a une choses que vous devez savoir sur les primitives num�riques. Lorsqu'un nombre est pr�sent dans le code, il est appel� un *literal*.

	float f = 15.14f; // c'est literal

	long max = 3123456789; // Don't compile
	long max = 3123456789l; //compile c'est un literal 

Une autre fa�on de sp�cifier des nombres est de **changer la base**, 
* Octal (digits 0-7): le nombre � un pr�fix "0" *(int amount = 0156;)*
* Hexadecimal (digits 0-9 et A-F): le nombre � un pr�fixe "0x" *(int amount = 0xE;)*  
* Binary (digit 0-1): le nombre � un pr�fixe "0b" *(int amount = 0b101;)*   

	int dec = 110;            // no prefix   --> decimal literal
	int bin = 0b1101110;      // '0b' prefix --> binary literal
	int oct = 0156;           // '0' prefix  --> octal literal
	int hex = 0x6E;           // '0x' prefix --> hexadecimal literal   

La derni�re chose qu'il faut savoir sur les literal num�rique, on peut ajouter le underscores dans un nombre. 

		int million1 = 1000000;
		int million2 = 1_000_000;// COMPILE
		double notAtStart = _1000.00; // DOES NOT COMPILE
		double notAtEnd = 1000.00_; // DOES NOT COMPILE
		double notByDicimal = 1000_.00; // DOES NOT COMPILE
		double notAtStart = 1________2; // COMPILE
		double notAtStart = 10_0_0.0_0; //  COMPILE

#Declaring variable:  

Une variable est un nom pour un morceau de m�moire qui stocke des donn�es.   

	int numberAnimals; // numberAnimals une variable de type int
Une fois qu'on a d�clar� une variable on lui donne une valuer, et l� on parle d'initialiser une variable.  

	 int numberAnimals = 100; 
##### Identifier les identifiants (Identifying identifiers):  (OcpTest3)  

Java a mit des r�gles pr�cises sur le nom de l'identifiant, Un **identifiant** est le nom d'une variable, m�thode, classe, interface ou package. Heureusement, les r�gles relatives aux identificateurs de variables s'appliquent � tous les autres types que vous �tes libre de nommer.  
* Les identificatiant doivent commencer par une lettre, un symbole $ ou un symbole _  
* Les identifiants peuvent inclure des chiffres mais ne doivent pas commencer des chiffres  
* Depuis Java 9, un seul underscore _ n'est pas autoris� comme identifiant  
* On peut utilier les mots r�serv� au Java, comme case, default, switch,etc..  

Java a instaurer une convention pour nommer les identifiants.
* Style camelCase: thisIsMyClass   
* Style sanke_case: this_is_my_class  
  
#Initialisatin variable:(Initializing Variables)  

Avant de pouvoir utiliser une variable, elle a besoin d'une valeur. Certains types de variables 
obtiennent automatiquement cette valeur, et d'autres n�cessitent que le programmeur la sp�cifie. 
Dans les sections suivantes, nous examinerons les diff�rences entre les valeurs par d�faut des 
variables locales, les variable d'instance et variables de classe.

##### Cr�er des variables locales: (Creating local variables)  

Une variable locale est variable d�finie dans un constructeur, m�thode ou un bloc d'intialisation.  
Une variable localen n'a pas une valuer par d�faut est **doit** etre initialis�e.  

	public int notValid() {
		int y = 10;
		int x;
		int reply = x + y; // DOES NOT COMPILE
		return reply;
	}
Ce code ne compile pas parce que la variable x est utilis�e sans etre initialis�e.  

##### Passer des param�tres de constructeur et de m�thode: (Passing constructor and method parameters)  

Les variables pass�es � un constructeur ou � une m�thode sont appel�es param�tres de constructeur 
ou param�tres de m�thode, respect. Ces param�tres sont des variables locales qui ont �t� 
pr�-initialis�es.  

	public void findAnswer(boolean check) {}
		
	public void checkAnswer() {
		boolean value;
		findAnswer(value);// DOES NOT COMPILE
	}
L'appel de findAnwer ne compile pas par ce que la variable value n'etait pas initialis�e.  

##### D�finition des variables d'instance et de classe: (Defining instance and class variables)  

* Une variable d'instance, et appeler aussi un champ, est une valeur d�finie dans une instance 
sp�cifique d'un objet.   
* Une variable de classe: une variable de classe est une variable d�finie au niveau 
de la classe et partag�e entre toutes les instances de la classe. une variable de classe est
caractiriser par le mot cl� **static** avant la variable.    

	public class OcpTest4 {
		private String name; // instance variable 
		private static float temp; // class variable
	}
les variables d'instance ou de classe, n'est pas obligatoire de l'insialis�es. D�s que vous d�clarez 
ces variables, une valeur par d�faut leur est attribu�e.  

	boolean  				    	false
	byte, short, int, long  	    0
	float, double 			 	    0.0
	char 					    	'\u0000' (NULL)
	All Object references   	    null
##### Pr�sentation de var: (Introducing var)  

� partir de Java 10, vous avez la possibilit� d'utiliser le mot-cl� var au lieu du type de variable 
locale sous certaines conditions. Pour utiliser cette fonctionnalit�, vous tapez simplement var au 
lieu du type primitif ou r�f�rence. Voici un exemple:  

	public void whatTypeAmI() {
		var name = "Hello";
		var size = 7;
	}
Le nom formel de cette fonctionnalit� est *l'inf�rence de type de variable locale*.   

	public class OcpTest4 {
		var tricky = "Hello"; // DOES NOT COMPILE
	}
Ce code ne compile pas par ce que cette fonctionnalit�e concerne que les varaible **locale**.  

##### Inf�rence de type de var: (Type inference of var)  

Maintenant que vous comprenez la partie variable locale, il est temps de passer aux signification 
d'inf�rence de type. la bonne nouvelle est que cela signifie �galement � quoi cela ressemble. 
Lorsque vous tapez var, vous demandez au compilateur de d�terminer le type pour vous. 
Le compilateur examine le code sur la ligne de la d�claration et l'utilise pour d�duire le type. 
Jetez un �il � cet exemple:   

	public void reassignment() {
		var number = 7;
		number = 4;
		number = "five"; // DOES NOT COMPILE
	}
Dans le premi�re ligne, le compilateur d�termine que le variable number est de type int, le deuxi�me
ligne on affecte le variable par 4, mais dans le 3em ligne on affecte par un String c'est pas le 
meme type int donc ne compile pas.  
Par souci de simplicit�, lorsque nous aborderons var dans la section suivante, nous allons 
supposer qu'une instruction de d�claration de variable est compl�t�e en une seule ligne.
Par exemple, vous pouvez ins�rer un saut de ligne entre le nom de la variable et son initialisation.  

	public void breakingDeclaration() {
			var number 
			= 7;
	}  

##### Exemples avec var:  

	public void doesThisCompile(boolean check) {
		var question; // DOES NOT COMPILE
		question = 1;
	}
Ce code ne compile pas, N'oubliez pas que pour l'inf�rence de type de variable locale, 
le compilateur ne regarde que la ligne avec la d�claration. comme question ne re�oit pas de valeurs 
sur la ligne o� elle est d�finie, le compilateur ne sait pas ce qui en fait.   

	public void notValid() {
		int a, var b= 3; // DOES NOT COMPILE
		var x = 2, y = 8; // DOES NOT COMPILE
		var n = null; // DOES NOT COMPILE
	}
Java n'autorise pas var � la d�claration de plusieurs variables.  
Les concepteurs de Java ont d�cid� qu'il serait pr�f�rable de ne pas autoriser la valeur null pour 
var plut�t  que de deviner l'intention.  

alors qu'un var ne peut pas �tre initialis� avec une valeur nulle, il peut se voir attribuer une 
valeur nulle apr�s sa d�claration, � condition que le type sous-jacent du var soit un objet.    

	public void varAndNull() {
		var n = "myData";
		n = null;
		var m = 4;
		var m = null; // DOES NOT COMPILE
		var var = 7.1; // COMPILE
	} 
##### R�vision des r�gles var: (Review of var Rules) 
Nous compl�tons cette section en r�sumant toutes les diff�rentes r�gles d'utilisation de var dans 
votre code.  
1. Un var est utilis� comme variable **locale**.    
2. Un var ne peut pas �tre utilis� dans les param�tres du constructeur, les param�tres de m�thode  
3. Le var est toujours initialis� sur la m�me ligne (ou instruction) o� il est d�clar�    
4. La valeur de var peut changer, mais pas le type  
5. Un var ne peut pas etre initialiser avec la valuer null  
6. Un var n'autorise pas la declaration multiple des variables  
7. Un var est un nom de type r�serv� mais pas un mot r�serv�, ce qui signifie qu'il peut �tre 
utilis� comme identificateur sauf comme nom de classe, d'interface ou d'�num�ration  

#Managing variable scoop:  

Vous avez appris que les variables locales sont d�clar�es dans une m�thode. Combien de variables 
locales voyez-vous dans cet exemple:  

	public void eat(int piecesOfCheese) {
		int bitesOfCheese = 1;
	}
Il y a deux variables locales {piecesOfCheese et bitesOfCheese}  

##### Limiter la port�e: (Limiting Scope)  

Les variables locales ne peuvent jamais avoir une port�e plus grande que la m�thode dans laquelle 
elles sont d�finies. Cependant, elles peuvent avoir une port�e plus petite.  

	public void eatifHungry(boolean hungry) {
		if(hungry) {
			int bitesOfCheese = 1;
		}// bitesOfCheese goes out of scope here
		System.out.println(bitesOfCheese);// DOES NOT COMPILE
	}
La variable hungry a une port�e de la m�thode enti�re, tandis que la variable bitesOfCheese a une 
port�e plus petite. Il n'est disponible que pour une utilisation dans l'instruction if dans 
laquelle il est d�clar�.  

##### Imbrication port�e: (Nesting scope)  

N'oubliez pas que les blocs peuvent contenir d'autres blocs. Ces petits blocs contenus peuvent 
r�f�rencer des variables d�finies dans les grands blocs de port�e, mais pas l'inverse. Voici un 
exemple:   

	public void eatifHungry(boolean hungry) {
		if(hungry) {
			int bitesOfCheese = 1;
			{
				var teenyBit = true;
				System.out.println(bitesOfCheese);
			}
		}
		System.out.println(teenyBit);// DOES NOT COMPILE
	}
##### Application de port�e aux classes: (Applying Scope to Classes)  

Tout cela �tait pour les variables locales. Heureusement, la r�gle des variables d'instance est plus
simple: elles sont disponibles d�s qu'elles sont d�finies et durent toute la dur�e de vie de 
l'objet lui-m�me.  

	public class Mouse{
		final static int MAX_LENGTH = 5;
		int length;
		public void grow(int inches) {
			if(length < MAX_LENGTH) {
				int newSize = length + inches;
				length = newSize;
			}
		}
	}
##### R�vision de la port�e: (Reviewing Scope)  

Vous avez tout �a? Passons en revue les r�gles de port�e.  
* Variables locales: dans la port�e de la d�claration � la fin du bloc
* Variables d'instances: Dans la port�e de la d�claration jusqu'� l'objet �ligible pour le garbage
collection  
* Variables de classes: Dans la port�e de la d�claration jusqu'� la fin du programme  

# Destroying Object:  

Maintenant que j'ai jou� avec nos objets, il est temps de les ranger. Heureusement, la JVM s'en 
charge automatiquement pour vous. Java fournit un garbage collector pour rechercher automatiquement
les objets qui ne sont plus n�cessaires.  

##### Comprendre la collecte des ordures: (Understanding Garbage Collection)  

Le garbage collection fait r�f�rence au processus de lib�ration automatique de la m�moire sur le 
tas **heap** en supprimant les objets qui ne sont plus accessibles dans votre programme. Il existe 
de nombreux algorithmes diff�rents pour le ramasse-miettes, mais vous n'avez pas besoin d'en 
conna�tre pour l'examen. Si vous �tes curieux, cependant, un alghorithme est de garder un compteur 
sur le nombre de lieux o� un objet est accessible � un moment donn� et de le marquer comme �ligible 
pour le ramasse-miettes si le compteur atteint jamais z�ro.  

##### �ligible � la collecte des ordures: (Eligible for Garbage Collection)  

En tant que d�veloppeur, la partie la plus int�ressante du garbage collection est de d�terminer 
quand la m�moire appartenant � un objet peut �tre r�cup�r�e. En Java et dans d'autres langages, 
�ligible pour le garbage collection fait r�f�rence � l'�tat d'un objet de ne plus �tre accessible 
dans un programme et donc capable d'�tre garbage collection.  
Un objet est **eligible pour le garbage collection**, cela ne veut pas dire qu'il sera imm�daitement
d�truit de la m�moire. Lorsque l'objet est r�ellement supprim� n'est pas sous votre contr�le, 
mais pour l'examen, vous devrez savoir � tout moment quels objets sont �ligibles pour le garbage 
collection.  

Pensez � l'�ligibilit� au ramassage des ordures comme � l'exp�dition d'un colis. Vous pouvez 
prendre un article, le sceller dans une bo�te �tiquet�e et le mettre dans votre bo�te aux lettres. 
Cela revient � rendre un article �ligible au garbage collection, mais lorsque le facteur vient 
le chercher, ce n'est pas sous votre contr�le. 

En tant que programmeur, la chose la plus importante que vous puissiez faire pour limiter les 
probl�mes de m�moire insuffisante est de vous assurer que les objets sont �ligibles pour GC une 
fois qu'ils ne sont plus n�cessaires. il est de la responsabilit� de la JVM d'actualiser le GC   

##### Appel System.gc(): (Calling System.gc())  

Java inclut une m�thode int�gr�e pour aider � prendre en charge le garbage collection qui peut �tre appel� � tout moment.  

	public static void main(String[] args) {
		System.gc();
	}
Quel est le r�le garanti de **la commande System.gc()** ? Rien, en fait.  
System.gc() **sugg�re** simplement que la JVM de lancer le garbage collection, La JVM peut effectuer un garbage collection � ce moment-l� ou non. La JVM est libre d'ignorer la demande  
 
##### Tracage Eligibilit�: (Tracing Eligibility)  

Comment la JVM sait-elle quand un objet est �ligible pour le garbage collection? la JVM attend patiemment et surveille chaque objet jusqu'� ce qu'elle d�termine que le code n'a plus besoin de cette m�moire. Un objet restera sur le tas (heap) jusqu'� ce qu'il n'est plus acc�ssible. Un objet n'est plus accessible lorsque l'une des deux situations se produit:
* L'objet n'a plus de r�f�rences pointant vers lui  
* Toutes les r�f�rences � l'objet sont hors de port�e  

	public class Scope {
		public static void main(String[] args) {
			String one, two;
			one = new String("a");
			two = new String("b");
			one = two;
			String three = one;
			one = null;
		}
	}
Dans le m�moire on a deux objets de types String "a" et "b".   
Avec l'instruction one = two, l'objet "a" est eligible pour la premier fois en GC, et apres on a les 3 references pointent sur le'objet "b".  
avec l'instruction one = null, aucune refenrence qui pointe vers "b", donc � son toure l'objet est eligible pur GC.    


