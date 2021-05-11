package fr.unilim.iut.SpaceInvaders;

    import static org.junit.Assert.assertEquals;
    import org.junit.Test;
    import static org.junit.Assert.fail;
    import org.junit.Before;

    import fr.unilim.iut.SpaceInvaders.utils.HorsEspaceJeuException;

    public class SpaceInvadersTest {
    	
    	private SpaceInvaders spaceinvaders;

	    @Before
	    public void initialisation() {
		    spaceinvaders = new SpaceInvaders(15, 10);
	    }
	    
	   //Premier Test
	   @Test
		public void test_unNouveauVaisseauEstCorrectementPositionneDansEspaceJeu() {
			spaceinvaders.positionnerUnNouveauVaisseau(7,9);
			assertEquals("" + 
			"...............\n" + 
			"...............\n" +
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			".......V.......\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
		}
	   
	   //Second Test
	   @Test(expected = HorsEspaceJeuException.class)
		public void test_unNouveauVaisseauEstPositionneHorsEspaceJeuTropEnBas_UneExceptionEstLevee() throws Exception {
			spaceinvaders.positionnerUnNouveauVaisseau(14,10);
		}
	   
	   //Troisième Test
	   @Test
		public void test_UnNouveauVaisseauPositionneHorsEspaceJeu_DoitLeverUneException() {
			
			try {
				spaceinvaders.positionnerUnNouveauVaisseau(15,9);
				fail("Position trop à droite : devrait déclencher une exception HorsEspaceJeuException");
			} catch (final HorsEspaceJeuException e) {
			}
			
			
			try {
				spaceinvaders.positionnerUnNouveauVaisseau(-1,9);
				fail("Position trop à gauche : devrait déclencher une exception HorsEspaceJeuException");
			} catch (final HorsEspaceJeuException e) {
			}
			
			
			try {
				spaceinvaders.positionnerUnNouveauVaisseau(14,10);
				fail("Position trop en bas : devrait déclencher une exception HorsEspaceJeuException");
			} catch (final HorsEspaceJeuException e) {
			}
			
			
			try {
				spaceinvaders.positionnerUnNouveauVaisseau(14,-1);
				fail("Position trop à haut : devrait déclencher une exception HorsEspaceJeuException");
			} catch (final HorsEspaceJeuException e) {
			}				
		}
	   
	   //Test déplcement vers la droite
	   @Test
		public void test_VaisseauAvance_DeplacerVaisseauVersLaDroite() {
			
			spaceinvaders.positionnerUnNouveauVaisseau(7,9);

			spaceinvaders.deplacerVaisseauVersLaDroite();
			
			assertEquals("" + 
			"...............\n" + 
			"...............\n" +
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"........V......\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
		}
	   
	   //Test limite déplacement vers la droite
	   @Test
		public void test_VaisseauImmobile_DeplacerVaisseauVersLaDroite() {
			
			spaceinvaders.positionnerUnNouveauVaisseau(14,9);

			spaceinvaders.deplacerVaisseauVersLaDroite();
			
			assertEquals("" + 
			"...............\n" + 
			"...............\n" +
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"..............V\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
		}
	   
	   //Test déplacement vers la gauche
	   @Test
		public void test_VaisseauAvance_DeplacerVaisseauVersLaGauche() {
			
			spaceinvaders.positionnerUnNouveauVaisseau(7,9);

			spaceinvaders.deplacerVaisseauVersLaGauche();
			
			assertEquals("" + 
			"...............\n" + 
			"...............\n" +
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"......V........\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
		}
	   
	   //Test limite déplacement vers la gauche
	   @Test
		public void test_VaisseauImmobile_DeplacerVaisseauVersLaGauche() {
			
			spaceinvaders.positionnerUnNouveauVaisseau(0,9);

			spaceinvaders.deplacerVaisseauVersLaGauche();
			
			assertEquals("" + 
			"...............\n" + 
			"...............\n" +
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"...............\n" + 
			"V..............\n" , spaceinvaders.recupererEspaceJeuDansChaineASCII());
		}

    }
