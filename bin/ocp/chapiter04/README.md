									MAKING DECISIONS
									
# Création d'énoncés décisionnels: (Creating Decision-Making Statements)

Les opérateurs Java vous permettent de créer de nombreuses expressions complexes, mais ils sont limités dans la manière dont ils peuvent contrôler le flux du programme. 

##### Instructions et blocs:(Statements and Blocks)

Comme vous vous en souvenez du chapitre 2, une instruction Java est une unité d'exécution complète en Java, terminée par un point-virgule(semicolon) **;**  
Ces instructions peuvent être appliquées à des expressions uniques ainsi qu'à un bloc de code Java. Comme décrit au chapitre 2, un bloc de code en Java est un groupe de zéro instruction ou plus entre accolades équilibrées ** {} **  

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

##### L'instruction if: (The if statement)

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

##### L'instruction switch: (The switch statement)

Que faire si nous avons beaucoup de branches possibles pour une valeur unique, par exemple, nous pourrions vouloir imprimer un message différent en fonction du jour de la semaine. Nous pourrions certainement accomplir cela avec une combinaison de sept si ou autre, mais cela tend à créer du code long et difficile à lire.  
Heureusement, Java, avec de nombreux autres langages, offre une approche plus propre. Une instruction switch  

	switch(variableToTest){
		case constantExpression1:
				// Branch for case1;
			  break; // oprional
		case constantExpression2:
				// Branch for case 2
			 break; // oprional
			 ......
		default:
			// Branch for default
	}
*Syntaxe appropriée du Switch:(Proper Switch syntax)*  

