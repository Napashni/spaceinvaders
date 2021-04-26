package fr.unilim.iut.SpaceInvaders;

    import static org.junit.Assert.assertEquals;
    import org.junit.Test;
    import static org.junit.Assert.fail;

import fr.unilim.iut.SpaceInvaders.utils.HorsEspaceJeuException;

    public class SpaceInvadersTest {
	
	   @Test
	   public void test_AuDebut_JeuSpaceInvaderEstVide() {
		    SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
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
		    "...............\n" , spaceinvaders.toString());
	        }
	   
	   @Test
		public void test_unNouveauVaisseauEstCorrectementPositionneDansEspaceJeu() {
			SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
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
			".......V.......\n" , spaceinvaders.toString());
		}
	   
	   @Test(expected = HorsEspaceJeuException.class)
		public void test_unNouveauVaisseauEstPositionneHorsEspaceJeuTropADroite_UneExceptionEstLevee() throws Exception {
			SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
			spaceinvaders.positionnerUnNouveauVaisseau(15,9);
		}
	   
	   @Test(expected = HorsEspaceJeuException.class)
		public void test_unNouveauVaisseauEstPositionneHorsEspaceJeuTropEnBas_UneExceptionEstLevee() throws Exception {
			SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
			spaceinvaders.positionnerUnNouveauVaisseau(14,10);
		}
	   
	   
	   @Test
		public void test_UnNouveauVaisseauPositionneHorsEspaceJeu_DoitLeverUneException() {
			SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
			
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

    }
