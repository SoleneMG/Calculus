# Calculus

### Objectifs : Réalisez un jeu de calcul mental en java.

A partir du jeu calculus disponible dans les applications Edith, Joe ou Coco (disponibles sur le play store et l'app store), proposez une application de calcul mental.
Cette application doit proposer des calculs de différentes difficultés et doit pouvoir proposer des propositions.
Il n'est pas nécessaire de réaliser une interface identique ou des niveaux de difficultés identiques.

### Le projet comporte :

- [x] Un écran où sont rappelées les règles et où l'on peut choisir la difficulté
- [x] Un écran de jeu avec les questions et leurs propositions
- [x] Un écran de récapitulatif de score 
- [x] Un générateur de questions 
- [x] Un générateur de propositions



Je génère les questions grâce à différents modèles héritant de Operation pour les raisons suivantes : 

- Mieux maitriser la génération des questions de manière individuelle. Cela me permet d'adopter un comportement différent selon le type d'opération (génération des nombres aléatoires, réponses associées...)

- Rendre les opérations plus complexes : On peut imaginer des opérations avec plusieurs opérandes et opérateurs différents.

![image](https://user-images.githubusercontent.com/73821660/157997886-267a4cea-aa64-4a99-8576-e8daebfe0bd1.png)

- Rendre l'affichage dynamique : On peut facilement faire évoluer l'affichage et imaginer un affichage des opérations en colonnes. On pourrait aussi imaginer des affichages différents pour un même type d'opération. 

![image](https://user-images.githubusercontent.com/73821660/157997779-0686373c-bd7d-40e4-8c5a-981848e17907.png)

Je génère les réponses en prenant un interval de valeurs à partir du résultat. Celà me permet de générer des propositions sans doublons et proche du résultat attendu.
Vu que mes opérations sont typées on pourrait imaginer générer des propositions à partir du changement d'un opérande.






