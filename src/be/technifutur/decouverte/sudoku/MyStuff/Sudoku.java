package be.technifutur.decouverte.sudoku.MyStuff;

import be.technifutur.decouverte.sudoku.MyStruct.*;

public class Sudoku {

	public static void main(String[] args) {
		IdentifiantMinPossible plusPetit = new IdentifiantMinPossible();
		int i = 0, j = 0, testJ = 0, temp = 0, compteurErreur = 0, taille = 0, difficulte = 0, input = 0;

		System.out.println("Je vous propose de choisir la taille de votre sudoku. \nJe peux faire un 3 x 3 ou un 4 x 4.");
		taille = (int) Verif.Input(3, 4, taille);
		taille *= taille;
		SudokuStruct[][] tableau = new SudokuStruct[taille][taille], correction = new SudokuStruct[taille][taille];
		System.out.println("Quelle difficult� voulez-vous ?");
		System.out.println("1: Facile \n2: Moyen \n3: Difficile \n4: Au secours");
		difficulte = (int) Verif.Input(1, 4, difficulte);

		Initialiser(tableau, taille);
		Initialiser(correction, taille);

		while (i < taille){

			j = 0;
			while (j < taille){

				testJ = 0;
				plusPetit.j = 0;
				plusPetit.valeur = 0;
				while (testJ < taille){ // Teste toutes les cases d'une ligne pour voir celle o� il y a le moins de possibilit�s

					if (tableau[i][testJ].nombre == 0){

						for (temp = 1; temp <= taille; temp++){

							if (!VerifDoublon(tableau, i, testJ, temp)){ // Ajoute dans les valeurs possibles de la case si le programme ne trouve pas de doublon
								AjoutPossibler(tableau, i, testJ, temp);
								tableau[i][testJ].quantitePossible++;
							}

						}

						if (tableau[i][testJ].quantitePossible > plusPetit.valeur){ // l'indice colonne (plusPetit.j) prendra la valeur de la case avec le moins de possisbilit�
							plusPetit.valeur = tableau[i][testJ].quantitePossible;
							plusPetit.j = testJ;

						}

					}

					testJ++;
				}

				if (plusPetit.valeur == 0) { // S'il y a une case sans solution possible, r�initialise la ligne
					ReinitialiserLigne(tableau, i);
					j = 0;
					compteurErreur = compteurErreur + 1;

					if (taille == 9 && compteurErreur == 50 || taille == 16 && compteurErreur == 200) { // Si cette r�initialisation �choue � donner une solution pour x fois, r�initialise tout le tableau
						ReinitialiseSudoku(tableau);
						compteurErreur = 0;
						i = 0;

					}

				}
				else {
					do {
						tableau[i][plusPetit.j].nombre = (int) (Math.random() * (taille) + 1);
					} while (!VerifPosssible(tableau, i, plusPetit.j, tableau[i][plusPetit.j].nombre)); // Choisi un nombre au hasard correspondant � la liste des nombres possibles
					j++;

				}

				ReinitialisePossible(tableau, i); // R�initialise la valeur possible des cases apr�s avoir trouv� un nombre ou r�initialis� la ligne

			}

			compteurErreur = 0;
			i++;
		}

		CopieSudoku(tableau, correction);
		CacherNombres(tableau, (int) difficulte);
		AfficherSudoku(tableau);
		System.out.println();

		System.out.println("Voulez-vous la solution ? 1: Oui 2: Non");
		input = (int) Verif.Input(1, 2, input);

		switch (input) {
		case 1:
			AfficherSudoku(correction);
			break;
		case 2 :
			System.out.println("Au revoir !");

		}

	}

	// Affiche le tableau

	public static void AfficherSudoku(SudokuStruct tab[][]){
		int i = 0, j = 0, taille = tab.length, max = (int) Math.sqrt(tab.length), longueurLigne = 0;
		String ligne = "";

		if (taille == 9)
			ligne = "-------";
		else
			ligne = "-------------";

			for (; i < taille; i++){
				for (j = 0; j < taille; j++){

					if (j % max == max - 1 && j != taille - 1)
						System.out.print(AfficheVideSiZero(tab[i][j].nombre, taille) +" | ");				
					else
						System.out.print(AfficheVideSiZero(tab[i][j].nombre, taille) +" ");



				}

				System.out.println();
				if (i % max == max - 1 && i != taille - 1){
					for (longueurLigne = 0; longueurLigne < max; longueurLigne++)
						System.out.print(ligne);			

					System.out.println();

				}

			}

	}

	// Regroupe les fonctions de v�rifications

	public static boolean VerifDoublon(SudokuStruct tableau[][], int i, int j, int verif){

		if (DoublonLigneColonne(tableau, i, j, verif) || DoublonMatrice(tableau, i, j, verif))
			return true;

		return false;
	}

	// V�rifie V�rifie s'il y a un doublon dans la ligne et la colonne

	public static boolean DoublonLigneColonne(SudokuStruct tableau[][], int i, int j, int verif){
		int testI = 0, testJ = 0, taille = tableau.length;

		for (testI = 0; testI < taille; testI++){
			if (tableau[testI][j].nombre == verif)
				return true;

		}

		for (testJ = 0; testJ < taille; testJ++){
			if (tableau[i][testJ].nombre == verif)
				return true;

		}
		return false;


	}

	// V�rifie s'il y a un doublon dans la matrice

	public static boolean DoublonMatrice (SudokuStruct tab[][], int i, int j, int verif){
		int max = (int) Math.sqrt(tab.length);
		i = i - (i % max);
		int iniJ = j - (j % max);
		int maxI = i + 3, maxJ = iniJ + max;

		for (; i < maxI; i++){
			for (j = iniJ; j < maxJ; j++){
				if (verif == tab[i][j].nombre)
					return true;
			}

		}

		return false;
	}

	// Initialise le tableau de sudoku

	public static void Initialiser(SudokuStruct tab[][], int taille){
		int i = 0, j = 0, k = 0;

		for (; i < taille; i++){
			for (j = 0; j < taille; j++){
				tab[i][j] = new SudokuStruct();
				tab[i][j].nombre = 0;
				tab[i][j].quantitePossible = 0;				
				for (k = 0; k < taille; k++){
					tab[i][j].possible[k] = 0;

				}

			}

		}

	}

	//V�rifie si le nombre entr� est dans la liste des nombres possibles

	public static boolean VerifPosssible(SudokuStruct tab[][], int i, int j, int verif){
		int k = 0, taille = tab.length;

		for (; k < taille; k++){
			if (tab[i][j].possible[k] == verif)
				return true;
		}

		return false;
	}

	// Ajoute le nombre � la liste des possibles

	public static void AjoutPossibler (SudokuStruct tab[][], int i, int j, int ajout){
		int k = 0, taille = tab.length;

		while (k < taille){
			if (tab[i][j].possible[k] == 0){
				tab[i][j].possible[k] = ajout;
				k = taille;
			}

			k++;
		}

	}

	// Remet � 0 les valeurs possibles que peuvent prendre les cases

	public static void ReinitialisePossible(SudokuStruct tab[][], int i){
		int j = 0, k = 0, taille = tab.length;

		for (j = 0; j < taille; j++) {
			tab[i][j].quantitePossible = 0;

			for (k = 0; k < taille; k++)
				tab[i][j].possible[k] = 0;
		}

	}

	// Reinitialise les cases d'une ligne

	public static void ReinitialiserLigne (SudokuStruct tab[][], int i) {
		int j = 0, taille = tab.length;

		for (j = 0; j < taille; j++)
			tab[i][j].nombre = 0;
	}

	// R�initialise tout le Sudoku

	public static void ReinitialiseSudoku (SudokuStruct tab[][]) {
		int i = 0, j = 0, taille = tab.length;

		for (i = 0; i < taille; i++) {
			for (j = 0; j < taille; j++)
				tab[i][j].nombre = 0;

		}

	}

	// Enl�ve une certaine quantit�e de nombre, suivant la difficult� choisie

	public static void CacherNombres(SudokuStruct tab[][], int difficulte) {
		int i = 0, j = 0, k = 0, l = 0, suppression = 0, taille = tab.length;
		if (taille > 9)
			difficulte *= 4;

		// Enl�ve dans les matrices

		for (suppression = 0; suppression < difficulte && suppression < 4; suppression++) {
			int max = (int) Math.sqrt(tab.length);
			for (i = 0; i < max; i++) {
				for (j = 0; j < max; j++) {
					if (!VerifMatriceVide(tab, i, j)) {
						do {
							k = (int) (Math.random() * max);
							l = (int) (Math.random() * max);
						} while(tab[(i * max) + k][(j * max) + l].nombre == 0);

					}

					tab[(i * max) + k][(j * max) + l].nombre = 0;

				}

			}

		}

		suppression = 0;

		while (suppression < difficulte - 2 || suppression == 0) {


			// Enl�ve dans les lignes

			for (i = 0; i < taille; i++) {
				if (!VerifLigneVide(tab, i)) {
					do {
						j = (int) (Math.random() * taille);
					} while (tab[i][j].nombre == 0);

					tab[i][j].nombre = 0;

				}

				suppression++;

			}

			//Enl�ve dans les colonnes

			for (j = 0; j < taille; j++) {
				if (!VerifColonneVide(tab, j)) {
					do {
						i = (int) (Math.random() * taille);
					} while (tab[i][j].nombre == 0);

					tab[i][j].nombre = 0;

				}

			}

			suppression++;

		}



	}

	// retourne le nombre seulement s'il est diff�rent de 0, sinon retourne un espace

	public static String AfficheVideSiZero (int nombre, int taille) {
		String resultat =  String.valueOf(nombre);

		if (nombre != 0)
			if (nombre < 10 && taille > 9)
				return " " + resultat;
			else
				return resultat;
		else
			if (taille > 9)
				return "  ";
			else
				return " ";

	}

	// V�rifie si une ligne est vide

	public static boolean VerifLigneVide (SudokuStruct tab[][], int i) {
		int j = 0, taille = tab.length;;

		for (j = 0; j < taille; j++) {
			if (tab[i][j].nombre != 0)
				return false;
		}

		return true;
	}

	// V�rifie si une colonne est vide

	public static boolean VerifColonneVide (SudokuStruct tab[][], int j) {
		int i = 0, taille = tab.length;

		for (i = 0; i < taille; i++) {
			if (tab[i][j].nombre != 0)
				return false;
		}

		return true;
	}

	// V�rifie si une matrice est vide

	public static boolean VerifMatriceVide (SudokuStruct tab[][], int i, int j) {
		int max = (int) Math.sqrt(tab.length);
		i = i - (i % max);
		int iniJ = j - (j % max);
		int maxI = i + max, maxJ = iniJ + max;

		for (; i < maxI; i++){
			for (j = iniJ; j < maxJ; j++){
				if (tab[i][j].nombre != 0)
					return false;
			}

		}

		return true;

	}

	// R�alise une copie de tableau Sudoku depuis tab1 vers tab2

	public static void CopieSudoku (SudokuStruct tab1[][], SudokuStruct tab2[][]) {
		int i = 0, j = 0, taille = tab1.length;

		for (i = 0; i < taille; i++) {
			for (j = 0; j < taille; j++) {
				tab2[i][j].nombre = tab1[i][j].nombre;

			}

		}

	}



	/* poubelle

	// V�rifie que la valeur test�e ne soit pas dans la liste d'erreur

	public static boolean VerifSiErreurComplet (SudokuStructStruct tab[][], int i, int j){
		int k = 0;

		for (; k < 9; k++)
			if (tab[i][j].erreur[k] == 0)
				return false;

		return true;
	}

	// R�initialise la liste d'erreur pour la case s�lectionn�e

	public static void ReinitialiserErreur (SudokuStructStruct tab[][], int i, int j){
		int k = 0;

		for (; k < 9; k++)
			tab[i][j].erreur[k] = 0;
	}



	//V�rifie si le nombre entr� est dans la liste d'erreur

	public static void AjoutErreur (SudokuStruct tab[][], int i, int j, int ajout){
		int k = 0;

		for (; k < 9; k++){
			if (tab[i][j].erreur[k] == 0)
				tab[i][j].erreur[k] = ajout;
		}

	}

	// V�rification approfondie

	public static boolean VerifApprofondie (SudokuStruct tab[][], int i, int j, int verif){
		if (j >= 3 && j <= 5){
			if (DoublonMatrice(tab, i, 6, verif))
				return true;
			else
				return false;
		}

		else
			return false;

	}

	 */

}
