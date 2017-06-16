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
public abstract class BadConsequence {

    private String text;
    private int levels;
    
    public static final int MAXTREASURES = 10 ;
    
    public BadConsequence(String text, int levels) {
        this.text = text;
        this.levels = levels;
    }


    public String getText() {
        return text;
    }

    public int getLevels() {
        return levels;
    }

    @Override
    public String toString() {
        return "BadConsequence{" + "text=" + text + ", levels=" + levels + '}';
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    abstract BadConsequence adjustToFitTreasureList(ArrayList<Treasure> visibleTreasures, ArrayList<Treasure> hiddenTreasures);

    abstract boolean isEmpty();

    abstract void substractVisibleTreasure(Treasure t);

    abstract void substractHiddenTreasure(Treasure t);

    
    
}
