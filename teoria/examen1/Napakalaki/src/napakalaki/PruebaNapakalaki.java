/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
import napakalaki.mago.Poderes;

/**
 *
 * @author Redondo
 */


public class PruebaNapakalaki {

    static ArrayList<Monster> monstruos = new ArrayList();
        
    /**
     * @param args the command line arguments
     */
    
    
    static ArrayList<Monster> Combat10 () {
        ArrayList<Monster> output = new ArrayList();
        for (Monster monstruo : monstruos) { 
            if(monstruo.getCombatLevel() > 10) {
                output.add(monstruo);
            }
        }
        return output;
    }
    
    static ArrayList<Monster> PierdeNivel(){
        ArrayList<Monster> output = new ArrayList();
        for(Monster monstruo : monstruos){
            if(
                    monstruo.getRol().getLevels() > 0 &&
                    monstruo.getRol().getSpecificHiddenTreasures().isEmpty() &&
                    monstruo.getRol().getSpecificVisibleTreasures().isEmpty() &&
                    monstruo.getRol().isDeath() == false &&
                    monstruo.getRol().getnVisibleTreasures() == 0 &&
                    monstruo.getRol().getnHiddenTreasures() == 0)
                    output.add(monstruo); 
            
        } return output ;
    }
    
    static ArrayList<Monster> LevelSup1() {
        ArrayList<Monster> output = new ArrayList();
        for(Monster monstruo : monstruos) {
            if(monstruo.getPremio().getLevel() > 1) {
                output.add(monstruo);
            }
        }
        return output;
    }
    
    static ArrayList<Monster> PierdeTesoro(TreasureKind tipo) {
        ArrayList<Monster> output = new ArrayList();
        for(Monster monstruo : monstruos) {
            boolean encontrado = false;
            for(int i=0; i < monstruo.getRol().getSpecificHiddenTreasures().size() && !encontrado; i++)
                encontrado = monstruo.getRol().getSpecificHiddenTreasures().get(i) == tipo;
            
            if(!encontrado) {
              
                for(int i=0; i < monstruo.getRol().getSpecificVisibleTreasures().size() && !encontrado; i++)
                    encontrado = monstruo.getRol().getSpecificVisibleTreasures().get(i) == tipo;
            }
            if(encontrado) 
                output.add(monstruo);
            
        }
        return output;
    }
        
    
            
            
    public static void main(String[] args) {
        // TODO code application logic here
        
        // El Rey de Rosa
        BadConsequence badConsequence = new BadConsequence("Pierdes 5 niveles "
                + "y 3 tesoros visibles", 5, 3, 0);
        Prize prize = new Prize(4, 2);
        monstruos.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        
        // Ángeles de la noche ibicenca
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta "
                + "y te dejan caer en mitad del vuelo. Descarta 1 mano visible y "
                + "una mano oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4, 1);
        monstruos.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence, prize));
        
        // 3 Byakhees de bonanza
        badConsequence = new BadConsequence("Pierdes tu armadura visible y otra "
                + "oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize = new Prize(2, 1);
        monstruos.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        
        // Tenochtitlan
        badConsequence = new BadConsequence("Embobados con el lindo primigenio "
                + "te descartas de tu casco visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Tenochtitlan", 2, badConsequence, prize));
        
        // El sopor de Dunwich
        badConsequence = new BadConsequence("El primordial bostezo contagioso. "
                + "Pierdes el calzado visible", 0, new ArrayList(Arrays.asList(TreasureKind.SHOES)), 
                new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        
        // Demonios de Magaluf
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta"
                + "y te dejan caer en mitad del vuelo. Descarta 1 mano visible y "
                + "1 mano oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4, 1);
        monstruos.add(new Monster("Demonios de Magaluf", 2, badConsequence, prize));
        
        // El gorrón en el umbral
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles",
                0, Integer.MAX_VALUE, 0);
        prize = new Prize(3, 1);
        monstruos.add(new Monster("El gorrón en el umbral", 13, badConsequence, prize));
        
        // H.P. Munchcraft
        badConsequence = new BadConsequence("Pierdes la armadura visible", 0, 
            new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(2, 1);
        monstruos.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        
        // Necrófago
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. "
                + "Descarta la armadura visble", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Necrófago", 13, badConsequence, prize));
        
        // El rey de rosado
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize(3, 2);
        monstruos.add(new Monster("El rey de rosado", 11, badConsequence, prize));
        
        //Flecher
        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Flecher", 11, badConsequence, prize));

        //Los Hondos
        badConsequence = new BadConsequence("Estos monstruos resultan bastante"
                + "superficiales y te aburren mortalmente. Estás muerto." , true) ;
        prize = new Prize(2,1) ;

        monstruos.add(new Monster("Los hondos", 8, badConsequence, prize)) ;

        //Semillas Cthulhu
        badConsequence = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos",
        2,0,2) ;

        prize = new Prize(2,1) ;

        monstruos.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize)) ;

        //Dameargo
        badConsequence = new BadConsequence("Te intentas escaquear. Pierdenes "
                + "una mano visible.", 1, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
        new ArrayList()) ;

        prize = new Prize(2,1) ;

        monstruos.add(new Monster("Dameargo",1,badConsequence, prize)) ;

        //Pollipólipo
        badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles",
        3, 0, 0) ;

        prize = new Prize(2,1) ;

        monstruos.add(new Monster("Pollipólipo", 3, badConsequence, prize)) ;

        //YskgtihyssgGoth"
        badConsequence = new BadConsequence("No le hace gracia que pronuncien mal"
                + "su nombre. Estas muerto.", true) ;

        prize = new Prize(3,1 ) ;

        monstruos.add(new Monster("YskgtihyssgGoth", 14, badConsequence, prize)) ;

        //Familia feliz

        badConsequence = new BadConsequence("La familia te atrapa. Estás muerto.",
        true) ;

        prize = new Prize(3,1) ;

        monstruos.add(new Monster("Familia feliz", 1, badConsequence, prize)) ;

        //Roboggoth

        badConsequence = new BadConsequence("La quinta directiva primaria te obliga"
                + "a perder 2 niveles y un tesoro 2 manos visible.", 2, new ArrayList(
                Arrays.asList(TreasureKind.BOTHHANDS)),new ArrayList()) ;

        prize = new Prize(2,1) ;

        monstruos.add(new Monster("Roboggoth", 8, badConsequence, prize)) ;

        //El espía sordo

        badConsequence = new BadConsequence("Te asusta en la noche. Pierdes tu"
                + "casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)),
        new ArrayList()) ;

       prize = new Prize(1,1) ;

       monstruos.add(new Monster("El espía sordo", 5, badConsequence, prize)) ;

       // Tongue

       badConsequence = new BadConsequence("Menudo susto te levas. Pierdes 2 "
               + "niveles y 5 tesoros visibles", 2, 5, 0) ;
       prize = new Prize(2,1) ;

       monstruos.add(new Monster("Tongue", 19, badConsequence, prize)) ;
       
       //Bicéfalo

       badConsequence = new BadConsequence("Te faltan manos para tanta cabeza."
               + "Pierdes 3 niveles y tus tesoros visibles de las manos", 3,
       new ArrayList(Arrays.asList(TreasureKind.ONEHAND,TreasureKind.BOTHHANDS)),
       new ArrayList()) ;

       prize = new Prize(2,1) ;

       monstruos.add(new Monster("Bicéfalo",21, badConsequence, prize)) ;
       
       
       ArrayList<Monster> prueba = new ArrayList();
       
       prueba = PierdeNivel();
       System.out.println ("Los monstruos que sólo implican pérdida de niveles son:  \n");
       for(Monster monstruos : prueba) 
            System.out.println(monstruos);
       
       System.out.println ("Los monstruos que tienen un nivel de combate mayor a 10 son:  \n");
       prueba = Combat10();
       for(Monster monstruos : prueba)        
           System.out.println(monstruos);
       
       System.out.println ("Los monstruos que su buen rollo indica que ganan mas de un nivel son:  \n");
       prueba = LevelSup1();
       for(Monster monstruos : prueba) 
            System.out.println(monstruos);
       
       System.out.println ("Los monstruos que su mal rollo supone pérdida de tesoro son:  \n");
       prueba = PierdeTesoro(TreasureKind.ONEHAND);
       for(Monster monstruos : prueba) 
            System.out.println(monstruos);
       
     
       mago panoramix = new mago("Panoramix", Poderes.CAMBIANTE, monstruos.get(1)) ;
       mago merlin = new mago("Merlín", Poderes.INVISIBLE, monstruos.get(2)) ; 
       mago hoz = new mago("Hoz", Poderes.VOLADOR, monstruos.get(monstruos.size()-1)) ;
        
       ArrayList<mago> magos =  new ArrayList<>(Arrays.asList(panoramix, hoz)) ; 
       
       /* Otra opción : 
       
       mago[] magos = {panoramix, hoz} 
       
   
       */
        
        for(mago mg : magos){
            System.out.println(mg) ; 
        }
        
        System.out.println("El total de magos creados es: \n") ; 
        System.out.println(mago.getTotal_magos()) ; 
       

    }
  
    }
   
    

