						Advanced Class Design
						
					
# Créer des classes abstraites: (Creating Abstract Classes)  
Nous commençons notre discussion sur la conception de classe avancée avec des classes abstraites. Comme vous le verrez, les classes abstraites ont des utilisations importantes dans la définition d'un framework que d'autres développeurs peuvent utiliser.  
### Présentation des classes abstraites : (Introducing Abstract Classes)  
Au chapitre 8, vous avez appris qu'une sous-classe peut redéfinir une méthode héritée définie dans une classe parent. Le remplacement d'une méthode modifie potentiellement le comportement d'une méthode dans la classe parente. Par exemple, regardez la classe Bird suivante et sa sous-classe Stork.  

		class Bird {
			public String getName() { return null; }
			public void printName() {
				System.out.println(getName());
			}
		}
		public class Stork extends Bird{
			public String getName() { return "Stork!"; }
			public static void main(String[] args) {
				new Stork().printName();
			}
		}
Ce programme afficher *Stork!* à l'excution. Noter que la méthode getName() est redéfinie dans la sous-classe Stork. Même si l'implementation de la méthode printName() est définie dans la classe Bird, le fait que getName() est redéfinie dans la sous-calsse signifie qu'il est remplacé partout même dans la classe parente.   
Supposant on veut définir la classe Bird et  un autre developpeur l'hétitée er l'utilisée, mais nous voulons que le nouveau developpeur définie ça propre version de Bird, donc il doit redéfinir la méthode getName().    
Entrez des classes abstraites. Une classe abstraite est une classe qui ne peut pas être instanciée et peut contenir des méthodes abstraites. Une méthode abstraite qui ne définit pas une implémentation lorsqu'elle est déclarée. Les classes abstraites et les méthodes abstraites sont désignées par le modificateur *abstract*.   
Comparons l'implementation précedente avec celle là: 

		abstract class Bird {
			public abstract String getName();
			public void printName() {
				System.out.println(getName());
			}
		}
		public class Stork extends Bird{
			public String getName() { return "Stork!"; }
			public static void main(String[] args) {
				new Stork().printName();
			}
		}
La première difference la classe Bird est marquée comme abstract, le deuxième difference est la méthode getName() de la classe Bird est aussi marquée abstract, et finallement l'implementation de la méthode getName() entre braces {} était remplacée par un point-virgule (semicolon).  
Maintenant regardons la classe Stork, elle est exactement la même. Bien que cela puisse sembler identique, les règles relatives à la manière dont la classe doit être implémentée ont changé. En particulier la classe Stork **doit** désormais redéfinir la méthode  getName().  
Par exemple, l'implémentation suivante ne se compile pas car Stork ne redéfinie pas la méthode abstraite getName () requise:  

	public class Stork extends Bird { }	// DOES NOT COMPILE
Une classe abstraite est plus souvent utilisée lorsque vous souhaitez qu'une autre classe hérite des propriétés d'une classe particulière, mais que vous souhaitez que la sous-classe remplisse certains des détails d'implémentation. Dans notre exemple, l'auteur de la classe Bird a écrit la méthode printName() mais ne savait pas ce qu'elle allait faire à l'exécution, car l'implémentation getName() n'avait pas encore été fournie. 

*Override vs. Implement*: Souvent, lorsqu'une méthode abstraite est redéfinie dans une sous-classe, elle est appelée implémentation de la méthode. Il est décrit de cette manière parce que la sous-classe fournit une implémentation pour une méthode qui n'en a pas encore. Bien que nous ayons tendance à utiliser les termes implémenter et redéfinir de manière interchangeable pour les méthodes abstraites, le terme redéfinition est plus précis.

Plus tôt, nous avons dit qu'une classe abstraite ne peut pas être instanciée:  

	public abstract class Alligator {
		public static void main(String[] args) {
			var a = new Alligator();	// DOES NOT COMPILE
		}
	}
Une classe abstraite peut être initialisée, mais uniquement dans le cadre de l'instanciation d'une sous-classe non abstraite.   
### Defining an Abstract Class: (Defining an Abstract Class)   
Nous avons vu toute à l'heure, qu'une classe abstract peut contenir des méthodes non-abstract, en occurence la méthode printName(). Le fait qu'une classe abstract peut inclure tout les membres de non-abstract classe, incluant les variables, les methodes d'instances et les méthode statics, ainsi que les classes interne. Comme vous le verrez dans le section suivante une classe abstract peut aussi inclure des consturcteurs.  
L'une des caractéristiques les plus importantes d'une classe abstraite est qu'elle n'est en fait pas obligée d'inclure des méthodes abstraites. Par exemple, le code suivant se compile même s'il ne définit aucune méthode abstact.

		public abstract class Llama {
			public void chew() {}
		}
Bien qu'une classe abstract n'est pas obligée de declarée une méthode abstract, des qu'ume méthode abstract est declarée dans une classe elle la rend abstract. Cet exepmle ci-dessous ne compile pas:

	public class Egret {	// DOES NOT COMPILE
		public abstract void peck();
	}
Comme le modificateur final, le modifiacteur abstract peut être placer avant le modificatuer d'accés de la classe, regardons la classe Tiger: 

		abstract public class Tigre {
			abstract public void claw() {}
		}
Mais il faut faire attention, le modificateur abstract ne peut être palcer après le mot-clé classe dans la déclarattion d'une classe, et ne peut être aussi placer après le type de retour d'une méthode. Le programme suivant ne compile pas à cause de ces deux raisons: 

	public class abstract Jackal {	// DOES NOT COMPILE
		public int abstract claw() {}	// DOES NOT COMPILE
	} 
##### Constructeurs dans les classes abstraites: (Constructors in Abstract Classes)  
Même si une classe abstract ne peut pas être instancier, Ils sont toujours initialisés via les constructeurs par leurs sous-classes. Est ce programme suivant compile ?  

		abstract class Bear {
			abstract CharSequence chew();
			public Bear() {
				System.out.println(chew());
			}
		}
		public class Panda extends Bear{
			CharSequence chew() { return "yummy!"; }
			public static void main(String[] args) {
				new Panda();
			}
		} 
En utilisant les règles de constructeur que vous avez apprises au chapitre 8, le compilateur insère un constructeur sans argument par défaut dans la classe Panda, qui appelle d'abord super() dans la classe Bear. Le constructeur Bear n'est appelé que lorsque la classe abstraite est initialisée via une sous-classe, par conséquent, il existe une implémentation de chew() au moment où le constructeur est appelé. Ce code compile et imprime yummy!! lors de l'exécution.   

La principale différence entre un constructeur dans une classe abstraite et une classe non abstraite est qu'un constructeur dans une classe abstraite ne peut être appelé que lorsqu'il est initialisé par une sous-classe non abstraite. Cela a du sens, car les classes abstraites ne peuvent pas être instanciées.  
##### Déclarations de méthode abstraite non valides: (Invalid Abstract Method Declarations) 
Les rédacteurs d'examens sont également friands de questions avec des méthodes marquées comme abstraites pour lesquelles une implémentation est également définie. Quelles sont les méthodes qui compilent dans cet exemple ci-dessous:  

	public abstract class Turtle {
		public abstract long eat()	// DOES NOT COMPILE
		public abstract void swim() { };	// DOES NOT COMPILE
		public abstract int getAge() {	// DOES NOT COMPILE
			return 10;
		}
		public void sleep;	// DOES NOT COMPILE
		public void getInShell();	// DOES NOT COMPILE
	}
La méthode eat(): ne compile pas parce qu'elle finisse pas avec le semicolon(;)  
Les méthode swim() et getAge() ne compilent pas parce qu'elles sont marquées abstract mais elles impelementent un code entre braces {}, même le corps est vide dans la méthode swim().  
La méthode sleep ne compile pas parce qu'elle manque les parenthèses de paramètre de méthode.  
La méthode getInShell() ne compile parce qu'elle n'est pas marquée abstract *ou* elle ne définit pas un corps de méthode.   
##### Modificateurs non valides: (Invalid Modifiers)
Dans cette section nous examinons le modificateur abstract et quel modificateur et compatible avec lui:   
###### Modificateurs abstraits et finaux : (abstract and final Modifiers)  
Marquer une classe ou méthode avec abstract, vous donnez l'impression que vous voulez etendre ou implementer ça. Mais de marquer qques choses par final, vous prévenez de ne pas etendre une classe ou implemente une méthode. Donc de marquer une classe ou méthode au même temps avec abstrac et final crée un conflit, du coup ce n'est pas compatible. Le code suivant ne compile pas :

		public final abstract class Tortoise { // DOES NOT COMPILE
			public abstract final void walk();	// DOES NOT COMPILE
		}
Dans cet example ni la classe ni la méthode compile en marquant les deux au même temps abstract et final.   
###### Modificateurs abstraits et privés: (abstract and private Modifiers)  
On ne peut pas marquer une méthode à la fois abstract et private. Cette règle à un sens si on résone comme ça, pourquoi on définit une sous-classe pour implémnter une méthode, alors que cette méthode ne peut pas être héritée. Regardons cet exemple:   

		public abstract class Whale {
			private abstract void sing();	// DOES NOT COMPILE
		}
		class HumpbackWhale extends Whale {
			private void sing() {
				System.out.println("Humpback Whale is singing");
			}
		}
Dans cet exemple, la méthode abstraite sing() définie dans la classe parente Whale n'est pas visible par la sous-classe HumpbackWhale. Même si HumpbackWhale fournit une implémentation, elle n'est pas considérée comme un remplacement de la méthode abstraite puisque la méthode abstraite n'est pas héritée. Le compilateur reconnaît cela dans la classe parent et signale une erreur dès que privé et abstrait sont appliqués à la même méthode.   

Si on change le modificateur d'accés de private à protected dans la classe Whale, est ce code compile ? 

	public abstract class Whale {
		protected abstract void sing();
	}
	class HumpbackWhale extends Whale {
		private void sing() {	// DOES NOT COMPILE
			System.out.println("Humpback Whale is singing");
		}
	}
Dans cet exemple modifié, le code ne sera toujours pas compilé mais pour une raison complètement différente. Si vous vous souvenez des règles précédentes dans ce chapitre pour remplacer une méthode, la sous-classe ne peut pas réduire la visibilité de la méthode parente, sing (). Étant donné que la méthode est déclarée protégée dans la classe parent, elle doit être marquée comme protégée ou publique dans la classe enfant. Même avec des méthodes abstraites, les règles de substitution des méthodes doivent être suivies.
###### Modificateurs abstraits et statiques: (abstract and static Modifiers)  
Nous avons vu dans le chapitre 8 qu'une méthode static ne peut pas être redéfinie. Il est défini comme appartenant à la classe et non comme une instance de la classe. Si une méthode statique ne peut pas être remplacée ne peut pas être remplacée, il s'ensuit qu'elle ne peut pas non plus être marquée comme abstraite puisqu'elle ne peut jamais être implémentée. Par exemple, la classe suivante ne compile pas:   

	abstract class Hippopotamus {
		abstract static void swim();	// DOES NOT COMPILE
	}
### Créer une classe concrète: (Creating a Concrete Class)  
Une classe abstraite devient utilisable lorsqu'elle est étendue par une sous-classe concrète. Une *classe concrète* est une classe non abstraite. La première sous-classe concrète qui étend une classe abstraite est requise pour implémenter toutes les méthodes abstraites héritées. Cela inclut l'implémentation de toutes les méthodes abstraites héritées des interfaces héritées, comme nous le verrons plus loin dans ce chapitre.   
Lorsque vous voyez une classe concrète étendre une classe abstraite sur l'examen, assurez-vous qu'elle implémente toutes les méthodes abstraites requises. Pouvez-vous voir pourquoi la classe Walrus suivante ne se compile pas ?  

		public abstract class Animal {
			public abstract String getName();
		}
		class Walrus extends Animal { }	// DOES NOT COMPILE
Dans cet exemple la classe Animal est marquée abstract et la classe Walrus non, cela signifie que la classe Walrus est une sous-classe concrète de Animal, alors elle *doit* implementer toutes les méthodes abstracts de la classe Animal, en occurence la méthode getName(), or ce n'est pas le cas du coup le coompilateur génère une erreur.  

Nous mettons en évidence la *première sous-classe concrète* pour une raison. Une classe abstraite peut étendre une classe non abstraite, et vice versa. Chaque fois qu'une classe concrète étend une classe abstraite, elle doit implémenter toutes les méthodes héritées de manière abstraite. Illustrons cela avec un ensemble de classes héritées:  

	public abstract class Mammal {
		abstract void showHorn();
		abstract void eatLeaf();
	}
	
	abstract class Rhino extends Mammal { 
		void showHorn() { }
	}
	
	class BlackRhino extends Rhino {
		void eatLeaf() { }
	}
Dans cette exemple la classe BlackRhino est le première sous-classe concrète, ce pendant les deux classes Mammal et Rhino sont abstract. La classe BlackRhino hérite la méthode eatLeaf() comme abstraite et doit donc fournir une implémentation, ce qu'elle fait. Mais pourquoi pas aussi la méthode showHorn() ?  en fait cette méthode est déja implementé dans la classe Rhino donc n'est plus désormais abstract ce qui entraine que la première sous-classe concrète n'est pas obligé à l'implementée. 

Maintenant si nous supprimons le modificateur abstract de la classe Rhino. 

	abstract class Rhino extends Mammal {	// DOES NOT COMPILE
		void showHorn() { }
	}  
Désormais Rhino est devenue une classe concrète, en plus elle la premères non-abstract class qui étend de la classe Mammal, du coup elle doit implementer les deux methodes showHorn() et eatLeaf(). Alors notre code implemente juste une seule alors le compilateur génèr une erreur.

Regardons un autre exemple. La classe concrète suivante Lion hérite deux abstract méthodes, getName() et roar(): 

		public abstract class Animal {
			abstract String getName();
		}
		abstract class BigCat extends Animal {
			protected abstract void roar();
		}
		class Lion extends BigCat {
			public String getName() {
				return "Lion";
			}
			public void roar() {
				System.out.println("The Lion lets out a loud ROAR!");
			}
		}
Dans cet exemple, BigCat étend la classe Animal mais elle est marquée abstract, du coup elle n'est pas obligée d'implementée le méthode getName(). La classe Lion n'est pas marquée comme abstract, en plus elle est la première sous-classe concrète, donc elle doit implementer toutes les méthodes abstractes et non deéfinissentdasn les classes parents, alors les trois classes compiles sans erreurs.     
### Révision des règles de classe abstraite: (Reviewing Abstract Class Rules)  
Voici des listes de règles pour les classes abstraites et les méthodes abstraites que nous avons couvertes dans cette section. Lisez et comprenez ces règles avant de passer l'examen.  
###### Règles de définition de classe abstraite: (Abstract Class Definition Rules) 
1. Les classes abstraites ne peuvent pas être instanciées directement.  
2. Une classe de niveau supérieur (une classe qui n'est pas définie dans une autre classe), y compris aussi une classe abstract ne peut pas marquée comme protected ou privée.  
3. Les classes abstraites ne peuvent pas être marquées comme finales.  
4. La classe abstraite peut inclure zéro ou plusieurs méthodes abstraites et non abstraites.  
5. Classe abstraite qui étend une autre classe abstraite hérite de toutes ses méthodes abstraites.  
6. La première classe concrète qui étend une classe abstraite doit fournir une implémentation pour toutes les méthodes abstraites héritées.   
7. Les constructeurs de classes abstraites suivent les mêmes règles d'initialisation que les constructeurs réguliers, sauf qu'ils ne peuvent être appelés que dans le cadre de l'initialisation d'une sous-classe.  

######  Règles de définition de méthode abstraite: (Abstract Method Defi nition Rules)
Ces règles pour les méthodes abstraites s'appliquent indépendamment du fait que la méthode abstraite soit définie dans une classe abstraite ou une interface. 
1. Les méthodes abstraites ne peuvent être définies que dans des classes abstraites ou des interfaces.  
2. Les méthodes abstraites ne peuvent pas être déclarées privées ou finales.  
3. Les méthodes abstraites ne doivent pas fournir un corps/une implémentation de méthode dans la classe abstraite pour laquelle elle est déclarée.   
4. L'implémentation d'une méthode abstraite dans une sous-classe suit les mêmes règles pour redéfinir une méthode, y compris le type de retour covariant, la déclaration d'exception, etc.  

# Implémentation d'interfaces: (Implementing Interfaces)
### Définition d'une interface: (Defining an Interface)  
### Insertion de modificateurs implicites: (Inserting Implicit Modifiers)  
### Hériter d'une interface: (Inheriting an Interface)  
### Méthodes d'interface par défaut: (Default Interface Methods)   
### Méthodes par défaut et héritage multiple: (Default Methods and Multiple Inheritance)  
### Polymorphisme et interfaces: (Polymorphism and Interfaces)  
### Révision des règles d'interfaces: (Reviewing Interfaces Rules)  
# Présentation des classes internes: (Introducing Inner Classes)
### Définition de membres de classes Internes: (Defining a Member Inner Classes)
### Utilisation de membres de classes Internes: (Using a Member Inner Classes)