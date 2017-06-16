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

public class NumericBadConsequence extends BadConsequence {

    private int nVisibleTreasures;
    private int nHiddenTreasures;
    
    public NumericBadConsequence(String text, int levels, int nVisibleTreasures, int nHiddenTreasures) {
        super(text, levels);
        this.nVisibleTreasures = nVisibleTreasures;
        this.nHiddenTreasures = nHiddenTreasures;
    }
     
    public int getnVisibleTreasures() {
        return nVisibleTreasures;
    }

    public int getnHiddenTreasures() {
        return nHiddenTreasures;
    }
    
    public boolean isDeath() {
        return false;
    }
    
    public void setnVisibleTreasures(int nVisibleTreasures) {
        this.nVisibleTreasures = nVisibleTreasures;
    }

    public void setnHiddenTreasures(int nHiddenTreasures) {
        this.nHiddenTreasures = nHiddenTreasures;
    }
    
    @Override
    public boolean isEmpty(){
        if (nVisibleTreasures > 0 )
            return false ;
        else if(nHiddenTreasures > 0)
            return false;
        return true ;
    }
     @Override
    public void substractVisibleTreasure(Treasure t){

        if(nVisibleTreasures > 0)
            nVisibleTreasures-- ;

    }

    @Override
      public void substractHiddenTreasure(Treasure t){

        if(nHiddenTreasures > 0)
            nHiddenTreasures-- ;
      }
      
    @Override
      public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v, ArrayList<Treasure> h){
          
            int nv = this.getnVisibleTreasures();
            int nh = this.getnHiddenTreasures();
            if(nv > v.size())
                nv = v.size() ;
            if(nh > h.size())
                nh = h.size() ;

        return (new NumericBadConsequence(this.getText(), this.getLevels(), nv, nh)) ;
        
      }

    

}
