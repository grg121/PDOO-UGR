/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author Redondo
 */
public class CultistPlayer extends Player {
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c) {
        super(p);
        this.myCultistCard = c;
        totalCultistPlayers += 1;
    }
    
    @Override
    public String toString() {
        return( "   " + myCultistCard.toString() + "TotalCP: " + totalCultistPlayers + super.toString()) ;
    }
    
    
    @Override
    protected int getCombatLevel() {
        int levelOut = super.getCombatLevel();      
        levelOut += (super.getCombatLevel() * 70 / 100);
        levelOut += myCultistCard.getGainedLevels() * totalCultistPlayers;
        return levelOut;
    }
    
    @Override
    protected int getOponentLevel(Monster m) {
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    @Override
    protected boolean shouldConvert() {
        return false;
    }
    
    @Override
    public boolean is_cultist(){
        return true ; 
    }
    
    
    protected Treasure giveMeATreasure() {
        int numeroAleatorio = (int) (Math.random()*getVisibleTreasures().size());
        Treasure aux = getVisibleTreasures().get(numeroAleatorio);
        getVisibleTreasures().remove(numeroAleatorio);
        return aux;
    }
    
    protected boolean canYouGiveMeATreasure() {
        return !enemy.getVisibleTreasures().isEmpty();
    }
    
    public int getTotalCultistPlayers() {
        return totalCultistPlayers;
    }
    
    /// EXAMEN: 
    
    public void freeBadConsequence() {
        super.freeBadConsequence(); 
        int numero = (int) (Math.random() % this.getVisibleTreasures().size());
        this.discardVisibleTreasure(this.getVisibleTreasures().get(numero));
    }
    
}
