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
La méthode contains() recherche des correspondances dans la chaîne. Ce n'est pas aussi particulier que startsWith() et endsWith(). La correspondance peut être n'importe où dans la chaîne. La signature de la méthode est la suivantee:  
	*boolean contains(CharSequence charSeq)*  
Le code suivant montre comment utiliser replace():  

		System.out.println("abc".contains("a"));	// true
		System.out.println("abc".contains("B"));	// false
###### trim(),strip(), strip()Leading(), and stripTrailing():  
Vous avez vu presque toutes les méthodes String que vous devez connaître. La prochaine étape consiste à supprimer l'espace vide du début et/ou de la fin d'une chaîne. Les méthodes strip() et trim() suppriment les espaces du début et de la fin d'un String.  
Dans les termes de l'examen, les espaces se composent d'espaces avec \t (tab) et \n (newLine)  
La méthode strip() est nouvelle dans **Java 11**. Elle fait tout ce que trim() fait, mais elle prend en charge Unicode.  
De plus, les méthodes stripLeading() et stripTrailing() ont été ajoutées dans Java11. La méthode stripLeading() supprime les espaces au début de la chaîne et les laisse à la fin. La méthode stripTrailing() fait le contraire. Les signatures de la méthode sont les suivantes:  
	*String strip()* 
	*String stripLeading()* 
	*String stripTrailing()* 
	*String trim()* 

		System.out.println("\t  a b c \n".strip());	// a b c
		System.out.println("\t  a b c \n".trim());	//a b c
		String text = " abc\t ";
		System.out.println(text.trim().length());	// 3
		System.out.println(text.strip().length());	// 3
		System.out.println(text.stripLeading().length());	// 5
		System.out.printlntext.stripTrailing().length());	// 4
	
###### intern():  
la méthode intern() renvoie la valeur du pool de String s'il y en a. Sinon, il ajoute la valeur au pool de String, on aura d'avantage d'explication dans le paragraphe concernant string pool.  
##### Chaînage de méthodes: (Method Chaining)  
Il est courant d'appeler plusieurs méthodes comme indiqué ici:  

		String start = "AniMaL ";
		String trimmed = start.trim();	// "AniMaL"
		String lowercase = trimmed.toLowerCase();	// "animal"
		String result = lowercase.replace('a', 'A');	// "AnimAl"
	   System.out.println(result);	// AnimAl
Ceci est juste une série de méthodes String. A chaque appel, la valeur renvoyée est placée dans une nouvelle variable. Il existe quatre valeurs String en cours de route et AnimAl est généré. Cependant, lors de l'examen, il y a une tendance à entasser autant de code que possible dans un petit espace. Vous verrez du code utilisant une technique de chaînage de méthode appelée. Voici un exemple  

		String res = "AniMal ".trim().toLowerCase().replace('a', 'A');
		System.out.println(res);	// AnimAl
# Utilisation de la classe StringBuilder: (Using the StringBuilder Class)  

La classe StringBuilder crée un String sans stocker toutes ces valeurs String provisoires. Contrairement à la classe String, StringBuilder n'est pas immuable

### Mutabilité et chaînage: (Mutability ans Chaining)
L'examen tentera probablement de vous tromper sur le fait que String et Stringbuilder sont mutables.  
lorsque nous avons enchaîné les appels de la méthode String, le résultat était un nouveau String avec la réponse. Au lieu de cela, le StringBuilder change son propre état et renvoie une référence à lui-même.  
Regardons un exemple pour rendre cela plus clair:  

		StringBuilder sb = new StringBuilder("start");
		sb.append("+middle");
		StringBuilder same = sb.append("+end");
		System.out.println(sb);	// start+middle+end
		System.out.println(same);	// start+middle+end
Les deux reference affiche le même resultat, contrairement avec la classe String.  

### Créer un StringBuilder: (Creating a StringBuilder)  
Il existe **trois** façons de construire un StringBuilder:  

	StringBuilder sb1 = new StringBuilder();  
	StringBuilder sb2 = new StringBuilder("animal");  
	StringBuilder sb3 = new StringBuilder(10);
La première ligne, crée un StringBuilder  contient une séquence vide.  
La deuxième ligne, crée un StringBuilder contient la chaine "animal".  
La dernière indique à Java que nous avons une idée de la taille de la valeur éventuelle.  

### Méthodes StringBuilder importantes: (Important StringBuilder Methods)  

Comme avec String, nous n'allons pas couvrir toutes les méthodes de la classe StringBuilder, Ce sont ceux que vous pourriez voir à l'examen:  

###### charAt(), indexOf(), lengh() and substring():  

Ces quatre méthodes fonctionnent exactement de la même manière que dans la classe String. Assurez-vous de pouvoir identifier la sortie de cet exemple:  

		StringBuilder strB = new StringBuilder("animals"); 
		String sub = strB.substring(strB.indexOf("a"), strB.indexOf("al"));
		int len = strB.length();
		char ch = strB.charAt(6);
		System.out.println(sub + " " + len + " " + ch);	// anim 7 s
In faut noter que **substring** renvoie String plutôt qu'in StringBuilder

###### append(): 
La méthode append() est de loin la méthode la plus fréquement utilisé dans StringBuilder. Elle ajoute le paramètre au StringBuilder et renvoie une référene au StringBuilder acutel. L'une des signature des méthde est la suivante:  
	*append(String str)*
Notez que nous avois dit l'une des signatures de la méthode. Il existe plus de **10** signatures:  

	StringBuilder sb = new StringBuilder().append(1).append('c').append("-").append(true);
		System.out.println(sb);	// 1c-true
###### insert(): 
Ajoute des caractères au StringBuilder à l'index demandé et renvoie une référence au StringBuilder actuel. Il existe plusieurs signatures des méthodes pour differents types, en voici un:  
	*StringBuilder insert(int offset, String str)*  
Le code suivant montre comment utiliser insert():  

		StringBuilder sb = new StringBuilder("animals");
		sb.insert(7, "-");		// sb = animals-
		sb.insert(0, "-");	// sb = -animals-
		sb.insert(4, "-");	// sb = ani-mals-
		System.out.println(sb);	// -ani-mals-
il faut faire attention:

		StringBuilder sb = new StringBuilder("animals");
		sb.insert(8, "-");		// throws an exception
###### delete() and deleteCharAt():  
La méthode delete() est l'inverse de la méthode inserte() permet de supprimer une séquence de caractères, et la méthode deleteCharAt() est pratique si on veut supprimer un seul caractère, les signagures de méthodes sont les suivantes:  
	*StringBuilder delete(int start, int end)*  
	*StringBuilder deleteCharAt(int index)*  
Le code suivant montre comment utiliser delete() et deleteCharAt():  

		StringBuilder sb = new StringBuilder("abcdef");
		sb.delete(1, 3);	// sb = adef
		sb.deleteCharAt(5);	// throws an exception
Si vous spécifiez un deuxième paramètre qui dépasse la fin de StringBuilder, Java supposera simplement que vous vouliez dire la fin.  
		
			StringBuilder sb = new StringBuilder("abcdef");
			sb.delete(1, 100);	// sb = a
###### replace():  
La méthode replace() fonctionne différemment pour StringBuilder et pour String. La signature de la méthode est la suivante:  
	*StringBuilder replace(int startIndex, int endIndex, String newString)*  
Le code suivant montre comment utiliser la méthode replace():  

		StringBuilder builder = new StringBuilder("pigeon dirty");
		builder.replace(3, 6, "sty");
		System.out.println(builder);	// pigsty dirty
###### reverse():  
Après tout cela, il est temps de choisir une méthode simple et agréable. Le méthode reverse() inverse les caractère des séquences et renvoie une référence au StringBuilder atuel. La signature de la méthode est la suivante:  
	*StringBuilder reverse()*  
Le code suivant montre comment utiliser la méthode reverse():  

		StringBuilder sb = new StringBuilder("ABC");
		sb.reverse();
		System.out.println(sb);	// CBA
###### toString():    
La dernière méthode convertit un StringBuilder en String, La signature de la méthode est la suivante: 
	*String toString()*
Le code suivant montre comment utiliser la méthode toString():  

	StringBuilder sb = new StringBuilder("ABC");
	String s = sb.toString();
# Comprendre l'égalité: (Understanding Equality)  

### Comparaison equlas() et "==" : (Comparing equals() and "==" )  
### The String pool:  

# Comprendre les tableaux Java: (Understanding Java Arrays)  

