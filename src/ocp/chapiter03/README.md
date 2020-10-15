						          OPERATORS

						
# Comprendre les op�rateurs Java: (understand Java Operators)  

L'op�rateur est un symbole sp�cial qui peut �tre appliqu� � un ensemble de variables, de valeurs ou 
de litt�raux - appel�s op�randes - et qui renvoie un r�sultat. 

##### Type d'op�rateurs: (Type d'op�rateurs)

En g�n�ral, trois types d'op�rateurs sont disponibles en java:  
* Unary: besoin d'un seul op�rande (-8)
* Binary: besoin 2 op�randes (7 + 9)
* Ternary: besoind 3 op�randes (total > MAX ? total + 1 : total * 2)
Ces types d'op�rateurs peuvent �tre appliqu�s � un, deux ou trois op�randes, respectivement*

##### Priorit� de l'op�rateur: (Operator Precedence)  

Lors de la lecture d'un livre ou d'un journal, certaines langues �crites sont �valu�es de gauche � 
droite, tandis que d'autres sont �valu�es de droite � gauche. En math�matiques, certains op�rateurs 
peuvent remplacer d'autres op�rateurs et �tre �valu�s en premier. d�terminer quels op�rateurs sont 
�valu�s dans quel ordre est appel� priorit� des op�rateurs. De cette mani�re, Java suit de plus 
pr�s les r�gles des math�matiques. Evaluons cette expression: 

		int height = 7;
		int length = 3;
		var perimeter = 2 * height + 2 * length;
		System.out.println(perimeter);
L'operateur de multiplication (*) a une priorit� plus �lev�e que l'op�rateur d'addition (+), donc 
on va multiplier height et length par 2 avant de faire l'addition, l'affectation (=) a une priorit� 
la moin �lev�e. donc ce code affiche **20**  

# Application d'op�rateurs unaires: (Applying Unary Operators)  

Par d�finition, un op�rateur unaire est celui qui n�cessite exactement un op�rande.  

##### Op�rateurs de compl�ment logique et de n�gation: (Logical Complement and Negation Operators)  

Puisque nous allons travailler avec beaucoup d'op�rateurs num�riques dans le chapitre, �liminons d'abord le bool�en. L'op�rateur de compl�ment logique (!) Inverse la valeur d'une expression bool�enne.  

		boolean isAnimalAsleep = false;
		System.out.println(isAnimalAsleep); //false
		System.out.println(!isAnimalAsleep); //true
De m�me, l'op�rateur de n�gation (-) inverse le signe d'une expression num�rique  

		double zooTemperature = 1.21;
		System.out.println(zooTemperature); //-1.21
		System.out.println(-zooTemperature); //-1.21
##### Op�rateurs d'incr�mentation et de d�cr�mentation: (Increment and Decrement Operators)  
Les op�rateurs d'incr�mentation et de d�cr�mentation, ++ et --, respectivement, peuvent �tre appliqu�s � une variable num�rique et ont un ordre de priorit� �lev�, par rapport aux op�rateurs binaires.  

Les op�rateurs d'incr�mentation et de d�cr�mentation n�cessitent une attention particuli�re car l'ordre dans lequel ils sont attach�s � leur variable associ�e peut faire une diff�rence dans la fa�on dont une expression est trait�e  

si l'op�rateur est plac� avant l'op�rande, appel� op�rateur de pr�-incr�mentation et op�rateur de pr�-d�cr�mentation, l'op�rateur est appliqu� en premier et la valeur retrun�e est la nouvelle valeur de l'expression. Sinon, si l'oprateur est plac� apr�s l'op�rande, appel� �me op�rateur de post-incr�mentation et post-d�cr�mentation, alors la valeur d'origine de l'expression est retourn�e, avec operatof appliqu� apr�s le retour de la valeur

		int parkAttendance = 0;
		System.out.println(parkAttendance); //0
		System.out.println(++parkAttendance); //1
		System.out.println(parkAttendance); //1
		System.out.println(parkAttendance--); //1
		System.out.println(parkAttendance); //0
Une pratique courante dans un examen de certification, bien que moins courante dans le monde r�el, consiste � appliquer plusieurs op�rateurs d'incr�mentation ou de d�cr�mentation � une seule variable sur la m�me ligne.  

		int lion = 3;
		int tiger = ++lion * 5 / lion--;
		System.out.println("Lion is " + lion); // 3
		System.out.println("Tiger is " + tiger); // 5
premierement on incremente lion et returne l'expression int tiger = 4 * 5 / lion--;
ensuite on decremente lion mais l'expression garde la valeur 4 int tiger  4 * 5 / 4; finellement on multiple 4 * 5 alors int tiger = 20 / 4; parce que on de gauche � droite.

# Travailler avec l'arithm�tique binaire: (Working with Binary Arithmetic)  

 Ensuite, nous passons aux op�rateurs qui prennent deux arguments, appel�s op�rateurs binaires.  
 
 Les op�rateurs arithm�tqiues binaires sont: ** +, -, *, /, %**  
 
##### Op�rateurs arithm�tiques: (Arithmetic Operators)

	int price = 2 * 5 + 3 * 4 - 8;
Tout d'abord, vous �valuez 2 * 5 et 3 * 4, ce qui r�duit l'expression � ceci:  
int price = 10 + 12 - 8; le r�sultat est donc 14.  

##### Op�rateurs de division et de module: (Division and Modulus Operators)

		System.out.println( 9 / 3); // 3 la division
		System.out.println( 9 % 3); // 0 modulus le reste.

##### Promotion num�rique: (Numeric Promotion)

R�gles de promotion num�riques:

* Si deux valeurs ont des types de donn�es diff�rents, Java promouvra automatiquement l'une des valeurs vers le type de donn�e le plus grand.    
* Si deux valeurs ont des types de donn�es diff�rents, Java promouvra automatiquement l'une des valeurs vers la lager des deux types de donn�es.  
* Les types de donn�es plus petits, � savoir les bytes, les shorts et les char, sont tous promus en int � chaque fois qu'ils sont utilis�s avec des op�rateurs arithm�tiques binaires Java.  
* Une fois que toutes les promotions ont eu lieu et que les op�randes ont le m�me type de donn�es, la valeur r�sultante aura le m�me type de date que celle qui a promu les op�randes.

# Attribution de valeurs: (Assigning Values)

Les op�rateurs d'attribution des formulaires d'erreur de compilation sont souvent n�glig�s lors de l'examen, en partie � cause de la subtilit� de ces erreurs.  

	int herd = 1; //  = est l'operateur d'attribution
	
##### Casting Values:

La Cast est une op�ration unaire dans laquelle un type de donn�es est explicitement interpr�t� comme un autre type de donn�es.  
La conversion (Casting) est effectu�e en pla�ant le type de donn�es, entre parenth�ses, � gauche de la valeur que vous souhaitez convertir, Voici quelques exemples de casting :

		int fur = (int) 5;
		int hair = (short) 2;
		String type = (String) "Bird";

Casting est un op�rateur unitaire dons on dois mettre des parenth�se si on veut l'appliquer � une expression:

		short tail = (short) (4 + 5);

On met les parenth�se � gauche :

		long feathers = 10(long); // DOES NOT COMPILE
		
Les exemples suivant ne compilent pas parce que on essaye d'attribuer un type de taille grande.

	int fish  = 1.0;
	short bird = 19212222;
	int mam = 9f; 

##### Application de Casting: (Applying Casting)  

Nous pouvons corriger l'ensemble pr�c�dent d'exemples en convertissant les r�sultats en un type de donn�es plus petit.

	int fish  = (int)1.0;
	short bird = (short)19212222;
	int mam = (int)9f; 

Revenons � un exemple similaire de la section "Promotion num�rique" plus haut dans le chapitre

		short mouse = 10;
		short hamster = 3;
		short capybara = mouse * hamster; // DOES NOT COMPILE
Pour que cette exemple compile on doit faire �a:  

	short capybara =(short) mouse * hamster;
	
##### Op�rateurs d'affectation de compos�s: (Compound Assignment Operators) 
 
Les op�rateurs d'affection compos�s sont: ** +=, -=, *-, /= **  

		int camel = 2 , giraffe = 3;
		camel *= giraffe; // la meme chose que camel = camel * giraffe;
Autre exemple:

		long goat = 10;
		int sheep = 5;
		sheep *= goat; // DOES NOT COMPILE
		
##### Valeur de retour de l'op�rateur d'affectation:(Assignment Operator Return Value)  

Une derni�re chose � savoir sur les op�rateurs d'affectation est que le r�sultat d'une affectation est une expression en soi, �gale � la valeur de l'affectation, par exemple, l'extrait de code suivant est parfaitement valide:

		long wolf = 5;
		long coyote = (wolf=3);
		System.out.println(wolf); // 3
		System.out.println(coyote);// 3
La cl� ici est que (wolf = 3) fait deux choses. Premi�rement, il d�finit la valeur de la variable wolf sur 3. Deuxi�mement, il renvoie une valeur de l'affectation, qui est �galement 3.

# Comparaison des valeurs: (Comparing Values)

Le dernier ensemble d'op�rateurs binaires tourne autour de la comparaison des valeurs.

##### Op�rateurs d'�galit�: (Equality Operators)

La d�termination de l'�galit� en Java peut �tre un effort non triviale car il existe une diff�rence s�mantique entre �deux objets qui wsont les m�mes� et �deux objets sont �quivalents�.  
Les op�rateurs d'�galit�s sont: ** == et != **  

* Comparer deux numeriques: 

		int x = 5;
		int y = 4;
		System.out.println(x == y); // false
		System.out.println(x != y); // true
* Comparer deux boolean:

		boolean b = true;
		boolean a = false;
		System.out.println(a == b); //false
Pour les types primitifs, la comparaison est appliqu�e sur l'equalit� des valeurs.

* Comparaison entre objets, en incluant les String et null: 

		File monday = new File("f1.txt");
		File tuesday = new File(f1.txt");
		File wednesday = tuesday;
		System.out.println(monday == tuesday); // false
		System.out.println(tuesday == wednesday); //true
Pour les objet l'op�rateur d'egalit� est appliqu� sur les references, donc on compare si les references pointent sur le meme objet.

		System.out.println(null == null); //true
		
##### Op�rateurs relationnels: (Relational Operators)

Nous passons maintenant aux op�rateurs relationnels, qui comparent deux expressions et renvoient une valeur bool�enne.  
La liste des op�rateur est: ** <, <=, >, >=, a instanceof b **  

		int gibbonNumFeet = 2 , wolfNumFeet = 4, ostrichNumFeet = 2;
		System.out.println(gibbonNumFeet < wolfNumFeet); // true
		System.out.println(gibbonNumFeet <= wolfNumFeet); // true
		System.out.println(gibbonNumFeet >= ostrichNumFeet); // true
		System.out.println(gibbonNumFeet > ostrichNumFeet);// false

##### instanceof Op�rateur: (instanceof Operator)

L'op�rateur relationnel final dont vous avez besoin pour l'examen est l'op�rateur instanceof. Il est utile pour d�terminer si un objet arbitraire est membre d'une classe ou d'une interface particuli�re au moment de l'ex�cution  

L'op�rateur instanceof fonctionne sur le principe de la relation **Is-A**. Le concept de relation is-a est bas� sur l' h�ritage de classe ou l'impl�mentation d'interface  

		Integer zooTime = Integer.valueOf(9);
		Number num = zooTime;
		Object obj = zooTime;te
Dans cet exemple, il n'y a qu'un seul objet cr�� en m�moire, mais trois r�f�rences de diff�rence � celui-ci car Integer h�rite � la fois de Number et Object. Cela signifie que vous pouvez appeler instanceof sur n'importe laquelle de ces r�f�rences avec trois types de donn�es diff�rents et qu'elle renvoie true pour chacune d'elles.  

	public void openZoo(Number time){
		if(time instanceof Integer) {
			System.out.println((Integer) time + " O'clock");
		}else
			System.out.println(time);
	}
ce code affiche: 

	9 O'clock
Notez que nous convertissons la valeur Integer dans cet exemple. Il est courant d'utiliser le casting et l'instance ensemble lorsque vous travaillez avec des objets qui peuvent �tre de diff�rents types, car cela peut vous donner acc�s aux champs disponibles uniquement dans les classes plus sp�cifiques. Il est consid�r� comme une bonne pratique de codage d'utiliser l'op�rateur instanceof avant de convertir d'un objet un objet en un type plus �troit.

##### Invalid instance:

Un domaine dans lequel l'examen pourrait essayer de vous tromper est l'utilisation d'instance de type incompatible. Par exemple, Number ne peut pas contenir de valeur String, donc ce qui suit provoquerait une erreur de compilation.

	public void openZoo(Number time){
		if(time instanceof String) { // DOES NOT COMPILE
		.....

##### null and instanceof operator:

Que se passe-t-il si vous appelez instanceof sur une variable nulle? pour l'examen, vous devez savoir que l'appel de instanceof sur le litt�ral nul ou une r�f�rence nulle renvoie toujours false

	System.out.println(null instanceof String); // false
Cet exemple ne compile pas:

	System.out.println(null instanceof null); // DOES NOT COMPILE

# Op�rateurs logiques:(Logical Operators)  

Les op�rateurs logiques sont: **&, |, ^**  

* &: AND logique n'est vrai que si les deux valeurs sont true
* |: Inclusive OR est true si au moins une des valeurs est true
* ^: Exclusive OR est true si une valeur est true et l'autre est false  

		boolean eyesClosed = true;
		boolean breathingSlowly = true;
		System.out.println(eyesClosed & breathingSlowly); // true
		System.out.println(eyesClosed | breathingSlowly); // true
		System.out.println(eyesClosed ^ breathingSlowly); // false

# Op�rateurs de court-circuit: (Short-Circuit Operators)

Ensuite, nous pr�sentons les op�rateurs conditionnels: ** &&, ||**  

Les op�rateurs de court-circuit sont presque identiques aux op�rateurs logiques, & et |, sauf que le c�t� droit de l'expression peut ne jamais �tre �valu� si le r�sultat final peut �tre d�termin� par le c�t� gauche de l'expression. Par exemple:

		int hour = 10;
		boolean zooOpen = true || (hour < 4);
		System.out.println(zooOpen);  // true

##### �viter une exception NullPointerException: (avoiding a NullPointerException)

Un exemple plus courant d'utilisation d'op�rateurs de court-circuit est la v�rification des objets nuls avant d'effectuer une op�ration, Dans l'exemple suivant, si duck est nul, alors le programme lancera un NullPointerExceptio � l'ex�cution (runtime): 
	
	if(duck != null & duck.getAge()< 5){ // pourrait lever un NullPointerException
		// Do someting
	}
Le probl�me est que l'op�rateur logique AND (&) �value les deux c�t�s de l'expression, Une solution facile � lire consiste � utiliser l'op�rateur AND court-circuit (&&)

	if(duck != null && duck.getAge()< 5){
		// Do someting
	}

##### V�rification les effet de bord; (Checking for Unperformed Side effects)  

M�fiez-vous du comportement de court-circuit � l'examen, car les questions sont connues pour modifier une variable du c�t� droit de l'expression qui peut ne jamais �tre plus accessible.

		int rabbit = 6;
		boolean bunny = (rabbit >= 6 ) || (++rabbit <= 7);
		System.out.println(rabbit); // 6
Comme rabbit >= 6 est true, l'op�rateur d'incrementation n'a pas eu lieu donc le valuer de rabbit est 6

# Prise de d�cision avec l'op�rateur ternaire: (Making Decision with the Ternary Operator)

L'op�rateur final que vous devez conna�tre pour l'examen est l'op�rateur conditionnel, ** ? : **, autrement connu sous le nom d'op�rateur ternaire *ternary operator*  
L'op�rateur ternaire a la forme suivante: *booleanExpression ? expression1 : expression2*  

	int stripes = 3;
	System.out.println((stripes > 5 ) ? 21 : "Zebra"); // Zebra
