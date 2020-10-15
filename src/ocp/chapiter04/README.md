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
*Syntaxe appropri�e du Switch:(Proper Switch syntax)*  

