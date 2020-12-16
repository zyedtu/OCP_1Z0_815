									MAKING DECISIONS
									
# Création d'énoncés décisionnels: (Creating Decision-Making Statements)

Les opérateurs Java vous permettent de créer de nombreuses expressions complexes, mais ils sont limités dans la manière dont ils peuvent contrôler le flux du programme. 

### Instructions et blocs:(Statements and Blocks)

Comme vous vous en souvenez du chapitre 2, une instruction Java est une unité d'exécution complète en Java, terminée par un point-virgule(semicolon) **;**  
Ces instructions peuvent être appliquées à des expressions uniques ainsi qu'à un bloc de code Java. Comme décrit au chapitre 2, un bloc de code en Java est un groupe de zéro instruction ou plus entre accolades équilibrées **{}**  

	patrons++; // Single statement
	
	{
		partron++; // Statement inside a block
	} 

Une déclaration ou un bloc fonctionnent souvent comme la cible d'une déclaration de prise de décision. Par exemple, nous pouvons ajouter la déclaration de L'instruction if à ces deux exemples

	if(ticketsTaken > 1)
		patron++; // Single statement
		
	if(ticketsTaken > 1){
		patron++; // Statement inside a block
	}
Ces deux  codes sont equivalants.  

### L'instruction if: (The if statement)

Souvent, nous voulons exécuter un bloc de code uniquement dans certaines circonstances, l'instruction if accomplit cela en permettant à votre application d'exécuter un bloc particulier  

	if(booleanExpression) {
		//Branch if true
	}		
Par exemple, imaginons que nous ayons une fonction qui utilisait l'heure du jour, une valeur entière de 0 à 23, pour afficher un message à l'utilisateur:

	if(hourOfDay > 13)
		System.out.println("Good Morning");
si l'heure de la journée est inférieure à 11, le message sera affiché

	if(hourOfDay < 11){
		System.out.println("Good Morning");
		morningGreetingCount++;
	}
	
##### L'instruction else: (The else statement)

Développons un peu notre exemple, que faire si nous voulons afficher un message différent s'il est 11 h ou plus tard. Pourrions-nous le faire en utilisant uniquement les outils dont nous disposons? bien sûr on peut, on utilisant l'instruction **else**  

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
Maintenant, notre code bifurque véritablement entre l'une des deux options possibles, l'évaluation booléenne ne se produisant qu'une seule fois. L'opérateur else prend une instruction ou un bloc d'instructions, de la même manière que l'instruction if. De même, nous pouvons ajouter une instruction if supplémentaire à un bloc else pour arriver à un exemple plus raffiné  
	
	if(hourOfDay < 11){
		System.out.println("Good Morning");
	} else if(hourOfDay < 15){
		System.out.println("Good Afternoon");
	}esle {
		System.out.println("Good Evening");
	}

### L'instruction switch: (The switch statement)

Que faire si nous avons beaucoup de branches possibles pour une valeur unique, par exemple, nous pourrions vouloir imprimer un message différent en fonction du jour de la semaine. Nous pourrions certainement accomplir cela avec une combinaison de sept si ou autre, mais cela tend à créer du code long et difficile à lire.  
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
###### Syntaxe appropriée du Switch:(Proper Switch syntax) 

Étant donné que les instructions de Switch peuvent être plus longues que la plupart des déclarations de prise de décision, l'examen peut présenter une syntaxe de switch non valide pour voir si vous faites attention.

	int month = 5;
	switch month { // DOES NOT COMPILE
			case 1: System.out.println("January");
	}
L'instruction switch ne se compile pas car il  manquante les parenthèses entre la variable switch **(month)**  

	switch (month) // DOES NOT COMPILE
			case 1: System.out.println("January");
L'instruction switch ne se compile pas car il  manquante les accolade **{}**

	switch (month) { 
			case 1: 2: System.out.println("January");// DOES NOT COMPILE
	}
L'instruction switch ne se compile pas car le mot clé case est manquant avant le 2:

	switch (month) { 
			case 1 || 2: System.out.println("January");// DOES NOT COMPILE
	}
Enfin, la dernière instruction switch ne se compile pas car **1 || 2** utilise les opérateurs booléens de court-circuit, qui ne peuvent pas être appliqués aux valeurs numériques. Un seul opérateur au niveau du bit(bitwise) **|** aurait tout le code à compiler (pas l'opératuer ou logique aussi(|), donc l'interpretation de 1 | 2 donne la valuer 3 et pas 1 ou 2:

	 switch (month) { 
				case 1 | 2: System.out.println("January");// COMPILE Operator BITWISE, not OR Logique
		}
###### Changer de type de données:(Switch Data Types)

Avant Java 5.0, la variable de l'instruction switch ne pouvait être que int ou les valeurs pouvant être promues en int, (byte, short, char). la variable de l'instruction switch accepte les wrapper classes (Integer, Byte,..).  
Lorsque l'énumération, notée enum, était ajoutée dans Java 5.0, le support était ajouté à switch.  
Dans Java 7, les instructions switch ont été davantage mises à jour pour permettre la correspondance sur les valeurs String.  
Dans Java 10, si le type auquel une variable est résolue est l'un des types pris en charge par une instruction switch, alors var peut également être utilisé dans une instruction switch.  

Voici une liste de tous les types de données pris en charge par l'instruction switch:
* { **int et Integer, byte et Byte, short et Short, char et Character, Strin, enum, var (Si le type se résout en l'un des types précédents)** }

###### Flux de contrôle de Switch: (Switch Control Flow)  

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

Dans ce paragraphe on va parler sur les valeurs accéptées par l'instruction case.

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

 - bananas est marqué final, sa valeur est connue au moment de la compilation.  
 - ap	ples non marqué final, même si sa valeur est connue, elle n'est donc pas autorisée.  
 - getCookies() et cookies, ne compilent pas par ce que leurs valeurs ne sont pas évalués à la complition, elles sont évaluées pendent l'exécution (runtime).  
 - 3*5 est une expression, et comme expression sont autorisés comme valeur de case.  

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
- Le premier instruction case "Test" compile parce que c'est litéral.  
- middleName ne compile pas parc que n'est pas marqué final.  
- suffix complie  est une constante final.   
- lastName, bien qu'il soit final, ce n'est pas une variable constante car il est passé à la fonction  
- 5 ne complie parceq que c'est int et non pas String  
- 'J' c'est un char ne matche pas avec un String    
- java.time.DayOfWeek.SUNDAY enum ne match pas avec String  

###### Promotion numérique et casting: (Numeric Promotion and Casting)  

Enfin, l'instruction Switch prend en charge la promotion numérique qui ne nécessite pas de conversion explicite. Par exemple:

		short size = 4;
		final int small = 15;
		final int big = 1_000_000;
		switch(size) {
			case small:
			case 1+2:
			case big: // DOES NOT COMPILE
		}
  
- small et l'expresion 1+2 Le compilateur peut facilement cast un small ou 1+2  à int au moment de la compilation car la valeur 15  et la valuer 3 est suffisamment petite pour tenir dans un short.  
- big est trop grand pour contenir un short.  

# Écriture de boucles While: (Writing While Loops) 

Une pratique courante lors de l'écriture de logiciels est la nécessité de faire la même tâche un certain 
nombre de fois. Vous pouvez utiliser les structures de décision que nous avons présentées jusqu'à présent 
pour y parvenir, mais cela va être une assez longue chaîne de déclarations if ou else...  
Entrez des boucles! Une boucle est une structure de contrôle répétitive qui peut exécuter une instruction 
de code plusieurs fois de suite  
Dans l'exemple suivant, la boucle incrémente une variable de compteur qui fait augmenter la valeur de price
de 10 à chaque exécution de la boucle  

	int counter = 0;
	while (counter < 10) {
		double price = counter * 10;
		System.out.println(price);
		counter++;
	}

### La déclaration While :(The While Statement)  

La structure de contrôle respective la plus simple en Java est l'instruction while, il a une condition de 
terminaison, implémentée comme une expression booléenne, qui continuera tant que l'expression sera évaluée 
à vrai

	while(booleanExpression){
		// Body
	}
Les parentheses sont obligatoire et les curly braces obliqatoire si le block contient plusieus instructions.  

### La déclaration do / While: (The do/While Statement)

La seconde forme qu'une boucle while peut prendre est appelée boucle do / while. Contrairement à une boucle while, through, une boucle do / while garantit que l'instruction ou le bloc sera exécuté au moins une fois  

	do{
		// BODY
	}while(booleanExpression); // semicolon(virgule) obligatoire
	
### Comparaison des boucles while et do / while: (Comparing while and do/while loops)  

		int llama = 10;
		
		while(llama > 10) {
			System.out.println("Llama while!");
		}
		
		do {
			System.out.println("Llama do/while!");
		}while(llama > 10);
La boucle While n'affiche rien, contrairement la boucle do/while affiche *Llama do/while!* donc grandit l'execution du bloc une fois.  

# Construction boucles for: (Construction for Loops)  

Avec cela, nous présentons la structure de contrôle de répétition la plus pratique des boucles for, Il existe deux types de la boule for, bien que les deux utilisent le même mot-clé for. La première est appelée boucle for de base et la seconde est souvent appelée boucle for améliorée. Pour plus de clarté, nous les appellerons respectivement la boucle for et la boucle for-each, tout au long du livre.  

### La boucle for: (The for loop)  

Une boucle for de base a la même expression et instruction booléenne conditionnelle, ou bloc d'instructions, que les boucles while, ainsi que deux nouvelles sections: un bloc d'ini tialisation et une instruction de mise à jour.  

	for(initialization; booleanExpression; updateStatement){
		//Body
	}
Dans la boucle for il y a 5 étapes: 
1. L'instruction d'initialisation s'exécute
2. si booleanExpression est vrai continuer, sinon quitter la boucle
3. Exécution du corps
4. Exécuter updateStatement
5. Retourner à l'étape 2  

Jetons un coup d'œil à un exemple qui imprime les cinq premiers nombres commençant par zéro:  

		for(int i = 0; i < 5; i++) {
			System.out.print(i + " "); // 0 1 2 3 4
		}

### Afficher d'éléments à l'envers: (Printing Elements in Reverse)  

Disons que vous vouliez imprimer les mêmes cinq premiers nombres pour zéro que nous l'avons fait dans la section précédente, mais cette fois dans l'ordre inverse, le but est d'afficher 4 3 2 1 0.  
Comment feriez-vous cela ? À partir de Java 10, vous pouvez maintenant voir var utilisé dans une boucle for, alors utilisons-le pour cet exemple. Une mise en œuvre initiale peut ressembler à ce qui suit:

		for(var counter = 5; counter > 0; counter--) {
			System.out.print(counter + " "); //5 4 3 2 1
		}
C'est pas ça le resultat entendu, en doit initialiser en 4 et afficher le 0:  

		for(var counter = 4; counter >= 0; counter--) {
			System.out.print(counter + " "); //4 3 2 1 0 
		}
Finalement! Nous avons du code qui affiche 4 3 2 1 0.  

### Travailler avec les boucles for:(Working with for loops)  

Bien que la plupart des boucles for que vous êtes susceptible de rencontrer dans votre expérience de développement professionnel seront bien définies et similaires aux exemples précédents, il existe un certain nombre de variations et de cas extrêmes que vous pourriez voir à l'examen. Vous devez vous familiariser avec les 5 exemples suivants:  

###### Créer une boucle infinie: (Creating an infinite loop)

	for( ; ; )
		System.out.print("Hello world");
Visisblement cet exemple ne compile pas, ça va en fait compile et s'eécute sans problème. Cet exemple crée une boucel infinie.  

###### Ajout de plusieurs termes à l'instruction for:(Adding Multiple Terms to the for statement) 

		int x = 0;
		for(long y = 0, z = 4 ; x < 5 && y < 10 ; x++, y++)
			System.out.print(y + " ");
		System.out.println(x + " "); // 0 1 2 3 4 5 
Ce code montre 3 variables dans une boucle for  

###### Déclaration d'une variable dans le bloc d'initialisation: (Declaring a Variable in the Initialization Block)  

		int x = 0;
		
		for(int x = 4; x < 5; x++) { // DOES NOT COMPILE
			System.out.println(x + "");
		}
Ce code ne compile pas, à cause du bloc d'initialisation, x est répété dans le bloc d'initialisation après avoir déjà été déclaré avant la boucle.  Pour corriger ça:

	   int x = 0;
		
		for(x = 4; x < 5; x++) { // COMPILE
			System.out.println(x + "");
		}

###### Utilisation de types de données incompatibles dans le bloc d'initialisation: (Using Incompatible Data types in the Initialization block)  

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
Ce code ne compile pas, la variable x est initialisée dans la boucle dans la portée de la variable x est dans la boucle for.

### Modification des variables de boucle: (Modifying Loop Variables)

Que se passe-t-il si vous modifiez une variable dans une boucle for, ou toute autre boucle d'ailleurs:  

		for(int i=0; i<10; i++)
			i=0;
			
		for(int j=0; j<10; j++)
			j--;
		
		for(int k=0; k<10;)
			k++;
Ces deux codes compilient bien, comme Java vous permet de modifier les variables de boucle, qu'elles soient dans les boucles for, while ou do / while  
* Le premier et le deuxieme exemple créent une boucle infinie.
* Le dernier exécute la boucle 10 fois.

### La boucle for-each: (The for-each Loop)

Disons que vous voulez parcourir un ensemble de valeurs, comme une liste de noms, et affiche chacune de nom. En utilisant une boucle for, cela peut être accompli avec une variable de compteur:

	public void printNames(String[] names){
		for(int counter = 0; counter < names.length; counter++)
			System.out.println(names[counter]);
	}
cela fonctionne, bien que ce soit un peu verbeux, donc les auteurs de Java ont ajouté les améliorations pour la boucle For, la boucle for-each est une structure spécialisée conçue pour itérer sur des tableaux et diverses classes du Framework de collections: 

	for(datatype instance : collection){ // patenthenses and Colon":" are required
		// BADY
	}
Revenons à notre exemple précédent et voyons comment nous pouvons lui appliquer une boucle for-each:

	public void printNames(String[] names){
		for(String name: names)
			System.out.println(name);
	}
* Exemples avec for-each:

	final String[] names = new String[3];
		names[0] = "Lisa";
		names[1] = "Kevin";
		names[2] = "Roger";
		for(String name : names)
			System.out.print(name + ", ");
	}
ce code compile sans problème est effiche: **Lisa, Kevin, Roger,**

	String str = "Lisa";
		for(String name: str) // DOES NOT COMPILE
			System.out.print(name + ", ");
ce code ne compile pas, String n'est pas un tableau.

# Contrôle du flux avec branchement: (Controlling Flow with Branching)

Le dernier type de structure de contrôle que nous aborderons dans le chapitre sont les instructions de branchement.

### Boucles imbriquées: (Nested loops)

Avant de passer aux instructions de branchement, nous devons introduire le concept de boucles imbriquées. Une boucle imbriquée est une boucle qui contient une autre boucle comprenant des boucles while, do/while, for et for-each, supposons maintenant que ce qui suit est de savoir comment déclarer un tableau à deux dimensions:

	   int [][] myComplexArray = {{5,2,1,3}, {3,9,8,9}, {5,7,12,7}};
		for(int[] mySimpleArray: myComplexArray) {
			for(int i=0; i<mySimpleArray.length; i++)
				System.out.print(mySimpleArray[i]+"\t");
			System.out.println();
		}
Notez que nous mélangeons intentionnellement une boucle for et foreach dans cet exemple. La boucle externe s'exécutera trois fois au total. Chaque fois que la boucle externe s'exécute, la boucle interne est exécutée plusieurs fois. Lorsque nous exécutons ce code, nous voyons la sortie suivante:

		5	2	1	3	
		3	9	8	9	
		5	7	12	7
		
### Ajout d'étiquettes facultatives:(Adding Optional Labels)

Une chose que nous avons volontairement ignorée, nous avons présenté l'instruction if, les instructions switch et les boucles, c'est qu'elles ont toutes des étiquettes optionnelles.
Une étiquette **label** est un pointeur facultatif vers l'en-tête d'une instruction qui permet au flux d'application d'y accéder ou d'en rompre. L'étiquette est un identifiant unique précédé de deux points (:)

		int [][] myComplexArray = {{5,2,1,3}, {3,9,8,9}, {5,7,12,7}};
		OUTER_LOOP: for(int[] mySimpleArray: myComplexArray) {
			INNER_LOOP: for(int i=0; i<mySimpleArray.length; i++)
				System.out.print(mySimpleArray[i]+"\t");
			System.out.println();
		}
Les étiquettes suivent les mêmes règles de mise en forme que les identificateurs, elles sont généralement exprimées en majuscules, avec des traits de soulignement entre les mots, pour les distinguer des variables régulières.

### La déclaration de rupture: (The break Statement) OcpTest9

Comme vous l'avez vu lors de l'exécution de l'instruction switch, une instruction break transfère le flux de contrôle vers l'instruction englobante, il en va de même pour une instruction break qui apparaît à l'intérieur d'un while, do/while ou for loop:

	optionalLabel: while(booleanExpression){
		// BODY
		// Somewher in loop
		break optionalLabel;
	}
Que l'instruction break peut prendre une étiquette facultative. Sans un paramètre d'étiquette, l'instruction break terminera la boucle interne la plus proche qu'elle est actuellement en cours d'exécution. Le paramètre d'étiquette facultatif nous permet de sortir d'une boucle externe de niveau supérieur. Dans l'exemple suivant, nous recherchons la première position d'index de tableau (x, y) d'un nombre dans un tableau à deux dimensions non trié:

		int [][] list = {{1,13}, {5,2}, {2,2}};
		int searchValue = 2;
		int positionX = -1;
		int positionY = -1;
		PARENT_LOOP: for(int i=0; i<list.length; i++) {
			for(int j=0; j<list[i].length; j++) {
				if(list[i][j] == searchValue) {
					positionX = i;
					positionY = j;
					break PARENT_LOOP;
				}
			}
		}
		System.out.println("Value found at: ("+ positionX + "," + positionY+")" );
Quand on execute ce programmme on aura ça comme resultat: **Value found at: (1,1)** 
En particulier, jetez un œil à l'instruction break PARANT_LOOP, l'instruction sortira de l'ensemble de la structure de la boucle dès que la première valeur correspondante sera trouvée.  
Maintenant, imaginez ce qui se passerait si nous remplaçions le corps de la boucle interne par ce qui suit:

				if(list[i][j] == searchValue) {
					positionX = i;
					positionY = j;
					break;
				}
Comment cela changerait notre flux, et la sortie changerait-elle? Au lieu de quitter lorsque la première valeur correspondante est trouvée, le programme ne quittera désormais la boucle interne que lorsque la condition est remplie:  
Quand on execute le programmme **sans** le Label **PARENT_LOOP** on aura ça comme resultat: **Value found at: (1,1)** 
 

### L'instruction continue: (The continue Statement) OcpTest10

	optionalLabel: while(booleanExpression){
		// BODY
		// Somewher in loop
		continue optionalLabel;
	}
Vous remarquerez peut-être que la syntaxe de l'instruction continue reflète celle de l'instruction break. En fait, les déclarations sont identiques dans la façon dont elles sont utilisées, mais avec des résultats différents. Alors que l'instruction break transfère le contrôle à l'instruction englobante, l'instruction continue transfère le contrôle à l'expression booléenne qui détermine si la boucle doit continuer  
Jetons un coup d'œil à un exemple:

	 CLEANING: for(char stables = 'a'; stables <= 'd'; stables++) {
			for(int leopard = 1; leopard<4; leopard++) {
				if(stables=='b' || leopard==2) {
					continue CLEANING;
				}
				System.out.println("Cleaning: "+stables+","+leopard);
			}
		}
Ce programme affiche:
	
		Cleaning: a,1
		Cleaning: c,1
		Cleaning: d,1
Maintenant, imaginez que nous ayons supprimé l'étiquette CLEANING dans l'instruction continue afin que le contrôle soit retourné à la boucle interne au lieu de la boucle externe  

				if(stables=='b' || leopard==2) {
					continue;
				}
Cela correspond au gardien de zoo sautant tous les léopards sauf ceux étiquetés 2 ou en écurie, ce serait alors le suivant:  

		Cleaning : a,1
		Cleaning : a,3
		Cleaning : c,1
		Cleaning : c,3
		Cleaning : d,1
		Cleaning : d,3


### La déclaration de retour: (The return Statement) OcpTest11

Étant donné que ce livre ne devrait pas être votre premier dans la programmation, nous espérons que vous avez rencontré des méthodes contenant des instructions return.  
Pour l'instant, cependant, vous devez être familier avec l'idée que la création de méthodes et l'utilisation d'instructions return peuvent être utilisées comme une alternative à l'utilisation d'étiquettes et d'instructions break. Par exemple, jetez un œil à cette réécriture de notre précédente classe FindInMatix  
Quand on execude le programme de la classe **OcpTest11**on aura ce resultat:  

	Value 2 found at: (1,1)
	
### Code inaccessible:(Unreachable code)  

Une facette de break, continue et return dont vous devez être conscient est que tout code placé immédiatement après dans le même bloc est considéré comme inaccessible  

		int checkDate = 0;
		while(checkDate < 10) {
			if(checkDate>100) {
				break;
				checkDate++; // DOES NOT COMPILE
			}
		}
Cet exmple et vrai pour continue et return

		int minute = 1;
		WATCH: while(minute > 2) {
			if(minute++ >2) {
				continue WATCH;
				System.out.println(minute); // DOES NOT COMPILE
			}
