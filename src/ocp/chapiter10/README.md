											EXCEPTIONS

											
# Understanding Exceptions: (Comprendre les exceptions)   
Un programme peut échouer pour n'importe quelle raison. Voici quelques possibilités:  
* Le code tente de se connecter à un site Web, mais la connexion Internet est interrompue.  
* Vous avez commis une erreur de codage et tenté d'accéder à un index non valide dans un tableau.  
* Une méthode en appelle une autre avec une valeur que la méthode ne prend pas en charge.   

Comme vous pouvez le voir, certaines de ces erreurs sont des erreurs de codage. D'autres sont totalement hors de votre contrôle. Votre programme ne peut pas l’aider si la connexion Internet tombe en panne. Ce qu'il peut faire, c'est gérer la situation.   
Tout d'abord, nous examinerons le rôle des exceptions. Nous aborderons ensuite les différents types d'exceptions, suivis d'une explication sur la manière de lever une exception en Java.   
### The Role of Exceptions: (Le rôle des exceptions)  
Une exception est la manière de Java de dire: «J'abandonne. Je ne sais pas quoi faire maintenant. Lorsque vous écrivez une méthode, vous pouvez soit gérer l'exception, soit laisser le problème au code appelant. Ce sont les deux approches utilisées par Java pour traiter les exceptions.  
Des exceptions peuvent se produire tout le temps, même dans un code de programme solide. À l'examen, les exceptions concernent en grande partie des erreurs dans les programmes. Par exemple, un programme peut essayer d'accéder à une position non valide dans un tableau. Le point clé à retenir est que les exceptions modifient le *flux du programme*. 

Vous avez vu une exception dans le chapitre 1, «Bienvenue à Java», avec un exemple très simple de Zoo. Vous avez écrit une classe qui a imprimé le nom du zoo:     

		public class Zoo {
			public static void main(String[] args) {
				System.out.println(args[0]);	// Line 3
				System.out.println(args[1]);	// Line 4
			}
		}
Ensuite, vous avez essayé de l'appeler sans suffisamment d'arguments:   
> javac Zoo.java   
> java Zoo    

À la ligne 4, Java a réalisé qu’il n’y avait qu’un seul élément dans le tableau et que l’index 1 n’était pas autorisé. Java a jeté ses mains dans la défaite et a jeté une exception. Il n’a pas essayé de gérer l’exception. Il a simplement dit: "Je ne peux pas y faire face" et l'exception a été affichée:     
*Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0  at ocp.chapiter10.Zoo.main(Zoo.java:4)* 
### Understanding Exception Types: (Comprendre les types d'exceptions)   
Comme nous l'avons expliqué, une exception est un événement qui modifie le flux du programme. Java a une superclasse **Throwable** pour tous les objets qui représentent ces événements. Tous n'ont pas le mot exception dans leur nom de classe, ce qui peut prêter à confusion. Ci-dessous on montre les sous-classes clés de Throwable.      

	java.lang.Object  
		^  
		|   
	java.lang.Throwable -> java.lang.Error   
		^    
		|  
	java.lang.Exception    
		^  
		|  
	java.lang.RuntimeException  
Une erreur signifie que quelque chose s'est tellement mal passé que votre programme ne devrait pas tenter de s'en remettre. Par exemple, le lecteur de disque a «disparu» ou le programme a manqué de mémoire. Ce sont des conditions anormales que vous ne rencontrerez probablement pas et dont vous ne pourrez pas vous remettre.    
Pour l'examen, la seule chose que vous devez savoir sur Throwable est qu'il s'agit de la classe *parente de toutes les exceptions,* y compris la classe Error.  Bien que vous puissiez gérer les exceptions Throwable et Error, il n'est pas recommandé de le faire en le faisant dans le code de votre application. Dans ce chapitre, lorsque nous faisons référence aux exceptions, nous entendons généralement toute classe qui hérite de Throwable, bien que nous travaillions presque avec la classe ou la sous-classe Exception de celle-ci.   
###### Checked Exceptions: (Exceptions Contrôlées)  
Une *exception contrôlée* est une exception qui doit être déclarée ou gérée par le code d'application là où elle est levée. En Java, les exceptions contrôlée héritent toutes de la classe Exception mais pas de RuntimeException. les exceptions vérifiées ont tendance à être une exception anticipée - par exemple, essayer de lire un fichier qui n'existe pas.   
Exceptions contrôlée ? Que contrôlons-nous ? Java a une règle appelée le gestionnaire ou la règle de déclaration. Pour les exceptions contrôlée, Java requiert que le code les gère ou les déclare dans la signature de la méthode.   
Parce que les exceptions contrôlées ont tendance à être anticipées, Java impose au programmeur de faire quelque chose pour montrer que l'exception a été pensée. Peut-être que cela a été géré dans la méthode. Ou peut-être que la méthode déclare qu'elle ne peut pas gérer l'exception et que quelqu'un d'autre devrait le faire.   
Jetons un œil à un exemple. La méthode fall() suivante déclare qu'elle pourrait lever une IOException, qui est une exception contrôlée: 

		void fall(int distance) throws IOException {
			if(distance > 10) {
				throw new IOException();
			}
		}
* Remarque: dans cet exemple on utilise deux mot-clé, le premier **throw** dit a Java que vous voulez **lever** une exception, alors que le mot-clé **throws**  déclare que votre méthode peurrait **propager** une exception.  

Maintenant que vous savez comment déclarer une exception, comment la gérez-vous ? La version alternative suivante de la méthode fall() gère l'exception:  

	void fall(int distance) throws IOException {
			try {
				if(distance > 10) {
					throw new IOException();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
Notez que l'instruction catch utilise Exception, pas IOException. Étant donné que IOException est une sous-classe d'Exception, le bloc catch est autorisé à l'attraper. Nous aborderons plus en détail les blocs try et catch plus loin dans ce chapitre.     
###### Unchecked Exceptions: (Exceptions non Contrôlées)
Une *exception non contrôlée* est une exception qui n'a pas besoin d'être déclarée ou gérée par le code d'application où elle est levée. Exception non contrôlée est souvent appelée exception d'exécution, bien qu'en Java, exception non contrôlée inclut toute classe qui hérite de RuntimeException ou Error.   
L'exception de d'exécution *runtime exception*, est définie dans la classe RuntimeException et ses sous-classes.    
Les exceptions de d'exécutions ont tendance à être inattendus mais pas nécessairement fatals. Par exemple, l'accès à un index de tableau non valide est inattendu. Même s'ils héritent de la classe Exception, ils ne sont pas des exceptions contrôlées.   
*Runtime vs. at the Time the Program is Run (Exécution vs au moment où le programme est compilé)*: Une exception d'exécution (non contrôlée) est un type d'exception spécifique. Toutes les exceptions se produisent au moment de l'exécution du programme. (L'alternative est le temps de compilation, ce qui serait une erreur du compilateur.) Les gens ne se réfèrent pas à eux comme des exceptions d'exécution car ce serait trop facile à confondre avec l'exécution! Lorsque vous voyez runtime, cela signifie non contrôlé.   
Une exception non contrôlée peut souvent se produire sur presque toutes les lignes du code, car il n'est pas nécessaire de la traiter ou de la déclarer. Par exemple, un NullPointerException peut être levé dans le corps de la méthode suivante si la référence d'entrée est nulle:

		void fall(String input) {
			System.out.println(input.toLowerCase());
		} 
Nous travaillons si fréquemment avec des objets en Java qu'un NPE peut se produire presque partout. Si vous deviez déclarer une exception non contrôlée partout, chaque méthode aurait cet encombrement!  
*Checked vs. Unchecked (Runtime) Exceptions: (Contôlée vs non contrôlée exception )* Par le passé, les développeurs utilisaient plus souvent des exceptions contrôlées qu'aujourd'hui. Selon Oracle, ils sont destinés aux problèmes dont un programmeur «pourrait raisonnablement s'attendre à se remettre». Ensuite, les développeurs ont commencé à écrire du code où une chaîne de méthodes continuait à déclarer la même exception et personne ne l'a réellement gérée. Certaines bibliothèques ont commencé à utiliser des exceptions d'exécution pour les problèmes dont un programmeur pourrait raisonnablement s'attendre à récupérer. De nombreux programmeurs peuvent tenir un débat avec vous sur l'approche qui est la meilleure. Pour l'examen OCA, vous devez connaître les règles de fonctionnement des exceptions contrôlées et non contrôlées. Vous n’avez pas à décider philosophiquement si une exception doit être contrôlée ou non.       
### Throwing an Exception: (Lever une exception)  
Tout code Java peut lever une exception, cela inclut le code que vous écrivez. Pour l'examen OCP, vous apprendrez à créer vos propres classes d'exception. L'examen OCA est limité aux exceptions créées par quelqu'un d'autre. Très probablement, ce seront des exceptions fournies avec Java. Vous pouvez rencontrer une exception qui a été compensée pour l'examen. C'est bon. La question rendra évident que ce sont des exceptions en ayant le nom de classe se terminant par exception. Par exemple, «MyMadeUpException» est clairement une exception.    
Lors de l'examen, vous verrez deux types de code qui entraînent une exception. Le premier est un code erroné. Par exemple:  

		String[] animals = new String[0];
		System.out.println(animals[0]);
Ce code lève une ArrayIndexOutOfBoundsException car le tableau ne contient aucun élément. Cela signifie que les questions sur les exceptions peuvent être cachées dans des questions qui semblent concerner autre chose.   

La deuxième façon pour que le code génère une exception est de demander explicitement à Java d'en lancer une. Java vous permet d'écrire des instructions comme celles-ci:   

		throw new Exception();
		throw new Exception("Ow! I fell.");
		throw new RuntimeException();
		throw new RuntimeException("Ow! I fell.");
Le mot-clé throw indique à Java que vous souhaitez qu'une autre partie du code traite l'exception. C'est la même chose que la jeune fille qui pleure pour son papa. Quelqu'un d'autre doit déterminer ce qu'il faut faire à propos de l'exception.   
* throw vs throws: Chaque fois que vous voyez throw ou throws dans l'examen, assurez-vous que le bon est utilisé. Le mot clé throw est utilisé comme une instruction à l'intérieur d'un bloc de code pour lever une nouvelle exception ou renvoyer une exception existante, tandis que le mot clé throws n'est utilisé qu'à la fin d'une déclaration de méthode pour indiquer quelle exception est prise en charge.  

Lors de la création d'une exception, vous pouvez généralement transmettre un paramètre String avec un message ou vous ne pouvez passer aucun paramètre et utiliser les valeurs par défaut. Nous disons généralement parce que c'est une convention. Quelqu'un pourrait créer une classe d'exception qui n'a pas de constructeur qui accepte un message. Les deux premiers exemples créent un nouvel objet de type Exception et le lancent. Les deux derniers montrent que le code est le même quel que soit le type d'exception que vous lancez.  

En outre, vous devez savoir qu'*une exception est un objet*. Cela signifie que vous pouvez stocker dans une variable, et c'est légale:  

			Exception e = new RuntimeException();
			throw e;
Le code instancie une exception sur une ligne, puis lève sur la suivante. L'exception peut venir de n'importe où, même passée dans une méthode. Tant qu'il s'agit d'une exception valide, elle peut être levée.  

L'examen pourrait également essayer de vous tromper. Voyez-vous pourquoi ce code ne se compile pas ?  

		throw RuntimeException();	//DOES NOT COMPILE
Si votre réponse est qu'il manque un mot-clé, vous avez absolument raison. L'exception n'est jamais instanciée avec le mot-clé new.

Jetons un coup d'œil à un autre endroit où l'examen pourrait essayer de vous tromper. Pouvez-vous voir pourquoi ce qui suit ne compile pas.  

		try {
				throw new RuntimeException();	// Line 4
				throw new ArrayIndexOutOfBoundsException();	//DOES NOT COMPILE
		}catch(Exception e) {
				...
		}   
Puisque la ligne 4 lève une exception, la ligne 5 ne peut jamais être atteinte pendant l'exécution. La compilation reconnaît cela et signale une erreur de code inaccessible.   
* Runtime exception: Sous-classe de RuntimeException, le programme peut catcher l'exception, Le programme n'est pas obligé de la traiter ou la déclarer.    
* Checked exception: Sous-classe d'exception mais pas sous-classe de RuntimeException, le programme peut catcher l'exception, le programme doit traiter ou la déclarer l'exception.  
* Error: Sous-classe de Error, le programme ne peut pas catcher l'exception, Le programme n'est pas obligé de la traiter ou la déclarer. 

# Recognizing Exception Classes: (Reconnaître les classes d'exception)  
Vous devez reconnaître trois types d'exceptions pour l'examen, les exceptions d'exécution (runtime exceptions), les exceptions contrôlées et les erreurs (Error). Nous examinerons des exemples courants de chaque type. Pour l’examen, vous devrez reconnaître de quel type d’exception il s’agit et si elle est lancée par la JVM ou un programmeur. Pour que vous puissiez les reconnaître, nous allons vous montrer quelques exemples de code pour ces exceptions.
### Runtime Exception Classes: (Classes d'exception à l'exécution)  
Les exceptions d'exécution étendent de RuntimeException. Ils n’ont pas à être manipulés ou déclarés. Ils peuvent être lancés par le programmeur ou par la JVM. Les exceptions d'exécution courantes sont les suivantes: 
###### ArithmeticException:  
Lancé par la JVM lorsque le code tente de diviser par zéro.  

	int answer = 11 / 0;
L'exécution de ce code entraîne la sortie suivante:
*java.lang.ArithmeticException: / by zero*
###### ArrayIndexOutOfBoundsException:  
Lancé par la JVM lorsque le code utilise un index illégal pour accéder à un tableau. 
Vous savez maintenant que les index de tableau commencent par 0 et vont jusqu'à 1 de moins que la longueur du tableau - ce qui signifie que ce code lèvera une ArrayIndexOutOfBoundsException:  

		int[] countsOfMoose = new int[3];
		System.out.println(countsOfMoose[-1]); 
C'est un problème car il n'existe pas d'index de tableau négatif. L'exécution de ce code produit la sortie suivante:
*java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 3*
###### ClassCastException: 
Lancé par la JVM lors d'une tentative de conversion d'une exception vers une sous-classe dont elle n'est pas une instance.  
Java essaie de vous protéger des casts impossibles. Ce code compile pas car Integer n'est pas une sous-classe de String:  

		String type = "moose";
		Integer number = (Integer) type; // DOES NOT COMPILE
Un code plus compliqué contredit les tentatives de Java pour vous protéger. Lorsque le cast échoue à l'exécution, Java lèvera une ClassCastException:   

		String type = "moose";
		Object obj = type;
		Integer number = (Integer) obj; 
Le compilateur voit une conversion de Object en Integer. Cela pourrait être correct. Le compilateur ne réalise pas qu'il y a une chaîne dans cet objet. Lorsque le code s'exécute, il donne la sortie suivante:  
*java.lang.ClassCastException: class java.lang.String cannot be cast to class java.lang.Integer*
###### NullPointerException:  
Lancé par la machine viruelle Java lorsqu'il existe une référence nulle où un objet est requis.   
Les variables et méthodes d'instance doivent être appelées sur une référence non nulle. Si la référence est null, la JVM lèvera une NullPointerException. C'est généralement subtil, comme cet exemple, qui vérifie si vous vous souvenez que les références de variable d'instance sont par défaut nulles.  

		String name = null;
		System.out.println(name.length());
L'exécution de ce code entraîne cette sortie:  
*java.lang.NullPointerException*
###### IllegalArgumentException:  
Lancé par le programmeur pour indiquer qu'une méthode a reçu un argument illégal ou inapproprié.  
IllegalArgumentException est un moyen pour votre programme de se protéger. Nous avons d'abord vu la méthode setter suivante dans la classe Swan au chapitre 7, «Méthodes et encapsulation».  

		public void setNumberEggs(int numberEggs) {// setter
			if (numberEggs >= 0) // guard condition
				this.numberEggs = numberEggs;
		}
Ce code fonctionne, mais nous ne voulons pas vraiment ignorer la demande de l'appelant quand il nous dit qu'un cygne a –2 œufs. Nous voulons dire à l'appelant que quelque chose ne va pas. Les exceptions sont un moyen efficace de le faire. Voir le code se terminer par une exception est un excellent rappel que quelque chose ne va pas:  

		public void setNumberEggs(int numberEggs) {
			if (numberEggs < 0)
				throw new IllegalArgumentException(
						 "# eggs must not be negative");
			this.numberEggs = numberEggs;
		}
Le programme lève une exception lorsqu'il n'est pas satisfait des valeurs des paramètres. La sortie ressemble à ceci:   
*java.lang.IllegalArgumentException: # eggs must not be negative*
###### NumberFormatException:  
Lancé par le programmeur lorsqu'une tentative est faite pour convertir une chaîne en type numérique mais que la chaîne n'a pas un format approprié.   
Java fournit des méthodes pour convertir des chaînes en nombres. Lorsque ceux-ci reçoivent une valeur non valide, ils lèvent une NumberFormatException. L'idée est similaire à IllegalArgumentException. Puisqu'il s'agit d'un problème courant, Java lui attribue une classe distincte. En fait, NumberFormatException est une sous-classe d'IllegalArgumentException. Voici un exemple de tentative de conversion d'un élément non numérique en un entier:  

		Integer.parseInt("abc");
La sortie ressemble à ceci:  
*java.lang.NumberFormatException: For input string: "abc"*
### Checked Exception Classes: (Classes d'exception contôlées)  
Les exceptions contrôlées ont une exception dans leurs hiérarchie mais n'est pas RuntimeException. Elles doivent être gérées ou déclarées. elles peuvent être lancées par le programmeur ou par la JVM. Les exceptions contrôlées les plus courantes sont les suivantes.  
###### IOException: 
Lancé par le programme en cas de problème de lecture ou d'écriture d'un fichier.   
###### FileNotFoundException:  
Lancé par le programme lorsque le code tente de référencer un fichier qui n'existe pas.  :
Pour l'examen, il vous suffit de savoir qu'il s'agit d'exceptions contrôlées. Gardez également à l'esprit que FileNotFoundException est une sous-classe d'IOException. Vous verrez bientôt pourquoi c'est important.  
### Errors Classes: (Classes d'erreurs)  )Les erreurs étendent la classe Error. Ils sont lancés par la JVM et ne doivent pas être traités ou déclarés. Les erreurs sont rares, mais vous pourriez les voir:  
###### ExceptionInInitializerError:
Lancé par la JVM lorsqu'un initialiseur statique lève une exception et ne la gère pas.  
Java exécute des initialiseurs statiques la première fois qu'une classe est utilisée. Si l'un des initialiseurs statiques lève une exception, Java ne peut pas commencer à utiliser la classe. Il déclare la défaite en lançant une ExceptionInInitializerError. Ce code montre un ArrayIndexOutOfBounds dans un initialiseur statique:    

		public class ErrorsExcep {
			static {
				int[] countsOfMoose = new int[3];
				int num = countsOfMoose[-1];
			}
			public static void main(String[] args) {
			}
		}
Ce code fournit des informations sur l'erreur et l'exception sous-jacente:  
*java.lang.ExceptionInInitializerError*   
*Caused by: java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 3*    
Nous obtenons le ExceptionInInitializerError car l'erreur s'est produite dans un initialiseur statique. Ces informations à elles seules ne seraient pas particulièrement utiles pour résoudre le problème. Par conséquent, Java nous indique également la cause initiale du problème: l'exception ArrayIndexOutOfBoundsException que nous devons corriger.
ExceptionInInitializerError est une erreur car Java n'a pas pu charger toute la classe. Cet échec empêche Java de continuer.    
###### StackOverflowError:
Lancé par la JVM lorsqu'une méthode s'appelle elle-même trop de fois (cela s'appelle une récursion infinie car la méthode s'appelle généralement sans fin).  
Lorsque Java appelle des méthodes, il place des paramètres et des variables locales sur la pile. Après avoir fait cela un très grand nombre de fois, la pile manque de place et déborde. Cela s'appelle une StackOverflowError. La plupart du temps, cette erreur se produit lorsqu'une méthode s'appelle elle-même.   

		public static void doNotCodeThis(int num) {
			doNotCodeThis(1);
		}
La sortie contient cette ligne:  
*Exception in thread "main" java.lang.StackOverflowError*   
Puisque la méthode s'appelle elle-même, elle ne s'arrêtera jamais. Finalement, Java manque de place sur la pile et renvoie l'erreur. C'est ce qu'on appelle la récursion infinie. C'est mieux qu'une boucle infinie car au moins Java l'attrapera et lèvera l'erreur. Avec une boucle infinie, Java utilise simplement tout votre processeur jusqu'à ce que vous puissiez le tuer.    
###### NoClassDefFoundError:  
Lancé par la JVM lorsqu'une classe utilisée par le code est disponible au moment de la compilation mais pas à l'exécution.  
Cette erreur n'apparaîtra pas dans le code de l'examen. Vous devez simplement savoir qu'il s'agit d'une erreur. NoClassDefFoundError se produit lorsque Java ne peut pas fi et la classe au moment de l'exécution.   
# Handling Exceptions: (Gestion des exceptions) 
### Using try and catch Statements: (Utilisation des instructions try et catch)   ### Chaining catch Blocks: (Chaînage des blocs de capture)### Applying a Multi-catch Block: (Application d'un bloc multi-catch)  ### Adding finally Blocks: (Ajouter le bloc finally)  ### Finally Closing Resources: (fermeture des ressources dans finally)  ### Throwing Additional Exceptions: (Lever des exceptions supplémentaires)    # Calling Methods That Throw Exceptions: (Appel de méthodes qui lèvent des exceptions)   ### Declaring and Overriding Methods with Exceptions: (Déclaration et redéfinissant de méthodes avec des exceptions)   ### Printing an Exception: (Affichage d'une Exception)  
