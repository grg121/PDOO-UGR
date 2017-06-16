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
public class Monster {
    
    private String name;
    private int combatLevel;
    
    private Prize premio;
    private BadConsequence rol;
    
    private int levelChangeAgainstCultistPlayer;
    
    /**
     *
     * @param name
     * @param level
     * @param prize
     * @param bc
     */
    public Monster(String name, int level, BadConsequence bc, Prize prize) {
        this.name = name;
        this.combatLevel = level; 
        premio = prize;
        rol = bc;
        this.levelChangeAgainstCultistPlayer=0;
    }
    
    public Monster(String name, int level, BadConsequence bc, Prize prize, int IC) {
        this.name = name;
        this.combatLevel = level; 
        premio = prize;
        rol = bc;
        this.levelChangeAgainstCultistPlayer = IC;
    }
    
    

    public String getString() {
        return name;
    }

    public int getCombatLevel() {
        return combatLevel;
    }
     
    public Prize getPremio() {
        return premio;
    }

    public BadConsequence getRol() {
        return rol;
    }

    
    @Override
    public String toString() {
        //return name;
        return "Monster{" + "name=" + name + ", combatLevel=" + combatLevel + ", premio=" + premio + ", rol=" + rol + '}';
    }

// Devuelve el número de niveles ganados proporcionados por su buen rollo.  
    public int getLevelsGained() {
        return premio.getLevel();
    }

// Devuelve el número de tesoros ganados proporcionados por su buen rollo.    
    public int getTreasuresGained() {
        return premio.getTreasure();
    }
    
    public int getCombatLevelAgainstCultistPlayer() {
        return this.getCombatLevel() + this.levelChangeAgainstCultistPlayer;
    }

}
