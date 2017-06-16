/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import GUI.Dice ;
import java.util.Random;

/**
 *
 * @author Redondo
 */
public class Napakalaki {
    
    private static Napakalaki instance = null;

    private ArrayList<Player> players = new ArrayList();
    private Player currentPlayer=null;
    private CardDealer dealer;
    private Monster currentMonster;

    
    public Napakalaki() {
        dealer = CardDealer.getInstance();
        
    }

    @Override
    public String toString() {
        return "Napakalaki{" + "currentPlayer=" + currentPlayer + '}';
    }
    

    public static Napakalaki getInstance() {
        if( instance == null)
            instance = new Napakalaki();

        return instance;
    }
    
    
    // MÉTODOS
    
/* Inicializa el array de jugadores que contiene Napakalaki, creando tantos jugadores como
elementos haya en names, que es el array de String que contiene el nombre de los
jugadores. */  
    private void initPlayers(ArrayList<String> names){
        for(String nombre : names) {
            players.add(new Player(nombre));
        }
    }
    
/* Decide qué jugador es el siguiente en jugar.
En primer lugar, se calcula el índice que ocupa el siguiente jugador en la lista de jugadores.
Se pueden dar dos posibilidades:
◦ Que sea la primera jugada, en este caso hay que generar un número aleatorio entre 0 y
el número de jugadores menos 1. Este número indicará el índice que ocupa en la lista
de jugadores el jugador que comenzará la partida.
◦ Que no sea la primera jugada, en este caso el índice es el del jugador que se encuentra
en la posición siguiente respecto al jugador actual. Hay que tener en cuenta que si el
jugador actual está en la última posición de la lista, el siguiente será el que está en la
primera posición.
Una vez calculado el índice, se devuelve el jugador que ocupa esa posición. Se debe
actualizar currentPlayer. */
    private Player nextPlayer() {
        int numero=0;
        if(currentPlayer == null ) {
            numero = (int) (Math.random()*players.size());
        }
        else {
            
            numero = players.indexOf(currentPlayer) ;
            numero += 1 ; 
            numero %= players.size() ;   
        }
        return players.get(numero) ;  
    }
   
/* Método que comprueba si el jugador activo (currentPlayer) cumple con las reglas del juego
para poder terminar su turno. Devuelve false si el jugador activo no puede pasar de turno y
true en caso contrario, para ello usa el método de Player validState() donde se realizan las
comprobaciones pertinentes.
Si currentPlayer es null, devuelve true. */
    private boolean nextTurnAllowed() {
        if(currentPlayer == null)
            return true;
        return currentPlayer.validState();
    }
   
/* Se asigna un enemigo a cada jugador. Esta asignación se hace de forma aleatoria teniendo
en cuenta que un jugador no puede ser enemigo de sí mismo. */
    private void setEnemies () {
        Random rnd = new Random();
        rnd.setSeed(1234);
        
        int random = rnd.nextInt() % (players.size()-1) + 1; 
       
        for(Player jugador : players) {
            int enemy = ( players.indexOf(jugador) + random ) % players.size() ;  
            jugador.setEnemy(this.players.get(enemy));
        }
    }
    
/* Operación responsabilidad de la única instancia de Napakalaki, la cual pasa el control al
jugador actual (currentPlayer) para que lleve a cabo el combate con el monstruo que le ha
tocado (currentMonster). El método de la clase Player con esa responsabilidad es
combat(currentMonster:Monster): CombatResult, cuyo comportamiento general (también
reflejado en el diagrama y responsabilidad de Player) es: si el nivel de combate del jugador
supera al del monstruo, se aplica el buen rollo y se puede ganar el combate o el juego, en
otro caso, el jugador pierde el combate y se aplica el mal rollo correspondiente. */
    public CombatResult developCombat() {
        CombatResult resultado = currentPlayer.combat(currentMonster);
        if (resultado == CombatResult.LOSEANDCONVERT) {
            Cultist carta = dealer.nextCultist();
            CultistPlayer sectario = new CultistPlayer(currentPlayer, carta);
            
            if(players.contains(currentPlayer)){
            int cpi = players.indexOf(currentPlayer) ;
            players.set(cpi, sectario) ; 
            }
            
            for(Player jugador: players) {
                if(jugador.enemy == currentPlayer)
                    jugador.enemy = sectario;
            }
            
            currentPlayer = sectario ; 
            
        }
        dealer.giveMonsterBack(currentMonster);
        return resultado;
        
            
    }
    
/* Operación encargada de eliminar los tesoros visibles indicados de la lista de tesoros
visibles del jugador. Al eliminar esos tesoros, si el jugador tiene un mal rollo pendiente, se
indica a éste dicho descarte para su posible actualización. Finalmente, se invoca a
dieIfNoTreasure() para comprobar si se ha quedado sin tesoros y en ese caso pasar a
estado de muerto. Los tesoros descartados se devuelven al CardDealer. */
    public void discardVisibleTreasures(ArrayList<Treasure> treasures) {
        for(Treasure tesoro: treasures) {
                currentPlayer.discardVisibleTreasure(tesoro);
                dealer.giveTreasureBack(tesoro);
            }
        }
    
// Análoga a la operación anterior aplicada a tesoros ocultos.
    public void discardHiddenTreasures(ArrayList<Treasure> treasures) {
        for(Treasure tesoro: treasures) {
                currentPlayer.discardHiddenTreasure(tesoro);
                dealer.giveTreasureBack(tesoro);
            }
        }
    
/* Operación en la que se pide al jugador actual que pase tesoros ocultos a visibles, siempre
que pueda hacerlo según las reglas del juego, para ello desde Player se ejecuta el método:
canMakeTreasureVisible(treasures:Treasure ):boolean */
    public void makeTreasuresVisible(ArrayList<Treasure> treasures) {
        for(Treasure tesoro: treasures) {
            this.currentPlayer.makeTreasureVisible(tesoro);
        }
    }
    
    /// <EXAMEN>: 
    public boolean is_joker(ArrayList<Treasure> treasures){
        for(Treasure tesoro: treasures) {
            if(tesoro.getType() == TreasureKind.JOKER)
                return true ; 
        }
       
        return false ; 
    }
    
    // </EXAMEN>
    
/* Se encarga de solicitar a CardDealer la inicialización de los mazos de cartas de Tesoros y
de Monstruos, de inicializar los jugadores proporcionándoles un nombre, asignarle a cada
jugador su enemigo y de iniciar el juego con la llamada a nextTurn() para pasar al siguiente
turno (que en este caso será el primero). */
    public void initGame(ArrayList<String> players) {
        this.initPlayers(players);
        this.setEnemies();
        dealer.initCards();
        this.nextTurn();
        
        /* String[] nombres = new String[players.size()];
         nombres = players.toArray(nombres);
         initPlayers(nombres);
         
         setEnemies();
         this.nextTurn();
         dealer.initCards(); */
    }

// Devuelve el jugador actual (currentPlayer).
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

// Devuelve el monstruo en juego (currentMonster).
    public Monster getCurrentMonster() {
        return currentMonster;
    }
    
/* Esta operación usa el método nextTurnAllowed(), donde se verifica si el jugador activo
(currentPlayer) cumple con las reglas del juego para poder terminar su turno.
En caso el caso que nextTurnIsAllowed() devuelva true, se le solicita a CardDealer el
siguiente monstruo al que se enfrentará ese jugador (currentMonster) y se actualiza el
jugador activo al siguiente jugador.
En caso de que el nuevo jugador activo esté muerto, por el combate en su anterior turno o
porque es el primer turno, se inicializan sus tesoros siguiendo las reglas del juego. La
inicialización de los tesoros se encuentra recogida en el diagrama subordinado
initTreasures. */
    public boolean nextTurn() {
        boolean stateOK = nextTurnAllowed();
        if(stateOK) {
            currentMonster = dealer.nextMonster();
            this.currentPlayer = nextPlayer();
            boolean dead = currentPlayer.isDead();
            
            if(dead) 
                currentPlayer.initTreasures();
        }
        return stateOK;
    }

/* Devuelve true si el parámetro result es WINGAME (valor del enumerado CombatResult). En
caso contrario devuelve false. */   
    public boolean endOfGame(CombatResult result) {
        return result == CombatResult.WINGAME;
    }
    
}
