/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author Redondo
 */
public class Monster {
    
    private String name;
    private int combatLevel;
    
    private Prize premio;
    private BadConsequence rol;
    
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
        // return name
        return "Monster{" + "name=" + name + ", combatLevel=" + combatLevel + ", premio=" + premio + ", rol=" + rol + '}';
    }

   
    
    
    
}
