									CORE JAVA APIs
									
									
# Créer et manipuler les Strings:(Creating and manipulating Strings)  

La classe String est une classe tellement fondamentale que vous auriez du mal à écrire du code sans elle. Après tout, vous ne pouvez même pas écrire une méthode main () sans utiliser la classe String. Un string est essentiellement une séquence de caractères, voici un exemple:

	String name = "Fluffy";
Dans Java, on peut crée de deux façon un string:

	String name = "Fluffy";
	String name =  new String("Fluffy");
Les deux vous donnent une variable de référence nommée name pointant vers l'objet String "Fluffy". Ils sont subtilement différents, comme vous le verrez dans la section "Le pool de chaînes" plus loin dans le chapitre. Pour l'instant, rappelez-vous simplement que la classe String est spéciale et n'a pas besoin d'être instanciée avec new.

### Concatenation: (Enchaînement)

Placer une chaîne avant l'autre chaîne et les combiner est appelée concaténation de chaînes.  
Les créateurs d'examens apprécient la concaténation de chaînes car l'opérateur + peut être utilisé de deux manières dans la même ligne de code.Il n'y a pas beaucoup de règles à connaître pour cela, mais vous devez bien les connaître:  
	- Si les deux opérandes sont numériques, + signifie une addition numérique.  
	- Si l'un des opérandes est une chaîne, + signifie concaténation.  
	- L'expression est évaluée de gauche à droite.  
Ci-dessous, qques exemples:

		System.out.println(1 + 2);	// 3
		System.out.println("a" + "b");	// ab
		System.out.println("a" + "b" + 3);	// ab3
		System.out.println(1 + 2 + "c");	// 3c
		System.out.println("c" + 1 + 2);	// c12
Il n'y a plus qu'une chose à savoir sur la concaténation, mais c'est facile. Dans cet exemple, il vous suffit de vous rappeler ce que fait +=  

	String s = "1";
	s += "2";
	s += "3";
	System.out.println(s);	// 123
Vous avez appris que + est utilisé pour faire la concaténation de chaînes en Java. Il existe une autre méthode **concat** qui n'est pas beaucoup utilisée sur de vrais projets mais qui est idéale pour tromper les gens à l'examen:  

	String s = "1";
	String s1 = s.concat("2");
	System.out.println(s2);	// 12
	
### Immutability: (Immutabilité)

Une fois qu'un objet String est créé, il n'est pas autorisé à changer. Il ne peut pas être agrandi ou réduit et vous ne pouvez pas modifier l'un des caractères qu'il contient.  
À l'examen, vous devez savoir que String est immuable.
Une classe immuable a seulement des getters.  

### Important String Methods: (Méthodes de chaîne importantes) (StringMethods.java)  

La classe String a des dizaines de méthodes. Heureusement, vous n'avez besoin d'en connaître que quleques une pour l'examen.  
Pour toutes ces méthodes, vous devez vous rappeler que la chaîne est une séquence de caractères en Java qui compte à partir de 0 lorsqu'elle est indexée. par exemple String s = "animals"; est une séquence de 7 charactères:    
      
| a | n | i | m | a | l | s |    
| 0 | 1 | 2 | 3 | 4 | 5 | 6 |  

###### length(): 
La méthode lenghth() renvoie le nombre de caractères dans la chaîne, la signature de la méthode est:  
	*int length()*

		String s = "animals";
		System.out.println(s.length());	// 7
###### charAt():  
La méthode charAt(), vous permet d'interroger la chaîne pour savoir quel caractère se trouve dans un index spécifique. La signature de la méthode est la suivante:  
	*char charAt(int index)*  
	
		String s = "animals";
		System.out.println(s.charAt(0));	// a
		System.out.println(s.charAt(6));	// s
		System.out.println(s.charAt(7));	// throws exception String index out of range: 7
###### indexOf():
La méthode indexf(), regarde les caractères de la chaîne et trouve le premier index qui correspond à la valeur souhaitée.  
indexOf peut fonctionner avec un caractère individuel ou une chaîne entière en entrée. Il peut également démarrer à partir d'une position demandée. Les signatures de la méthode sont les suivantes:  
	*int indexOf(int ch)*  
	*int indexOf(int ch, int fromIndex)*  
	*int indexOf(String str)*  
	*int indexOf(String str, int fromIndex)*  
Le code suivant montre comment utiliser indexOf():  

		String s = "animals"; 
		System.out.println(s.indexOf('a'));	// 0
		System.out.println(s.indexOf("al"));	// 4
		System.out.println(s.indexOf('a', 4));	// 4
		System.out.println(s.indexOf("al",5));	// -1
Contrairement à charAt(), la méthode indexOf() ne lève pas une exception si le match n'est pas trouvé, mais elle renvoie la valeur **-1** comme dans le dernier exemple.  
###### substring():
La méthode substring recherche également des caractères dans une chaîne. Il renvoie des parties de la chaîne. Le premier paramètre est l'index avec lequel commencer pour la chaîne retournée. Il existe un deuxième paramètre facultatif, qui est l'index de fin auquel vous souhaitez vous arrêter. Les signatures de la méthode sont les suivantes:   
	*String substring(int beginIndex)*
	*String substring(int beginIndex, int endIndex)*
Il est utile de penser les index un peu différemment pour les méthodes de substring(). Faire semblant que les index sont juste avant le caractère vers lequel ils pointeraient.  
Le code suivant montre comment utiliser substring():  

		String s = "animals";
		System.out.println(s.substring(3));	// mals
		System.out.println(s.substring(7));	// empty String dernier index
		System.out.println(s.substring(s.indexOf('m')));	//mals
		System.out.println(s.substring(3, 4));	// m
		System.out.println(s.substring(3, 3));	// empty String
		System.out.println(s.substring(5, 4));	//throws exception
		System.out.println(s.substring(5, 8));	//throws exception
		System.out.println(s.substring(8));	// //throws exception

###### toLowerCase() and to UpperCase():
Ces méthodes font ce qu'elles disent. toUpperCase convertit tous les caractères minuscules en majuscules dans la chaîne renvoyée. toLowerCase convertit tous les caractères majuscules en minuscules. Les signatures de la méthode sont les suivantes:  
	*String toLowerCase()*
	*String toUpperCase()*
Le code suivant montre comment utiliser toLowerCase et toUpperCase:  

		String str = "robin";
		System.out.println(str.toUpperCase());	// ROBIN
		System.out.println("ABC123".toLowerCase());	// abc123
###### equals() and equalsIgnoreCase():
La méthode equals() vérifie si deux objets String contiennent exactement les mêmes caractères dans le même ordre, le méthode equalsIgnoreCase() resemble la méthode equlas() sauf qu'elle ignore la casse. Les signatures de la méthode sont les suivantes:  
	*boolean equals(Object obj)*
	*boolean equalsIgnoreCase(Object obj)*  
Le code suivant montre comment utiliser equals() et equalsIgnoreCase():  

		System.out.println("abc".equals("ABC"));	// false
		System.out.println("abc".equals("abc"));	// true
		System.out.println("abc".equalsIgnoreCase("ABC"));	//true
###### startsWith() and endsWith():  
Les méthodes startsWith () et endsWith () vérifient si la valeur fournie correspond à une partie de la chaîne. Les signatures de la méthode sont les suivantes:  
	*boolean startsWith(String prefix)*  
	*boolean endsWith(String suffix)*  
Le code suivant montre comment utiliser startsWith() et endsWith():  

		System.out.println("abc".startsWith("a"));	// true
		System.out.println("abc".startsWith("A"));	// false
		System.out.println("abc".endsWith("c"));	// true
		System.out.println("abc".endsWith("a"));	// false
###### replace(): 
La méthode replace() effectue une simple recherche et remplacement sur la string. Il existe une version qui prend les paramètres char ainsi qu'une version prend les paramètres CharSequence. Les signatures de la méthode sont les suivantes:  
	*String replace(char oldChar, char newCher)*
	*String replace(CharSequence target, CharSequence replacement)*
Le code suivant montre comment utiliser replace():  

		System.out.println("abcab".replace('a', 'A'));	// AbcAb
		System.out.println("abcab".replace("bc", "BC"));	// aBCab
La classe String **implements** l'interface CharSequence.  

###### contains():  
La méthode contains() recherche des correspondances dans la chaîne. Ce n'est pas aussi particulier que startsWith() et endsWith(). La correspondance peut être n'importe où dans la chaîne. La signatures de la méthode sont les suivantes:  
	*boolean contains(CharSequence charSeq)*  
Le code suivant montre comment utiliser replace():  

		System.out.println("abc".contains("a"));	// true
		System.out.println("abc".contains("B"));	// false
###### trim(),strip(), strip()Leading(), and stripTrailing():  
Vous avez vu presque toutes les méthodes String que vous devez connaître. La prochaine étape consiste à supprimer l'espace vide du début et/ou de la fin d'une chaîne. Les méthodes strip() et trim() suppriment les espaces du début et de la fin d'un String.  
La méthode strip() est nouvelle dans **Java 11**. Elle fait tout ce que trim () fait, mais elle prend en charge Unicode  
###### intern():  
la méthode intern() renvoie la valeur du pool de String s'il y en a. Sinon, il ajoute la valeur au pool de String, on aura d'avantage d'explication dans le paragraphe concernant string pool.  

##### Chaînage de méthodes: (Method Chaining)

# Utilisation de la classe StringBuilder: (Using the StringBuilder Class)