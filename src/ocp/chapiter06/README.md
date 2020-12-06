								Lambdas And Functional Interfaces
								

# Writing Simple Lambdas: (Écrire des lambdas simples)  
Java est un langage orienté objet dans l'âme. Vous avez déjà vu de nombreux objets. Dans Java 8, le langage a ajouté la possibilité d'écrire du code en utilisant un autre style.   
La programmation fonctionnelle est une manière d'écrire du code de manière plus déclarative. Vous spécifiez ce que vous voulez faire plutôt que de vous occuper de l'état des objets. Vous vous concentrez davantage sur les expressions que sur les boucles.  
La programmation fonctionnelle utilise des expressions lambda pour écrire du code. Une expression lambda est un bloc de code qui est transmis. Vous pouvez considérer **une expression lambda** comme **une méthode sans nom**. Elle a des paramètres et un corps comme les méthodes à part entière, mais elle n’a pas de nom comme une vraie méthode. Les expressions lambda sont souvent appelées lambdas pour faire court. Vous pourriez également les considérer comme des fermetures si Java n’est pas votre premier langage. Si vous avez eu une mauvaise expérience des fermetures (closures) dans le passé, ne vous inquiétez pas. Ils sont beaucoup plus simples en Java.      
En d'autres termes, une expression lambda est comme une méthode que vous pouvez passer comme s'il s'agissait d'une variable. Par exemple, il existe différentes façons de calculer l'âge. Une année humaine équivaut à sept années canines. Vous voulez écrire une méthode qui prend une méthode age() comme entrée. Pour ce faire dans un programme orienté objet, vous devez définir une sous-classe Human et une sous-classe Dog. Avec lambdas, vous pouvez simplement passer l'expression appropriée pour calculer l'âge.   
Seules les expressions lambda les plus simples figurent dans cet examen. Le but est de vous familiariser avec la syntaxe et les concepts. Cela signifie que vous ne faites pas encore vraiment de programmation fonctionnelle. Vous verrez à nouveau les lambdas à l'examen 1Z0-816.   
Dans cette section, nous allons couvrir un exemple de pourquoi les lambdas sont utilées et la syntaxe des lambdas    
### Lambda Example: (Exemple Lambda)   
Notre objectif est d'afficher tous les animaux dans une liste selon certains critères. Nous allons vous montrer comment faire cela sans lambdas pour illustrer à quel point les lambdas sont utiles. Nous commençons avec la classe Animal:   

	 public class Animal {
		 private String species;
		 private boolean canHop;
		 private boolean canSwim;
		 
		 public Animal(String speciesName, boolean hopper, boolean swimmer) {
			 species = speciesName;
			 canHop = hopper;
			 canSwim = swimmer;
		 }
		 
		 public boolean canHop() { return canHop; }
		 public boolean canSwim() { return canSwim; }
		 public String toString() { return species; }
	}
La classe Animal a trois variables d'instance, qui sont définies dans le constructeur. Il a deux méthodes qui déterminent si l'animal peut sauter ou nager. Il a également une méthode toString () afin que nous puissions facilement identifier l'animal dans les programmes.  
Nous prévoyons d'écrire beaucoup de contrôles différents, nous voulons donc une interface. Vous en apprendrez plus sur les interfaces dans le chapitre suivant. Pour l'instant, il suffit de se rappeler qu'une interface spécifie les méthodes que notre classe doit implémenter:  

		public interface CheckTrait {
			boolean test(Animal a);
		} 
La première chose que nous voulons vérifier est de savoir si l'animal peut sauter. Nous fournissons une classe qui peut vérifier ceci:  

		public class CheckIfHopper implements CheckTrait {
			@Override
			public boolean test(Animal a) {
				return a.canHop();
			}
		}
Cette classe peut sembler simple - et elle l'est. Cela fait en fait partie du problème que les lambdas résolvent. Reste un peu avec nous. Maintenant, nous avons tout ce dont nous avons besoin pour écrire notre code pour trouver les animaux qui sautent:   

	public class ExempleLambda {
		public static void main(String[] args) {
			List<Animal> animals = new ArrayList<Animal>(); // list of animals
			animals.add(new Animal("fish", false, true));
			animals.add(new Animal("kangaroo", true, false));
			animals.add(new Animal("rabbit", true, false));
			animals.add(new Animal("turtle", false, true));
			
			print(animals, new CheckIfHopper()); // pass class that does check
		}
		
		private static void print(List<Animal> animals, CheckTrait checker) {
			for (Animal animal : animals) {
				if (checker.test(animal)) // the general check
					System.out.print(animal + " ");
			}
			System.out.println();
		}
	}
La méthode print() est très générale - elle peut vérifier n'importe quel trait. C'est une bonne conception. Il ne devrait pas avoir besoin de savoir ce que nous recherchons spécifiquement pour afficher une liste d’animaux.    
Maintenant, que se passe-t-il si nous voulons imprimer les animaux qui nagent? Nous devons écrire une autre classe CheckIfSwims, ce n'est pas térible !  
Pourquoi ne pouvons-nous pas simplement spécifier la logique qui nous tient à cœur ici? Il s'avère que nous pouvons avec des expressions lambda. Nous pourrions répéter tout ce cours ici et vous faire trouver la seule ligne qui a changé. Au lieu de cela, nous allons simplement vous montrer. Nous pourrions remplacer la ligne 9 par ce qui suit, qui utilise un lambda:  

		print(animals, a -> a.canHop());
Ne vous inquiétez pas, la syntaxe semble un peu géniale. Vous vous y habituerez et nous le décrirons dans la section suivante. Nous expliquerons également les éléments qui ressemblent à de la magie. Pour l'instant, concentrez-vous simplement sur la facilité de lecture. Nous disons à Java que nous ne nous soucions que des animaux qui peuvent sauter.   
Il ne faut pas beaucoup d’imagination pour déterminer comment on ajouterait de la logique pour que les animaux sachent nager. Nous n'avons qu'à ajouter une ligne de code sans avoir besoin d'une classe supplémentaire pour faire quelque chose de simple. Voici cette autre ligne:  

		print(animals, a -> a.canSwim()); 
Et les animaux qui ne savent pas nager ?  

		print(animals, a -> !a.canSwim());
Le point ici est qu'il est vraiment facile d'écrire du code qui utilise des lambdas une fois que vous avez mis les bases en place. Ce code utilise un concept appelé exécution différée *Deferred execution*. L'exécution différée signifie que le code est spécifié maintenant mais qu'il s'exécutera plus tard. Dans ce cas, c'est plus tard que la méthode print() l'appelle.     

		// use Lambda expression
		print(animals, a-> a.canHop());	// kangaroo rabbit
		print(animals, a-> !a.canHop());	// fish turtle
### Lambda Syntax: (syntaxe Lambda)  
L'une des expressions lambda les plus simples que vous pouvez écrire est celle que vous venez de voir:   

		a -> a.canHop();
Les lambdas fonctionnent avec des interfaces qui n'ont qu'une **seule méthode abstraite**. Dans ce cas, Java regarde l'interface CheckTrait qui a une seule méthode.   
Le Lambda indique que Java doit appeler une méthode avec un paramètre Animal qui renvoie une valeur booléenne qui est le résultat de a.canHop().   
Java répond sur le contexte lors de la détermination de la signification des expressions lambda. Nous passons ce lambda comme deuxième paramètre de la méthode print(). Cette méthode attend un CheckTrait comme deuxième paramètre. Puisque nous passons un lambda à la place, Java essaie de mapper notre lambda à cette interface:  

	boolean test(Animal a);
Étant donné que la méthode de cette interface prend un animal, cela signifie que le paramètre lambda doit être un animal. Et puisque la méthode de cette interface renvoie un booléen, nous savons que le lambda renvoie un booléen.   
La syntaxe des lambdas est délicate car de nombreuses parties sont facultatives. Ces deux lignes font exactement la même chose:   

		a -> a.canHop()
		(Animal a) -> { return a.canHop(); }
Voyons ce qui se passe ici. Le premier exemple, illustré à la figure ci-dessous, comprend trois parties:   
* Un seul paramètre spécifié avec le nom a.
* L'opérateur de flèche pour séparer le paramètre et le corps.
* Un corps qui appelle une seule méthode et renvoie le résultat de cette méthode.   

		a -> a.canHop() // a parameter name, (->) arrow, a.canHop() bady
Le deuxième exemple comporte également trois parties, c'est juste plus bavard   

	(Animal a) -> { return a.canHop(); } // {} et ; required because in block
Les parenthèses ne peuvent être omises que s'il existe un seul paramètre et que son type n'est pas explicitement indiqué. Java fait cela parce que les développeurs utilisent généralement les expressions lambda de cette façon et qu'ils peuvent faire le moins de frappe possible.   
Regardons quelques exemples de lambdas valides. Prétendez qu'il existe des interfaces valides qui peuvent consommer un lambda avec zéro, un ou deux paramètres String.   

		() -> true); // 0 parameters
		a -> a.startsWith("test") // 1 parameter
		(String a) -> a.startsWith("test") // 1 parameter
		(a, b) -> a.startsWith("test") // 2 parameters
		(String a, String b) -> a.startsWith("test") // 2 parameters
Assurez-vous maintenant que vous pouvez identifier une syntaxe incorrecte. Voyez-vous ce qui ne va pas avec chacun de ces éléments ?   

		print(a, b -> a.startsWith("test")); // DOES NOT COMPILE
		print(a -> { a.startsWith("test"); }); // DOES NOT COMPILE
		print(a -> { return a.startsWith("test") }); // DOES NOT COMPILE 
# Introducing Functional Interfaces: (Présentation des interfaces fonctionnelles)   
Dans notre exemple précédent, nous avons créé une interface avec une méthode.  

		boolean test(Animal a)
Lambda fonctionne avec des interfaces qui n'ont qu'une seule méthode abstraite. Celles-ci sont appelées interfaces fonctionnelles **functional interfaces**.  
Nous avons mentionné qu'une interface fonctionnelle n'a qu'une seule méthode abstraite. Votre ami Sam peut vous aider à vous en souvenir car il est officiellement connu sous le nom de règle *Single Abstract Method (SAM)*.   
Il y a quatre interfaces fonctionnelles que vous verrez probablement sur l'examen. Les sections suivantes examinent le prédicat, le consommateur, le fournisseur et le comparateur.    
### Predicate: (prédicat)  
Vous pouvez imaginer que nous devions créer beaucoup d'interfaces comme celle-ci pour utiliser des lambdas.  
Heureusement, Java reconnaît qu'il s'agit d'un problème courant et nous fournit une telle interface. C'est dans le package java.util.function et l'essentiel de celui-ci est le suivant:   

		public interface Predicate<T> {
			boolean test(T t);
		}
Cela ressemble beaucoup à notre méthode. La seule différence est qu'il utilise ce type T au lieu d'Animal. C’est 
la syntaxe des génériques. C’est comme lorsque nous avons créé une ArrayList et que nous devions spécifier 
tout type qui y entre.   
Cela signifie que nous n'avons plus besoin de notre propre interface et que nous pouvons mettre tout ce qui
concerne notre recherche dans une seule classe:   

		public class PredicateSearch {
			public static void main(String[] args) {
				List<Animal> animals = new ArrayList<Animal>();
				animals.add(new Animal("fish", false, true));
				
				print(animals, a -> a.canHop());
			}
			private static void print(List<Animal> animals, Predicate<Animal> checker) {
				for (Animal animal : animals) {
					if (checker.test(animal))
					System.out.print(animal + " ");
				}
				System.out.println();
			}
		}    
### Consumer:(consommateur) 
L'interface fonctionnelle consommateur *Consumer*  a une méthode que vous devez connaître:

		void accept(T t)
Pourquoi souhaiteriez-vous recevoir une valeur et ne pas la renvoyer? Une raison courante est lors de 
l'impression d'un message:    

		Consumer<String> consumer = x -> System.out.println(x);
Nous avons déclaré la fonctionnalité pour afffiche la valeur qui nous a été donnée. C'est normal que nous n'ayons
pas encore de valeur. Lorsque le consommateur est appelé, la valeur sera fournie et affiche ensuite. Jetons un 
coup d'œil au code qui utilise un Consumer:   

	public class ConsumerPrint {

		public static void main(String[] args) {
			Consumer<String> consumer = x -> System.out.println(x);
			print(consumer, "Hello World");
		}
		
		private static void print(Consumer<String> consumer, String value) {
			consumer.accept(value);
		}
	}
Ce code affiche Hello World. C'est une version plus compliquée que celle que vous avez apprise en tant que premier programme. La méthode print() accepte un consommateur qui sait comment afficher une valeur. Lorsque la méthode accept() est appelée, le lambda s'exécute en fait, affichant la valeur.
### Supplier:(Fournisseur)   
L'interface fonctionnelle *Supplier* n'a que la méthode:   
		
		T get()
Un bon cas d'utilisation pour un Supplier est la création de valeur. Voici deux exemples:   

		public class SupplierGet {

			public static void main(String[] args) {
				Supplier<Integer> number = () -> 42;
				Supplier<Double> random = () -> Math.random();
				System.out.println(returnNumber(number));	// 42
				System.out.println(random.get());	// 0.7897090816772635
			}
			
			private static int returnNumber(Supplier<Integer> supplier) {
				return supplier.get();
			}
		}
Lorsque la méthode returnNumber() est appelée, elle appelle le lambda pour obtenir la valeur souhaitée. Dans le cas, la méthode renvoie 42.
### Comparator: (comparateur)   
Dans le chapitre «API Java Core», nous comparons les nombres. Nous n'avons pas fourni de comparateur *Comparator*  car nous utilisions l'ordre de tri par défaut. Nous avons appris les règles. Un nombre négatif signifie que les premières valeurs sont petites, zéro signifie qu'elles sont aquales et un nombre positif signifie que la valeur est plus grande. La signature de la méthode est la suivante:  

		int compare(T o1, T o2);
Cette interface est une interface fonctionnelle puisqu'elle n'a qu'une seule méthode non implémentée. Il dispose de nombreuses méthodes statiques et par défaut pour faciliter l'écriture de comparateurs complexes.   
* Remarque: L'interface Comparator existait avant l'ajout de lambda à Java. En conséquence, il est dans un emballage différent. Vous pouvez trouver Comparator dans java.util   

Le seul besoin de savoir compare() pour l'examen. Pouvez-vous savoir si cela trie par ordre croissant ou décroissant ?  

		Comparator<Integer> ints = (i1, i2) -> i1- i2;
Le comparateur ints utilise l'ordre de tri naturel. Du premier nombre est plus grand, il renverra un nombre positif. Essayez-le.   

	public class ComparatorTester {
	
		public static void main(String[] args) {
			Comparator<Integer> ints = (i1, i2) -> i1- i2;
			System.out.println(comparaison(8, 11, ints));	// 3
		}
		
		private static int comparaison(Integer o1, Integer o2, Comparator comparator) {
			return comparator.compare(o1, o2);
		}
	}
Du coup on peut conclure que 8 est infèrieur de 11.   
# Working with Variables in Lambdas: (Utilisation de variables dans Lambdas)  
### Parameter List: (Liste des paramètres)   
### Local Variables inside the Lambda Body: (Variables locales à l'intérieur du corps Lambda)   
### Variables Referenced from the Lambda Body: (Variables référencées à partir du corps Lambda)  
# Calling APIs with Lambdas: (Appeler des API avec Lambdas)  
### removeIf():
### sort():
### forEach():
