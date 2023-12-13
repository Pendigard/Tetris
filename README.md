# Projet Tetris par Célian VASSON et Evan DOXANIS

## Description
Ce projet est une reproduction du jeu classique Tetris en java. Il a été réalisé dans le cadre du cours de Programmation Orientée Objet (POO) de la Licence 3 Informatique à l'Université de Lyon 1.

## Caractéristiques

- **Mode Solo** : Jouez contre vous-même et tentez de battre votre meilleur score en empilant stratégiquement les tétriminos.
- **Mode Duo** : Affrontez un ami dans un match en tête-à-tête pour voir qui peut obtenir le meilleur score.
- **Thèmes Personnalisables** : Choisissez parmi une variété de thèmes graphiques et audio pour personnaliser votre expérience de jeu.
- **Création de Thèmes** : Créez vos propres thèmes en héritant de la classe abstraite `Theme`.

## Comment Jouer

1. **Lancement du Jeu** : Compilez le fichier `Tetris.java`.
2. **Sélection du Mode** : Choisissez entre le mode solo ou duo au début du jeu.
3. **Choix du Thème** : Sélectionnez un thème graphique et audio ou créez le vôtre.
4. **Commencer à Jouer** : Utilisez les touches directionnelles pour déplacer et faire tourner les pièces.

## Personnalisation des Thèmes

Pour créer un nouveau thème :

1. **Créez une Classe** : Dans le package `theme`créer une classe héritant de la classe abstraite `Theme`.
2. **Définissez les Éléments Graphiques et Audio** : Surchargez les méthode d'affichage de la classe `Theme` (voir code de la classe `Theme` pour plus de détails).
3. **Intégrez votre Thème** : 
- Une fois votre class créer, dans le fichier `Tetris.java`, chargez votre thème en utilisant la méthode `loadThemes()` de la classe `Tetris`.
- Si vous avez une font personnalisée, ajoutez-la dans le dossier `fonts` et chargez-la en utilisant la méthode `loadFonts()` de la classe `Tetris`.

Le nombre de thèmes est limité à 16.

## Librairies Utilisées

- awt
- swing

## Auteurs

- Célian VASSON
- Evan DOXANIS
