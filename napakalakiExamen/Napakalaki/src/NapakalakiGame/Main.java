/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;
import GUI.Dice;
import GUI.NapakalakiView ; 
import GUI.PlayersNamesCapture;
import java.util.ArrayList;

/**
 *
 * @author pinguino
 */
public class Main {
    
    public static void main ( String [] args ){
        
        Player currentPlayer  ; 
        
        Napakalaki game = Napakalaki.getInstance() ;
        NapakalakiView napakalakiView = new NapakalakiView() ;
        Dice.createInstance(napakalakiView) ; 
        
        ArrayList<String> names ; 
        PlayersNamesCapture namesCapture = new PlayersNamesCapture(napakalakiView, true) ;
        names = namesCapture.getNames()  ;
        game.initGame(names);
        
        napakalakiView.setNapakalaki(game) ; 
        napakalakiView.setVisible(true) ; 
        napakalakiView.setVisibleMonster(false) ; 
        
        
    }
    
}
