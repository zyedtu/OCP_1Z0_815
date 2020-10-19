									MAKING DECISIONS
									
# Cr�ation d'�nonc�s d�cisionnels: (Creating Decision-Making Statements)

Les op�rateurs Java vous permettent de cr�er de nombreuses expressions complexes, mais ils sont limit�s dans la mani�re dont ils peuvent contr�ler le flux du programme. 

##### Instructions et blocs:(Statements and Blocks)

Comme vous vous en souvenez du chapitre 2, une instruction Java est une unit� d'ex�cution compl�te en Java, termin�e par un point-virgule(semicolon) **;**  
Ces instructions peuvent �tre appliqu�es � des expressions uniques ainsi qu'� un bloc de code Java. Comme d�crit au chapitre 2, un bloc de code en Java est un groupe de z�ro instruction ou plus entre accolades �quilibr�es ** {} **  

	patrons++; // Single statement
	
	{
		partron++; // Statement inside a block
	} 

Une d�claration ou un bloc fonctionnent souvent comme la cible d'une d�claration de prise de d�cision. Par exemple, nous pouvons ajouter la d�claration de L'instruction if � ces deux exemples

	if(ticketsTaken > 1)
		patron++; // Single statement
		
	if(ticketsTaken > 1){
		patron++; // Statement inside a block
	}
Ces deux  codes sont equivalants.  

##### L'instruction if: (The if statement)

Souvent, nous voulons ex�cuter un bloc de code uniquement dans certaines circonstances, l'instruction if accomplit cela en permettant � votre application d'ex�cuter un bloc particulier  

	if(booleanExpression) {
		//Branch if true
	}		
Par exemple, imaginons que nous ayons une fonction qui utilisait l'heure du jour, une valeur enti�re de 0 � 23, pour afficher un message � l'utilisateur:

	if(hourOfDay > 13)
		System.out.println("Good Morning");
si l'heure de la journ�e est inf�rieure � 11, le message sera affich�

	if(hourOfDay < 11){
		System.out.println("Good Morning");
		morningGreetingCount++;
	}
	
##### L'instruction else: (The else statement)

D�veloppons un peu notre exemple, que faire si nous voulons afficher un message diff�rent s'il est 11 h ou plus tard. Pourrions-nous le faire en utilisant uniquement les outils dont nous disposons? bien s�r on peut, on utilisant l'instruction **else**  

	if(booleanExpression){
		// Branch iftrue
	} else{
		// Branch if false
	}
Alors notre exemple devient:

	if(hourOfDay < 11){
		System.out.println("Good Morning");
	} else{
		System.out.println("Good Afternoon");
	}
Maintenant, notre code bifurque v�ritablement entre l'une des deux options possibles, l'�valuation bool�enne ne se produisant qu'une seule fois. L'op�rateur else prend une instruction ou un bloc d'instructions, de la m�me mani�re que l'instruction if. De m�me, nous pouvons ajouter une instruction if suppl�mentaire � un bloc else pour arriver � un exemple plus raffin�  
	
	if(hourOfDay < 11){
		System.out.println("Good Morning");
	} else if(hourOfDay < 15){
		System.out.println("Good Afternoon");
	}esle {
		System.out.println("Good Evening");
	}

##### L'instruction switch: (The switch statement)

Que faire si nous avons beaucoup de branches possibles pour une valeur unique, par exemple, nous pourrions vouloir imprimer un message diff�rent en fonction du jour de la semaine. Nous pourrions certainement accomplir cela avec une combinaison de sept si ou autre, mais cela tend � cr�er du code long et difficile � lire.  
Heureusement, Java, avec de nombreux autres langages, offre une approche plus propre. Une instruction switch  

	switch(variableToTest){ //required
		case constantExpression1:
				// Branch for case1;
			  break; // oprional
		case constantExpression2:
				// Branch for case 2
			 break; // oprional
			 ......
		default:
			// Branch for default
	}//required
###### Syntaxe appropri�e du Switch:(Proper Switch syntax) 

�tant donn� que les instructions de Switch peuvent �tre plus longues que la plupart des d�clarations de prise de d�cision, l'examen peut pr�senter une syntaxe de switch non valide pour voir si vous faites attention.

	int month = 5;
	switch month { // DOES NOT COMPILE
			case 1: System.out.println("January");
	}
L'instruction switch ne se compile pas car il  manquante les parenth�ses entre la variable switch **(month)**  

	switch (month) // DOES NOT COMPILE
			case 1: System.out.println("January");
L'instruction switch ne se compile pas car il  manquante les accolade **{}**

	switch (month) { 
			case 1: 2: System.out.println("January");// DOES NOT COMPILE
	}
L'instruction switch ne se compile pas car le mot cl� case est manquant avant le 2:

	switch (month) { 
			case 1 || 2: System.out.println("January");// DOES NOT COMPILE
	}
Enfin, la derni�re instruction switch ne se compile pas car **1 || 2** utilise les op�rateurs bool�ens de court-circuit, qui ne peuvent pas �tre appliqu�s aux valeurs num�riques. Un seul op�rateur au niveau du bit(bitwise) **|** aurait tout le code � compiler (pas l'op�ratuer ou logique aussi(|), donc l'interpretation de 1 | 2 donne la valuer 3 et pas 1 ou 2:

	 switch (month) { 
				case 1 | 2: System.out.println("January");// COMPILE Operator BITWISE, not OR Logique
		}
###### Changer de type de donn�es:(Switch Data Types)

Avant Java 5.0, la variable de l'instruction switch ne pouvait �tre que int ou les valeurs pouvant �tre promues en int, (byte, short, char). la variable de l'instruction switch accepte les wrapper classes (Integer, Byte,..).  
Lorsque l'�num�ration, not�e enum, �tait ajout�e dans Java 5.0, le support �tait ajout� � switch.  
Dans Java 7, les instructions switch ont �t� davantage mises � jour pour permettre la correspondance sur les valeurs String.  
Dans Java 10, si le type auquel une variable est r�solue est l'un des types pris en charge par une instruction switch, alors var peut �galement �tre utilis� dans une instruction switch.  

Voici une liste de tous les types de donn�es pris en charge par l'instruction switch:
* { **int et Integer, byte et Byte, short et Short, char et Character, Strin, enum, var (Si le type se r�sout en l'un des types pr�c�dents) } **  [pip]*

###### Flux de contr�le de Switch: (Switch Control Flow)  

	   int dayOfWeek = 5;
		switch(dayOfWeek) {
			default:
				System.out.println("Weekday");
				break;
			case 0:
				System.out.println("Sunday");
				break;
			case 6:
				System.out.println("Saturday");
				break;
		} 
Cet exemple affiche **Weekday**
Le bloc case ou default n'ont pas un ordre particulier dans l'instruction switch.

	 var dayOfWeek = 5;
		switch(dayOfWeek) {
			case 0:
				System.out.println("Sunday");
			default:
				System.out.println("Weekday");
			case 6:
				System.out.println("Saturday");
				break;
		}
Cet exemple affiche **Weekday Saturday**  
Le remarque ici que l'instruction break ne figure pas dans le bloc default donc on passe automatiquement au bloc suivant.  

###### Valeurs de case acceptables: (Acceptable case Values) 

Dans ce paragraphe on va parler sur les valeurs acc�pt�es par l'instruction case.

		final int getCookies() {return 4;}
	
		final int bananas = 1;
		int apples = 2;
		int numberofAnimals = 3;
		final int cookies = getCookies();
		switch(numberofAnimals) {
			case bananas:
			case apples: // DOES NOT COMPILES
			case getCookies(): // DOES NOT COMPILES
			case cookies: // DOES NOT COMPILES
			case 3*5:
		}

 - bananas est marqu� final, sa valeur est connue au moment de la compilation.  
 - ap	ples non marqu� final, m�me si sa valeur est connue, elle n'est donc pas autoris�e.  
 - getCookies() et cookies, ne compilent pas par ce que leurs valeurs ne sont pas �valu�s � la complition, elles sont �valu�es pendent l'ex�cution (runtime).  
 - 3*5 est une expression, et comme expression sont autoris�s comme valeur de case.  

###### Un exemple plus complexe: (A More Complex Example) 

		private int getSortOrder(String firsName, final String lastName) {
		
		String middleName = "Patricia";
		final String suffix = "JR";
		int id = 0;
		switch(firsName) {
			case "Test":
				return 52;
			case middleName: // DOES NOT COMPILE
				id = 5;
				break;
			case suffix:
				id = 0;
				break;
			case lastName: // DOES NOT COMPILE
				id = 8;
				break;
			case 5: // DOES NOT COMPILE
				id = 7;
				break;
			case 'J': // DOES NOT COMPILE
				id = 10;
				break;
			case java.time.DayOfWeek.SUNDAY: // DOES NOT COMPILE
				id = 15;
				break;
		}
		return id;
	}  
- Le premier instruction case "Test" compile parce que c'est lit�ral.  
- middleName ne compile pas parc que n'est pas marqu� final.  
- suffix complie  est une constante final.   
- lastName, bien qu'il soit final, ce n'est pas une variable constante car il est pass� � la fonction  
- 5 ne complie parceq que c'est int et non pas String  
- 'J' c'est un char ne matche pas avec un String    
- java.time.DayOfWeek.SUNDAY enum ne match pas avec String  

###### Promotion num�rique et casting: (Numeric Promotion and Casting)  

Enfin, l'instruction Switch prend en charge la promotion num�rique qui ne n�cessite pas de conversion explicite. Par exemple:

		short size = 4;
		final int small = 15;
		final int big = 1_000_000;
		switch(size) {
			case small:
			case 1+2:
			case big: // DOES NOT COMPILE
		}
  
- small et l'expresion 1+2 Le compilateur peut facilement cast un small ou 1+2  � int au moment de la compilation car la valeur 15  et la valuer 3 est suffisamment petite pour tenir dans un short.  
- big est trop grand pour contenir un short.  

# �criture de boucles While: (Writing While Loops) 

Une pratique courante lors de l'�criture de logiciels est la n�cessit� de faire la m�me t�che un certain 
nombre de fois. Vous pouvez utiliser les structures de d�cision que nous avons pr�sent�es jusqu'� pr�sent 
pour y parvenir, mais cela va �tre une assez longue cha�ne de d�clarations if ou else...  
Entrez des boucles! Une boucle est une structure de contr�le r�p�titive qui peut ex�cuter une instruction 
de code plusieurs fois de suite  
Dans l'exemple suivant, la boucle incr�mente une variable de compteur qui fait augmenter la valeur de price
de 10 � chaque ex�cution de la boucle  

	int counter = 0;
	while (counter < 10) {
		double price = counter * 10;
		System.out.println(price);
		counter++;
	}

##### La d�claration While :(The While Statement)  

La structure de contr�le respective la plus simple en Java est l'instruction while, il a une condition de 
terminaison, impl�ment�e comme une expression bool�enne, qui continuera tant que l'expression sera �valu�e 
� vrai

	while(booleanExpression){
		// Body
	}
Les parentheses sont obligatoire et les curly braces obliqatoire si le block contient plusieus instructions.  

##### La d�claration do / While: (The do/While Statement)

La seconde forme qu'une boucle while peut prendre est appel�e boucle do / while. Contrairement � une boucle while, through, une boucle do / while garantit que l'instruction ou le bloc sera ex�cut� au moins une fois  

	do{
		// BODY
	}while(booleanExpression); // semicolon(virgule) obligatoire
	
##### Comparaison des boucles while et do / while: (Comparing while and do/while loops)  

		int llama = 10;
		
		while(llama > 10) {
			System.out.println("Llama while!");
		}
		
		do {
			System.out.println("Llama do/while!");
		}while(llama > 10);
La boucle While n'affiche rien, contrairement la boucle do/while affiche *Llama do/while!* donc grandit l'execution du bloc une fois.  

# Construction boucles for: (Construction for Loops)  

Avec cela, nous pr�sentons la structure de contr�le de r�p�tition la plus pratique des boucles for, Il existe deux types de la boule for, bien que les deux utilisent le m�me mot-cl� for. La premi�re est appel�e boucle for de base et la seconde est souvent appel�e boucle for am�lior�e. Pour plus de clart�, nous les appellerons respectivement la boucle for et la boucle for-each, tout au long du livre.  

##### La boucle for: (The for loop)  

Une boucle for de base a la m�me expression et instruction bool�enne conditionnelle, ou bloc d'instructions, que les boucles while, ainsi que deux nouvelles sections: un bloc d'ini tialisation et une instruction de mise � jour.  

	for(initialization; booleanExpression; updateStatement){
		//Body
	}
Dans la boucle for il y a 5 �tapes: 
1. L'instruction d'initialisation s'ex�cute
2. si booleanExpression est vrai continuer, sinon quitter la boucle
3. Ex�cution du corps
4. Ex�cuter updateStatement
5. Retourner � l'�tape 2  

Jetons un coup d'�il � un exemple qui imprime les cinq premiers nombres commen�ant par z�ro:  

		for(int i = 0; i < 5; i++) {
			System.out.print(i + " "); // 0 1 2 3 4
		}

##### Afficher d'�l�ments � l'envers: (Printing Elements in Reverse)  

Disons que vous vouliez imprimer les m�mes cinq premiers nombres pour z�ro que nous l'avons fait dans la section pr�c�dente, mais cette fois dans l'ordre inverse, le but est d'afficher 4 3 2 1 0.  
Comment feriez-vous cela? � partir de Java 10, vous pouvez maintenant voir var utilis� dans une boucle for, alors utilisons-le pour cet exemple. Une mise en �uvre initiale peut ressembler � ce qui suit:

		for(var counter = 5; counter > 0; counter--) {
			System.out.print(counter + " "); //5 4 3 2 1
		}
C'est pas �a le resultat entendu, en doit initialiser en 4 et afficher le 0:  

		for(var counter = 4; counter >= 0; counter--) {
			System.out.print(counter + " "); //4 3 2 1 0 
		}
Finalement! Nous avons du code qui affiche 4 3 2 1 0.  

##### Travailler avec les boucles for:(Working with for loops)  

Bien que la plupart des boucles for que vous �tes susceptible de rencontrer dans votre exp�rience de d�veloppement professionnel seront bien d�finies et similaires aux exemples pr�c�dents, il existe un certain nombre de variations et de cas extr�mes que vous pourriez voir � l'examen. Vous devez vous familiariser avec les 5 exemples suivants:  

###### Cr�er une boucle infinie: (Creating an infinite loop)

	for( ; ; )
		System.out.print("Hello world");
Visisblement cet exemple ne compile pas, �a va en fait compile et s'e�cute sans probl�me. Cet exemple cr�e une boucel infinie.  

###### Ajout de plusieurs termes � l'instruction for:(Adding Multiple Terms to the for statement) 

		int x = 0;
		for(long y = 0, z = 4 ; x < 5 && y < 10 ; x++, y++)
			System.out.print(y + " ");
		System.out.println(x + " "); // 0 1 2 3 4 5 
Ce code montre 3 variables dans une boucle for  

###### D�claration d'une variable dans le bloc d'initialisation: (Declaring a Variable in the Initialization Block)  

		int x = 0;
		
		for(int x = 4; x < 5; x++) { // DOES NOT COMPILE
			System.out.println(x + "");
		}
Ce code ne compile pas, � cause du bloc d'initialisation, x est r�p�t� dans le bloc d'initialisation apr�s avoir d�j� �t� d�clar� avant la boucle.  Pour corriger �a:

	   int x = 0;
		
		for(x = 4; x < 5; x++) { // COMPILE
			System.out.println(x + "");
		}

###### Utilisation de types de donn�es incompatibles dans le bloc d'initialisation: (Using Incompatible Data types in the Initialization block)  

		int x = 0;
		
		for(long y = 0, int z = 4; x < 5; x++) { // DOES NOT COMPILE
			System.out.print(y + " ");
		}
Ce code ne compile pas, parce que les variables dans le bloc d'initialisation doivent etre de meme type.  

		int x = 0;
		
		for(long y = 0,z = 4; x < 5; x++) { // COMPILE
			System.out.print(y + " "); // 0 0 0 0 0 
		}

###### Utilisation de variables de boucle en dehors de la boucle:(Using Loop Variables Outside the Loop)  

		for(long y = 0, x = 4; x < 5 && y < 10; y++) {
			System.out.print(y + " ");
		}
		System.out.println(x); // DOES NOT COMPILE
Ce code ne compile pas, la variable x est initialis�e dans la boucle dans la port�e de la variable x est dans la boucle for.

##### Modification des variables de boucle: (Modifying Loop Variables)

Que se passe-t-il si vous modifiez une variable dans une boucle for, ou toute autre boucle d'ailleurs:  

		for(int i=0; i<10; i++)
			i=0;
			
		for(int j=0; j<10; j++)
			j--;
		
		for(int k=0; k<10;)
			k++;
Ces deux codes complient bien, comme Java vous permet de modifier les variables de boucle, qu'elles soient dans les boucles for, while ou do / while  
* Le premier et le deuxieme exemple cr�ent une boucle infinie.
* Le dernier ex�cute la boucle 10 fois.

##### La boucle for-each: (The for-each Loop)



