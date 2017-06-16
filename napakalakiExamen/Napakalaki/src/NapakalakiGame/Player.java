/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import GUI.Dice ;

/**
 *
 * @author Redondo
 */
public class Player {
    private String name;
    private int level;
    private boolean dead = true;
    private boolean canISteal = true;
    
    static final int MAXLEVEL = 10;
    
    protected Player enemy;
    
    private ArrayList<Treasure> hiddenTreasures = new ArrayList();
    protected ArrayList<Treasure> visibleTreasures= new ArrayList();
    
    private BadConsequence pendingBadConsequence = null;

    @Override
    public String toString() {
        return name + " Lvl: " + level + " enemy: " + enemy.getName() + " CombatLvl: " + Integer.toString(this.getCombatLevel()) ;
    }
    
    public boolean is_cultist(){
        return false ; 
    }

    public BadConsequence getPendingBadConsequence() {
        return pendingBadConsequence;
    }
    
    /// <EXAMEN>
   
    
     public void freeBadConsequence() {
        pendingBadConsequence = new NumericBadConsequence("",0,0,0) ; 
    }
    
    

    
    
    // ....... MÉTODOS ...............
    
    
    
    public Player(String name) {
        this.name = name;
        level=1;            // level 0 o 1   
        dead=true;
        
    }
    
    public Player(Player p) {
        this.name = p.name;
        this.level = p.level;
        this.dead = p.dead;
        this.canISteal = p.canISteal;
        this.enemy = p.enemy;
        this.hiddenTreasures = p.hiddenTreasures;
        this.visibleTreasures = p.visibleTreasures;
        this.pendingBadConsequence = p.pendingBadConsequence;
    }
    
// Devuelve el nombre del jugador.
    public String getName() {
        return name;
    }
    
// Devuelve la vida al jugador, modificando el atributo correspondiente.
    private void bringToLife() {
        dead=false;
    }

/* Devuelve el nivel de combate del jugador, que viene dado por su nivel más los
bonus que le proporcionan los tesoros que tenga equipados. */
    protected int getCombatLevel() {
        int levelfinal=level;
        for(Treasure t : this.visibleTreasures)
            levelfinal += t.getBonus();
        return levelfinal;
    }
    
// Incrementa el nivel del jugador en i niveles.
    private void incrementLevels(int I) {
        level+=I;
    }
    
// Decrementa el nivel del jugador en i niveles.
    private void decrementLevels(int I) {
        level-=I;
        if(level <=0)
            level=1;
    }
    
// Asigna el mal rollo al jugador, dándole valor a su atributo pendingBadConsequence.
    private void setPendingBadConsequence(BadConsequence b) {
        pendingBadConsequence = b;
    }
    
/* Esta operación es la encargada de aplicar el buen rollo del monstruo vencido al jugador,
sumando los niveles correspondientes y pidiendo al CardDealer que le dé el número de
tesoros indicado en el buen rollo del monstruo. Esos tesoros se añaden a sus tesoros
ocultos. */
    private void applyPrize(Monster m) {
        int nLevels = m.getLevelsGained();
        incrementLevels(nLevels);
        int nTreasures = m.getTreasuresGained();
        
        if(nTreasures > 0) {
            CardDealer dealer = CardDealer.getInstance();
            for(int i=0; i<nTreasures; i++) {
                Treasure treasure = dealer.nextTreasure();
                hiddenTreasures.add(treasure);
            } 
        }
    }
   
/* Cuando el jugador ha perdido el combate, hay que considerar el mal rollo que le impone el
monstruo con el que combatió. Para ello, decrementa sus niveles según indica el mal rollo y
guarda una copia de un objeto badConsequence ajustada a los tesoros que puede perder.
Es decir, un objeto mal rollo que refleje el mal rollo indicado por el monstruo pero
eliminando las condiciones que el jugador no pueda cumplir según los tesoros de que
disponga (por ejemplo si el mal rollo del monstruo implica perder 2 tesoros visibles y el
jugador sólo tiene 1, entonces el mal rollo pendiente será de sólo 1 tesoro visible). La
operación encargada de hacer esto es adjustToFitTreasureList de la clase badConsequence.
Éste es el mal rollo pendiente (pendingbadConsequence) que el jugador almacenará y que
deberá cumplir descartándose de esos tesoros antes de que pueda pasar al siguiente turno. */
    private void applyBadConsequence(Monster m) {
        BadConsequence badConsequence = m.getRol();
        int nLevels = badConsequence.getLevels();
        decrementLevels(nLevels);
        BadConsequence pendingBad = badConsequence.adjustToFitTreasureList(visibleTreasures, hiddenTreasures);
        this.setPendingBadConsequence(pendingBad);
    }
    
    protected Player getEnemy() {
        return enemy;
    }
    
// Comprueba si el tesoro t se puede pasar de oculto a visible según las reglas del juego.
    private boolean canMakeTreasureVisible(Treasure t) {
        
        if(t.getType() == TreasureKind.JOKER) {
            return true ; 
        }
        
        if(t.getType() == TreasureKind.ONEHAND) {
            int onehand=0;
            for(Treasure tesoro : visibleTreasures) {
                if(tesoro.getType() == TreasureKind.ONEHAND)
                    onehand++;
                if(tesoro.getType() == TreasureKind.BOTHHANDS)
                    return false;
                if(onehand == 2)
                    return false;
            }
            
        }
        
        else {
            if(t.getType() == TreasureKind.BOTHHANDS) {
            for(Treasure tesoro : visibleTreasures)
                if(tesoro.getType() == TreasureKind.ONEHAND)
                    return false;
            }
        
        
            for(Treasure tesoro : visibleTreasures) {
                if(tesoro.getType() == t.getType())
                    return false;
            }
        }
        
        return true;
    }

// Devuelve el número de tesoros visibles de tipo tKind que tiene el jugador.    
    private int howManyVisibleTreasures(TreasureKind tKind) {
        int contador=0;
        for(Treasure t : this.visibleTreasures) {
            if(t.getType() == tKind)
                contador++;
        }
        return contador;
    }
    
/* Cambia el estado de jugador a muerto, modificando el correspondiente atributo.
(Esto ocurre cuando el jugador, por algún motivo, ha perdido todos sus tesoros.) */
    private void dielfNoTreasures() {
        if(this.hiddenTreasures.isEmpty() && this.visibleTreasures.isEmpty())
            dead=true;
    }
    
    // Devuelve true si el jugador está muerto, false en caso contrario.
    public boolean isDead() {
        return dead;
    }
    
    
    
    public ArrayList<Treasure> getHiddenTreasures() {
        return hiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasures() {
        return visibleTreasures;
    }
    
    public CombatResult combat(Monster m) {
        int myLevel = getCombatLevel();
        int monsterLevel = this.getOponentLevel(m);
            
        if(!canISteal) {
            Dice dice = Dice.getInstance();
            int number = dice.nextNumber();
            if(number < 3) {
                int enemyLevel = enemy.getCombatLevel();
                monsterLevel += enemyLevel;
            }
        }

        
        if(myLevel > monsterLevel) {
            applyPrize(m);
            if(level >= MAXLEVEL)
                return CombatResult.WINGAME;
            else
                return CombatResult.WIN;
            
        }
        else {
            applyBadConsequence(m);
            if(this.shouldConvert() == true)
                return CombatResult.LOSEANDCONVERT;
            else
                return CombatResult.LOSE;
        
        } 
    
    }
    
    
    public void makeTreasureVisible(Treasure t) {
        boolean canI = canMakeTreasureVisible(t);
        if(canI) {
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }
    
    public void discardVisibleTreasure(Treasure t) {
       visibleTreasures.remove(t);
       if(pendingBadConsequence != null && (!pendingBadConsequence.isEmpty()))
            pendingBadConsequence.substractVisibleTreasure(t);
       dielfNoTreasures();

    }
    
    public void discardHiddenTreasure(Treasure t) {
       hiddenTreasures.remove(t);
       if(pendingBadConsequence != null && (!pendingBadConsequence.isEmpty()))
            pendingBadConsequence.substractHiddenTreasure(t);
       dielfNoTreasures();
    
    }
    
/* Devuelve true cuando el jugador no tiene ningún mal rollo que cumplir y no tiene
más de 4 tesoros ocultos, y false en caso contrario. Para comprobar que el jugador
no tenga mal rollo que cumplir, utiliza el método isEmpty de la clase
BadConsequence. */
    public boolean validState() {
        if ( pendingBadConsequence != null){
            if(hiddenTreasures.size() <= 4 &&  pendingBadConsequence.isEmpty())  
                return true ; 
            else
                    return false ;  
        }
        else return true ;
       
    //    return (this.pendingBadConsequence == null) || (this.pendingBadConsequence.isEmpty() && this.hiddenTreasures.size() <= 4);
        
    }
    
/* Cuando un jugador está en su primer turno o se ha quedado sin tesoros, hay que
    proporcionarle nuevos tesoros para que pueda seguir jugando. El número de tesoros que se
les proporciona viene dado por el valor que saque al tirar el dado: */
    public void initTreasures() {
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        this.bringToLife();
        Treasure treasure = dealer.nextTreasure();
        hiddenTreasures.add(treasure);
        int number = dice.nextNumber("Tesoros iniciales:", 
                "1 -> 1, 6 -> 3, otro -> 2");
        
        if(number > 1) {
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        
        if(number == 6) {
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
    }
    
    public int getLevels() {
        return level;
    }
    
/* Cuando el jugador decide robar un tesoro a su enemigo, este método comprueba que
puede hacerlo (sólo se puede robar un tesoro durante la partida) y que su enemigo tiene
tesoros ocultos para ser robados (canYouGiveMeATreasure()), en el caso que así sea éste le
proporciona un tesoro que se almacenará con sus ocultos. El jugador no puede volver a
robar otro tesoro durante la partida. En el caso que no se haya podido robar el tesoro por
algún motivo se devuelve null. */
    public Treasure stealTreasure() {
        boolean canI = this.canISteal();
        if(canI) {
            boolean canYou = enemy.canYouGiveMeATreasure();
            if(canYou) {
                Treasure treasure = enemy.giveMeATreasure();
                hiddenTreasures.add(treasure);
                this.haveStolen();
                return treasure;
            }
        }
        return null;
    }

// Asigna valor al atributo que referencia al enemigo del jugador.
    public void setEnemy(Player enemy) {
        this.enemy=enemy;
    }

// Devuelve un tesoro elegido al azar de entre los tesoros ocultos del jugador.
    private Treasure giveMeATreasure() {
        int numeroAleatorio = (int) (Math.random()*hiddenTreasures.size());
        Treasure aux = hiddenTreasures.get(numeroAleatorio);
        hiddenTreasures.remove(numeroAleatorio);
        return aux;
    }

/* Devuelve el valor de la variable canISteal, que indica si el jugador ha robado antes
o no un tesoro a su enemigo. */
    public boolean canISteal() {
        return this.canISteal;
    }

/* Devuelve true si el jugador tiene tesoros para ser robados por otro jugador y false
en caso contrario. */
    private boolean canYouGiveMeATreasure() {
        return !hiddenTreasures.isEmpty();
    }

// Cambia el atributo canISteal a false cuando el jugador roba un tesoro.
    private void haveStolen() {
        this.canISteal = false;
    }

/* El jugador se descarta de todos sus tesoros ocultos y visibles. Para cada tesoro que se
d e s c a r t a s e h a c e u s o d e l a o p e r a c i ó n discardVisibleTreasure(t:Treasure) o
discardHiddenTreasure(t:Treasure) según corresponda, de esa forma se verifica si se cumple
con algún mal rollo pendiente. */
    public void discardAllTreasures() {
        ArrayList<Treasure> copia = new ArrayList(visibleTreasures);
        
        for(Treasure tesoro: copia) {
            this.discardVisibleTreasure(tesoro);
        }
        copia = new ArrayList(hiddenTreasures);
        
        for(Treasure tesoro: copia) {
            this.discardHiddenTreasure(tesoro);
        }
    }
    
    protected int getOponentLevel(Monster m) {
        return m.getCombatLevel();
    }
    
    protected boolean shouldConvert() {
        Dice dado = Dice.getInstance();
        if(dado.nextNumber("Has perdido el combate. Tira un dado.", 
                "Si sacas un 6 te convertirás en sectario.") == 6)
            return true;
        else 
            return false;
    }
    
    
    
       
}
