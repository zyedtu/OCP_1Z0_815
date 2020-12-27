											CLASS DEDIGN
									
À la base, une conception de classe Java appropriée concerne la réutilisabilité du code, une fonctionnalité accrue et la standardisation. Par exemple, en créant une nouvelle classe qui étend une classe existante, vous pouvez accéder à un grand nombre de primitives, d'objets et de méthodes hérités. Sinon, en concevant une interface standard pour votre application, vous vous assurez que toute classe qui implémente l'interface dispose de certaines méthodes requises définies. Enfin, en créant des définitions de classe abstraites, vous définissez une plate-forme que d'autres développeurs peuvent étendre et utiliser.   					
# Comprendre l'héritage: (Understanding Inheritance)  
Lors de la création d'une nouvelle classe en Java, vous pouvez définir la classe à hériter d'une classe existante. L'héritage est le processus par lequel la nouvelle sous-classe enfant inclut automatiquement toutes les primitives, objets ou méthodes publics ou protégés définis dans la classe parente.  
À des fins d'illustration, nous nous référons à toute classe qui hérite d'une autre classe en tant que classe enfant, ou un descendant de cette classe. Alternativement, nous nous référons à la classe dont l'enfant hérite en tant que classe parent, ou ancêtre de la classe. Si l'enfant X hérite de la classe Y, qui à son tour hérite de la classe Z, alors X serait considéré comme un enfant indirect, ou descendant, de la classe Z.  
 
Dans le dernier chapitre, vous avez appris qu'il existe quatre niveaux d'accès: public, protégé, package-private et private. Lorsqu'une classe hérite d'une classe parent, tous les membres publics et protégés sont automatiquement disponibles dans le cadre de la classe enfant. Les membres package-private sont disponibles si la classe enfant est dans le même package que la classe parent. Dernier point mais n, les membres privés sont restitués à la classe dans laquelle ils sont définis et ne sont jamais disponibles via inheritane. Cela ne signifie pas que la classe parente n'a pas de membres privés qui peuvent contenir des données ou modifier un objet, cela signifie simplement que la classe enfant n'a aucune référence directe àces memebres. 

Regardons cet exemple avec les classes BigCat et Jaguar:

		public class BigCat {
			public double size;
		}
		
		public class Jaguar extends BigCat {
			public Jaguar() {
				size = 10.2;
			}
			
			public void printDetails() {
				System.out.println();
			}
		}
Dans la classe Jaguar, la variable "size" est accessible car elle est marquée publique. Par héritage, la sous-classe Jaguar peut lire ou écrire "size" comme si elle était son propre membre
### Héritage unique vs multiple: (Single vs. Multiple Inheritance)  
Java prend en charge **l'héritage unique** (single inheritance), par lequel une classe peut hériter d'une seule classe parente directe. Java prend également en charge plusieurs niveaux d'héritage, par lesquels une classe peut étendre une autre classe, qui à son tour étend une autre classe. Vous pouvez étendre une classe un nombre illimité de fois, ce qui permet à chaque descendant d’accéder aux membres de ses ancêtres.  
Pour vraiment comprendre l'héritage unique, il peut être utile de le comparer à l'héritage multiple, par lequel une classe peut avoir plusieurs parents directs. Par conception, Java ne prend pas en charge l'héritage multiple dans le langage, car des études ont montré que l'héritage multiple peut conduire à des modèles de données complexes et souvent difficiles à gérer. Java autorise une exception à la règle d'héritage unique: les classes peuvent implémenter plusieurs interfaces, comme vous le verrez plus loin dans le chapite 9.  
### Objet hérité: (Inheriting Object)  
Tout au long de notre discussion sur Java dans ce livre, nous avons jeté de nombreuses fois le mot objet - et avec raison. En Java, toutes les classes héritent d'une seule classe: *java.lang.Object*, ou Object en abrégé. De plus, Object est la seule classe qui n'a pas de classe parente.   
Vous vous demandez peut-être: "Aucune des classes que j'ai écrites jusqu'à présent n'étend Object, alors comment toutes les classes en héritent-elles ?". 
La réponse que le compilateur a inséré automatiquement du code dans toute classe que vous écrivez qui n'étend pas une classe spécifique. Par exemple, considérez les deux définitions de classe équivalentes suivantes:

	public class Zoo {}
	
	public class Zoo extends java.lang.Object {}
Lorsque Java voit que vous définissez une classe qui n'étend pas une autre classe, ajoute automatiquement la syntaxe *extends java.lang.Object* à la définition de classe. Le résultat est que chaque classe accède à toutes les méthodes accessibles de la classe Object. Par exemple, les méthodes toString () et equals () sont disponibles dans Object, par conséquent, elles sont accessibles dans toutes les classes. Sans être redéfinit dans une sous-classe, elles ne peuvent ne pas être bien utiles, nous couvrirons les méthodes de redéfinition plus loin dans ce chapitre.  
D'un autre côté, lorsque vous définissez une nouvelle classe qui étend une classe existante, Java n'étend pas automatiquement la classe Object. Comme toutes les classes héritent d'Object, l'extension d'une classe existante signifie que l'enfant hérite déjà d'Object par définition. Si vous regardez la structure d'héritage de n'importe quelle classe, elle se terminera toujours par Object en haut de l'arborescence, comme le montre la figure.  

		java.lang.Object
				^
				|
			........
				Mammal
				^
				|
				Ox				
# Créer des classes: (Creating Classes)  
Maintenant que nous avons établi le fonctionnement de l'héritage en Java, nous pouvons l'utiliser pour définir et créer des relations de classe complexes. Dans cette section, nous passerons en revue les bases de la création et de l'utilisation des classes.  
### Extension d'une classe: (Extending a Class)   
En Java, vous pouvez étendre une classe en ajoutant le nom de la classe parent dans la définition à l'aide du mot clé extend. La syntaxe de définition et d'extension d'une classe est affichée ci-dessous:  

	public abstract class ElephantSeal extends Seal {
		// Methods and Variables defined here
	}
* public: public or default access modifier
* abstract: abstract or final keyword (optional)
* class: class keyword (required)
* ElephantSeal: class name
* extends Seal: extends parent class (optional)

Comme Java n'autorise qu'une seule classe publique par fichier, nous pouvons créer deux fichiers, Animal.java et Lion.java, dans lesquels la classe Lion étend la classe Animal. En supposant qu'ils sont dans le même package, une instruction d'importation n'est pas requise dans Lion.java pour accéder à la classe Animal.
Voici le contenu d'Animal.java:  

		public class Animal {
			 private int age;
			 protected String name;
			 
			 public int getAge() {
				 return age;
			 }
			 
			 public void setAge(int age) {
				 this.age = age;
			 }
		}
Et voici le contenu de Lion.java:

	public class Lion extends Animal {
	
		 public void setProperties(int age, String n) {
			 setAge(age);
			 name = n;
			 
		 }
		 private void roar() {
			 System.out.println(name + ", age " + getAge() + ", says: Roar!");
		}
		 
		public static void main(String[] args) {
			var lion = new Lion();
			lion.setProperties(3, "kio");
			lion.roar();
		}
	}
Le mot clé extend est utilisé pour exprimer que la classe Lion hérite de la classe Animal. Une fois exécuté, le programme Lion affiche les éléments suivants: *kio, age 3, says: Roar!*  

Jetons un coup d'œil aux membres de la classe Lion. La variable d'instance age est marquée comme privée et n'est pas directement accessible depuis la sous-classe (subclass) Lion. Par conséquent, ce qui suit ne compilerait pas:

	public class Lion extends Animal {
		private void roar() {
		System.out.println("The "+age+" year old lion says: Roar!");
	 	// DOES NOT COMPILE
	  }
    }
La variable "age" n'est pas accessible directement parce qu'elle marqué privée dans la classe Animal, en revanche elle est accessible indirectement via setAge et getAge méthodes.
La variable name est accessible directement parce qu'elle est protected dans la classe Animal.  
### Application des modificateurs d'accès aux classes: (Applying Class Access Modifiers) 
Vous pouvez appliquer des modificateurs d'accès (public, privé, protégé, par défaut) aux méthodes de classe et aux variables. Ce n'est pas surprenant que vous puissiez également appliquer des modificateurs d'accès aux définitions de classe, puisque nous avons ajouté le modificateur d'accès public à presque toutes les classes jusqu'à présent.  
En Java, une classe de niveau supérieur est une classe qui n'est pas définie dans une autre classe. La plupart des cours de ce livre sont des cours de haut niveau.  
Ils ne peuvent avoir qu'un accès public ou package-privé. L'application d'un accès public à une classe indique qu'elle peut être référencée et utilisée dans n'importe quelle classe. L'application de l'accès par défaut (package-private), dont vous vous souviendrez est l'absence de tout modificateur d'accès, indique que la classe n'est accessible que par une classe dans le même package.   
* Remarque: Une classe interne est une classe définie à l'intérieur d'une autre classe (au contraire d'une classe de premier niveau). En plus de l'accès public et package-privé, les classes internes peuvent également avoir un *accès protégé et privé*. Nous discuterons des classes internes au chapitre 9.

Un fichier Java peut avoir plusieurs classes de premier-niveau mais une seule classe de premier niveau avec l'accés public. En fait, il se peut qu'il n'y ait aucune classe publique du tout. L'un des avantages de l'utilisation du modificateur private de package par défaut est que vous pouvez définir plusieurs classes dans le même fichier Java. Par exemple, la définition suivante peut apparaître dans un seul fichier Java nommé Groundhog.java, car il ne contient qu'une seule classe public:  

		class Rodent {}
		public class Groundhog extends Rodent {}
Si on ajoute devant la classe Rodent le modificateur d'accés public le fichier Groundhog.java ne se compilerait, pour corriger ça on doit la classe Rodent était déplacée vers son propre fichier Rodent.java.  
### Accéder à cette "this" référence: (Accessing the this Reference) 
Que se passe-t-il lorsqu'un paramètre de méthode porte le même nom qu'une variable d'instance existante ? Jetons un œil à un exemple. Que pensez-vous que le programme suivant affiche ?  

		public class Flamingo {
		
			private String color;
			
			public void setColor(String color) {
				color = color;
			}
			public static void main(String[] args) {
				Flamingo f = new Flamingo();
				f.setColor("PINK");
				System.out.println(f.color);
			}
		}
Ce code affiche "null", Java utilise la portée la plus granulaire (pécis), donc quand on a fait color = color, on a assigné la valeur du paramètre de méthode par lui-même, et la variable d'instance color n'est jamais était modifier, c'est pour cela on afficher null dans la méthode main().   
Le correctif lorsque vous avez une variable locale avec le même nom qu'une variable d'instance consiste à utiliser la référence "this" ou le mot-clé "this".  
La référence *this* fait référence à l'instance actuelle de la classe et peut être utilisée pour accéder à n'importe quel membre de la classe, y compris les membres hérités. Il peut être utilisé dans n'importe quelle méthode d'instance, constructeur et bloc d'initialisation d'instance. Il ne peut pas être utilisé lorsqu'il n'y a pas d'instance implicite de la classe, comme dans une méthode statique ou un bloc d'initialisation statique. Nous appliquons *this* à notre implémentation précédente de methos comme suit: 

			public void setColor(String color) {
				this.color = color;
			}
Le code corrigé imprimera maintenant PINK, Dans de nombreux cas, la référence *this* est facultative. Si Java rencontre une variable ou une méthode qu'il ne trouve pas, il vérifiera la hiérarchie des classes pour voir si elle est disponible.  
Voyons maintenant quelques exemples qui ne sont pas courants mais que vous pourriez voir à l'examen:  

	public class Duck {
	
		private String color;
		private int height;
		private int length;
		
		public void setData(int length, int theHeight) {
			length = this.height; // Backward - no good
			height = theHeight;	// Fine because a different name
			this.color = "white";	// Fine, but this not necessary
		}
		public static void main(String[] args) {
			Duck b = new Duck();
			b.setData(1, 2);
			System.out.println(b.length +" " + b.height + " " + b.color);
		}
	}
Ce code affiche: *0 2 white*    
### Appel de la super référence: (Calling the super Reference)    
En Java, une variable ou une méthode peut être définie à la fois dans une classe parent et dans une classe enfant. Lorsque cela se produit, comment référencer la version dans la classe parente au lieu de la classe actuelle ?
Pour ce faire, vous pouvez utiliser la référence ou le mot-clé *super*. La super référence est similaire à la référence *this*, sauf qu'elle exclut tous les membres trouvés dans la classe actuelle. En d'autres termes, le membre doit être accessible via l'héritage. La classe suivante montre comment appliquer *super* pour utiliser deux variables avec le même nom dans une méthode:  

		class Mammal{
			String type = "mammal";
		}

		public class Bat extends Mammal{		
			String type = "bat";
			public String getType() {
				return super.type + ":" + this.type;
			}
			public static void main(String[] args) {
				System.out.println(new Bat().getType());
			}
		}
Le programme affiche *mammal:bat*
Que pensez-vous si la *super référence* était supprimée ? le programme affichera *bat:bat*
Javautilise la portée la plus étroite possible-dans ce cas la variable "type" définie dans la classe Bat. 

Voyons si vous avez compris this et super. Que produit le programme suivant ?

	class Insect {
		protected int numberOfLegs = 4;
		String label = "buggy";
	}
	public class Beetle extends Insect{
		protected int numberOfLegs = 4;
		short age = 3;
		public void printData() {
			System.out.println(this.label);	// buggy
			System.out.println(super.label);	// buggy
			System.out.println(this.age);	// 3
			System.out.println(super.age);	// DOES Not Compile
			System.out.println(super.numberOfLegs);		// 4
			System.out.println(super.numberOfLegs);	// 6
		}
		public static void main(String[] args) {
			new Beetle().printData();
		}
	}
* Ce code ne compile.
* label: est definit dans la classe parent, cette variable est accessible à la fois par this et super référence.  
* age: est définit seulement dans la classe fille, donc elle est accissible via le mot clé this et non super, et pour cela le programme ne compile pas.
* numberOfLegs: est définit dans la classe mère est fille, donc avec super.numberOfLegs on accède à la classe mère et super.numberOfLegs pour accéder à la classe fille. 

# Déclarer les constructeurs: (Declaring Constructors)  
Comme vous l'avez appris au chapitre 2, un constructeur est une méthode spéciale qui correspond au nom de la classe et qui n'a pas de type de retour. Il est appelé lorsqu'une nouvelle instance de la classe est créée. Pour l'examen, vous aurez besoin de connaître de nombreuses règles sur les constructeurs. Dans la section, nous montrerons comment créer un constructeur. Ensuite, nous examinerons les constructos par défaut, la surcharge des constructeurs, l'appel des constructeurs parents, les champs final et l'ordre d'initialisation dans une classe.  
### Créer un constructeur: (Creating a Constructor)  
Commençons par un constructeur simple:  

		public class Bunny {
			public Bunny() {
				System.out.println("constructor");
			}
		}
Le nom du constructeur, Bunny, correspond au nom de la classe, Bunny, et il n'y a pas de *type de retour*, pas même void. Cela en fait un constructeur.   
Pouvez-vous dire pourquoi ces deux constructeurs ne sont pas valides pour la classe Bunny ?

		public bunny() { } // DOES NOT COMPILE
		public void Bunny() { }
Le premier ne correspond pas au nom de la classe car Java est sensible à la casse. Comme il ne correspond pas, Java sait qu'il ne peut pas être un constructeur et qu'il est censé être une méthode régulière. Cependant, il manque le type de retour et ne compile pas.  
La deuxième méthode est une méthode parfaitement bonne, mais n'est pas un constructeur car elle a un type de retour.
Comme les paramètres de méthode, les paramètres de constructeur peuvent être n'importe quel type de classe, tableau ou primitif valide, y compris les génériques, mais peuvent ne pas inclure var. ce qui suit ne compile pas:  

		class Bonobo {
			public Bonobo(var food) {	// DOES NOT COMPILE
			}
		}
Une classe peut avoir plusieurs constructeurs, à condition que chaque constructeur ait une signature unique. Dans ce cas, cela signifie que les paramètres du constructeur doivent être distincts. Comme les méthodes avec le même nom mais avec des signatures différentes, la déclaration de plusieurs constructeurs avec des signatures différentes est appelée surcharge de constructeur. La classe Turtle suivante a quatre constructeurs surchargés distincts:

		public class Turtle {
			private String name;
			
			public Turtle() {
				name = "John Doe";
			}
			public Turtle(int age) {}
			public Turtle(long age) {}
			public Turtle(String newName, String... favoriteFoods) {
				name = newName;
			}
		}
Les constructeurs sont utilisés lors de la création d'un nouvel objet. Ce processus est appelé instanciation car il crée une nouvelle instance de la classe. Un constructeur est appelé lorsque nous écrivons *new* suivi du nom de la classe que nous voulons instancier. Par exemple:

	new Turtle()
Lorsque Java voit le mot-clé *new*, il alloue de la mémoire pour le nouvel objet. Java recherche également un constructeur et l'appelle.
### Constructeur par défaut: (Default Constructor)  
Chaque classe en Java a un constructeur, que vous en codiez un ou non. Si vous n'incluez aucun constructeur dans la classe, Java en créera un pour vous sans aucun paramètre.  
Ce constructeur créé par Java est appelé le constructeur par défaut et est ajouté à chaque fois qu'une classe est déclarée sans aucun constructeur. Nous l'appelons souvent le constructeur sans arguments par défaut pour plus de clarté. Voici un exemple:  

		public class Rabbit {
			public static void main(String[] args) {
				Rabbit rabbit = new Rabbit(); // Calls default constructor
			}
		}
Dans la classe Rabbit, Java voit qu'aucun constructeur n'a été codé et en crée un. Ce constructeur par défaut équivaut à taper ceci:  

		public Rabbit() {}
Le constructeur par défaut a une liste de paramètres vide et un corps vide. Il est juste que vous saisissiez cela en vous-même. Cependant, comme il ne fait rien, Java se fera un plaisir de vous le fournir et de vous éviter de taper.
Nous n'arrêtons pas de dire généré. Cela se produit pendant l'étape de *compilation*. Si vous regardez le fichier avec l'extension .java, le constructeur sera toujours manquant. Ce n'est que dans le fichier compilé avec l'extension.class qu'il fait son apparition.
N'oubliez pas qu'un constructeur par défaut n'est fourni que s'il n'y a pas de constructeur présent. Selon vous, laquelle de ces classes a un constructeur par défaut ?

		class Rabbit1 {
		}
		class Rabbit2 {
		 public Rabbit2() { }
		}
		class Rabbit3 {
		 public Rabbit3(boolean b) { }
		}
		class Rabbit4 {
		 private Rabbit4() { }
		}
Seul Rabbit1 a un constructeur sans argument par défaut. Voyons rapidement comment appeler ces constructeurs:  

		public class RabbitsMultiply {
			public static void main(String[] args) {
				Rabbit1 r1 = new Rabbit1();
				Rabbit2 r2 = new Rabbit2();
				Rabbit3 r3 = new Rabbit3(true);
				Rabbit4 r4 = new Rabbit4(); // DOES NOT COMPILE
		} }
Rabbit4 a rendu le constructeur privé afin que les autres classes ne puissent pas l'appeler, donc ne compile pas.  
*Remarque:* Avoir un constructeur privé dans une classe indique au compilateur de ne pas fournir de constructeur noargument par défaut. Cela empêche également les autres classes d'instancier la classe. Ceci est utile lorsqu'une classe n'a que des méthodes statiques ou que la classe veut contrôler tous les appels pour créer de nouvelles instances d'elle-même.   
### Appel de constructeurs surchargés avec this(): (Calling Overloaded Constructors with this())  
N'oubliez pas qu'une seule classe peut avoir plusieurs constructeurs. C'est ce qu'on appelle la surcharge de constructeur car tous les constructeurs ont le même nom inhérent mais une signature différente.  
Jetons un coup d'œil à cela plus en détail en utilisant une classe Hamster:   

	public class Hamster {
		 private String color;
		 private int weight;
		 
		 public Hamster(int weight) { // first constructor
			 this.weight = weight;
			 color = "brown";
		 }
		 
		 public Hamster(int weight, String color) { // second constructor
			 this.weight = weight;
			 this.color = color;
		 }
	}
L'un des constructeurs prend un seul paramètre int. L'autre prend un int et un String. Ces listes de paramètres sont différentes, les constructeurs sont donc surchargés avec succès.  
Il y a cependant un problème ici. Il y a un peu de duplication. En programmation, même un peu de duplication a tendance à se transformer en beaucoup de duplication. Ce que nous voulons vraiment, c'est que le premier constructeur appelle le second constructeur avec deux paramètres. Vous pourriez être tenté d'écrire ceci:  

		public Hamster(int weight) {
		 Hamster(weight, "brown"); // DOES NOT COMPILE
		}
Cela ne fonctionnera pas. Les constructeurs ne peuvent être appelés qu'en *écrivant new avant le nom du constructeur. Ce ne sont pas des méthodes normales que vous pouvez simplement appeler. Que se passe-t-il si nous plaçons new avant le nom du constructeur ?

		public Hamster(int weight) {
			new Hamster(weight, "brown"); // Compiles but does not do what we want
		}
Cette tentative compile. Cependant, cela ne fait pas ce que nous voulons !
Java fournit une solution: *this* - oui, le même mot-clé que nous avons utilisé pour désigner les variables d'instance. Lorsqu'il est utilisé comme s'il s'agissait d'une méthode, Java appelle un autre constructeur sur la même instance de la classe.  

		public Hamster(int weight) {
			this(weight, "brown");
		}
Succès! Maintenant, Java appelle le constructeur qui prend deux paramètres. le poids et la couleur sont définis sur cette instance.
L'appel de this() a une règle spéciale que vous devez connaître. Si vous choisissez de l'appeler, l'appel this() doit être la première instruction du constructeur. L'effet secondaire de ceci est qu'il ne peut y avoir qu'un seul appel à this() dans n'importe quel constructeur.  

		public Hamster(int weight) {
			System.out.println("in constructor");
			// ready to call this
			this(weight, "brown"); // DOES NOT COMPILE
		}
Même si une instruction d'affichage ne change aucune variable, il s'agit toujours d'une instruction Java et ne peut pas être insérée avant l'appel à this(). Le commentaire. Les commentaires n'exécutent pas d'instructions Java et sont autorisés partout.  
Le compilateur est capable de détecter que ce constructeur s'appelle lui-même indéfiniment. Étant donné que ce code ne peut jamais se terminer, le compilateur s'arrête et signale cela comme une erreur. De même, cela ne compile pas non plus:  

		public class Gopher {
			public Gopher() {
				this(5);	// DOES NOT COMPILE
			}
			public Gopher(int dugHoles) {
				this();	// DOES NOT COMPILE
			}
		}
Ce code ne compile pas à cause: *Recursive constructor invocation*
* this vs. this(): Malgré l'utilisation du même mot-clé, this et this() sont très différents. Le premier, this, fait référence à une instance de la classe, tandis que le second, this(), fait référence à un appel de constructeur dans la classe. L'examen peut essayer de vous tromper en utilisant les deux ensemble, alors assurez-vous de savoir lequel utiliser et pourquoi.

### Appel du constructeur parent avec super(): (Calling Parent Constructor with super())  
En Java, la première instruction de chaque constructeur est soit un appel à un autre constructeur de la classe, en utilisant this(), soit un appel à un constructeur dans la classe parent directe, en utilisant super(). Si un constructeur parent prend des arguments, l'appel super() prend également des arguments.  
Jetons un coup d'œil à la classe Animal et à sa sous-classe Zebra et voyons comment leurs constructeurs peuvent être correctement écrits pour en appeler un autre:

		public class Animal {
			private int age;
			public Animal(int age) {
				super();	// Refers to constructor in java.lang.Object
				this.age = age; 
			}
		}
		
		public class Zebra extends Animal {
			public Zebra(int age) {
				super(age);	// Refers to constructor in Animal
			}
			public Zebra() {
				this(4); // Refers to constructor in Zebra with int argument
			}
		}
Dans la première classe Animal, la première instruction du constructeur est un appel au constructeur parent défini dans java.lang.Object qui ne prend aucun argument.  
 Dans la deuxième classe Zebra, la première instruction du premier constructeur est un appel au constructeur d'Animal, qui prend un seul argument. La classe Zebra comprend également un second constructeur sans argument qui n'appelle pas super() mais appelle à la place l'autre constructeur de la classe Zebra en utilisant this(4).  
Comme this(), la super() ne peut être utilisée que comme *première instruction du constructeur*. Par exemple, les deux définitions de classe suivantes ne seront pas compilées:   

		public class Zoo {
			public Zoo() {
				System.out.println("Zoo created");
				super(); // DOES NOT COMPILE
			}
		}
Deuxième exemple:

		public class Zoo {
			public Zoo() {
				super();
				System.out.println("Zoo created");
				super(); // DOES NOT COMPILE
			}
		}
La première classe ne sera pas compilée car l'appel au constructeur parent doit être la première instruction du constructeur.  
Dans le deuxième extrait de code, super() est la première instruction du constructeur, mais elle est également utilisée comme troisième instruction. Puisque super() ne peut être utilisé que comme la première instruction du constructeur, le code ne se compilera pas non plus.  

Si la classe parent a plus d'un constructeur, la classe enfant peut utiliser n'importe quel constructeur parent valide dans sa définition, comme illustré dans l'exemple suivant:  

		public class Animal {
			private int age;
			private String name;
			public Animal(int age, String name) {
				super();
				this.age = age;
				this.name = name;
			}
			public Animal(int age) {
				super();
				this.age = age;
				this.name = null;
			}
		}
		
		public class Gorilla extends Animal {
			public Gorilla(int age) {
				super(age,"Gorilla");
			}
			public Gorilla() {
				super(5);
			}
		}
Dans cet exemple, le premier constructeur enfant prend un argument, age, et appelle le constructeur parent, qui prend deux arguments, age et name. Le deuxième constructeur enfant n'accepte aucun argument et appelle le constructeur parent, qui prend un argument, age. Dans cet exemple, notez que les constructeurs enfants ne sont pas obligés d'appeler les constructeurs parents correspondants. Tout constructeur parent valide est acceptable tant que les paramètres d'entrée appropriés au constructeur parent sont fournis.  
* Remarque: comme this et this(), super et super() ne sont pas liés en java. le super est utilisé pour référencer les membres de la classe parent. tandis que supe() appelle un constructeur parent.   

###### Comprendre les améliorations du compilateur: (Understanding Compiler Enhancements)  
Attendez une seconde, nous avons dit que la première ligne de chaque constructeur est un appel à this() ou super(), mais nous avons créé des classes et des constructeurs tout au long de ce livre, et nous l'avons rarement fait non plus. 
alors pourquoi le code a-t-il été compilé? La réponse est que le compilateur Java insère automatiquement un appel au constructeur sans argument super() si la première instruction n'est pas un appel au constructeur parent. Par exemple, les trois définitions de classe et de constructeur suivantes sont équivalentes, car le compilateur les convertira automatiquement dans le *dernier exemple*:  

		public class Donkey {
		
		}
		public class Donkey {
			public Donkey() {
			}
		}
		public class Donkey {
			public Donkey() {
				super();
			}
		}
Assurez-vous que vous comprenez les différences entre ces trois définitions de classe Donkey et pourquoi Java les convertira toutes automatiquement à la dernière définition. Gardez à l'esprit le processus de compilation Java lorsque nous aborderons les quelques exemples suivants.  
###### Il manque un constructeur sans argument par défaut: (Missing a Default No-Argument Constructor)  
Que se passe-t-il si la classe parente n’a pas de constructeur sans argument ? Rappelez-vous que le constructeur sans argument n'est pas obligatoire et n'est inséré que s'il n'y a pas de constructeur défini dans la classe. Dans ce cas, le compilateur Java n'aidera pas et vous devez créer au moins un constructeur dans votre classe enfant qui appelle explicitement un constructeur parent via la commande super(). Par exemple, le code suivant ne sera pas compilé:  

		public class Mammal{
			public Mammal(int age) {
			}
		}
		public class Elephant extends Mammal{	// DOES NOT COMPILE
		}
Puisque Elephant ne définit aucun constructeur, le compilateur Java tentera d'insérer un constructeur sans argument par défaut. En tant que deuxième amélioration lors de la compilation, il insérera également automatiquement un appel à super() comme première ligne du consturcteur sans argument par défaut. Notre précédente déclinaison Elephant est ensuite convertie par le compilateur en la déclaration suivante:

	public class Elephant extends Mammal{	
		public Elephant(){
			super();	// DOES NOT COMPILE
		}
	}
Étant donné que la classe Mammal a au moins un constructeur déclaré, le compilateur n'insère pas de constructeur sans argument par défaut. Par conséquent, l'appel super() dans la déclaration de classe Elephant ne se compile pas. Dans ce cas, le compilateur Java n'aidera pas, et vous devez créer au moins un constructeur dans votre classe enfant qui appelle explicitement un constructeur parent via la commande super(). Nous pouvons résoudre ce problème en ajoutant un appel à un constructeur parent qui prend un argument fixe:   

	public class Elephant extends Mammal{	
		public Elephant(){
			super(10);	// DOES NOT COMPILE
		}
	}
Ce code se compilera car nous avons ajouté un constructeur avec un appel explicite à un constructeur parent. Notez que la classe Elephant a maintenant un constructeur sans argument même si sa classe parent Mammal n'en a pas. Les sous-classes peuvent définir des constructeurs sans argument même si leurs classes parentes ne le font pas, à condition que le constructeur de l'enfant mappe à un constructeur parent via un appel explicite de la commande super().   
Cela signifie que les sous-classes de l'éléphant peuvent s'appuyer sur les améliorations du compilateur. Par exemple, la classe suivante se compile car Elephant a maintenant un constructeur sans argument, bien qu'il soit défini explicitement

	public class AfricanElephant extends Elephant { }	// COMPILE
Vous devez vous méfier de toute question d’examen dans laquelle la classe parente définit un constructeur qui prend des arguments et ne définit pas de constructeur sans argument. Assurez-vous de vérifier que le code se compile avant de répondre à une question à ce sujet.
   
*super() fait toujours référence au parent le plus direct: (super() always Refers to the Most Direct Parent)* Une classe peut avoir plusieurs ancêtres via l'héritage. Dans notre exemple précédent, AfricanElephant est une sous-classe de la classe Elephant, qui à son tour est une sous-classe de Mammel. Pour les constructeurs via super() fait toujours référence au parent le plus direct. Dans cet exemple, appeler super() dans la classe AfricanElephant fait toujours référence à la classe Elephant, et jamais à la classe Mammel.   
### Constructeurs et les champs final: (Constructors and final fields)  
La valeur final static doit se voir attribuer une valeur exactement une seule fois. vous avez vu cela se produire dans la ligne de la déclaration et dans un initialiseur statique. Les variables d'instance marquées comme finales suivent des règles similaires. Des valeurs peuvent leur être affectées dans la ligne dans laquelle elles sont déclarées ou dans un initialiseur d'instance.

	 public class MouseHouse {
		 private final int volume;
		 private final String name = "The Mouse House";
		 {
			 volume = 10;
		 }
	 }
Comme les autres variables finales, une fois que la valeur est affectée, elle ne peut pas être modifiée. Le constructeur fait partie du processus d'initialisation, il est donc autorisé à y affecter une variable d'instance finale. Pour l'examen, vous devez connaître une règle importante. Au moment où le constructeur se termine, toutes les variables d'instance finale doivent recevoir une valeur. Essayons ceci dans un exemple:  

		public class MouseHouse {
			 private final int volume;
			 private final String name = "The Mouse House";
			 public MouseHouse(int length, int width, int height) {
				 volume = length * width * height;
			 }
		}
Dans notre implémentation MousseHouse, les valeurs de "volume" et "type" sont attribuées dans le constructeur. N'oubliez pas que le mot-clé «this» est facultatif car la variable d'instance fait partie de la déclaration de classe et qu'il n'y a pas de paramètres de constructeur portant le même nom.  
Contrairement à la variable finale locale, qui n'est pas obligée d'avoir une valeur sauf si elle est réellement utilisée, la variable d'instance finale doit se voir attribuer une valeur. Les valeurs par défaut ne sont pas utilisées pour ces variables. Si aucune valeur ne leur est affectée dans la ligne où ils sont déclarés ou dans un initialiseur d'instance, une valeur doit leur être attribuée dans la déclaration du constructeur.
Si vous ne le faites pas, une erreur du compilateur se produira sur la ligne qui déclare le constructeur.  

		public class MouseHouse {
			 private final int volume;
			 private final String type;
			 {
				 volume = 10;
			 }
			 public MouseHouse(String type) {
				 this.type = type;
			 }
			 public MouseHouse() {	// DOES NOT COMPILE
				 this.volume = 2;	// DOES NOT COMPILE
			 }
		}
Dans cet exemple, le premier constructeur qui accepte un argument String se compile. Bien qu'une variable d'instance finale ne puisse recevoir une valeur qu'une seule fois, chaque constructeur est considéré indépendamment en termes d'affectation. 
Le deuxième constructeur ne compile pas pour deux raisons: Tout d'abord, le constructeur ne parvient pas à définir une valeur pour la variable "type". Le compilateur détecte qu'une valeur n'est jamais définie pour "type" et signale une erreur sur la ligne où le constructeur est déclaré. Deuxièmement, le constructeur définit une valeur pour la variable de volume, et comme cette variable est attribué avec une valeur par l'initialiseur d'instance. Le compilateur signale cette erreur sur la ligne où le "volume" est défini.
### Ordre d'initialisation: (Order of Initialization)  
Dans le chapitre 2, nous avons présenté l'ordre d'initialisation. Avec l'héritage, à travers, l'ordre d'initialisation d'une instance devient un peu plus compliqué. Nous allons commencer par comment initialiser la classe, puis nous développerons l'initialisation de l'instance.  
###### Initialisation de classe: (Class Initialization)   
Tout d'abord, vous devez initialiser la classe, ce qui implique d'appeler tous les membres statiques de la hiérarchie de classes, en commençant par la superclasse la plus élevée et en descendant. Ceci est souvent appelé chargement de la classe. La JVM contrôle le moment où la classe est initialisée, bien que vous puissiez supposer que la classe est chargée avant d'être utilisée. La classe peut être initialisée au premier démarrage du programme, lorsqu'un membre statique de la classe est référencé ou peu de temps avant la création d'une instance de la classe.   
La règle la plus importante avec l'initialisation de classe est que cela se produit au plus une fois pour chaque classe. La classe peut également ne jamais être chargée si elle n'est pas utilisée dans le programme. Nous résumons l'ordre d'initialisation d'une classe comme suit:  
*Initialize Class X:*
* S'il existe une superclasse Y de X, initialisez d'abord la classe Y.  
* Traitez toutes les déclarations de variables static dans l'ordre dans lequel elles apparaissent dans la classe.   
* Traitez tous les initialiseurs static dans l'ordre dans lequel ils apparaissent dans la classe.  

En regardant un exemple, qu'est-ce que le programme suivant affiche ?  

		class Animal{
			static {System.out.print("A");}
		}
		public class Hippo extends Animal{
			static {System.out.print("B");}
			public static void main(String[] args) {
				System.out.print("C");
				new Hippo();
				new Hippo();
				new Hippo();
			}
		}
Ce programme affiche *ABC*. Puisque la méthode main() est à l'intérieur de la classe Hippo, la classe sera initialisée en premier, en commençant par la superclasse et en imprimant AB. Ensuite, la méthode main() est exécutée, imprimant C. Même si la méthode main() crée trois instances, la classe n'est chargée *qu'une seule fois*.  
###### Initialisation de l'instance: (Instance Initialization)  
Une instance est initialisée à chaque fois que le mot-clé new est utilisé. Dans notre exemple précédent, il y avait trois nouveaux appels Hippo(), entraînant l'initialisation de trois instances Hippo. L'initialisation d'une instance est un peu plus compliquée que l'initialisation de classe, car une classe ou une superclasse peut avoir de nombreux constructeurs déclarés, mais seulement un seul constructeur est utilisé dans le cadre de l'initialisation de l'instance.  
Tout d'abord, commencez par le constructeur de niveau le plus bas où le mot-clé new est utilisé. Rappelez-vous, la première ligne de chaque constructeur est un appel à this() ou super(), et si omis, le compilateur insérera automatiquement un appel au constructeur sans-argument parent super(). Ensuite, progressez vers le haut et notez l'ordre des constructeurs. Enfin, initialisez chaque classe en commençant par la superclasse, en traitant chaque initialiseur et constructeur d'instance dans l'ordre inverse dans lequel il a été appelé. Nous résumons l'ordre d'initialisation d'une instance comme suit:  
*Initialize Instance of X:*
* S'il y a une superclasse Y de X, initialisez d'abord l'instance de Y.
* Traitez toutes les déclarations de variables d'instance dans l'ordre dans lequel elles apparaissent dans la classe.
* Traitez tous les initialiseurs d'instance dans l'ordre dans lequel ils apparaissent dans la classe.
* Initialisez le constructeur en incluant tous les constructeurs surchargés référencés par this().  

Essayons un exemple simple sans héritage. Voyez si vous pouvez comprendre ce que les applications suivantes produisent:  

		public class ZooTickets {
			private String name = "BestZoo";	// line 2
			{System.out.println(name+"-");}	// line 3
			private static int COUNT = 0;	// line 4
			static{System.out.println(COUNT+"-");}	// line 5
			static {COUNT += 10; System.out.println(COUNT+"-");}	// line 6
			
			public ZooTickets( ) {	// line 8
				System.out.println("z-");	// line 9
			}	// line 10
			
			public static void main(String... patrons) {
				new ZooTickets();	// line 13
			}
		}
Ce programme affiche : **0-10-BestZoo-z-**, voila l'explication ci-dessous:
En premier lieu on doit initialiser la classe, étant donné que la classe ZooTickets n'a pas une class mère (bien évidament la classe Objetc et ça class mère), donc on commence par les composants static. Dans notre cas les lignes 4, 5 et 6 seront exécutées en affichant "0-10". Ensuite, on initialise les instances, et comme n'a pas un classe mère nous commençons par les composants d'instances, les lignes 2 et 3 seront exécutées en affichant "BestZoo-". Finalement, on exécute le consturcteur (les ligne 8, 9 et 10) en affichant "z-". 
Si on crée une deuxième instance de ZooTickets: new ew ZooTickets(); on affiche "BestZoo-z-", il ne faut oublie que l'initialisation de la classe se fait une seule fois.

Ensuite, essayons un exemple simple avec héritage:  

		class Primate{
			public Primate() {
				System.out.print("Primate-");
			}
		}
		class Ape extends Primate{
			public Ape(int fur) {
				System.out.print("Ape1-");
			}
			public Ape() {
				System.out.print("Ape2-");
			}
		}
		public class Chimpanzee extends Ape{
			public Chimpanzee() {
				super(2);
				System.out.print("Chimpanzee-");
			}
			public static void main(String[] args) {
				new Chimpanzee();
			}
		}
Le compilateur insère la commande super () comme première instruction des constructeurs Primate et Ape. Le code s'exécutera avec les constructeurs parents appelés en premier et produira la sortie suivante: *Primate-Ape1-Chimpanzee-*   
Notez que seul l'un des deux constructeurs Ape() est appelé. Vous devez commencer par l'appel à new Chimpanzee() pour déterminer quels constructeurs seront exécutés. Se souvient, les constructeurs sont exécutés de bas en haut.  

L'exemple suivant est un peu plus difficile. Que pensez-vous qu'il se passe ici ? 

		public class Cuttlefish {
			private String name = "swimmy";
			{ System.out.print(name+"-"); }
			private static int COUNT = 0;
			static { System.out.print(COUNT+"-");}
			{ COUNT++; System.out.print(COUNT+"-"); }
			
			public Cuttlefish() {
				System.out.println("Constructor");
			}
			public static void main(String[] args) {
				System.out.print("Ready-");
				new Cuttlefish();
			}
		} 
Ce programme affiche: **0-Ready-swimmy-1-Constructor**  
Dans notre cas la classe Cuttlefish n'a pas de classe mère donc on peut ignorer les règles de l'héritage. En commençant par les variables statics et les initialiseurs statics, on affciher "0-", ensuite en exécture la méthode main() en affichant "Ready-" après on exécute les variables d'instances et les initialiseurs d'instances en affichant "swimmy-1-". A la fin on exécute le constructuer "Constructor".   ,

Prêt pour un exemple plus difficile: 

		class GiraffeFamily {
			static { System.out.print("A"); }
			{ System.out.print("B"); }
			
			public GiraffeFamily(String name) {
				this(1);
				System.out.print("C");
			}
			public GiraffeFamily() {
				System.out.print("D");
			}
			public GiraffeFamily(int stripes) {
				System.out.print("E");
			}
		}
		public class Okapi extends GiraffeFamily{
			static { System.out.print("F"); }
			
			public Okapi(int stripes) {
				super("sugar");
				System.out.print("G");
			}
			{ System.out.print("H"); }
			
			public static void main(String[] args) {
				new Okapi(1);
				System.out.println();
				new Okapi(2);
			}
		}
Ce programme affiche:

		AFBECHG
		BECHG
On commence par l'initialisation de la classe Okapi, or elle a une classe mère GiraffeFamily, donc elle sera initialisée avant donc on affiche "A" ensuite "F".
Après l'initialisation de la classe, on exécute la méthode main(), la première ligne de cette méthode est new Okapi, cette ligne déclanche le process d'initialisation d'instance. Et comme Okapi a une superclasse, alors on commence par GiraffeFamily et on affiche "B". Selon la quatrième règle, nous initialisons les constructeurs donc on exécute le constructeur Okapi(int stripes), qui a sont tour appelle le consturcteur avec le paramètre String de sa superclasse ensuite l'appel this(1) tous ça affiche "EC", car les corps du constructeur sont déroulés dans l'ordre inverse qu'ils ont appelé.
Le process continu avec l'initialisation de l'initialiseur d'instance qui affiche "H", ensuite la fin du constructeur qui affiche "G".
La deuxième instanciation du l'objet Okapi, repecte le même ordre d'initialisation du premier objet sans l'initialisation de la class, du coup on affiche "BECHG".
### Révision des règles du constructeur: (Reviewing Constructor Rules)  
Passons en revue certaines des règles de constructeur les plus importantes que nous avons couvertes dans la partie du chapitre:  
1. La première instruction de chaque constructeur est un appel à un constructeur surchargé via this(), ou à un constructeur du parent direct via super().  
2. Si la première instruction d'un constructeur n'est pas un appel à this() ou à super(), le compilateur insérera un super() sans argument après la première instruction d'un constructeur.  
3. L'appel de this() et super() après une instruction d'un constructeur entraîne une erreur du compilateur.
4. Si la classe parente n'a pas de constructeur sans-argument, alors chaque constructeur de la classe enfant doit commencer par un appel explicite du consturcteur this() ou super().   
5. Si la classe parent n'a pas de constructeur sans-argument et que l'enfant ne définit aucun constructeur, alors la classe enfant ne compilera pas.
6. Si une classe définit uniquement des constructeurs privés, elle ne peut pas être étendue par une classe de niveau supérieur.  
7. Toutes les variables d'instance finale doivent se voir attribuer une valeur exactement une fois à la fin du constructeur. Toute variable d'instance finale sans valeur attribuée sera signalée comme une erreur du compilateur sur la ligne où le constructeur est déclaré.   

Assurez-vous de bien comprendre ces règles. l'examen fournira souvent un code qui enfreint une ou plusieurs de ces règles et ne compile donc pas.  
# Membres héritiers: (Inheriting Members)
### Appel des membres hérités: (Calling Inherited Members)
### Hériter des méthodes: (Inheriting Methods)
### Masquer les variables: (Hiding Variables)
# Comprendre le polymorphisme: (Understanding Polymorphism)
Java supporte le polymorphisme, la propriété d'un objet peut avoir de nombreuses formes différentes. Plus précisément, un objet Java peut être accédé en utilisant une référence du même type que l'objet, une référence qui est une super-classe de l'objet ou une référence définissant une interface que l'objet implémente, soit directement, soit via une superclasse. 
De plus, un cast n'est pas nécessaire si l'objet est réaffecté à un super type ou à une interface de l'objet.
En Java, *tous les objets sont accessibles par référence*. En tant que développeur, vous n’avez jamais accès directement à l’objet lui-même.
### Objet contre référence: (Object vs. Reference)
### Casting des objets: (Casting Objects)
### L'opérateur instanceof: ( The instanceof Operator)
### Polymorphisme et redéfinissement de méthode: (Polymorphism and Method Overriding) 
### Redéfinir contre masquer des membres: (Overriding vs. Hiding Members)