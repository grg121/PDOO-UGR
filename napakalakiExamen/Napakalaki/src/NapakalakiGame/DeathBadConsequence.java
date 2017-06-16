/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author Redondo
 */
public class DeathBadConsequence extends NumericBadConsequence {
    
    public DeathBadConsequence(String text) {
        super(text, Player.MAXLEVEL, MAXTREASURES, MAXTREASURES);
    }
    
    @Override
    public boolean isDeath() {
        return true;
    }
    
    @Override
    public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v, ArrayList<Treasure> h){
        DeathBadConsequence output = new DeathBadConsequence(this.getText()) ;
        output.setnHiddenTreasures(h.size());
        output.setnVisibleTreasures(v.size());
        return output ; 
    }

        
    
}
