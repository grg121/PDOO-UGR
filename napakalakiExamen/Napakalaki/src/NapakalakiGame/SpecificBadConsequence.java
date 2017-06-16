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
public class SpecificBadConsequence extends BadConsequence {
    
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    public SpecificBadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden) {
            super(text, levels);
            specificVisibleTreasures = tVisible;
            specificHiddenTreasures = tHidden;
    }
    
    public boolean isDeath() {
        return false;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }

    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }
    
    public void setSpecificHiddenTreasures(ArrayList<TreasureKind> specificHiddenTreasures) {
        this.specificHiddenTreasures = specificHiddenTreasures;
    }

    public void setSpecificVisibleTreasures(ArrayList<TreasureKind> specificVisibleTreasures) {
        this.specificVisibleTreasures = specificVisibleTreasures;
    }
    
    @Override
    public boolean isEmpty() {
        if(!specificHiddenTreasures.isEmpty())
            return false ;
        else if(!specificVisibleTreasures.isEmpty())
            return false ;

        return true ;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){

        if(specificVisibleTreasures.contains(t.getType()))
           specificVisibleTreasures.remove(t.getType()) ;
       
    }

    @Override
      public void substractHiddenTreasure(Treasure t){

        if(specificHiddenTreasures.contains(t.getType()))
           specificHiddenTreasures.remove(t.getType()) ;
       
      }
      
    @Override
      public BadConsequence adjustToFitTreasureList(ArrayList<Treasure> v, ArrayList<Treasure> h){
          
            ArrayList<TreasureKind> nuevovisible = new ArrayList() ;
            for (TreasureKind tipo: specificVisibleTreasures) {
                for (Treasure tesoro: v)
                    if (tesoro.getType() == tipo)
                        nuevovisible.add(tipo) ;
                break;
            }

            ArrayList<TreasureKind> nuevooculto = new ArrayList();
            for (TreasureKind tipo: specificVisibleTreasures) {
                for (Treasure tesoro: h)
                    if (tesoro.getType() == tipo)
                        nuevooculto.add(tipo);
                break;
            }

            return (new SpecificBadConsequence(this.getText(), this.getLevels(), nuevovisible, nuevooculto));
        }
    


    
}
