									MAKING DECISIONS
									
# CrÃ©ation d'Ã©noncÃ©s dÃ©cisionnels: (Creating Decision-Making Statements)

Les opÃ©rateurs Java vous permettent de crÃ©er de nombreuses expressions complexes, mais ils sont limitÃ©s dans la maniÃ¨re dont ils peuvent contrÃ´ler le flux du programme. 

### Instructions et blocs:(Statements and Blocks)

Comme vous vous en souvenez du chapitre 2, une instruction Java est une unitÃ© d'exÃ©cution complÃ¨te en Java, terminÃ©e par un point-virgule(semicolon) **;**  
Ces instructions peuvent Ãªtre appliquÃ©es Ã  des expressions uniques ainsi qu'Ã  un bloc de code Java. Comme dÃ©crit au chapitre 2, un bloc de code en Java est un groupe de zÃ©ro instruction ou plus entre accolades Ã©quilibrÃ©es ** {} **  

	patrons++; // Single statement
	
	{
		partron++; // Statement inside a block
	} 

Une dÃ©claration ou un bloc fonctionnent souvent comme la cible d'une dÃ©claration de prise de dÃ©cision. Par exemple, nous pouvons ajouter la dÃ©claration de L'instruction if Ã  ces deux exemples

	if(ticketsTaken > 1)
		patron++; // Single statement
		
	if(ticketsTaken > 1){
		patron++; // Statement inside a block
	}
Ces deux  codes sont equivalants.  

##### L'instruction if: (The if statement)

Souvent, nous voulons exÃ©cuter un bloc de code uniquement dans certaines circonstances, l'instruction if accomplit cela en permettant Ã  votre application d'exÃ©cuter un bloc particulier  

	if(booleanExpression) {
		//Branch if true
	}		
Par exemple, imaginons que nous ayons une fonction qui utilisait l'heure du jour, une valeur entiÃ¨re de 0 Ã  23, pour afficher un message Ã  l'utilisateur:

	if(hourOfDay > 13)
		System.out.println("Good Morning");
si l'heure de la journÃ©e est infÃ©rieure Ã  11, le message sera affichÃ©

	if(hourOfDay < 11){
		System.out.println("Good Morning");
		morningGreetingCount++;
	}
	
##### L'instruction else: (The else statement)

DÃ©veloppons un peu notre exemple, que faire si nous voulons afficher un message diffÃ©rent s'il est 11 h ou plus tard. Pourrions-nous le faire en utilisant uniquement les outils dont nous disposons? bien sÃ»r on peut, on utilisant l'instruction **else**  

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
Maintenant, notre code bifurque vÃ©ritablement entre l'une des deux options possibles, l'Ã©valuation boolÃ©enne ne se produisant qu'une seule fois. L'opÃ©rateur else prend une instruction ou un bloc d'instructions, de la mÃªme maniÃ¨re que l'instruction if. De mÃªme, nous pouvons ajouter une instruction if supplÃ©mentaire Ã  un bloc else pour arriver Ã  un exemple plus raffinÃ©  
	
	if(hourOfDay < 11){
		System.out.println("Good Morning");
	} else if(hourOfDay < 15){
		System.out.println("Good Afternoon");
	}esle {
		System.out.println("Good Evening");
	}

##### L'instruction switch: (The switch statement)

Que faire si nous avons beaucoup de branches possibles pour une valeur unique, par exemple, nous pourrions vouloir imprimer un message diffÃ©rent en fonction du jour de la semaine. Nous pourrions certainement accomplir cela avec une combinaison de sept si ou autre, mais cela tend Ã  crÃ©er du code long et difficile Ã  lire.  
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
###### Syntaxe appropriÃ©e du Switch:(Proper Switch syntax) 

Ã‰tant donnÃ© que les instructions de Switch peuvent Ãªtre plus longues que la plupart des dÃ©clarations de prise de dÃ©cision, l'examen peut prÃ©senter une syntaxe de switch non valide pour voir si vous faites attention.

	int month = 5;
	switch month { // DOES NOT COMPILE
			case 1: System.out.println("January");
	}
L'instruction switch ne se compile pas car il  manquante les parenthÃ¨ses entre la variable switch **(month)**  

	switch (month) // DOES NOT COMPILE
			case 1: System.out.println("January");
L'instruction switch ne se compile pas car il  manquante les accolade **{}**

	switch (month) { 
			case 1: 2: System.out.println("January");// DOES NOT COMPILE
	}
L'instruction switch ne se compile pas car le mot clÃ© case est manquant avant le 2:

	switch (month) { 
			case 1 || 2: System.out.println("January");// DOES NOT COMPILE
	}
Enfin, la derniÃ¨re instruction switch ne se compile pas car **1 || 2** utilise les opÃ©rateurs boolÃ©ens de court-circuit, qui ne peuvent pas Ãªtre appliquÃ©s aux valeurs numÃ©riques. Un seul opÃ©rateur au niveau du bit(bitwise) **|** aurait tout le code Ã  compiler (pas l'opÃ©ratuer ou logique aussi(|), donc l'interpretation de 1 | 2 donne la valuer 3 et pas 1 ou 2:

	 switch (month) { 
				case 1 | 2: System.out.println("January");// COMPILE Operator BITWISE, not OR Logique
		}
###### Changer de type de donnÃ©es:(Switch Data Types)

Avant Java 5.0, la variable de l'instruction switch ne pouvait Ãªtre que int ou les valeurs pouvant Ãªtre promues en int, (byte, short, char). la variable de l'instruction switch accepte les wrapper classes (Integer, Byte,..).  
Lorsque l'Ã©numÃ©ration, notÃ©e enum, Ã©tait ajoutÃ©e dans Java 5.0, le support Ã©tait ajoutÃ© Ã  switch.  
Dans Java 7, les instructions switch ont Ã©tÃ© davantage mises Ã  jour pour permettre la correspondance sur les valeurs String.  
Dans Java 10, si le type auquel une variable est rÃ©solue est l'un des types pris en charge par une instruction switch, alors var peut Ã©galement Ãªtre utilisÃ© dans une instruction switch.  

Voici une liste de tous les types de donnÃ©es pris en charge par l'instruction switch:
* { **int et Integer, byte et Byte, short et Short, char et Character, Strin, enum, var (Si le type se rÃ©sout en l'un des types prÃ©cÃ©dents) } **  [pip]*

###### Flux de contrÃ´le de Switch: (Switch Control Flow)  

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

Dans ce paragraphe on va parler sur les valeurs accÃ©ptÃ©es par l'instruction case.

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

 - bananas est marquÃ© final, sa valeur est connue au moment de la compilation.  
 - ap	ples non marquÃ© final, mÃªme si sa valeur est connue, elle n'est donc pas autorisÃ©e.  
 - getCookies() et cookies, ne compilent pas par ce que leurs valeurs ne sont pas Ã©valuÃ©s Ã  la complition, elles sont Ã©valuÃ©es pendent l'exÃ©cution (runtime).  
 - 3*5 est une expression, et comme expression sont autorisÃ©s comme valeur de case.  

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
- Le premier instruction case "Test" compile parce que c'est litÃ©ral.  
- middleName ne compile pas parc que n'est pas marquÃ© final.  
- suffix complie  est une constante final.   
- lastName, bien qu'il soit final, ce n'est pas une variable constante car il est passÃ© Ã  la fonction  
- 5 ne complie parceq que c'est int et non pas String  
- 'J' c'est un char ne matche pas avec un String    
- java.time.DayOfWeek.SUNDAY enum ne match pas avec String  

###### Promotion numÃ©rique et casting: (Numeric Promotion and Casting)  

Enfin, l'instruction Switch prend en charge la promotion numÃ©rique qui ne nÃ©cessite pas de conversion explicite. Par exemple:

		short size = 4;
		final int small = 15;
		final int big = 1_000_000;
		switch(size) {
			case small:
			case 1+2:
			case big: // DOES NOT COMPILE
		}
  
- small et l'expresion 1+2 Le compilateur peut facilement cast un small ou 1+2  Ã  int au moment de la compilation car la valeur 15  et la valuer 3 est suffisamment petite pour tenir dans un short.  
- big est trop grand pour contenir un short.  

# Ã‰criture de boucles While: (Writing While Loops) 

Une pratique courante lors de l'Ã©criture de logiciels est la nÃ©cessitÃ© de faire la mÃªme tÃ¢che un certain 
nombre de fois. Vous pouvez utiliser les structures de dÃ©cision que nous avons prÃ©sentÃ©es jusqu'Ã  prÃ©sent 
pour y parvenir, mais cela va Ãªtre une assez longue chaÃ®ne de dÃ©clarations if ou else...  
Entrez des boucles! Une boucle est une structure de contrÃ´le rÃ©pÃ©titive qui peut exÃ©cuter une instruction 
de code plusieurs fois de suite  
Dans l'exemple suivant, la boucle incrÃ©mente une variable de compteur qui fait augmenter la valeur de price
de 10 Ã  chaque exÃ©cution de la boucle  

	int counter = 0;
	while (counter < 10) {
		double price = counter * 10;
		System.out.println(price);
		counter++;
	}

##### La dÃ©claration While :(The While Statement)  

La structure de contrÃ´le respective la plus simple en Java est l'instruction while, il a une condition de 
terminaison, implÃ©mentÃ©e comme une expression boolÃ©enne, qui continuera tant que l'expression sera Ã©valuÃ©e 
Ã  vrai

	while(booleanExpression){
		// Body
	}
Les parentheses sont obligatoire et les curly braces obliqatoire si le block contient plusieus instructions.  

##### La dÃ©claration do / While: (The do/While Statement)

La seconde forme qu'une boucle while peut prendre est appelÃ©e boucle do / while. Contrairement Ã  une boucle while, through, une boucle do / while garantit que l'instruction ou le bloc sera exÃ©cutÃ© au moins une fois  

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

Avec cela, nous prÃ©sentons la structure de contrÃ´le de rÃ©pÃ©tition la plus pratique des boucles for, Il existe deux types de la boule for, bien que les deux utilisent le mÃªme mot-clÃ© for. La premiÃ¨re est appelÃ©e boucle for de base et la seconde est souvent appelÃ©e boucle for amÃ©liorÃ©e. Pour plus de clartÃ©, nous les appellerons respectivement la boucle for et la boucle for-each, tout au long du livre.  

##### La boucle for: (The for loop)  

Une boucle for de base a la mÃªme expression et instruction boolÃ©enne conditionnelle, ou bloc d'instructions, que les boucles while, ainsi que deux nouvelles sections: un bloc d'ini tialisation et une instruction de mise Ã  jour.  

	for(initialization; booleanExpression; updateStatement){
		//Body
	}
Dans la boucle for il y a 5 Ã©tapes: 
1. L'instruction d'initialisation s'exÃ©cute
2. si booleanExpression est vrai continuer, sinon quitter la boucle
3. ExÃ©cution du corps
4. ExÃ©cuter updateStatement
5. Retourner Ã  l'Ã©tape 2  

Jetons un coup d'Âœil Ã  un exemple qui imprime les cinq premiers nombres commenÃ§ant par zÃ©ro:  

		for(int i = 0; i < 5; i++) {
			System.out.print(i + " "); // 0 1 2 3 4
		}

##### Afficher d'Ã©lÃ©ments Ã  l'envers: (Printing Elements in Reverse)  

Disons que vous vouliez imprimer les mÃªmes cinq premiers nombres pour zÃ©ro que nous l'avons fait dans la section prÃ©cÃ©dente, mais cette fois dans l'ordre inverse, le but est d'afficher 4 3 2 1 0.  
Comment feriez-vous cela? Ã€ partir de Java 10, vous pouvez maintenant voir var utilisÃ© dans une boucle for, alors utilisons-le pour cet exemple. Une mise en Âœuvre initiale peut ressembler Ã  ce qui suit:

		for(var counter = 5; counter > 0; counter--) {
			System.out.print(counter + " "); //5 4 3 2 1
		}
C'est pas Ã§a le resultat entendu, en doit initialiser en 4 et afficher le 0:  

		for(var counter = 4; counter >= 0; counter--) {
			System.out.print(counter + " "); //4 3 2 1 0 
		}
Finalement! Nous avons du code qui affiche 4 3 2 1 0.  

##### Travailler avec les boucles for:(Working with for loops)  

Bien que la plupart des boucles for que vous Ãªtes susceptible de rencontrer dans votre expÃ©rience de dÃ©veloppement professionnel seront bien dÃ©finies et similaires aux exemples prÃ©cÃ©dents, il existe un certain nombre de variations et de cas extrÃªmes que vous pourriez voir Ã  l'examen. Vous devez vous familiariser avec les 5 exemples suivants:  

###### CrÃ©er une boucle infinie: (Creating an infinite loop)

	for( ; ; )
		System.out.print("Hello world");
Visisblement cet exemple ne compile pas, Ã§a va en fait compile et s'eÃ©cute sans problÃ¨me. Cet exemple crÃ©e une boucel infinie.  

###### Ajout de plusieurs termes Ã  l'instruction for:(Adding Multiple Terms to the for statement) 

		int x = 0;
		for(long y = 0, z = 4 ; x < 5 && y < 10 ; x++, y++)
			System.out.print(y + " ");
		System.out.println(x + " "); // 0 1 2 3 4 5 
Ce code montre 3 variables dans une boucle for  

###### DÃ©claration d'une variable dans le bloc d'initialisation: (Declaring a Variable in the Initialization Block)  

		int x = 0;
		
		for(int x = 4; x < 5; x++) { // DOES NOT COMPILE
			System.out.println(x + "");
		}
Ce code ne compile pas, Ã  cause du bloc d'initialisation, x est rÃ©pÃ©tÃ© dans le bloc d'initialisation aprÃ¨s avoir dÃ©jÃ  Ã©tÃ© dÃ©clarÃ© avant la boucle.  Pour corriger Ã§a:

	   int x = 0;
		
		for(x = 4; x < 5; x++) { // COMPILE
			System.out.println(x + "");
		}

###### Utilisation de types de donnÃ©es incompatibles dans le bloc d'initialisation: (Using Incompatible Data types in the Initialization block)  

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
Ce code ne compile pas, la variable x est initialisÃ©e dans la boucle dans la portÃ©e de la variable x est dans la boucle for.

##### Modification des variables de boucle: (Modifying Loop Variables)

Que se passe-t-il si vous modifiez une variable dans une boucle for, ou toute autre boucle d'ailleurs:  

		for(int i=0; i<10; i++)
			i=0;
			
		for(int j=0; j<10; j++)
			j--;
		
		for(int k=0; k<10;)
			k++;
Ces deux codes complient bien, comme Java vous permet de modifier les variables de boucle, qu'elles soient dans les boucles for, while ou do / while  
* Le premier et le deuxieme exemple créent une boucle infinie.
* Le dernier exécute la boucle 10 fois.

##### La boucle for-each: (The for-each Loop)



