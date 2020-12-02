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

### Méthodes StringBuilder importantes: (Important StringBuilder Methods)  StringMethods.java

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
	
# Comprendre l'égalité: (Understanding Equality)  UnderstandEqual.java

Dans le chapitre 3, vous avez appris à utiliser == pour comparer des nombres et que les références d'objet font référence au même objet. 

### Comparaison equlas() et "==" : (Comparing equals() and "==" )  
Prenons cet exemple:  

		StringBuilder one = new StringBuilder();
		StringBuilder two = new StringBuilder();
		StringBuilder three = one.append("a");
		System.out.println(one == two); // false
		System.out.println(one == three); // true
Puisque cet exemple ne traite pas des primitives, nous savons chercher si les références font référence au même objet. one et two sont les deux des StringBuilders complètement séparés, ce qui nous donne deux objets. Par conséquent, la première instruction print nous donne false. three est plus intéressant. Rappelez-vous comment les méthodes StringBuilder aiment renvoyer la référence actuelle pour le chaînage? Cela signifie qu'un et trois pointent tous les deux vers le même objet et la deuxième instruction d'impression nous donne vrai.
Vous avez vu précédemment que vous pouvez dire que vous voulez l'égalité logique plutôt que l'égalité d'objet pour les objets String:   

		String x = "Hello World";	// literal string
		String y = " Hello World".trim();
		System.out.println(x.equals(y)); // true
Cela fonctionne car les auteurs de la classe String ont implémenté une méthode standard appelée equals pour vérifier l'egalité des valeurs à l'intérieur de String plutôt que la référence String elle-même. Et si la classe n'implemente pas la méthode equlas(), alors la classe va vérifier si les references pointent sur le même objet, c'est la même chose ce qu'elle fait l'opérateur ==  

Regardons cet exemple très important:

		String s1 = new String();
		String s2 = new String();
		System.out.println(s1 == s2);	// false
		System.out.println(s1.equals(s2));	// true
Avec une classe qque qui s'appelle Tiger:  

		Tiger t1 = new Tiger();
		Tiger t2 = new Tiger();
		Tiger t3 = t1;
		System.out.println(t1 == t3);	// true
		System.out.println(t1 == t2);	// false
		System.out.println(t1.equals(t2));	// false
Le resultat est different que la classe String, parce que la classe Tiger  n'implemente pas la méthode equals(). Si la classen'implemente pas equals() alros == et equals() donnent le même résultat.

Enfin, l'examen pourrait essayer de vous tromper avec une question comme celle-ci:  

		String str = "a";
		StringBuilder builder = new StringBuilder("a");
		System.out.println(str == builder);	// DOES NOT COMPILE
N'oubliez pas que == vérifie l'égalité des références d'objet de même type.
### The String pool:  
Comme les Strings sont partout en Java, elles utilisent beaucoup de mémoire. Dans certaines applications de production, ils peuvent utiliser une grande quantité de mémoire dans l'ensemble du programme. Java se rend compte que de nombreuses chaînes se répètent dans le programme et résout ce problème en réutilisant les chaînes courantes. Le pool de Strings, également appelé pool interne, est un emplacement de la machine virtuelle Java (JVM) qui collecte toutes ces chaînes.  
Le pool de chaînes contient des valeurs littérales et des constantes qui apparaissent dans votre programme. Par exemple, "name" est un littéral et va donc dans le pool de chaînes. myObject.toString () est une chaîne mais pas un littéral, donc il n'entre pas dans le pool de Strings.  
Voyons maintenant le scénario plus complexe et déroutant, l'égalité des chaînes, en partie à cause de la façon dont la JVM réutilise les littéraux de chaîne.  

		String x = "Hello World";
		String y = "Hello World";
		System.out.println(x == y); // true
x et y deux litéraux avec la même valeure "Hello World" donc le JVM va crée un seul litéral dans la mémoire, exactement dans le Pool Strings, et x et y les deux pointent sur cet objet.  
Cela devient encore plus délicat. Considérez ce code:  

		String x = "Hello World";
		String z = " Hello World".trim();
		System.out.println(x == z); // false
Dans cet exemple, nous n'avons pas deux même littéral String. Bien que x et z soient évalués sur la même chaîne, l'un est calculé au moment de l'exécution(runtime), ce n'est pas la même chose au moment de la compilation, donc un nouvel objet chaîne est créé. Regardons un deuxième exemple:  

		String singleString = "hello world";
		String oneLine = "hello " + "world";
		String concat = "hello ".concat("world");
		System.out.println(singleString == oneLine);	// true
		System.out.println(singleString == concat);	//false
On peut dire à Java d'utiliser le pool de String. La méthode intern() utilisera un objet dans le pool de chaînes s'il y en a un. Si le littéral n'est pas encore dans le pool de chaînes, Java l'ajoutera à ce moment:  

		String name = "Hello world";
		String name2 = new String("Hello world").intern();
		System.out.println(name == name2);	// true
# Comprendre les tableaux Java: (Understanding Java Arrays)  

Un tableau est une zone de mémoire sur le tas (Heap) avec de l'espace pour un nombre désigné d'éléments. Une grande différence est qu'un tableau peut être de n'importe quel type Java. Si nous ne voulions pas utiliser un String pour une raison quelconque, nous pourrions utiliser directement un tableau de primitives char:  
	*char [] letters:*  
	
### Créer un tableau de primitives: (Creating an Array of Primitives) CreatingArray.java 

La façon la plus courante de créer un tableau ressemble à ceci:  

		int[] numbers = new int[3];	// [] les brackets sont obligatoires pour un tableau
numbers est un tableau de type int et de taille 3.  
Une autre façon de créer un tableau est de spécifier tous les éléments avec lesquels il doit commencer:  

		int[] numbers2 = new int[] {4, 52, 89};
Dans cet exemple, nous créons également un tableau int de taille 3. Cette fois, nous spécifions les valeurs initiales de ces trois éléments au lieu d'utiliser les valeurs par défaut.  
Java reconnaît que cette expression est redondante. Puisque vous spécifiez le type du tableau sur le côté gauche du signe égal, Java connaît déjà le type. Et puisque vous spécifiez les valeurs initiales, il connaît déjà la taille. En tant que raccourci, Java vous permet d'écrire ceci:  

		int[] numbers2 = {4, 52, 89};
Enfin, vous pouvez taper le [] avant ou après le nom, et l'ajout d'un espace est facultatif. Cela signifie que ces 5 instructions font exactement la même chose:  

		int[] numAnimals;
		int [] numAnimals2;
		int []numAnimals3;
		int numAnimals4[];
		int numAnimals5 [];
* Plusieurs «tableaux» dans les déclarations: 

	int [] ids, types; // on creé deux tableau de type int.
	int [] a, b; // a un tableau de type int et b une primitive sur un entier
### Création d'un tableau avec des variables de référence: (Creating an Array with Reference Variables) 

Vous pouvez choisir n'importe quel type Java comme type de tableau. Cela inclut les classes que vous créez vous-même. Jetons un coup d'œil à un type String: 

		String [] bugs = {"cricket", "beetle", "ladybug"};
		String [] alias = bugs;
		System.out.println(bugs.equals(alias));	// true
		System.out.println(bugs.toString());	// [Ljava.lang.String;@39ed3c8d
Nous pouvons appeler equals() car **un tableau est un objet**. Il renvoie true en raison de l'égalité de référence. La méthode equals () sur les tableaux ne regarde pas les éléments du tableau. Rappelez-vous que cela fonctionnerait même sur un int [] aussi. int est un primitif, int[] est un objet.
### Utilisation d'un tableau: (Using an Array)  

Maintenant que nous savons comment créer un tableau, essayons d’y accéder:  

		String[] mammals = {"monkey", "chimp", "donkey"};	// déclare et initialise le tableau
		System.out.println(mammals.length); // 3
		System.out.println(mammals[0]); // monkey
		System.out.println(mammals[1]); // chimp
		System.out.println(mammals[2]); // donkey
Pour vous assurer que vous comprenez comment fonctionne la longueur (length):  
	
		String[] birds = new String[6];
		System.out.println(birds.length);	// 6
### Tri: (Sorting)  

Java facilite le tri d'un tableau en fournissant une méthode de tri, ou plutôt un ensemble de méthodes de tri. Tout comme StringBuilder vous a permis de transmettre presque tout à append (), vous pouvez passer presque n'importe quel tableau à **Arrays.sort ()**.  
Arrays est la première classe fournie par Java que nous avons utilisée et qui nécessite une importation. Pour l'utiliser, vous devez avoir l'une des deux instructions suivantes dans votre classe:  

		import java.util.* // import whole package including Arrays
		import java.util.Arrays; // import just Arrays
Cet exemple trie trois nombres:

		int [] tab = {9, 5 , 1};
		Arrays.sort(tab);
		for(int i : tab)
			System.out.println(i + " ");	// 1 5 9
Réessayez avec les types String:  

		String[] strings = { "10", "9", "100" };
		Arrays.sort(strings);
		for (String string : strings)
			System.out.print(string + " ");	// 10 100 9
Cette fois, le résultat n'est peut-être pas celui que vous attendez. Ce code produit 10 100 9. Le problème est que String trie par ordre alphabétique et 1 trie avant 9. (Les nombres sont triés avant les lettres et les majuscules avant les minuscules, au cas où vous vous poseriez la question.)
### Recherche: (Recherche)  

Java fournit également un moyen pratique de recherche, mais uniquement si *le tableau est déjà trié*, en utilisant **Arrays.binarySearch()**. Ci-dessous on trouve les règles de la recherche:  
	- Si l'élément cible est trouvé dans un tableau trié alors on retourne l'index de l'élément.  
	- Si l'élément cible n'est pas trouvé dans un tableau trié alors on retourne une valeur négative strictement infèrieur à l'index ou devrait l'être.  
	- Si le tableau n'est pas trié alors on aura une valeur surpprise.  
Essayons ces règles avec un exemple:  

		int[] tabInt = {2,4,6,8};
		System.out.println(Arrays.binarySearch(tabInt, 2)); // 0
		System.out.println(Arrays.binarySearch(tabInt, 4)); // 1
		System.out.println(Arrays.binarySearch(tabInt, 1)); // -1
		System.out.println(Arrays.binarySearch(tabInt, 3)); // -2
		System.out.println(Arrays.binarySearch(tabInt, 9)); // -5
Que pensez-vous qu'il se passe dans cet exemple ?  

		int [] tabNoSort = new int[] {3,2,1};
		System.out.println(Arrays.binarySearch(tabNoSort, 2));	//1
		System.out.println(Arrays.binarySearch(tabNoSort, 3));	// -4
Dans l'exam dès que vous voyez que le tableau n’est pas trié, recherchez un choix de réponse concernant une sortie imprévisible.
### Comparant: (Comparing) 

Java fournit également des méthodes pour comparer deux tableaux afin de déterminer lequel est "plus petit". Nous allons d'abord couvrir la méthode compare(), puis passer à mismatch() " l'incompatibilité".  
###### compare():  

Il y a un tas de règles que vous devez connaître avant d'appeler compare(). Vous devez d'abord savoir ce que signifie la valeur de retour. vous n'avez pas besoin de connaître les valeurs de retour exactes, mais vous devez connaître les éléments suivants:  
	- Un nombre négatif signifie que le premier tableau est plus petit que le second.
	- Un zéro signifie que les tableaux sont égaux.
	- Le nombre positif signifie que le premier tableau est plus grand que le second.  
Voici un exemple: 

		System.out.println(Arrays.compare(new int[] {1}, new int[] {2}));	// -1
retourne -1 parce que 1 est plus petit que 2, c'est normal.  
Mais si on veut comparer deux tableaux avec une tailles differentes, qq ce passe ?  Ci-dessous des exemples qui illustrent les règles:  

	System.out.println(Arrays.compare(new int[] {1, 2}, new int[] {2}));	// -1
	System.out.println(Arrays.compare(new int[] {1, 2}, new int[] {1, 2}));	// 0
	System.out.println(Arrays.compare(new int[] {1, 2}, new int[] {2, 1}));	// -1
	System.out.println(Arrays.compare(new String[] {"a"}, new String[] {"aa"}));	// -1
	System.out.println(Arrays.compare(new String[] {"a"}, new String[] {"A"}));	// 32
	System.out.println(Arrays.compare(new String[] {"a"}, new String[] {null}));	//1
	System.out.println(Arrays.compare(new int[] {1}, new String[] {"a"}));	// DOES NOT COMPILE
###### mismatch():  

Il est maintenant temps d'en apprendre davantage sur les mismatch(). si les tableaux sont égaux, mismatch() renvoie -1. Sinon, il renvoie le premier index où ils diffèrent. Pouvez-vous comprendre ce que ces imprimés?  

	System.out.println(Arrays.mismatch(new int[] {1},  new int[] {1}));	// -1
		System.out.println(Arrays.mismatch(new String[] {"a"}, new String[] {"A"}));	// 0
		System.out.println(Arrays.mismatch(new int[] {1, 2},  new int[] {1}));	// 1
### Varargs:  

Lorsque vous créez un tableau vous-même, cela ressemble à ce que nous avons vu jusqu'à présent. Quand on est passé à votre méthode, il y a une autre façon dont cela peut ressembler. Voici trois exemples avec une méthode main():  

		public static void main(String[] args)
		public static void main(String args[])
		public static void main(String... args) // varargs
Le troisième exemple utilise une syntaxe appelée varargs (arguments de variable), que vous avez vue au chapitre 1. Vous apprendrez comment appeler une méthode à l'aide de varargs au chapitre 7, «Méthodes et encapsulation». Pour l'instant, tout ce que vous devez savoir, c'est que vous pouvez utiliser une variable définie à l'aide de varargs comme s'il s'agissait d'un tableau normal. Par exemple, args.length et args[0] sont légaux.
# Tableaux multidimensionnels: (Multidimensional Arrays)   

Les tableaux sont des objets et, bien entendu, les composants du tableau peuvent être des objets. Il ne faut pas beaucoup de temps, en frottant ces deux faits ensemble, pour se demander si les tableaux peuvent contenir d'autres tableaux, et bien sûr ils le peuvent.  
### Création d'un tableau multidimensionnel: (Creating a Multidimensional Array) 

Plusieurs séparateurs de tableau sont tout ce qu'il faut pour déclarer des tableaux avec plusieurs dimensions. Vous pouvez les localiser avec le type ou le nom de variable dans la déclaration, comme précédemment:  

		int[][] vars1; // 2D array
		int vars2 [][]; // 2D array
		int[] vars3[]; // 2D array
		int[] vars4 [], space [][]; // a 2D AND a 3D array
Vous pouvez spécifier la taille de votre tableau multidimensionnel dans la déclaration si vous le souhaitez:  

		String [][] rectangle = new String[3][2];
Le résultat de cette instruction est un de tableau avec trois éléments, chacun faisant référence à un 
tableau de deux éléments. Vous pouvez considérer la plage adressable de rectangle[0][0] à rectangle[2][1], mais ne la 
considérez pas comme une structure d'adresses comme [0,0] ou [2,1].  
Supposons maintenant que nous définissions l'une de ces valeurs:  

		rectangle[0][1] = "set";
Une autre façon de créer un tableau 2D consiste à initialiser uniquement la première dimension d'un tableau et à définir la taille de chaque composant du tableau dans une instruction distincte:  

		int [][] args = new int[4][];
		args[0] = new int[5];
		args[1] = new int[3];
Cette technique révèle ce que vous obtenez réellement avec Java: des tableaux de tableaux qui, correctement gérés, offrent un effet multidimensionnel.
### Utilisation d'un tableau multidimensionnel: (Using a Multidimensional Array)

L'opération la plus courante sur un tableau multidimensionnel est de le parcourir. Cet exemple imprime un tableau 2D:

		int[][] twoD = new int[3][2];
		for (int i = 0; i < twoD.length; i++) {
			for (int j = 0; j < twoD[i].length; j++)
				System.out.print(twoD[i][j] + " "); // print element
			System.out.println(); // time for a new row
		}

# Comprendre une ArrayList: (Understanding an ArrayList)  
### Créer une ArrayList: (Creating an ArrayList )  
### Utilisation d'un ArrayList: (Using an ArrayList)
###### add():
###### remove():  
###### set():  
###### isEmpty() and size():  
###### clear():  
###### contains():  
###### equals():  
### Classes Enveloppée :(Wrapper Classes)  
###### Autoboxing and Unboxing:  
###### Conversion entre tableau et liste: (Converting Between array and List)  
###### Utilisation de Varargs pour créer une liste: (Using Varargs to Create a List)  
###### Tri: (Sorting)  
# Création d'ensembles et de cartes: (Creating Sets and Maps)
### Présentation des ensembles: (Introducing Sets)  
### Présentation des cartes: (Introducing Maps)
# Travailler avec les dates et les heures: (Working with Dates and Times)
### Créer des dates et des heures: (Creating Dates and Times)
### Manipulation des dates et des heures: (Manipulating Dates and Times)
### Formatage des dates et heures: (Formatting Dates and Times)
### Analyse des dates et heures: (Parsing Dates and Times)
# Calcul avec les API Math: (Calculating with Math APIs)  
### min() and max():  
### round():  
### pow():  
### random():