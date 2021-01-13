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
Bien que Java n'autorise pas l'héritage multiple, il permet aux classes d'implémenter n'importe quel nombre d'interfaces. Une interface est un type de données abstrait qui définit une liste de méthodes publiques abstraites que toute classe implémentant l'interface doit fournir. Une interface peut également inclure une liste de variables constantes et de méthodes par défaut, que nous aborderons dans cette section.     
### Définition d'une interface: (Defining an Interface)  
En Java, une interface est définie avec le mot clé interface, analogue au mot clé class utilisé lors de la définition d'une classe. Une classe appelle l'interface en utilisant le mot clé implements dans sa définition de classe.  

	public abstract interface CanBurrow {
		public static final int MINIMUM_DEPTH = 2;	// Abstract Interface method
		public abstract int getSpeed(int age);	// Interface variable
	}
Les mots clé d'une interface: 
* public: une interface peut avoir deux modificateur d'accés public ou package-private, comme une classe.  
* abstract: modificateur implicite (n'est pas obligatoire).  
* CanBurrow: le nom de l'interface.
* interfcae: le mot clé pour déclarer une interface.  

les mots clé des membres d'une interface:
* public static final: modificateur implicite pour déclaré une variable constante.
* public abstract: modificateur implicite pour déclarer une méthode abstract d'interface.

*Note:* Par souci de concision, nous disons parfois "une instance d'une interface" pour désigner une instance d'une classe qui implémente l'interface. 
Que signifie le fait qu'une variable ou une méthode soit supposée être un code ? Un aspect d'une déclaration d'interface qui diffère d'une classe abstraite est qu'elle contient des modificateurs implicites. Un modificateurs implicite est un modificateur que le compilateur l'ajoute automatiquement à une classe, ou à une interface, ou à une méthode ou à une déclaration de variable. Par exemple une interface est toujours considérée être abstract, même si ce n'est pas marquée.  
Commençons par un exemple. Imaginons que nous ayons une interface WalsOnTwoLegs, défini comme suit:  

		public abstract interface WalsOnTwoLegs {} 
Il compile car les interfaces ne sont pas obligées de définir des méthodes. Le modificateur abstrait dans cet exemple est facultatif pour l'interface, le compilateur l'insérant s'il n'est pas fourni. Maintenant, considérons les deux exemples suivants, qui ne se compilent pas:

		public class Biped {
			public static void main(String[] args) {
				var e = new WalsOnTwoLegs();	// DOES NOT COMPILE
			}
		}

		public final interface WalsOnTwoLegs {}	// DOES NOT COMPILE
Le premier exemple ne compile pas, parce que WalsOnTwoLegs est une interface donc on ne peut pas l'instanciée.   
Le deuxième exemple ne compile pas, parce qu'une interface ne peut pas être marquée par final.  

Comment utilisez-vous une interface? Disons que nous avons une interface Climb, définie comme suit:  

		interface Climb {
			Number getSpeed(int age);
		}
Ensuite, nous avons une classe concrète FieldMouse qui appelle l'interface Climb en utilisant le mot clé *implements* dans sa déclaration de classe.

		public class FieldMouse implements Climb, CanBurrow{
			public Number getSpeed(int age) {
				return 11f;
			}
		}
La classe FieldMouse déclare qu'elle implémente l'interface Climb et inclut une version redéfinie de getSpeed() héritée de l'interface Climb. La signature de la éthode de getSpeed() est exacte, et le type de retour est covariant. Le modificateur d'accés de la méthode d'interface est supposée public dans l'interface Climb, Bien que la classe concrète FieldMouse doit la déclaré explicitement.  
L'exemple de la classe FieldMouse montre qu'un classe peut implementer plusieur interface, chacune est séparée par une virgule (a comma ,). Si l'un des interfaces définit des méthodes abstract alors la classe est obligée de la redéfinir.  

Comme une classe, une interface peut étendre une autre interface à l'aide du mot clé extend.

	interface Nocturnal {}

	public interface HasBigEyes extends Nocturnal { }
Contrairement à une classe qui ne peut pas héritée qu'une seule classe, une interface peut étendre plusieurs interfaces.  

		interface Nocturnal {
			int hunt();
		}
		interface CanFly {
			void flap();
		}
		
		interface HasBigEyes extends Nocturnal, CanFly { }
		
		public class Owl implements Nocturnal, CanFly {
			public void flap() { System.out.println("Flap!");}
			public int hunt() { return 5; }
		}
La classe  Owl doit implementée les deux méthodes flap() et hunt().  
De nombreuses règles pour les déclarations de classe s'appliquent également à l'interface, notamment les suivantes:  
* Le fichier Java peut avoir qu'une seule classe ou une interface public de premier-niveau et doit correspondre au nom du fichier.  
* la classe de premier-niveau ou l'interface ne peut être déclarée qu'avec un accès public ou package-private.   

Dans cet exemple, Cat hérite les deux méthodes par défaut getSpeed() des deux interfaces Waldk et Run, alors laquelle utilise-t-il ? En termes d'utilisation dans la classe Cat, il n'est pas clair si le code doit afficher 5 ou 10. La réponse est que le code ne produit aucune valeur et il une erreur de compilation.   

*Que dire de type Enum:* Dans cette section, nous avons décrit comment une classe Java peut avoir au plus un élément public de premier niveau, une classe ou une interface. Cet élément public de premier niveau peut également être une énumération, ou **enum** pour faire court. Une énumération est un type spécialisé qui définit un ensemble de valeurs fixes. il est déclaré avec le mot-clé enum. Voici un exemple simple d'énumération pour Color:

		public enum Color {
			RED, YELOW, BLUE, GREEN, ORANGE, PURPLE
		}
Comme les classes et les interfaces, les énumérations peuvent avoir des formations plus complexes comprenant des méthodes, des constructeurs privés et des variables d'instance.
Le constructeur enum doit avoir une portée privée ou une portée de package-private (par défaut). Vous ne pouvez pas utiliser de constructeurs publics ou protected pour une énumération Java. 
### Insertion de modificateurs implicites: (Inserting Implicit Modifiers)    
Comme on vient de le dire, un *modificateur implicite* celui qui le compilateur l'ajoute automatiquement, ça rappelle le compilateur ajoute *non-argument par défault consturcteur* si on a pas définit un consturcteur dans la classe. En fait t'as le choix soit d'insérer le modificatuer implicite ou de laisser le compilatuer de faire ça à ta place.  
La liste suivante comprend les modificateurs implicites des interfaces que vous devez connaître pour l'examen: 
* Les interfaces sont supposées être abstraites.
* Les variables d'interfaces sont supposées être public, static et final.  
* Les méthodes d'interfaces sans corps sont supposées être abstract et public.  

Par exemple, les deux définitions d'interface suivantes sont équivalentes, car le compilateur les convertira toutes les deux en deuxième déclaration:  

		public interface Soar {
			int MAX_HEIGHT = 10;
			final static boolean UNDERWATER = true;
			void fly(int speed);
			abstract void takeOff();
			public abstract double drive();
		}
Le compilation va ajouter les modificatuers implicites:  

		public interface Soar {
			public static final int MAX_HEIGHT = 10;	//ADD  public static final
			public final static boolean UNDERWATER = true;	// ADD public
			public abstract void fly(int speed);	// ADD public abstract
			public abstract void takeOff();	// ADD public
			public abstract double drive();
		}
###### Modificateurs en conflit: (Conflicting Modifiers)  
Que se passe-t-il si un développeur marque une méthode ou une variable avec un modificateur qui entre en conflit avec un modificateur implicite ? Par exemple, si une méthode abstraite est supposée être publique, elle peut alors être explicitement marquée comme protégée ou privée ?  

	public interface Dance {
		private int count = 4;	// DOES NOT COMPILE
		protected void step();	// DOES NOT COMPILE
	}
Aucune de ces déclarations de membre d'interface n'est compilée, car le compilateur appliquera le modificateur public aux deux members, ce qui entraînera un conflit.  
Alors que les problèmes avec les modificateurs d'accès privés et protégés dans les interfaces sont faciles à repérer, qu'en est-il de l'accès package-private  ? Par exemple, quel est le niveau d'accès des deux éléments suivants volume et start() ?

		public interface Sing {
			float volume = 10;
			abstract void start();
		}
Si tu dis public, alors t'as raison, quand on tavaille avec les membres de classe, si on omet le modificateur d'acces alors il est par défaut (package-private). Alors quand on travaille avec les membres interface, et on omet le modificateur d'accés ça sera obligatoirement public. 

Essayons un autre. Quelle(s) ligne(s) de cette déclaration d'interface de niveau supérieur (top-level) ne compile pas ?  

		private final interface Crawl {
			String distance;
			private int MAXIMUM_DEPTH = 100;
			protected abstract boolean UNDERWATER = false;
			private void dig(int depth);
			protected abstract double depth();
			public final void surface();
		}
Toutes les lignes dans cet exemple ci-dessus, ne compilent pas:   
La première ligne ne compile pas à cause de plusieurs raison, premièrement une interface ne peut pas être marquée final, la deuxième raison le modificateur d'accés private n'est pas autorisé, en fait une déclaration d'interface ne peut être que public ou package-privae.  
Ligne 2: la variable distance n'est pas initialiée. Souviens-toi qu'une variable d'interface est supposée être une constante static final et initialisée.   
Ligne 3: ne compile pas parce que une variable d'interface est supposée être public.  
Ligne 4: ne compile pas pour deux raison, parce que une variable d'interface est supposée être public, et aussi une variable ne peut pas être marquée abstract.  
Ligne 5 et 6: ne complient pas parce que une méthode d'interface est supposée être public, donc être marquée private ou protected gènère une erreur de compilation.  
Ligne 7: ne compile pas parce que la méthode surface() est marquée final.  
###### Différences entre les interfaces et les classes abstraites: (Differences between Interfaces and Abstract Classes)   
Même si les classes abstraites et les interfaces sont toutes deux considérées comme des types abstraits, seules les interfaces utilisent des modificateurs implicites. Cela signifie qu'une classe abstraite et une interface avec des déclarations similaires peuvent avoir des propriétés très différentes. Par exemple, en quoi les méthodes play() diffèrent-elles dans les deux définitions suivantes ?    

		abstract class Husky {
			abstract void play();
		}
		
		interface Poodle {
			void play();
		}
Les deux méthodes sont considérée comme abstract. Cela dit, la classe Husky ne se compilera pas si la méthode play() n'est pas marquée abstraite, alors que la méthode paly() dans l'interface Poodle compile avec ou sans le modifiactuer abstract.   
Que peut on dire de niveau d'accés de la méthode paly() ? Même si ni l'un ni l'autre n'a de modificateur d'accès, elles ont pas le même niveau d'accès. La méthode play() dans la classe Husky est considérée default (package-private), alors que la méthode play() dans l'interface Poodle est supsosée être public. Ceci est particulièrement important lorsque vous créez des classes qui héritent de ces définitions. Par exemple, pouvez-vous repérer quelque chose de mal avec les définitions de classe suivantes qui utilisent nos types abstraits ?  

		class Webby extends Husky {
			void play() {}	// COMPILE
		}
		
		class Georgette implements Poodle {
			void play() {}	// DOES NOT COMPILE
		}
La classe Webby mais la classe Georgette ne compile pas, poutant les deux implémentent presque la même méthode, en fait le méthode de la classe Georgette viole les règle de redéfinition, parce que le modéficateur d'accès est public dans une interface dans la méthode play() doit avoir au moins le même modificateur au plus et comme public est le plus grand alors doit être public.  

		class Georgette implements Poodle {
			public void play() {}	// COMPILE
		} 
### Hériter d'une interface: (Inheriting an Interface)  
Une interface peut être héritée de trois manières:  
* Une interface peut étendre (extends) une autre interface.
* Une classe peut implémenter une interface.  
* Une classe peut étendre une autre classe dont l'ancêtre implémente une interface.  

Lorsqu'une interface est héritée, toutes les méthodes abstraites sont héritées. Comme nous l'avons vu avec les classes abstraites, si le type héritant de l'interface est également abstrait, comme une interface ou une classe abstraite, il n'est pas nécessaire d'implémenter les méthodes d'interface. D'autre part, la première sous-classe concrète qui hérite de l'interface doit implémenter toutes les méthodes abstraites héritées.  
Prenons l'exemple suivant:   

		public interface HasTail {
			 public int getTailLength();
		}
		
		public interface HasWhiskers {
			public int getNumberOfWhiskers();
		}
		
		public abstract class HarborSeal implements HasTail, HasWhiskers {
		}
		
		public class CommonSeal extends HarborSeal { // DOES NOT COMPILE
		}
Dans cet exemple, nous voyons que HarborSeal est une classe abstraite et se compile sans problème, comme elle est abstract n'est pas obligée d'implementée les méthodes abstract des interfaces HasTail et HasWhiskers.   
CommonSeal est la première classe concète, elle extends la classe abstact HarborSeal, alors elle est obligée d'implementer toutes les méthodes abstract, et comme cette classe n'implémnte aucune méthode (getTailLength() et getNumberOfWhiskers()) le compilateur génère une erreur de compilation.  
###### Mélange de mots-clés de classe et d'interface: (Mixing Class and Interface Keywords)  
Les créateurs d'examens sont friands de questions qui mélangent la terminologie de classe et d'interface. Bien qu'une classe puisse implémenter une interface, une classe ne peut pas étendre une interface. De même, alors qu'une interface peut étendre une autre interface, une interface ne peut pas implémenter une autre interface. Les exemples suivants illustrent ces principes:  

		public interface CanRun {}
		public class Cheetah extends CanRun {} // DOES NOT COMPILE
		public class Hyena {}
		public interface HasFur extends Hyena {} // DOES NOT COMPILE
Le premier exemple montre une classe essayant d'étendre une interface qui ne compile pas. Le deuxième exemple montre une interface essayant d'étendre une classe, qui ne compile pas non plus. Méfiez-vous des exemples de l'examen qui mélangent les définitions de classe et d'interface.     
Voici la seule syntaxe valide pour relier la classe et les interfaces dans leurs déclarations:    
  
*class1 extends class2*   
*interface1 implements interface2, interface3, ....*   
*class1 implements interface1, interface2, ...*    
###### Déclarations de méthode d'interface en double: (Duplicate Interface Method Declarations)  
Puisque Java permet l'héritage multiple via des interfaces, vous vous demandez peut-être ce qui se passera si vous définissez une classe qui hérite de deux interfaces qui contiennent la même méthode abstraite:   

		public interface Herbivore {
			 public void eatPlants();
		}
		
		public interface Omnivore {
			 public void eatPlants();
			 public void eatMeat();
		}
Dans ce scénario, les signatures des deux méthodes d'interface eatPlants() sont des dupliquées. Comme ils ont des déclarations de méthode identiques, ils sont également considérés comme *compatibles*. Par compatibilité, nous entendons que le compilateur peut résoudre les différences entre les deux déclarations sans trouver de conflit. Vous pouvez définir une classe qui implemente les deux interfaces simultanément. 

		class Bear implements Herbivore, Omnivore {
			public void eatMeat() {
				System.out.println("Eating meat");
			}
		
			public void eatPlants() {
				System.out.println("Eating plants");
			}
		}
Comme dit précédemment, les interfaces définissent simplement un ensemble de ce qu'une classe les implémentant doit suivre. Si deux méthodes d'interface abstraites ont des comportements identiques - ou dans ce cas la même déclaration de méthode (même signature) - il vous suffit de pouvoir créer une seule méthode qui redéfinit les deux méthodes abstraites héritées en même temps.  

Que se passe-t-il si les deux méthodes ont des signatures différentes? Si le nom de la méthode est le même mais que les paramètres d'entrée sont différents, il n'y a pas de conflit car cela est considéré comme une surcharge de méthode. Nous démontrons ce principe dans l'exemple suivant:  

		public interface Herbivore {
			public int eatPlants(int quantity);
		}
		
		interface Omnivore {
			public void eatPlants();
		}
		
		class Bear implements Herbivore, Omnivore {
			public int eatPlants(int quantity) {
				System.out.println("Eating plants: " + quantity);
				return quantity;
			}
		
			public void eatPlants() {
				System.out.println("Eating plants");
			}
		}
Dans cet exemple, nous voyons que la classe qui implémente les deux interfaces doit fournir des implémentations des deux versions de eatPlants(), puisqu'elles sont considérées comme des méthodes distinctes.   

Que faire si les méthodes dupliquées ont la même signature mais des types de retour différents ? Dans ce cas, vous devez examiner les règles de remplacement des méthodes. Essayons un exemple:

		public interface Dance {
			String swingArms();
		}
		interface EatsFish {
			CharSequence swingArms();
		}
		
		class Penguin implements Dance, EatsFish {	// COMPILE
			public String swingArms() {
				return "swing!";
			}
		}     
Dans cet exemple, la classe Penguin se compile. La version Dances de la méthode swingArms() est trivialement remplacée dans la classe Penguin, car la déclaration dans Dances et Penguin a les mêmes déclarations de méthode. La version EatsFish de swingArms() est également redéfinie car String et CharSequence sont des types de retour covariants.  

Jetons un coup d'œil à un exemple où les types de retour ne sont pas covariants:  

		public interface Dance {
			int countMoves();
		}
		interface EatsFish {
			boolean countMoves();
		}
		
		class Penguin implements Dance, EatsFish {	// DOES NOT COMPILE
			...
		}
Ce n'est pas possible de définire une version de la méthode countMoves() qui retourne à la fois int et un type boolean, il n'y a pas d'implémentation du Penguin qui permettra à cette déclaration de compiler.   
Le compilateur génère une erreur de complilation si vous définissez une classe abstraite ou une interface qui hérite de deux types abstraits en conflit, comme indiqué ici:  

	public interface LongEars {
		int softSkin();
	}
	interface LongNose {
		void softSkin();
	}
	
	interface Donkey extends LongEars, LongNose { }	// DOES NOT COMPILE
	
	abstract class Aardvark implements LongEars, LongNose { }	// DOES NOT COMPILE
Tous les types de cet exemple sont abstraits, aucun n'est concret. Malgré le fait qu'ils soient tous abstraits, le compilateur détecte que Donkey et Aardvark contiennent des méthodes incompatibles et les empêche de compiler.   
### Méthodes d'interface par défaut: (Default Interface Methods)
Avec la sortie de Java 8, les auteurs de Java ont introduit un nouveau type de méthode dans une interface, appelée *méthode par défaut*. La méthode par défaut est une méthode définie dans une interface avec le mot-clé par défaut dans lequel un corps de méthode est fourni. Comparez les méthodes par défaut avec les méthodes «régulières» dans une interface, qui sont supposées être abstraites et peuvent ne pas avoir de corps de méthode.     
###### Méthode par défaut: (Default Method)  
Une méthode par défaut dans une interface définit une méthode abstraite avec une implémentation par défaut. De cette manière, les classes ont la possibilité de redéfinir la méthode par défaut si elles en ont besoin, mais elles ne sont pas obligées de le faire. Si la classe ne remplace pas la méthode, l'implémentation par défaut sera utilisée. De cette manière, la définition de la méthode est concrète et non abstraite.    
Voici un exemple de méthode par défaut définie dans une interface:   

		public interface IsWarmBlooded {
			boolean hasScales();
			public default double getTemperature() {
				return 10.0;
			}
		}
Cet exemple définit deux méthodes d'interface, l'une est une méthode abstraite normale et l'autre une méthode par défaut. Notez que les deux méthodes sont supposées être publiques, car toutes les méthodes d'une interface sont publiques. La première méthode se termine par un point-virgule et ne fournit pas de corps, tandis que la deuxième méthode par défaut fournit un corps.   
Voici les règles de méthode d'interface par défaut avec lesquelles vous devez vous familiariser:  
1. Une méthode par défaut ne peut être déclarée que dans une interface et non dans une classe ou une classe abstraite.  
2. Une méthode par défaut doit être marquée avec le mot-clé par défaut. Si une méthode est marquée par défaut, elle doit fournir un corps de méthode.   
3. Une méthode par défaut n'est pas supposée être statique, finale ou abstraite, car elle peut être utilisée ou redéfinie par une classe qui implémente l'interface.  
4. Comme toutes les méthodes d'une interface, une méthode par défaut est supposée être publique et ne sera pas compilée si elle est marquée comme privée ou protégée.   

Par exemple, les extraits de code suivants ne seront pas compilés:  

	public interface Carnivore {
		public default void eatMeat(); // DOES NOT COMPILE
	
		public int getRequiredFoodAmount() { // DOES NOT COMPILE
			return 13;
		}
		private default int getNumberOfFins() {	// DOES NOT COMPILE
			return 4;
		}
		protected default double getLongestFinLength() {	// DOES NOT COMPILE
			return 20.0;
		}
		static default boolean doFinsHaveScales() {	// DOES NOT COMPILE
			return true;
		}
	}
Dans cet exemple, la première méthode, eatMeat(), ne compile pas car elle est marquée par défaut mais ne fournit pas de corps de méthode.  
La deuxième méthode, getRequiredFoodAmount(), ne compile pas non plus car elle fournit un corps de méthode mais n'est pas marquée avec le mot-clé par défaut.  
Les trois dernières méthodes ne compilent pas, parce que les modificateurs private, protected et static ne sont pas permis avec la méthode par défaut dans une interface.  
###### Méthodes par défaut et héritage multiple: (Default Methods and Multiple Inheritance)
Comme on a dit toute àl'heure, une classe qui implemente une interface qui inclut une méthode par défaut, n'est pas obligé de redéfinir la méthode, et peut l'utiliser comme elle est.  

		interface Vehicle {
			default void print() {
				System.out.println("I am a vehicle!");
			}
		}
		public class Car implements Vehicle{
			public static void main(String[] args) {
				new Car().print();
			}
		}  
Ce code affiche: *I am a vehicle!*

Vous avez peut-être réalisé qu'en autorisant les méthodes par défaut dans les interfaces, couplé au fait qu'une classe peut implémenter plusieurs interfaces, Java a essentiellement ouvert la porte à de multiples problèmes d'héritage. Par exemple, quelle valeur le code suivant produirait-il ?  

		interface Walk {
			public default int getSpeed() {
				return 5;
			}
		}
		interface Run {
			public default int getSpeed() {
				return 10;
			}
		}
		public class Cat implements Walk, Run{	// DOES NOT COMPILE
			public static void main(String[] args) {
				System.out.println(new Cat().getSpeed());
			}
		}  
### Static Interface Methods: (Static Interface Methods)    
Java 8 inclut désormais également la prise en charge des méthodes statiques dans les interfaces. Ces méthodes sont définies explicitement avec le mot-clé static et fonctionnent presque de la même manière que les méthodes statiques définies dans les classes, comme discuté au chapitre 4. En fait, il n'y a vraiment qu'une seule distinction entre une méthode statique dans une classe et une interface. Une méthode statique définie dans une interface n'est héritée dans aucune classe qui implémente l'interface.    
Voici les règles de méthode d'interface statique avec lesquelles vous devez vous familiariser:   
* Comme toutes les méthodes d'une interface, une méthode statique est supposée être publique et ne sera pas compilée si elle est marquée comme privée ou protégée.  
* Pour référencer la méthode statique, une référence au nom de l'interface doit être utilisée.    

Voici un exemple de méthode statique définie dans une interface:   

		public interface Hop {
			static int getJumpHeight() {
				return 8;
			}
		}
La méthode getJumpHeight() fonctionne comme une méthode statique telle que définie dans une classe. En d'autres termes, il est accessible sans instance de la classe en utilisant la syntaxe Hop.getJumpHeight(). Notez également que le compilateur insérera automatiquement le modificateur d'accès public puisque toutes les méthodes des interfaces sont supposées être publiques.  

Voici un exemple de classe Bunny qui implémente Hop:  

		public class Bunny implements Hop {
			public void printDetails() {
				System.out.println(getJumpHeight()); // DOES NOT COMPILE
			}
		}
Comme vous pouvez le voir, sans référence explicite au nom de l'interface, le code ne se compilera pas, même si Bunny implémente Hop. De cette manière, les méthodes d'interface statiques ne sont pas héritées par une classe implémentant l'interface. La version modifiée suivante du code résout le problème avec une référence au nom de l'interface Hop:  

		class Bunny implements Hop {
			public void printDetails() {
				System.out.println(Hop.getJumpHeight()); // DOES NOT COMPILE
			}
		}
Il s'ensuit donc qu'une classe qui implémente deux interfaces contenant des méthodes statiques avec la même signature sera toujours compilée à l'exécution, car les méthodes statiques ne sont pas héritées par la sous-classe et doivent être accédées avec une référence au nom de l'interface. Comparez cela avec le comportement que vous avez vu pour les méthodes d'interface par défaut dans la section précédente: le code se compilerait si la sous-classe remplaçait les méthodes par défaut et échouait à compiler autrement. Vous pouvez voir que les méthodes d'interface statiques n'ont aucun des mêmes problèmes et règles d'héritage multiples que les méthodes d'interface par défaut.   
###### Méthode d'interface privée (méthode d'instance et méthode de classe): (Private Interface Methods)    
Depuis Java 9, les méthode d'interface peuvent être private, (méthode d'instance ou de méthode de classe), ans les deux cas, la méthode privée n'est pas héritée par les sous-interfaces ou les implémentations. Ils sont principalement là pour améliorer la réutilisation du code dans l'interface uniquement - améliorant ainsi l'encapsulation.  
Regardons ce programme:   

	interface CustomInterface {
		public default void method2() {
			method4(); // private method inside default method
			method5(); // static method inside other non-static method
			System.out.println("default method");
		}
	
		private void method4() {
			System.out.println("private method");
		}
	
		private static void method5() {
			System.out.println("private static method");
		}
	}
	
	public class CustomClass implements CustomInterface{
		public static void main(String[] args) {
			new CustomClass().method2();
	
		}
	}
Ce programme compile et affiche: 

	private method
	private static method
	default method
### Polymorphisme et interfaces: (Polymorphism and Interfaces)    
Dans le chapitre 8, nous avons introduit le polymorphisme et on a montré comment un objet en Java peut prendre de nombreuses formes via des références. Bien que plusieurs des mêmes règles s'appliquent, le fait qu'une classe puisse hériter de plusieurs interfaces limite certaines des vérifications que le compilateur peut effectuer.   
###### Types de références abstraites: (Abstract Reference Types)    
Lorsque vous travaillez avec des types abstraits, vous pouvez préférer travailler avec les types de référence abstraits, plutôt qu'avec des classes concrètes. Ceci est particulièrement courant lors de la définition des paramètres de méthode. Considérez l'implémentation suivante:   

		public class Zoo {
			public void sortAndPrintZooAnimals(List<String> animals) {
				Collections.sort(animals);
				for(String a : animals) {
					System.out.println(a);
				}
			}
		}
Cette classe définit une méthode qui trie et affiche les animaux par ordre alphabétique. A aucun moment, cette classe ne s'intéresse à ce qu'est l'objet réel sous-jacent pour les animaux. Cela peut être une ArrayList, que vous avez déjà vu, mais il peut également s'agir d'une LinkedList ou d'un Vector.  
###### Interfaces de casting: (Casting Interfaces)  
Disons que vous avez une variable de type référence abstraite, qui a été dans la sous-classe concrète. Si vous avez besoin d'accéder à une méthode qui n'est déclarée que dans la sous-classe concret, vous devrez alors transtyper la référence d'interface vers ce type, en supposant que le cast est pris en charge au moment de l'exécution. Cela nous ramène à la règle dont nous avons discuté au chapitre 8, à savoir que le comilateur n'autorise pas les conversions vers des types non liés. Par exemple, ce qui suit n'est pas autorisé car le compilateur détecte que les classes String et Long ne sont pas liées:   

		String lion = "Bert";
		Long tiger = (Long) lion;	// DOES NOT COMPILE
Avec les interfaces, il existe des limites à ce que le compilateur peut valider. Par exemple, le programme suivant compile-t-il ?   

		interface Canine { }
		class Dog implements Canine { }
		class Wolf implements Canine { }
		
		public class BadCasts {
			public static void main(String [] args) {
				Canine canine = new Wolf();
				Canine badDog = (Dog) canine;
			}
		}
Dans ce programme, un objet Wolf est créé puis affecté à un type de référence Canine. En raison du polymorphisme, Java ne peut pas être sûr du type de classe spécifique de l'instance canine. Par conséquent, il autorise la conversion non valide vers le type de références Dog, même si Dog et Wolf ne sont pas liés. Le code se compile mais lève une ClassCastException au moment de l'exécution.   
Cette limitation mise à part, le compilateur peut appliquer une règle concernant le casting d'interface. Le compilateur n'autorise pas une conversion d'une référence d'interface vers une référence d'objet si la compilation du programme échoue:   

		Object badDog = (Dog) canine;	// DOES NOT COMPILE
Puisque String n'implémente pas Canine, le compilateur reconnaît que cette conversion n'est pas possible.   
###### Interfaces et instance de l'opérateur: (Interfaces and the instanceof Operator)   
Dans le chapitre 3, nous devrions que le compilateur signale une erreur si vous essayez d'utiliser l'opérateur instanceof avec deux classes non liées, comme suit:  

		Number tickets = 4;
		if(tickets instanceof String) { }	// DOES NOT COMPILE
Avec les interfaces, le compilateur a une capacité limitée à appliquer cette règle car même via un type de référence peut ne pas implémenter une interface, l'une de ses sous-classes le pourrait. Par exemple, ce qui suit compile:  

		Number tickets = 4;
		if(tickets instanceof List) { }	// COMPILE
Même si Number n'hérite pas de List, il est possible que la variable tickets soit une référence à une sous-classe de Number qui hérite de List. Par exemple, la variable tickets peut être affectée à une instance de la classe MyNumber suivante (en supposant que toutes les méthodes héritées ont été implémentées):   

		public class MyNumber extends Number implements List 
Cela dit, le compilateur peut vérifier les interfaces non liées si la référence est une classe qui est marquée comme final:    

		Integer tickets = 4;
		if(tickets instanceof List) { }	// DOES NOT COMPILE
Le complilateur génère une erreur parce que la classe Integer est marquée final et n'hérite pas de List. Par conséquent, il n'est pas possible de créer une sous-classe d'Integer qui hérite de l'interface List.    
### Révision des règles d'interfaces: (Reviewing Interfaces Rules)   
Nous résumons les règles d'interface dans cette partie du chapitre dans la liste suivante. Si vous comparez la liste de règles pour une définition de classe abstraite, les quatre premières règles sont similaires.   
###### Règles de définition d'interface: (Interface Definition Rules)  
1. L'interface ne peut pas être instanciée.   
2. Tous les types de niveau supérieur (top-level), y compris les interfaces, ne peuvent pas être marqués comme protected ou private.     
3. Les interfaces sont supposées être abstraites et ne peuvent pas être marquées comme final.   
4. Les interfaces peuvent inclure zéro ou plusieurs méthodes abstraites.     
5. Une interface peut étendre n'importe quel nombre d'interfaces.  
6. Une référence d'interfaces peut être convertie en toute référence qui hérite de l'interface, bien que cela puisse produire une exception à l'exécution si la classe n'est pas liée.   
7.  Le compilateur signalera uniquement une erreur de type non liée pour une opération instanceof avec une interface sur le côté droit si la référence sur le côté gauche est une classe finale qui n'hérite pas de l'interface.  
8. Une méthode d'interface avec un corps doit être marquée, default, private, static ou private static. 

###### Règles de méthode d'interface abstraite:(Abstract Interface Method Rules)   
1. Les méthodes abstraites ne peuvent être définies que dans des classes abstraites ou des interfaces.   
2. Les méthodes abstraites (Pas d'une interface) ne peuvent pas être déclarées privées ou finales.  
3. Les méthodes abstraites ne doivent pas fournir un corps/une implémentation de méthode dans la classe abstraite pour laquelle elle est déclarée.   
4. L'implémentation d'une méthode abstraite dans une sous-classe suit les mêmes règles pour redéfinir une méthode, y compris les types de retour covariants, la déclaration d'exception, etc.  
5. Une méthode d'interface sans corps est supposée être abstract et public.   
  
###### Règles des variables d'interface: (Interface Variables Rules)
1. Les variables d'interface sont supposées être public, static et final. Par conséquent, le marquage d'une variable comme private ou protected ou abstract déclenchera une erreur du compilateur.    
2. La valeur d'une variable d'interface doit être initialisée lorsqu'elle est déclarée car elle est marquée comme final.  

# Présentation des classes internes: (Introducing Inner Classes)
### Définition de membres de classes Internes: (Defining a Member Inner Classes)
### Utilisation de membres de classes Internes: (Using a Member Inner Classes)