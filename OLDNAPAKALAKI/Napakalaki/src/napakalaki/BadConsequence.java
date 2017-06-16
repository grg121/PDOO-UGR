/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author Redondo
 */
public class BadConsequence {
    
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;

    public BadConsequence(String text, int levels, int nVisibleTreasures, int nHiddenTreasures) {
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisibleTreasures;
        this.nHiddenTreasures = nHiddenTreasures;
    }

    public BadConsequence(String text, boolean death) {
        this.text = text;
        this.death = death;
    }
    
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();

    
    BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden) {
            this.text = text;
            this.levels = levels;
            specificVisibleTreasures = tVisible;
            specificHiddenTreasures = tHidden;
    }
    
    
    public String getText() {
        return text;
    }

    public int getLevels() {
        return levels;
    }

    @Override
    public String toString() {
        return "BadConsequence{" + "text=" + text + ", levels=" + levels + ", nVisibleTreasures=" + nVisibleTreasures + ", nHiddenTreasures=" + nHiddenTreasures + ", death=" + death + ", specificHiddenTreasures=" + specificHiddenTreasures + ", specificVisibleTreasures=" + specificVisibleTreasures + '}';
    }

    public int getnVisibleTreasures() {
        return nVisibleTreasures;
    }

    public int getnHiddenTreasures() {
        return nHiddenTreasures;
    }

    public boolean isDeath() {
        return death;
    }

    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }

    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    public void setnVisibleTreasures(int nVisibleTreasures) {
        this.nVisibleTreasures = nVisibleTreasures;
    }

    public void setnHiddenTreasures(int nHiddenTreasures) {
        this.nHiddenTreasures = nHiddenTreasures;
    }

    public void setDeath(boolean death) {
        this.death = death;
    }

    public void setSpecificHiddenTreasures(ArrayList<TreasureKind> specificHiddenTreasures) {
        this.specificHiddenTreasures = specificHiddenTreasures;
    }

    public void setSpecificVisibleTreasures(ArrayList<TreasureKind> specificVisibleTreasures) {
        this.specificVisibleTreasures = specificVisibleTreasures;
    }
    
    
    
    
       
     
}
