									Methods And Encapsulation
									
									
# Designing Methods: (Méthodes de conception) 
Chaque programme Java intéressant que nous avons vu a une méthode main (). Nous pouvons également écrire d'autres méthodes. Par exemple, nous pouvons écrire une méthode de base.   

		public final void nap(int minutes) throws InterruptedException {
				// take a nap
		}   
Maintenent on va décortiquer cette méthode:   
* public: c'est Modificateur d'accès (Access modifier), et n'est Obligatoire (No Required ).  
* final: Spécificateur facultatif (Optional specifier), et n'est pas Obligatoire (No Required).  
* void: Type de retour (Return type), et Obligatoire (Required).  
* (int minutes): Liste de paramèrtre (Parameter list), Oui Obligatoire mais on peut avoir des parenthèses vides.  
* throws InterruptedException: (Optional exception list), et n'est pas Obligatoire (No Required).   
* { // take a nap }: le cops de la méthode (Method body), Oui Obligatoire, mais peut être des accolades vides.   

Pour appeler cette méthode, tapez simplement son nom, suivi d'une seule valeur int entre parenthèses, *nap (10);*    
Commençons par examiner chacune de ces parties d’une méthode de base.   
### Access Modifiers: (Modificateurs d'accès)  
Java propose quatre choix de modificateurs d'accès:   
* **private:** Le modificateur privé signifie que la méthode ne peut être appelée qu'à partir de la même classe.  
* **Default (Package Private Access):** Avec un accès par défaut, la méthode ne peut être appelée qu'à partir des classes du même package. Celui-ci est délicat car il n'y a pas de mot-clé pour l'accès par défaut. Vous omettez simplement le modificateur d'accès.    
* **protected:** Le modificateur protected signifie que la méthode ne peut être appelée qu'à partir des classes du même package ou des mêmes sous-classes. Vous en apprendrez davantage sur les sous-classes au chapitre 8.   
* **public:** Le modificateur public signifie que la méthode peut être appelée à partir de n'importe quelle classe.  

Nous explorerons l'impact des différents modificateurs d'accès plus loin dans ce chapitre. Pour l'instant, il suffit de maîtriser l'identification de la syntaxe valide des méthodes. Les créateurs d'examens aiment vous tromper en mettant les éléments de méthode dans le mauvais ordre ou en utilisant des valeurs incorrectes.   
Faites attention aux modificateurs d'accès lorsque vous déterminez ce qui ne va pas avec ceux qui ne se compilent pas:   

		public void walk1() {}
		default void walk2() {} // DOES NOT COMPILE
		void public walk3() {} // DOES NOT COMPILE
		void walk4() {}
walk2() ne compile pas car la valeur par default n’est pas un modificateur d'accès valide.
walk3() ne compile pas car le modificateur d'accès est spécifié après le type de retour.  
### Optional specifier: (Optional Specifiers)  
Il existe un certain nombre de spécificateurs facultatifs, mais la plupart d'entre eux ne figurent pas à l'examen. Les spécificateurs facultatifs proviennent de la liste suivante. Contrairement aux modificateurs d'accès, vous pouvez avoir plusieurs spécificateurs dans la même méthode (bien que toutes les combinaisons ne soient pas légales). Lorsque cela se produit, vous pouvez les spécifier dans n'importe quel ordre. Et comme il est facultatif, vous ne pouvez en avoir aucun. Cela signifie que vous pouvez avoir **zéro ou plusieurs spécificateurs** dans une déclaration de méthode.   
* **static:** Couvert plus loin dans ce chapitre. Utilisé pour les méthodes de classe.  
* **abstract:** Couvert au chapitre 8. Utilisé lorsque le corps de la méthode n'est pas fourni. 
* **final:** Couvert au chapitre 8. Utilisé lorsqu'une méthode ne peut pas être redifinit par une sous-classe.   
* **synchronized:** Le modificateur synchronized est utilisé avec du code multithread.  
* **native:** Utilisé lors de l'interaction avec du code écrit dans un autre langage tel que C ++.
* **strictfp:** Utilisé pour rendre les calculs en virgule flottante portables.

Encore une fois, concentrez-vous simplement sur la syntaxe pour le moment:   

		public void walk1() {}
		public final void walk2() {}
		public static final void walk3() {}
		public final static void walk4() {}
		public modifier void walk5() {} // DOES NOT COMPILE
		public void final walk6() {} // DOES NOT COMPILE
		final public void walk7() {}
walk5() ne compile pas car "modifier" n'est pas un spécificateur facultatif valide.
walk6() ne compile pas car le spécificateur facultatif se trouve après le type de retour.
### Return Type: (Type de retour)  
L'élément suivant dans une déclaration de méthode est le type de retour. Le type de retour peut être un type Java tel que String ou int. S'il n'y a pas de type de retour, le mot clé void est utilisé. Ce type de retour spécial vient de la langue anglaise: void signifie sans contenu.  
Lors de la vérification des types de retour, vous devez également regarder à l'intérieur du corps de la méthode. Les méthodes avec un type de retour autre que void doivent avoir une instruction **return** dans le corps de la méthode. Cette instruction de retour doit inclure la primitive ou l'objet à renvoyer.   
Pouvez-vous expliquer pourquoi ces méthodes se compilent ou non ?  

		public void walk1() { }
		public void walk2() { return; }
		public String walk3() { return ""; }
		public String walk4() { } // DOES NOT COMPILE
		public walk5() { } // DOES NOT COMPILE
		String walk6(int a) { if (a == 4) return ""; } // DOES NOT COMPILE
walk4() ne compile pas car l'instruction return est manquante.  
walk5() ne compile pas car le type de retour est manquant.   
walk6() est un peu délicat. Il y a une instruction return, mais elle n'est pas toujours exécutée. Si a vaut 6, l'instruction return n'est pas exécutée. Étant donné que String doit toujours être renvoyée, donc ne complile pas.   

		int integer() {
			return 9;
		}
		int long() {
			return 9L; // DOES NOT COMPILE
		}
Le 2em exemple ne complie pas parce quel e type de la variable locale ne correspond pas au type de retour de la méthode.  
### Method Name: (Nom de la méthode)  
Les noms de méthodes suivent les mêmes règles que celles que nous avons pratiquées avec les noms de variables dans le chapitre 2, «Blocs de construction Java». Pour vérifier, un identifiant ne peut contenir que des lettres, des chiffres, des "$" ou des "_" . De plus, le premier caractère n'est pas autorisé à être un nombre. Les mots réservés ne sont pas autorisés. Par convention, les méthodes commencent par une lettre minuscule mais ne sont pas obligées de le faire.      

		public void walk1() { }
		public void 2walk() { } // DOES NOT COMPILE
		public walk3 void() { } // DOES NOT COMPILE
		public void Walk_$() { }
		pulic _() { }	// DOES NOT COMPILE
		public void() { } // DOES NOT COMPILE
2walk() ne compile pas car les identificateurs ne sont pas autorisés à commencer par des nombres.   
walk3() ne compile pas car le nom de la méthode est avant le type de retour.    
la méthode _() n'est pas autorisée car elle consiste en un seul trait de soulignement, depuis Java 9 "_"n'est plus autorisé comme identifiant.  
### Parameter List: (Liste des paramètres)   
Bien que la liste des paramètres soit obligatoire, elle peut  ne pas à avoir de paramètres. Cela signifie que vous pouvez simplement avoir une paire de parenthèses vides après le nom de la méthode, comme ci-dessous:   

		void nap()
Si vous avez plusieurs paramètres, séparez-les par une virgule. Il existe quelques règles supplémentaires pour la liste de paramètres que vous verrez lorsque nous aborderons les varargs. Pour l'instant, essayons de regarder les signatures de méthode avec des paramètres "normaux":   

		public void walk1() { }
		public void walk2 { } // DOES NOT COMPILE
		public void walk3(int a) { }
		public void walk4(int a; int b) { } // DOES NOT COMPILE
		public void walk5(int a, int b) { }
walk2() ne compile pas car il manque les parenthèses autour de la liste des paramètres.   
walk4() ne compile pas car les paramètres sont séparés par un point-virgule plutôt qu'une virgule.   
### Optional Exception List: (Liste d'exceptions facultative)  
En Java, le code peut indiquer que quelque chose s'est mal passé en levant une exception. Pour l'instant, il vous suffit de savoir qu'il est facultatif et dans quel endroit de la signature de la méthode va d'être declarer.   

	public void zeroExceptions() { }
	public void oneException() throws IllegalArgumentException { }
	public void twoExceptions() throws IllegalArgumentException, InterruptedException { }
Vous vous demandez peut-être ce que font les méthodes avec ces exceptions. La méthode appelante peut lever les mêmes exceptions ou les gérer.  
### Method Body : (Corps de la méthode)   
La dernière partie d’une déclaration de méthode est le corps de la méthode (sauf pour les méthodes abstraites et les interfaces, mais vous n’avez pas besoin de connaître l’une ou l’autre de celles-ci avant le prochain chapitre). Un corps de méthode est simplement un bloc de code. Il a des accolades qui contiennent zéro ou plusieurs instructions Java. Nous avons déjà passé plusieurs chapitres à examiner les instructions Java, vous devriez donc trouver facile de comprendre pourquoi celles-ci compilent ou non:   

		public void walk1() { }
		public void walk2; // DOES NOT COMPILE
		public void walk3(int a) { int name = 5; }
walk2() ne compile pas car il manque les accolades autour du corps de la méthode vide.  
# Working with Varargs: (Travailler avec Varargs)  
Une méthode peut utiliser un paramètre vararg (argument variable) comme s'il s'agissait d'un tableau, mais c'est une petite différence. Un paramètre vararg doit être le dernier élément de la liste de paramètres d'une méthode. Cela implique que nous sommes autorisé à avoir *un seul paramètre* vararg par méthode. Regardons ces méthodes avec varargs:   

		public void walk1(int... nums) { }
		public void walk2(int start, int... nums) { }
		public void walk3(int... nums, int start) { } // DOES NOT COMPILE
		public void walk4(int... start, int... nums) { } // DOES NOT COMPILE
walk3 () et walk4 () ne se compilent pas car ils ont un paramètre vararg dans une position qui n'est pas la dernière, en plus walk4() à 2 paramètres varargs et ce n'est pas correcte.   
Lors de l'appel d'une méthode avec un paramètre vararg, vous avez le choix. Vous pouvez transmettre un tableau, ou vous pouvez lister les éléments du tableau, ou  omettre les valeurs vararg dans l'appel de méthode (zéro varargas).  

		public static void main(String[] args) {
			walk(1); // 0
			walk(1, 2); // 1
			walk(1, 2, 3); // 2
			walk(1, new int[] {4, 5}); // 2
		}
	
		public static void walk(int start, int... nums) {
			System.out.println(nums.length);
		}
# Applying Access Modifiers: (Application des modificateurs d'accès)  
### Private Access: (Accès privé)  
### Default (Package-Private) Access: (Accès par défaut (package-privé))
### Protected Access: (Accès protégé)  
### Public Access: (Accès publique)
# Applying the static Keyword: (Application du mot-clé statique)  
### Designing static Methods and Fields: (Conception de méthodes et de champs statiques)  
### Accessing a static Variable or Method: (Accéder à une variable ou une méthode statique)  
### Static vs. Instance: (Statique vs instance)  
### Static Variables: (Variables statiques)  
### Static Initialization: (Initialisation statique)  
### Static Imports: (Importations statiques)  
# Passing Data among Methods: (Transmission de données entre méthodes)  
# Overloading Methods: (Surcharge de méthodes)  
### Varargs:
### Autoboxing:  
### Reference Types: (Types de référence)  
### Primitives:  
### Generics:  
### Arrays:  
### Putting it All Together: (Mettre tous ensemble)  
# Encapsulating Data: (Encapsulation des données)  
