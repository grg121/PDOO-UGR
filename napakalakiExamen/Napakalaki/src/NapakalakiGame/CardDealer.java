/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Redondo
 */
public class CardDealer {
    
    private static CardDealer instance = null;

    private ArrayList<Monster> unusedMonsters = new ArrayList();
    private ArrayList<Monster> usedMonsters = new ArrayList();
    
    private ArrayList<Treasure> unusedTreasures = new ArrayList();
    private ArrayList<Treasure> usedTreasures = new ArrayList();
    
    private ArrayList<Cultist> unusedCultist = new ArrayList();
    
    
    
    private CardDealer() {}

    public static CardDealer getInstance() {
        if(instance == null) {
            instance = new CardDealer();
        }
        return instance;
    }
 
/* Inicializa el mazo de cartas de Tesoros (unusedTreasures) con todas las cartas de
tesoros proporcionadas en el documento de cartas de tesoros. */
    private void initTreasureCardDeck() {
        usedTreasures = new ArrayList();                
        unusedTreasures = new ArrayList(Arrays.asList(
           new Treasure("El JOKER", 0, TreasureKind.JOKER),
           new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND),
           new Treasure("Fez alópodo", 3, TreasureKind.HELMET),
           new Treasure("Hacha prehistórica", 2, TreasureKind.ONEHAND),
           new Treasure("El aparato del Pr. Tesla", 4, TreasureKind.ARMOR),
           new Treasure("Gaita", 4, TreasureKind.BOTHHANDS),
           new Treasure("Insecticida", 2, TreasureKind.ONEHAND),
           new Treasure("Escopeta de 3 cañones", 4, TreasureKind.BOTHHANDS),
           new Treasure("Garabato místico", 2, TreasureKind.ONEHAND),
           new Treasure("La rebeca metálica", 2, TreasureKind.ARMOR),
           new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS),
           new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND),
           new Treasure("Tentáculo de pega", 1, TreasureKind.BOTHHANDS),
           new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOES),
           new Treasure("¡Sí mi amo!", 4, TreasureKind.HELMET),
           new Treasure("Botas de investigación", 3, TreasureKind.SHOES),
           new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET),
           new Treasure("A prueba de babas", 2, TreasureKind.ARMOR),
           new Treasure("Botas de lluvia ácida", 1, TreasureKind.SHOES),
           new Treasure("Casco minero", 2, TreasureKind.HELMET),
           new Treasure("Ametralladora ACME", 4, TreasureKind.BOTHHANDS),
           new Treasure("Camiseta de la ETSIIT", 1, TreasureKind.ARMOR),
           new Treasure("Clavo de rail ferroviario", 3, TreasureKind.ONEHAND),
           new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS),
           new Treasure("Necro-comicón", 1, TreasureKind.ONEHAND),
           new Treasure("Necronomicón", 5, TreasureKind.BOTHHANDS),
           new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS),
           new Treasure("Necro-gnomicón", 2, TreasureKind.ONEHAND),
           new Treasure("Necrotelecom", 2, TreasureKind.HELMET),
           new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND),
           new Treasure("Necro-playboycón", 3, TreasureKind.ONEHAND),
           new Treasure("Porra preternatural", 2, TreasureKind.ONEHAND)));
        //this.shuffleTreasures();
    }
    
/* Inicializa el mazo de cartas de monstruos (unusedMonsters), con todas las cartas
de monstruos proporcionadas en el documento de cartas de monstruos. Se
recomienda reutilizar el código desarrollado en la primera práctica para construir
las cartas de monstruos. Usa el atributo de clase definido en la clase
BadConsequence MAXTREASURES para los monstruos cuyo mal rollo sea
pérdida de todos los tesoros visibles u ocultos. */
    private void initMonsterCardDeck() {
        
        usedMonsters = new ArrayList();
        unusedMonsters = new ArrayList();             
        
        ArrayList<Monster> monstruos = new ArrayList();
        
        // El Rey de Rosa
        BadConsequence badConsequence = new NumericBadConsequence("Pierdes 5 niveles "
                + "y 3 tesoros visibles", 5, 3, 0);
        Prize prize = new Prize(4, 2);
        monstruos.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        
        // Ángeles de la noche ibicenca
        badConsequence = new SpecificBadConsequence("Te atrapan para llevarte de fiesta "
                + "y te dejan caer en mitad del vuelo. Descarta 1 mano visible y "
                + "una mano oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4, 1);
        monstruos.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence, prize));
        
        // 3 Byakhees de bonanza
        badConsequence = new SpecificBadConsequence("Pierdes tu armadura visible y otra "
                + "oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize = new Prize(2, 1);
        monstruos.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        
        // Tenochtitlan
        badConsequence = new SpecificBadConsequence("Embobados con el lindo primigenio "
                + "te descartas de tu casco visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Tenochtitlan", 2, badConsequence, prize));
        
        // El sopor de Dunwich
        badConsequence = new SpecificBadConsequence("El primordial bostezo contagioso. "
                + "Pierdes el calzado visible", 0, new ArrayList(Arrays.asList(TreasureKind.SHOES)), 
                new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        
        // Demonios de Magaluf
        badConsequence = new SpecificBadConsequence("Te atrapan para llevarte de fiesta"
                + "y te dejan caer en mitad del vuelo. Descarta 1 mano visible y "
                + "1 mano oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4, 1);
        monstruos.add(new Monster("Demonios de Magaluf", 2, badConsequence, prize));
        
        // El gorrón en el umbral
        badConsequence = new NumericBadConsequence("Pierdes todos tus tesoros visibles",
                0, BadConsequence.MAXTREASURES, 0);
        prize = new Prize(3, 1);
        monstruos.add(new Monster("El gorrón en el umbral", 13, badConsequence, prize));
        
        // H.P. Munchcraft
        badConsequence = new SpecificBadConsequence("Pierdes la armadura visible", 0, 
            new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(2, 1);
        monstruos.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        
        // Necrófago
        badConsequence = new SpecificBadConsequence("Sientes bichos bajo la ropa. "
                + "Descarta la armadura visble", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Necrófago", 13, badConsequence, prize));
        
        // El rey de rosado
        badConsequence = new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize(3, 2);
        monstruos.add(new Monster("El rey de rosado", 11, badConsequence, prize));
        
        //Flecher
        badConsequence = new NumericBadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Flecher", 2, badConsequence, prize));

        //Los Hondos
        badConsequence = new DeathBadConsequence("superficiales y te aburren mortalmente. Estás muerto."
                + "Estos monstruos resultan bastante") ;
        prize = new Prize(2,1) ;

        monstruos.add(new Monster("Los hondos", 8, badConsequence, prize)) ;

        //Semillas Cthulhu
        badConsequence = new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros ocultos",
        2,0,2) ;

        prize = new Prize(2,1) ;

        monstruos.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize)) ;

        //Dameargo
        badConsequence = new SpecificBadConsequence("Te intentas escaquear. Pierdenes "
                + "una mano visible.", 1, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
        new ArrayList()) ;

        prize = new Prize(2,1) ;

        monstruos.add(new Monster("Dameargo",1,badConsequence, prize)) ;

        //Pollipólipo
        badConsequence = new NumericBadConsequence("Da mucho asquito. Pierdes 3 niveles",
        3, 0, 0) ;

        prize = new Prize(2,1) ;

        monstruos.add(new Monster("Pollipólipo", 3, badConsequence, prize)) ;

        //YskgtihyssgGoth"
        badConsequence = new DeathBadConsequence("No le hace gracia que pronuncien mal"
                + "su nombre. Estas muerto.") ;

        prize = new Prize(3,1 ) ;

        monstruos.add(new Monster("YskgtihyssgGoth", 14, badConsequence, prize)) ;

        //Familia feliz

        badConsequence = new DeathBadConsequence("La familia te atrapa. Estás muerto.") ;

        prize = new Prize(3,1) ;

        monstruos.add(new Monster("Familia feliz", 1, badConsequence, prize)) ;

        //Roboggoth

        badConsequence = new SpecificBadConsequence("La quinta directiva primaria te obliga"
                + "a perder 2 niveles y un tesoro 2 manos visible.", 2, new ArrayList(
                Arrays.asList(TreasureKind.BOTHHANDS)),new ArrayList()) ;

        prize = new Prize(2,1) ;

        monstruos.add(new Monster("Roboggoth", 8, badConsequence, prize)) ;

        //El espía sordo

        badConsequence = new SpecificBadConsequence("Te asusta en la noche. Pierdes tu"
                + "casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)),
        new ArrayList()) ;

       prize = new Prize(1,1) ;

       monstruos.add(new Monster("El espía sordo", 5, badConsequence, prize)) ;

       // Tongue

       badConsequence = new NumericBadConsequence("Menudo susto te levas. Pierdes 2 "
               + "niveles y 5 tesoros visibles", 2, 5, 0) ;
       prize = new Prize(2,1) ;
        
       monstruos.add(new Monster("Tongue", 19, badConsequence, prize)) ;
       
       //Bicéfalo

       badConsequence = new SpecificBadConsequence("Te faltan manos para tanta cabeza."
               + "Pierdes 3 niveles y tus tesoros visibles de las manos", 3,
       new ArrayList(Arrays.asList(TreasureKind.ONEHAND,TreasureKind.BOTHHANDS)),
       new ArrayList()) ;

       prize = new Prize(2,1) ;

       monstruos.add(new Monster("Bicéfalo",21, badConsequence, prize)) ;
       
       // MONSTRUOS CON SECTARIOS
       
       // El mal indecible impronunciable
       badConsequence = new SpecificBadConsequence("Pierdes 1 mano visible", 0, 
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
       prize = new Prize(3, 1);
       monstruos.add(new Monster("El mal indecible impronunciable", 10, badConsequence, prize, -2));
       
       // Testigos Oculares
       badConsequence = new NumericBadConsequence("Pierdes tus tesoros visibles. Jajaja.", 0, 
            BadConsequence.MAXTREASURES, 0);
       prize = new Prize(2, 1);
       monstruos.add(new Monster("Testigos Oculares", 6, badConsequence, prize, 2));
       
       // El gran cthulhu
       badConsequence = new DeathBadConsequence("Hoy no es tu día de suerte. Mueres");
       prize = new Prize(2, 5);
       monstruos.add(new Monster("El gran cthulhu", 20, badConsequence, prize, 4));
       
       // Serpiente Político
       badConsequence = new NumericBadConsequence("Tu gobierno te recorta 2 niveles", 2, 0, 0);
       prize = new Prize(2, 1);
       monstruos.add(new Monster("Serpiente Político", 8, badConsequence, prize, -2));
       
       // Felpuggoth
       badConsequence = new SpecificBadConsequence("Pierdes tu casco y tu armadura visible."
               + "Pierdes tus manos ocultas", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET, TreasureKind.ARMOR)),
                 new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND)));
       prize = new Prize(1, 1);
       monstruos.add(new Monster("Felpuggoth", 2, badConsequence, prize, 5));
       
       // Shoggoth
       badConsequence = new NumericBadConsequence("Pierdes 2 niveles", 2, 0, 0);
       prize = new Prize(4, 2);
       monstruos.add(new Monster("Shoggoth", 16, badConsequence, prize, -4));
       
       // Lolitagooth
       badConsequence = new NumericBadConsequence("Pintalabios negro. Pierdes 2 niveles", 2, 0, 0);
       prize = new Prize(1, 1);
       monstruos.add(new Monster("Lolitagooth", 2, badConsequence, prize, 3));
       
       
       unusedMonsters = monstruos;
       this.shuffleMonsters();
       
    }
 
// Baraja el mazo de cartas de tesoros unusedTreasures.
    private void shuffleMonsters() {
         Collections.shuffle(unusedMonsters);
         
    }
    
// Baraja el mazo de cartas de monstruos unusedMonsters.
    private void shuffleTreasures() {
        Collections.shuffle(unusedTreasures);
        
    }
 
/* Devuelve el siguiente tesoro que hay en el mazo de tesoros (unusedTreasures) y lo elimina
de él. Si al iniciar el método el mazo unusedTreasures estuviese vacío, pasa el mazo de
descartes (usedTreasures) al mazo de tesoros (unusedTreasures) y barájalo, dejando el
mazo de descartes vacío. */
    public Treasure nextTreasure() {
        if(unusedTreasures.isEmpty()) { 
            unusedTreasures = usedTreasures;
            shuffleTreasures();
            usedTreasures = new ArrayList();
        }
        Treasure salida = unusedTreasures.get(0);
        usedTreasures.add(unusedTreasures.get(0)) ; 
        unusedTreasures.remove(0);
        return salida;
        
    }
 
// Igual que la anterior pero con el mazo de monstruos.
    public Monster nextMonster() {
        if(unusedMonsters.isEmpty()) { 
                unusedMonsters = usedMonsters;
                shuffleMonsters();
                usedMonsters = new ArrayList();
            }
            Monster salida = unusedMonsters.get(0);
            unusedMonsters.remove(0);
            return salida;
    }
 
// Introduce en el mazo de descartes de tesoros (usedTreasures) el tesoro t.
    public void giveTreasureBack(Treasure t) {
        usedTreasures.add(t);
    }
   
// Introduce en el mazo de descartes de monstruos (usedMonsters) al monstruo m.
    public void giveMonsterBack(Monster m) {
        usedMonsters.add(m);
    }
    
// Inicializa los mazos de cartas de los tesoros y de los monstruos
    public void initCards() {
        this.initTreasureCardDeck();
        this.initMonsterCardDeck();
        this.initCultistCardDeck();
    }
    
    private void shuffleCultist() {
        Collections.shuffle(unusedCultist);
    }
    
    private void initCultistCardDeck() {                
        unusedCultist= new ArrayList(Arrays.asList(
                new Cultist("Sectario", 1),
                new Cultist("Sectario", 2),
                new Cultist("Sectario", 1),
                new Cultist("Sectario", 2),
                new Cultist("Sectario", 1),
                new Cultist("Sectario", 1)));

    }
    
    public Cultist nextCultist() {
        this.shuffleCultist();
        return this.unusedCultist.get(0);
    }
    
}
