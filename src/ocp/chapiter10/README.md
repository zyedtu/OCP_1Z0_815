											EXCEPTIONS

											
# Understanding Exceptions: (Comprendre les exceptions)   
Un programme peut échouer pour n'importe quelle raison. Voici quelques possibilités:  
* Le code tente de se connecter à un site Web, mais la connexion Internet est interrompue.  
* Vous avez commis une erreur de codage et tenté d'accéder à un index non valide dans un tableau.  
* Une méthode en appelle une autre avec une valeur que la méthode ne prend pas en charge.   

Comme vous pouvez le voir, certaines de ces erreurs sont des erreurs de codage. D'autres sont totalement hors de votre contrôle. Votre programme ne peut pas l’aider si la connexion Internet tombe en panne. Ce qu'il peut faire, c'est gérer la situation.   
Tout d'abord, nous examinerons le rôle des exceptions. Nous aborderons ensuite les différents types d'exceptions, suivis d'une explication sur la manière de lever une exception en Java.   
### The Role of Exceptions: (Le rôle des exceptions)  
Une exception est la manière de Java de dire: «J'abandonne. Je ne sais pas quoi faire maintenant. Lorsque vous écrivez une méthode, vous pouvez soit gérer l'exception, soit laisser le problème du code appelant. Ce sont les deux approches utilisées par Java pour traiter les exceptions.  
Des exceptions peuvent se produire tout le temps, même dans un code de programme solide. À l'examen, les exceptions concernent en grande partie des erreurs dans les programmes. Par exemple, un programme peut essayer d'accéder à une position non valide dans un tableau. Le point clé à retenir est que les exceptions modifient le *flux du programme*.  
### Understanding Exception Types: (Comprendre les types d'exceptions)
### Throwing an Exception: (Lever une exception)
# Recognizing Exception Classes: (Reconnaître les classes d'exception)  
### Runtime Exception Classes: (Classes d'exception à l'exécution)
### Checked Exception Classes: (Classes d'exception vérifiées)  
### Errors Classes: (Classes d'erreurs)
# Handling Exceptions: (Gestion des exceptions)  
### Using try and catch Statements: (Utilisation des instructions try et catch)   
### Chaining catch Blocks: (Chaînage des blocs de capture)
### Applying a Multi-catch Block: (Application d'un bloc multi-catch)  
### Adding finally Blocks: (Ajouter le bloc finally)  
### Finally Closing Resources: (fermeture des ressources dans finally)  
### Throwing Additional Exceptions: (Lever des exceptions supplémentaires)    
# Calling Methods That Throw Exceptions: (Appel de méthodes qui lèvent des exceptions)   
### Declaring and Overriding Methods with Exceptions: (Déclaration et redéfinissant de méthodes avec des exceptions)   
### Printing an Exception: (Affichage d'une Exception)  
