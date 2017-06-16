/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author grg121
 */
public class mago {
    
    public enum Poderes {
    INVISIBLE, CAMBIANTE, VOLADOR
}
    
    private String nombre ; 
    private Poderes poderes ; 
    private Monster monstruoAmigo ; 
    
    private static int total_magos = 0 ; 
    
    public mago(String nom, Poderes pod, Monster mamigo){
        nombre = nom ; 
        poderes = pod ; 
        monstruoAmigo = mamigo ; 
        total_magos++ ; 
    }

    @Override
    public String toString() {
        return "mago{" + "nombre=" + nombre + ", poderes=" + poderes + ", monstruoAmigo=" + monstruoAmigo + '}';
    }

    public static int getTotal_magos() {
        return total_magos;
    }
    
    
    
}
