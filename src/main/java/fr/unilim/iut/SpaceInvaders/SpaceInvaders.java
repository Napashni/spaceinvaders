package fr.unilim.iut.SpaceInvaders;

import fr.unilim.iut.SpaceInvaders.utils.HorsEspaceJeuException;

public class SpaceInvaders {

	    private static final char MARQUE_FIN_LIGNE = '\n';
		private static final char MARQUE_VIDE = '.';
		private static final char MARQUE_VAISSEAU = 'V';
		int longueur;
	    int hauteur;
	    Vaisseau vaisseau;

	    public SpaceInvaders(int longueur, int hauteur) {
		   this.longueur = longueur;
		   this.hauteur = hauteur;
	    }
	    
	    public void positionnerUnNouveauVaisseau(int longueur, int hauteur, int x, int y) {
			if (!estDansEspaceJeu(x, y))
				throw new HorsEspaceJeuException("La position du vaisseau est en dehors de l'espace jeu");

			vaisseau = new Vaisseau(longueur, hauteur);
			vaisseau.positionner(x, y);
		}

		private boolean estDansEspaceJeu(int x, int y) {
			return ((x >= 0) && (x < longueur)) && ((y >= 0) && (y < hauteur));
		}

		public String recupererEspaceJeuDansChaineASCII() {
			StringBuilder espaceDeJeu = new StringBuilder();
			for (int y = 0; y < hauteur; y++) {
				for (int x = 0; x < longueur; x++) {
					char marque = recupererMarqueDeLaPosition(x, y);
				    espaceDeJeu.append(marque);
				}
				espaceDeJeu.append(MARQUE_FIN_LIGNE);
			}
			return espaceDeJeu.toString();
		}

		private char recupererMarqueDeLaPosition(int x, int y) {
			char marque;
			if (this.aUnVaisseauQuiOccupeLaPosition(x, y))
			      marque=MARQUE_VAISSEAU;
			else
			      marque=MARQUE_VIDE;
			return marque;
		}

		private boolean aUnVaisseauQuiOccupeLaPosition(int x, int y) {
			return this.aUnVaisseau() && vaisseau.occupeLaPosition(x, y);
		}

		private boolean aUnVaisseau() {
			return vaisseau!=null;
		}

		public void deplacerVaisseauVersLaDroite() {
			if (vaisseau.abscisseLaPlusAGauche() < (longueur - 1))
				vaisseau.seDeplacerVersLaDroite();
		}

		public void deplacerVaisseauVersLaGauche() {
			if (vaisseau.abscisseLaPlusAGauche() > 1) vaisseau.seDeplacerVersLaGauche();			
		}
   }