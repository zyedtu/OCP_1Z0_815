									Methods And Encapsulation
									
									
# Designing Methods: (Méthodes de conception) 
Chaque programme Java intéressant que nous avons vu a une méthode main (). Nous pouvons également écrire d'autres méthodes. Par exemple, nous pouvons écrire une méthode de base.   

		public final void nap(int minutes) throws InterruptedException {
				// take a nap
		}   
Maintenent on va décortiquer cette méthode:   
* public: c'est Modificateur d'accès (Access modifier), et n'est Obligatoire (No Required ).  
* final: Spécificateur facultatif (Optional specifier), et n'est pas Obligatoire (No Required).  
* void: Type de retour (Return type), et Obligatoire (Required).  
* (int minutes): Liste de paramèrtre (Parameter list), Oui Obligatoire mais on peut avoir des parenthèses vides.  
* throws InterruptedException: (Optional exception list), et n'est pas Obligatoire (No Required).   
* { // take a nap }: le cops de la méthode (Method body), Oui Obligatoire, mais peut être des accolades vides.   

Pour appeler cette méthode, tapez simplement son nom, suivi d'une seule valeur int entre parenthèses, *nap (10);*    
Commençons par examiner chacune de ces parties d’une méthode de base.   
### Access Modifiers: (Modificateurs d'accès)  
Java propose quatre choix de modificateurs d'accès:   
* **private:** Le modificateur privé signifie que la méthode ne peut être appelée qu'à partir de la même classe.  
* **Default (Package Private Access):** Avec un accès par défaut, la méthode ne peut être appelée qu'à partir des classes du même package. Celui-ci est délicat car il n'y a pas de mot-clé pour l'accès par défaut. Vous omettez simplement le modificateur d'accès.    
* **protected:** Le modificateur protected signifie que la méthode ne peut être appelée qu'à partir des classes du même package ou des mêmes sous-classes. Vous en apprendrez davantage sur les sous-classes au chapitre 8.   
* **public:** Le modificateur public signifie que la méthode peut être appelée à partir de n'importe quelle classe.  

Nous explorerons l'impact des différents modificateurs d'accès plus loin dans ce chapitre. Pour l'instant, il suffit de maîtriser l'identification de la syntaxe valide des méthodes. Les créateurs d'examens aiment vous tromper en mettant les éléments de méthode dans le mauvais ordre ou en utilisant des valeurs incorrectes.   
Faites attention aux modificateurs d'accès lorsque vous déterminez ce qui ne va pas avec ceux qui ne se compilent pas:   

		public void walk1() {}
		default void walk2() {} // DOES NOT COMPILE
		void public walk3() {} // DOES NOT COMPILE
		void walk4() {}
walk2() ne compile pas car la valeur par default n’est pas un modificateur d'accès valide.
walk3() ne compile pas car le modificateur d'accès est spécifié après le type de retour.  
### Optional specifier: (Optional Specifiers)  
Il existe un certain nombre de spécificateurs facultatifs, mais la plupart d'entre eux ne figurent pas à l'examen. Les spécificateurs facultatifs proviennent de la liste suivante. Contrairement aux modificateurs d'accès, vous pouvez avoir plusieurs spécificateurs dans la même méthode (bien que toutes les combinaisons ne soient pas légales). Lorsque cela se produit, vous pouvez les spécifier dans n'importe quel ordre. Et comme il est facultatif, vous ne pouvez en avoir aucun. Cela signifie que vous pouvez avoir **zéro ou plusieurs spécificateurs** dans une déclaration de méthode.   
* **static:** Couvert plus loin dans ce chapitre. Utilisé pour les méthodes de classe.  
* **abstract:** Couvert au chapitre 8. Utilisé lorsque le corps de la méthode n'est pas fourni. 
* **final:** Couvert au chapitre 8. Utilisé lorsqu'une méthode ne peut pas être redifinit par une sous-classe.   
* **synchronized:** Le modificateur synchronized est utilisé avec du code multithread.  
* **native:** Utilisé lors de l'interaction avec du code écrit dans un autre langage tel que C ++.
* **strictfp:** Utilisé pour rendre les calculs en virgule flottante portables.

Encore une fois, concentrez-vous simplement sur la syntaxe pour le moment:   

		public void walk1() {}
		public final void walk2() {}
		public static final void walk3() {}
		public final static void walk4() {}
		public modifier void walk5() {} // DOES NOT COMPILE
		public void final walk6() {} // DOES NOT COMPILE
		final public void walk7() {}
walk5() ne compile pas car "modifier" n'est pas un spécificateur facultatif valide.
walk6() ne compile pas car le spécificateur facultatif se trouve après le type de retour.
### Return Type: (Type de retour)  
L'élément suivant dans une déclaration de méthode est le type de retour. Le type de retour peut être un type Java tel que String ou int. S'il n'y a pas de type de retour, le mot clé void est utilisé. Ce type de retour spécial vient de la langue anglaise: void signifie sans contenu.  
Lors de la vérification des types de retour, vous devez également regarder à l'intérieur du corps de la méthode. Les méthodes avec un type de retour autre que void doivent avoir une instruction **return** dans le corps de la méthode. Cette instruction de retour doit inclure la primitive ou l'objet à renvoyer.   
Pouvez-vous expliquer pourquoi ces méthodes se compilent ou non ?  

		public void walk1() { }
		public void walk2() { return; }
		public String walk3() { return ""; }
		public String walk4() { } // DOES NOT COMPILE
		public walk5() { } // DOES NOT COMPILE
		String walk6(int a) { if (a == 4) return ""; } // DOES NOT COMPILE
walk4() ne compile pas car l'instruction return est manquante.  
walk5() ne compile pas car le type de retour est manquant.   
walk6() est un peu délicat. Il y a une instruction return, mais elle n'est pas toujours exécutée. Si a vaut 6, l'instruction return n'est pas exécutée. Étant donné que String doit toujours être renvoyée, donc ne complile pas.   

		int integer() {
			return 9;
		}
		int long() {
			return 9L; // DOES NOT COMPILE
		}
Le 2em exemple ne complie pas parce quel e type de la variable locale ne correspond pas au type de retour de la méthode.  
### Method Name: (Nom de la méthode)  
Les noms de méthodes suivent les mêmes règles que celles que nous avons pratiquées avec les noms de variables dans le chapitre 2, «Blocs de construction Java». Pour vérifier, un identifiant ne peut contenir que des lettres, des chiffres, des "$" ou des "_" . De plus, le premier caractère n'est pas autorisé à être un nombre. Les mots réservés ne sont pas autorisés. Par convention, les méthodes commencent par une lettre minuscule mais ne sont pas obligées de le faire.      

		public void walk1() { }
		public void 2walk() { } // DOES NOT COMPILE
		public walk3 void() { } // DOES NOT COMPILE
		public void Walk_$() { }
		pulic _() { }	// DOES NOT COMPILE
		public void() { } // DOES NOT COMPILE
2walk() ne compile pas car les identificateurs ne sont pas autorisés à commencer par des nombres.   
walk3() ne compile pas car le nom de la méthode est avant le type de retour.    
la méthode _() n'est pas autorisée car elle consiste en un seul trait de soulignement, depuis Java 9 "_"n'est plus autorisé comme identifiant.  
### Parameter List: (Liste des paramètres)   
Bien que la liste des paramètres soit obligatoire, elle peut  ne pas à avoir de paramètres. Cela signifie que vous pouvez simplement avoir une paire de parenthèses vides après le nom de la méthode, comme ci-dessous:   

		void nap()
Si vous avez plusieurs paramètres, séparez-les par une virgule. Il existe quelques règles supplémentaires pour la liste de paramètres que vous verrez lorsque nous aborderons les varargs. Pour l'instant, essayons de regarder les signatures de méthode avec des paramètres "normaux":   

		public void walk1() { }
		public void walk2 { } // DOES NOT COMPILE
		public void walk3(int a) { }
		public void walk4(int a; int b) { } // DOES NOT COMPILE
		public void walk5(int a, int b) { }
walk2() ne compile pas car il manque les parenthèses autour de la liste des paramètres.   
walk4() ne compile pas car les paramètres sont séparés par un point-virgule plutôt qu'une virgule.   
### Optional Exception List: (Liste d'exceptions facultative)  
En Java, le code peut indiquer que quelque chose s'est mal passé en levant une exception. Pour l'instant, il vous suffit de savoir qu'il est facultatif et dans quel endroit de la signature de la méthode va d'être declarer.   

	public void zeroExceptions() { }
	public void oneException() throws IllegalArgumentException { }
	public void twoExceptions() throws IllegalArgumentException, InterruptedException { }
Vous vous demandez peut-être ce que font les méthodes avec ces exceptions. La méthode appelante peut lever les mêmes exceptions ou les gérer.  
### Method Body : (Corps de la méthode)   
La dernière partie d’une déclaration de méthode est le corps de la méthode (sauf pour les méthodes abstraites et les interfaces, mais vous n’avez pas besoin de connaître l’une ou l’autre de celles-ci avant le prochain chapitre). Un corps de méthode est simplement un bloc de code. Il a des accolades qui contiennent zéro ou plusieurs instructions Java. Nous avons déjà passé plusieurs chapitres à examiner les instructions Java, vous devriez donc trouver facile de comprendre pourquoi celles-ci compilent ou non:   

		public void walk1() { }
		public void walk2; // DOES NOT COMPILE
		public void walk3(int a) { int name = 5; }
walk2() ne compile pas car il manque les accolades autour du corps de la méthode vide.  
# Working with Varargs: (Travailler avec Varargs)  
Une méthode peut utiliser un paramètre vararg (argument variable) comme s'il s'agissait d'un tableau, mais c'est une petite différence. Un paramètre vararg doit être le dernier élément de la liste de paramètres d'une méthode. Cela implique que nous sommes autorisé à avoir *un seul paramètre* vararg par méthode. Regardons ces méthodes avec varargs:   

		public void walk1(int... nums) { }
		public void walk2(int start, int... nums) { }
		public void walk3(int... nums, int start) { } // DOES NOT COMPILE
		public void walk4(int... start, int... nums) { } // DOES NOT COMPILE
walk3 () et walk4 () ne se compilent pas car ils ont un paramètre vararg dans une position qui n'est pas la dernière, en plus walk4() à 2 paramètres varargs et ce n'est pas correcte.   
Lors de l'appel d'une méthode avec un paramètre vararg, vous avez le choix. Vous pouvez transmettre un tableau, ou vous pouvez lister les éléments du tableau, ou  omettre les valeurs vararg dans l'appel de méthode (zéro varargas).  

		public static void main(String[] args) {
			walk(1); // 0
			walk(1, 2); // 1
			walk(1, 2, 3); // 2
			walk(1, new int[] {4, 5}); // 2
		}
	
		public static void walk(int start, int... nums) {
			System.out.println(nums.length);
		}
# Applying Access Modifiers: (Application des modificateurs d'accès)  
Vous avez déjà vu qu'il existe quatre modificateurs d'accès: accès public, privé, protégé et par défaut. Nous allons en discuter dans l'ordre du plus restrictif au moins restrictif:   
* **private:** accessible uniquement dans la même classe
* **default (package private) access:** classes privées et autres dans le même package
* **protected:** accès par défaut et classes enfants
* **public:** accès protected et classes dans les autres packages

private < default (package private) access < protected  < public (ordre croissant).  
### Private Access: (Accès privé)  
L'accès privé est facile. Seul le code de la même classe peut appeler des méthodes privées ou accéder à des champs privés.

	package ocp.chapiter07.pond.duck;
	public class FatherDuck {
		private String noise = "quack";

		private void quack() {
			System.out.println(noise); // private access is ok
		}
		
		private void makeNoise() {
			quack(); // private access is ok
		}
	}
la méthode quack() affiche l'attribut noise qui est private mais c'est ok dans la même classe.
la méthode makeNoise() appel le méthode quack() qui est privée c ok dans la même classe.
Regardons maintenant un autre exemple.  

		package ocp.chapiter07.pond.duck;
		public class BadDuckling {
			public void makeNoise() {
				FatherDuck duck = new FatherDuck();
				duck.quack(); // DOES NOT COMPILE
				System.out.println(duck.noise); // DOES NOT COMPILE
			}
		}
BadDuckling essaie d'accéder à des membres d'une autre classe (FatherDuck), au début on instance un objet de type FatherDuck, et après la classe BadDuckling essaye d'accéder à la méthode quack(), or elle est private donc n'est pas visible, par conséquent ça compile pas. Dans la ligne suivante il essaye d'accéder àl'attribut noise, pareil il est private donc erreur de compilation (non visible dans cette classe).
### Default (Package-Private) Access: (Accès par défaut (package-privé))
Lorsqu'il n'y a pas de modificateur d'accès, Java utilise la valeur par défaut, qui est l'accès privé au package. Cela signifie que le membre (méthodes est attributs) est "privé" pour les classes du même package. En d'autres termes, seules les classes du package peuvent y accéder.
Regardons cet exemple ci-dessous:

		package ocp.chapiter07.pond.duck;
		public class MotherDuck {
		
			 String noise = "quack";	// Default (Package-Private) Access
			 void quack() {
				 System.out.println(noise); // default access is ok
			 }
			 private void makeNoise() {
				 quack(); // default access is ok
			 }
		}
On déclare une 2ème classe dans le même package:

		package ocp.chapiter07.pond.duck;
		public class GoodDuckling {

			public void makeNoise() {
				MotherDuck duck = new MotherDuck();
				duck.quack(); // default access
				System.out.println(duck.noise); // default access
			}
		}
La classe GoodDuckling essaye d'accéder à des membres de la classe MotherDuck, donc on crée une reference sur l'objet MotherDuck, ensuit on appele la méthode quack(), comme cette méthode est a un modificateur d'acces par defaut est les 2 classes sont dans le même package alors elle est visible.

Maintenant, créant une autre classe mais dans un package different:
	
		package ocp.chapiter07.pond.swan;
		import ocp.chapiter07.pond.duck.MotherDuck;
		
		public class BadCygnet {
			public void makeNoise() {
				MotherDuck duck = new MotherDuck();
				duck.quack(); // DOES NOT COMPILE
				System.out.println(duck.noise); // DOES NOT COMPILE
		} }
Comme la classe BadCygnet se trouve dans le package "pond.swan" qui est different ud package de la classe MotherDuck " pond.duck", alors les membres par défaut ne sont pas visibles du cooup DOES NOT COMPILE.   
### Protected Access: (Accès protégé)  
L'accès protégé permet tout ce que permet l'accès par défaut (package privé) et plus encore. Le modificateur d'accès protégé ajoute la possibilité d'accéder aux membres d'une classe parent. Nous aborderons la création de sous-classes en profondeur dans le chapitre 8. Pour l'instant, nous aborderons l'utilisation la plus simple possible d'une classe enfant.    
Dans ce paragraphe on va créer trois classe differente {Bird, Gosling et BirdWatcher}, Bird et BirdWatcher appartiennent au même package, et Gosling extends de Bird.

		package ocp.chapiter07.pond.shore;

		public class Bird {
			protected String text = "floating"; // protected access
		
			protected void floatInWater() { // protected access
				System.out.println(text);
			}
		}
La classe Gosling qui hérite de Bird:

		package ocp.chapiter07.pond.goose;
		import ocp.chapiter07.pond.shore.Bird;
		
		public class Gosling extends Bird {
			public void swim() {
				floatInWater(); // calling protected member
				System.out.println(text); // calling protected member
			}
		}
Il s'agit d'une sous-classe très simple. Il étend la classe Bird. Étendre signifie créer une sous-classe qui a accès à tous les membres protégés ou publics de la classe parente. L'exécution de ce code affiche deux fois "floating", une fois à partir de l'appel de floatInWater() et une fois à partir de l'instruction print dans swim(). Étant donné que Gosling est une sous-classe de Bird, il peut accéder à ces membres même s'il se trouve dans un package différent.

La classe BirdWatcher qui est dans le même package de la classe Bird:

		package ocp.chapiter07.pond.shore;

		public class BirdWatcher {
			public void watchBird() {
				Bird bird = new Bird();
				bird.floatInWater(); // calling protected member
				System.out.println(bird.text); // calling protected member
			}
		}
Comme les deux classes sont dans le même package, alors la classe BirdWatcher peut accéderaux memebres protected de la classe Bird, donc ce code compile.

Regardons cet exemple qui est **tordu**: 

		package ocp.chapiter07.pond.swan;
		import ocp.chapiter07.pond.shore.Bird;
		
		public class Swan extends Bird {
			public void swim() {
				floatInWater(); // package access to superclass line 5
				System.out.println(text); // package access to superclass line 6
			}
		
			public void helpOtherSwanSwim() {
				Swan other = new Swan();
				other.floatInWater(); // package access to superclass line 10
				System.out.println(other.text);// package access to superclass line 11
			}
		
			public void helpOtherBirdSwim() {
				Bird other = new Bird();
				other.floatInWater(); // DOES NOT COMPILE line 15
				System.out.println(other.text); // DOES NOT COMPILE line 16
			}
		}
En remarque que les lignes 5, 6, 10 et 1 complient mais les ligne 15 et 16 ne compilent pas c'est etrange, n'est ce pas.
C’est normal d’être confus. C'est sans doute l'un des points les plus déroutants de l'examen. En regardant les choses d'une manière différente, les règles *protected* s'appliquent dans deux scénarios:
* Un membre est utilisé sans faire référence à une variable. C'est le cas des lignes 5 et 6. Dans ce cas, nous profitons de l'héritage et l'accès protégé est autorisé.      
* Un membre est utilisé via une variable (référance). C'est le cas aux lignes 10, 11, 15 et 16. Dans ce cas, ce sont les règles du type de référence de la variable qui comptent. S'il s'agit d'une sous-classe, l'accès protégé est autorisé.       

Dans la ligne 10 et 11 on a une référence de type Swan, donc sous-classe de Bird => Compile.
Dans la ligne 16 et 16 on a une référance de type Bird, n'est pas une sous-classe de Bird et n'est pas dans le même package de Bird => les membres protected ne sont pas visible donc ne compile pas.   
### Public Access: (Accès publique)   
L'accès protégé était un concept difficile. Heureusement, le dernier type de modificateur d'accès est simple: public signifie que tout le monde peut accéder au membre de la classe.  
Créant une classe "DuckTeacher" avec tout les membres public.

		package ocp.chapiter07.pond.duck;
		public class DuckTeacher {
			public String name = "helpful"; // public access
		
			public void swim() { // public access
				System.out.println("swim");
			}
		}
DuckTeacher permet d'accéder à n'importe quelle classe qui le souhaite. Maintenant, nous pouvons l'essayer:

		package ocp.chapiter07.pond.goose;
		import ocp.chapiter07.pond.duck.DuckTeacher;
		
		public class LostDuckling {
			public void swim() {
				DuckTeacher teacher = new DuckTeacher();
				teacher.swim(); // allowed
				System.out.println("Thanks" + teacher.name); // allowed
			}
		}
LostDuckling peut faire référence à swim() et au name sur DuckTeacher car ils sont publics. Les membres (méthodes et champs) sont visible à partir de la classe LostDuckling.
# Applying the static Keyword: (Application du mot-clé statique)  
Lorsque le mot clé static est appliqué à une variable, une méthode ou une classe, il s'applique à la classe plutôt qu'à une instance spécifique de la classe. Dans cette section, vous verrez que le mot-clé static peut également être appliqué aux instructions d'importation.  
### Designing static Methods and Fields: (Conception de méthodes et de champs statiques)  
À l'exception de la méthode main(), nous avons examiné les méthodes d'instance. Les méthodes statiques ne nécessitent pas d'instance de la classe. Ils sont partagés entre tous les utilisateurs de la classe. Vous pouvez considérer la statique comme un membre de l'objet de classe unique qui existe indépendamment de toute instance de cette classe.   
Nous avons vu une méthode statique depuis le chapitre 1. La méthode main() est une méthode statique. Cela signifie que vous pouvez l'appeler par le nom de la classe.  

		public class Koala {
			public static int count = 0; // static variable
			public static void main(String[] args) { // static method
				System.out.println(count);
			}
		}
Nous avons dit que la JVM d'appeler Koala.main () pour lancer le programme. Ce programme afficher 0.  
En plus des méthodes main(), les méthodes statiques ont deux objectifs principaux:
* Pour les méthodes utilitaires ou d'assistance qui ne nécessitent aucun état d'objet. Puisqu'il n'est pas nécessaire d'accéder aux variables d'instance, avoir des méthodes statiques élimine le besoin pour l'appelant d'instancier l'objet juste pour appeler la méthode.   
* Pour un état partagé par toutes les instances d'une classe, comme un compteur.  

### Accessing a static Variable or Method: (Accéder à une variable ou une méthode statique)  
Pour accéder à un membre statique, il suffit de mettre le nom de la classe avec la méthode ou la vriable.  

		System.out.println(Koala.count); 
En revanche,Vous pouvez utiliser une instance de l'objet pour appeler une méthode statique:

		public class Koala {
			public static int count = 0;
			public static void main(String[] args) {
				Koala k = new Koala();
				System.out.println(k.count); // k is a Koala
				k = null;
				System.out.println(k.count); // k is still a Koala
			}
		}
Ce code afficher 0 deux fois, pourtant on a mit k = null, or Java ne se soucie pas que k soit nul. Puisque nous recherchons un statique, cela n’a pas d’importance.  
Encore une fois parce que c'est vraiment important, ça donne quoi le suivant ?  

		Koala.count = 4;
		Koala koala1 = new Koala();
		Koala koala2 = new Koala();
		koala1.count = 6;
		koala2.count = 5;
		System.out.println(Koala.count);	// affiche 5
### Static vs. Instance: (Statique vs instance)  
Les créateurs d'examens essaieront d'une autre manière de vous tromper concernant les membres statiques et d'instance. (N'oubliez pas que «membre» signifie champ ou méthode.) Un membre statique ne peut pas appeler un membre d'instance. Cela ne devrait pas être une surprise car statique ne nécessite aucune instance de la classe.    
Voici une erreur courante des programmeurs débutants:   

	 public class Static {
		 private String name = "Static class";
		 public static void first() { }
		 public static void second() { }
		 public void third() { System.out.println(name); }
		 
		 public static void main(String args[]) {
			 first();
			 second();
			 third(); // DOES NOT COMPILE
			 System.out.println(name); // DOES NOT COMPILE
		 }
	 }
On constate que le compilateur génère une erreur sur la métohde third() et le champ "name", c'est normal parce que ces deux membres non sont pas static donc on peut pas les appeler dans une méthode static.   
Pour resoudre le problème on a deux solutions: 
* Soit on ajoute le modificateur static devant la méthode third().
* On appelle la méthode third() comme une méthode d'instance new Static().third();    

Pour vulgariser la règle des appels des méthodes:  
* Une méthode static ou méthode d'instance peut appeler une méthode static.
* Seule une méthode d'instance peut appeler une autre méthode d'instance sur la même classe sans utilisée une référence. 

Regardons cet exemple:

		public class Gorilla {
			public static int count;
			public static void addGorilla() { count++; }
			public void babyGorilla() { count++; }
			
			public void announceBabies() {
				addGorilla();
				babyGorilla();
			}
			
			public static void announceBabiesToEveryone() {
				addGorilla();
				babyGorilla(); // DOES NOT COMPILE line 11
				Gorilla gorilla = new Gorilla();
				gorilla.babyGorilla();// COMPILE
			}
			public int total;
			public static average = total / count; // DOES NOT COMPILE line 14
		}
La ligne 11 ne compile pas car une méthode statique ne peut pas appeler une méthode d'instance.  
De même, la ligne 14 ne compile pas car une variable static tente d'utiliser une variable d'instance.  
Une utilisation courante des variables statiques consiste à compter le nombre d'instances:  

	public class Counter {
		private static int count;
		public Counter() { count++; }
		
		public static void main(String[] args) {
			 Counter c1 = new Counter();
			 Counter c2 = new Counter();
			 Counter c3 = new Counter();
			 System.out.println(count); // 3
		}
	}
Chaque fois que le constructeur est appelé, il incrémente le nombre de 1.  
### Static Variables: (Variables statiques)  
Certaines variables statiques sont censées changer pendant l'exécution du programme. Les compteurs sont un exemple courant. Vous pouvez initialiser une variable statique sur la ligne où elle est déclarée:

		public class Initializers {
			private static int counter = 0; // initialization
		}
Mais il y a d'autres variables statiques sont censées ne jamais changer pendant le programme. Ce type de
variable est appelé constante.

		public class Initializers {
		private static final int NUM_BUCKETS = 45;
		
		public static void main(String[] args) {
				NUM_BUCKETS = 5; // DOES NOT COMPILE
		} }
Comme la variable de classe est définit final on peut pas le modifier après initialisation. Que 
Pensez-vous de cet exemple:

		private static final ArrayList<String> values = new ArrayList<>();
		
		public static void main(String[] args) {
			values.add("changed");
		}
Ca compile en fait. "values" est une variable de référence. Nous sommes autorisés à appeler des méthodes sur des variables de référence. Tout ce que le compilateur peut faire est de vérifier que nous n’essayons pas de réaffecter les valeurs finales pour pointer vers un objet différent.	   
### Static Initialization: (Initialisation statique)  
Dans le chapitre 2, nous avons couvert les initialiseurs d'instances qui ressemblaient à des méthodes sans nom. Il suffit de coder entre accolades. Les initialiseurs statiques se ressemblent. Ils ajoutent le mot-clé static pour spécifier qu'ils doivent être exécutés lors de la première utilisation de la classe. Par exemple:  

		private static final int NUM_SECONDS_PER_HOUR;
		static {
			int numSecondsPerMinute = 60;
			int numMinutesPerHour = 60;
			NUM_SECONDS_PER_HOUR = numSecondsPerMinute * numMinutesPerHour;
		}
L'initialiseur statique s'exécute lorsque la classe est utilisée pour la première fois. Les instructions qu'il contient s'exécutent et affectent toutes les variables statiques selon les besoins. Il y a quelque chose d'intéressant dans cet exemple. Nous venons juste de dire que les variables finales ne peuvent pas être réaffectées. La clé ici est que l'initialiseur statique est la première affectation. Et comme cela se produit à l'avant, ça va.   
Essayons un autre exemple pour vous assurer que vous comprenez la distinction:

		public class StaticInitialization {
			private static int one;
			private static final int two;
			private static final int three = 3;
			private static final int four; // DOES NOT COMPILE
			static {
				one = 1;
				two = 2;
				three = 3; // DOES NOT COMPILE
				two = 4; // DOES NOT COMPILE
			}
		}
la variable "four" est déclaré comme une variable finale qui n'est jamais initialisée.   
la variable "three" est initialisé 2 fois ne compile pas.  
la variable"two" pareil, intialisée deux fois.   
### Static Imports: (Importations statiques)    
Dans le chapitre 1, nous avons vu que nous pouvions importer une classe spécifique ou toutes les classes d'un package:  

		import java.util.ArrayList;
		import java.util.*;
Nous pourrions utiliser cette technique pour importer:   

		import java.util.List;
		import java.util.Arrays;
		public class Imports {
			public static void main(String[] args) {
				List<String> list = Arrays.asList("one", "two");
			}
		} 
Les importations sont pratiques car vous n’avez pas besoin de spécifier d’où vient chaque classe à chaque fois que vous l’utilisez. Il existe un autre type d'importation appelé importation statique. Les importations régulières sont destinées à l'importation de classes. Les importations statiques servent à importer des membres statiques de classes. Tout comme les importations régulières, vous pouvez utiliser un caractère générique ou importer un membre spécifique. L’idée est que vous ne devriez pas avoir à spécifier d’où provient chaque méthode ou variable statique chaque fois que vous l’utilisez. Regardons cet exemple:   

		import java.util.List;
		import static java.util.Arrays.asList; // static import
		public class StaticImports {
			public static void main(String[] args) {
				List<String> list = asList("one", "two");
			}
		}
Dans cet exemple, nous importons spécifiquement la méthode asList. Cela signifie que chaque fois que nous nous référons à asList dans la classe, il appellera Arrays.asList().   
Le compilateur se plaindra si vous essayez de faire explicitement une importation statique de deux méthodes avec le même nom ou de deux variables statiques avec le même nom. Par exemple: 

		import static statics.A.TYPE;
		import static statics.B.TYPE; // DOES NOT COMPILE
Heureusement, lorsque cela se produit, nous pouvons simplement faire référence aux membres statiques via leur nom de classe dans le code au lieu d'essayer d'utiliser une importation statique.  
# Passing Data among Methods: (Transmission de données entre méthodes)  
### Pass-by-value:  
Java est un langage «pass-by-value». Cela signifie qu'une copie de la variable est effectuée et que la méthode reçoit cette copie. Les attributions effectuées dans la méthode n'affectent pas l'appelant. Prenons un exemple:

	public class PassingDataamongMethods {
	
		public static void main(String[] args) {
			int num = 4;
			newNumber(num);
			System.out.println(num);	// 4
		}
		
		public static void newNumber(int num) { num = 8; }
	}
Ici la variable "num" reçoit la valeur 4. Ensuite, nous appelons la méthode newNumber() en passant une copie de la variable "num" comme paramètre. La variable "num" ne change jamais car aucune affectation ne lui est faite.  

Maintenant que vous avez vu les primitives, essayons un exemple avec un type de référence. Que pensez-vous du code suivant ?

		public static void main(String[] args) {
			String name = "Webby";
			speak(name);
	    	System.out.println(name);	// Webby
		}	
			
		public static void speak(String p) { p = "Sparky"}; }
La bonne réponse est Webby. Tout comme dans l'exemple primitif, l'affectation de variable est uniquement au paramètre de méthode et n'affecte pas l'appelant. 
En fait on va shematiser cet exemple:
name -> "Webby", en passant name dans la méthode speak() on passe une copie de la référfence name, donc:  
name -> "Webby" <- p (avec p une copie de la référence name), ensuite dans la methode static speak() on affecte cette copie: p-> "Sparky" et name toujours refère sur "Webby", alors on peut dire L'appelé peut faire ce qu'il veut avec sa copie sans jamais modifier la référence d'origine détenue par l'appelant.  

Remarquez comment nous parlons constamment d'attributions de variables. C'est parce que nous pouvons appeler des méthodes sur les paramètres. À titre d'exemple, nous avons du code qui appelle une méthode sur le StringBuilder passé dans la méthode:

		public static void main(String[] args) {
			StringBuilder sb = new StringBuilder("Sparky");
			speak(sb);
			System.out.println(sb); // SparkyWebby
		}
		
		public static void speak(StringBuilder s) { s.append("Webby"); }
Dans ce cas, la sortie est SparkyWebby car la méthode appelle simplement une méthode sur le paramètre. Il n'attribue pas de "sb" à un objet différent.  
vous pouvez voir comment le pass-by-value est toujours utilisé."s" est une copie de la variable "sb". Les deux pointent vers le même Objet de type StringBuilder "Sparky" ( sb-> "Sparky" <- s ), ce qui signifie que les modifications apportées au StringBuilder sont disponibles pour les deux références.  

Pour prouvez que Java utilise le passage par valeur pour obtenir des données dans une méthode. L’attribution d’une nouvelle primitive ou d’une nouvelle référence à un paramètre ne change pas l’appelant.
### Exemple avec return type:  
Récupérer la valuer de retour d'une méthode est facile. Une copie est faite de la primitive ou de la référence et renvoyée par la méthode. La plupart du temps, cette valeur renvoyée est utilisée. Par exemple, il peut être stocké dans une variable. Si la valeur renvoyée n'est pas utilisée, le résultat est ignoré. Surveillez cela lors de l'examen. Les valeurs renvoyées ignorées sont délicates.  

		public class ReturningValues {
			public static void main(String[] args) {
				int number = 1; // 1
				String letters = "abc"; // abc
				number(number); // 1
				letters = letters(letters); // abcd
				System.out.println(number + letters); // 1abcd
			}
		
			public static int number(int number) {
				number++;
				return number;
			}
			
			public static String letters(String letters) {
				letters += "d";
				return letters;
			}
		}
# Overloading Methods: (Surcharge de méthodes) 
Maintenant que vous êtes familiarisé avec les règles de déclaration des méthodes, il est temps de créer des méthodes avec la même signature dans la même classe. La surcharge de méthode se produit lorsqu'il existe différentes signatures de méthode avec le même nom mais des paramètres différents ou de type différents. Tout autre que la signature de méthode peut varier pour les méthodes surchargées. Cela signifie qu'il peut y avoir une différence des modificateurs d'accès, spécificateurs (comme static), types de retour et listes d'exceptions mais n'impliquent pas sur le Overloading de la méthode.   
Ce sont toutes des méthodes surchargées (Overloading) valides:

		public void fly(int numMiles) { }
		public void fly(short numFeet) { }
		public boolean fly() { return false; }
		void fly(int numMiles, short numFeet) { }
		public void fly(short numFeet, int numMiles) throws Exception { }
Comme vous pouvez le voir, nous pouvons surcharger en modifiant n'importe quoi dans la liste des paramètres. Nous pouvons avoir un type différent, plusieurs types ou les mêmes types dans un ordre différent. Notez également que le modificateur d'accès et la liste d'exceptions ne sont pas dans la règle  pour la surcharge.  
Regardons maintenant un exemple de surcharge qui n'est pas valide:

		public void fly(int numMiles) { }
		protected void fly(int numMiles) { }	// DOES NOT COMPILE
		public int fly(int numMiles) { } // DOES NOT COMPILE
		public static void fly(int numMiles) { } // DOES NOT COMPILE
protected est un modificateur d'acces donc la méthode ne compile pas.
La deuxième erreur dû que la difference entre les 2 méthode est la valeur de retour void et int, mais on garde la même signature, donc erreur de compilation. 
La 3em erreur, la signature de la méthode et la même, la seul difference est le specificatuer static. 

L'appel de méthodes surchargées est facile. Vous écrivez simplement du code et Java appelle le bon. Par exemple, regardez ces deux méthodes:  

		public void fly(int numMiles) {
		 System.out.println("short");
		}
		public void fly(short numFeet) { // Ok Overloading
		 System.out.println("short");
		} 
Pour appeler la méthode avec le paramètre short, il suffit de faire ça:  fly((short) 1);   	
### Varargs
Quelle méthode pensez-vous est appelée si nous passons un int [] ?

		public void fly(int[] lengths) { }
		public void fly(int... lengths) { } // DOES NOT COMPILE		  
Question piège! N'oubliez pas que Java traite les varargs comme s'il s'agissait d'un tableau. Ça signifie
que la signature de la méthode est la même pour les deux méthodes donc ne compile pas !   
### Autoboxing: 
Dans le chapitre 5, vous avez vu comment Java convertit un int primitif en un objet Integer pour l'ajouter à une ArrayList à travers les merveilles de l'autoboxing. Cela fonctionne aussi pour le code que vous écrivez.  

		public void fly(int numMiles) { }
		public void fly(Integer numMiles) { }	// OK Overloading
Si on essaye d'appeler fly(3); avec un type primitive, qq ça va passer ?
Java correspondra à la version int numMiles. Java essaie d'utiliser la liste de paramètres la plus spécifique qu'il peut trouver. Lorsque la version primitive int n'est pas présente, elle sera autobox.  
### Reference Types: (Types de référence)   
Compte tenu de la règle selon laquelle Java choisit la version la plus spécifique d'une méthode possible, que pensez-vous que ce code produit ? 

		public class ReferenceTypes {

			public static void main(String[] args) {
				ReferenceTypes r = new ReferenceTypes();
				r.fly("test");	// String
				r.fly(56);	// Object
			}
			
			public void fly(String s) {
				 System.out.println("string ");
			}
			 
			public void fly(Object o) {
				System.out.println("object ");
			}
		}
Le premier appel est une chaîne et trouve une correspondance directe. Il n'y a aucune raison d'utiliser la version Object.   
Le deuxième appel recherche une liste de paramètres int. Lorsqu'il n'en trouve pas, il renvoie automatiquement à Integer. Puisqu'il ne trouve toujours pas de correspondance, il passe à l'objet un.  
### Primitives: 
Les primitives fonctionnent de manière similaire aux variables de référence. Java essaie de trouver la méthode surchargée correspondante la plus spécifique. Que pensez-vous qu'il se passe ici ?   
		public class Plane {

			public static void main(String[] args) {
				Plane p = new Plane();
				 p.fly(123);	// int
				 p.fly(123L);	// long
			}
		
			public void fly(int i) {
				System.out.println("int ");
			}
			
			public void fly(long l) {
				System.out.println("long ");
			}
		}
Le premier appel passe un int et trouve une correspondance exacte.  
Le deuxième appel passe un long et trouve également une correspondance exacte.    
### Generics:   
Vous serez peut-être surpris d'apprendre que ces surcharges non valides.  

	public void walk(List<String> strings) {}
	public void walk(List<Integer> integers) {}	// DOES NOT COMPILES
Java a un concept appelé effacement de type où les génériques *type erasure* ne sont utilisés qu'au moment de la compilation. Cela signifie que le code compilé ressemble à ceci:  

	public void walk(List<String> strings) {}
	public void walk(List<Integer> integers) {}
Nous ne pouvons clairement pas avoir deux méthodes avec la même signature de méthode, donc cela ne compile pas. N'oubliez pas que les surcharges de méthode doivent différer dans au moins un des paramètres de méthode.  
### Arrays: 
Contrairement à l'exemple précédent, ce code est correcte:

	public static void walk(int[] ints) {}
	public static void walk(Integer[] integers) {}
Les tableaux existent depuis le début de Java. Ils spécifient leurs types réels et ne participent pas à l'effacement (erasure).     
### Putting it All Together: (Mettre tous ensemble) 
Jusqu'à présent, toutes les règles relatives au moment où une méthode surchargée est appelée doivent être logiques. Java appelle la méthode la plus spécifique possible. Lorsque certains types interagissent, les règles Java se concentrent sur la compatibilité descendante. Dans Java 1.4 et versions antérieures, l'autoboxing et les varargs n'existaient pas. Même si c'était il y a longtemps, l'ancien code doit encore fonctionner - ce qui signifie que l'auto-box et les varargs viennent en dernier lorsque Java examine les méthodes surchargées. 

Ordre que Java utilise pour choisir la bonne méthode surchargée: Rules -> Example of what will be chosen for glide(1,2)  
* Correspondance exacte par type: public String glide(int i, int j) {}  
* Type primitif plus grand: public String glide(long i, long j) {}   
* Type Autoboxed: public String glide(Integer i, Integer j) {}  
* Varargs public String glide(int... nums) {} 

Pratiquons ceci en utilisant les règles:  

		public class Glider2 {
			
			public static String glide(String s) {
				return "1";
			}
			
			public static String glide(String... s) {
				return "2";
			}
			
			public static String glide(Object o) {
				return "3";
			}
			
			public static String glide(String s, String t) {
				return "4";
			}
			
			public static void main(String[] args) {
				System.out.print(glide("a"));
				System.out.print(glide("a", "b"));
				System.out.print(glide("a", "b", "c"));
			}
		}
Il affiche **142**. Le premier appel correspond à la signature en prenant une seule chaîne car c'est la correspondance la plus spécifique. Le deuxième appel correspond à la signature, en prenant deux paramètres String car il s'agit d'une correspondance exacte. Ce n’est qu’au troisième appel que la version varargs est utilisée car il n’ya pas de meilleures correspondances.  

Aussi accommodant que Java puisse essayer de trouver une correspondance, il ne fera qu'une seule conversion:  

		public class TooManyConversions {
		
			public static void play(Long l) { }
			public static void play(Long... l) { }
			
			public static void main(String[] args) {
				play(4); // DOES NOT COMPILE
				play(4L); // calls the Long version
			}
		}
Ici, nous avons un problème. Java est content de convertir le int 4 en un long 4 ou un Integer 4. Il ne peut pas gérer la conversion en deux étapes en un long, puis en un Long. Si nous avions public static void play (Object o) {}, cela correspondrait car une seule conversion serait nécessaire: de int à Integer. Un entier est un objet, comme vous le verrez au chapitre 8.
# Encapsulating Data: (Encapsulation des données) 
Au chapitre 2, nous avons eu un exemple de classe avec un champ qui n’était pas privé:   

		public class Swan {
			int numberEggs; // instance variable
		}
Nous n'avons plus le contrôle de ce qui se passe dans notre propre classe. Un appelant pourrait même 
écrire ceci: mother.numberEggs = -1; est ça ce n'est pas bon.   
L'encapsulation signifie que nous configurons la classe afin que seules les méthodes de la classe puissent faire référence aux variables d'instance. Les appelants doivent utiliser ces méthodes.   
Jetons un coup d'œil à notre nouvelle classe Swan:  

		public class Swan {
			private int numberEggs; // private
			
			public int getNumberEggs() { // getter
				return numberEggs;
			}
			
			public void setNumberEggs(int numberEggs) { // setter
				if (numberEggs >= 0) // guard condition
					this.numberEggs = numberEggs;
		} }
Remarque numberEggs est désormais privé, et nous avons ajouter deux méthodes public, getNumberEggs() pour lire la variable est appelée accessor ou getter, et la deuxième methode setNumberEggs(int numberEggs) qui permet de mettre à jour la valeur est appelée mutator ou setter. Le setter a une instruction if dans cet exemple pour éviter de définir la variable d'instance sur une valeur non valide. Cette condition de garde protège la variable d'instance.   

Pour l'encapsulation, rappelez-vous que les données (les variables d'instance) sont privées et que les getters/setters sont publics.   
Java définit une convention de nomination en se basant sur le standard JavaBeans, les varaibles d'instances sont applelées *propiètées* et sont privée, et la règle des getter/setter ci-dessous:

### Rules for JavaBeans naming conventions:    
* Les propriétés sont privées: private int numberEggs;
* Les méthodes getter commencent par "is" si la propriété est un booléen: 

		public boolean isHappy() {
			 return happy;
		}
* Les méthodes Getter commencent par get si la propriété n'est pas un booléen:

		public int getNumEggs() {
			return numEggs;
		}
* Les méthodes Setter commencent par set:

		public void setHappy(boolean happy) {
			this.happy = happy;
		}
* Le nom de la méthode doit avoir le préfixe set/get/is, suivi de la première lettre de la propriété en majuscules, suivie du reste du nom de la propriété.  

Il est temps de pratiquer. Voyez si vous pouvez déterminer quelles lignes suivent les conventions de dénomination JavaBeans: 

		private boolean playing;
		private String name;
		public boolean getPlaying() { return playing; }	// KO
		public boolean isPlaying() { return playing; }	// OK
		public String name() { return name; }	// KO
		public void updateName(String n) { name = n; }	// KO
		public void setname(String n) { name = n; }	// KO
getPlaying(): ne suit pas les conventions de dénomination JavaBeans (isPlaying()).     
name(): ne suit pas les conventions de dénomination JavaBeans (getName()).  
updateName(String n):  ne suit pas les conventions de dénomination JavaBeans (setName(String n)).   
setname(String n): ne suit pas les conventions de dénomination JavaBeans (setName(String n)).   
### Creating Immutable Classes: (Création de classes immuables)  
L'encapsulation des données est utile car elle empêche les appelants d'apporter des modifications incontrôlées à votre classe. Une autre technique courante consiste à rendre les classes immuables afin qu'elles ne puissent pas être modifiées du tout. La classe "String" est un cas concré des classe immutable.  
Une étape pour rendre une classe immuable est d'omettre les setters,mais au même temps nous voulons toujours que l'appelant puisse spécifier la valeur initiale, donc on doit crée un constructeur:  

		public class ImmutableClasses {
			 private int numberEggs;
			 
			 public ImmutableClasses (int numberEggs) {
				 this.numberEggs = numberEggs;
			 }
			 
			 public int getNumberEggs() {
				 return numberEggs;
			 }
		}