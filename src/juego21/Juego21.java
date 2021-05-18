/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego21;

/**
 *
 * @author ALESSANDRO TORRES
 */
import java.util.Scanner;

public class Juego21 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //Arreglo de la baraja, mano del usuario y mano del cpu
        int cantidad=11;
        int i=0;
        int[] baraja = new int[cantidad];
        int[] usuario = new int[11];
        int[] cpu = new int [11];
        int cercania=0;
        int cercaniacpu=0;
        int tempusr = 4; 
        int tempcpu= 5; //Se llevan uno de diferencia porque comparten la misma baraja pero el usuario saca primero
        int idxusuario=2, idxcpu=2;
        
        int sumatoria=0,sumatoriacpu=0;
        String jalar;
        
            //Rellenar la baraja del 1 a al 11 de manera random sin que se repitan numeros
            baraja[i]=(int) ((Math.random()*11) +1);
            
            for (i=1; i<cantidad; i++) {
                baraja[i]=(int) ((Math.random()*11) +1);
                    for (int j = 0; j<i; j++) {
                        if(baraja[i]==baraja[j]){
                            i--;
                        }
                    }
            }
            
            
            //Recorre la baraja y le da la carta bocaabajo a los jugadores y la primera carta normal
            for ( i = 0; i < baraja.length; i++) {
                
                if(i==0){
                    usuario[0]=baraja[i];
                }
                
                i++;
                
                if(i==1){
                    cpu[0]=baraja[i];
                }
                
                i++;
                
                if(i==2){
                    usuario[1]=baraja[i];
                }
                
                i++;
                
                if(i==3){
                    cpu[1]=baraja[i];
                }
                
            }
            
            //Sumatoria de las cartas del usuario y cpu, inicialmente incluye su carta bocaabajo y la primera bocaarriba
            
            //Sumatoria de las cartas del usuario
            sumatoria=sumatoria+usuario[0]+usuario[1];
            //Sumatoria de las cartas del cpu
            sumatoriacpu=sumatoriacpu+cpu[0]+cpu[1];
            
            //Esto no lo usaremos, pero es para ver la baraja y sus valores
            /*for ( int k = 0; k < cantidad; k++) {
            System.out.println(baraja[k]);
            }*/

            System.out.println("La carta que jalaste y estara boca abajo es:" +usuario[0]);
            System.out.println("La carta que jalaste y estara boca abajo del cpu no la puedes saber");
            System.out.println();
            
            //1er turno
            
            //Mano del cpu excepto la bocaabajo
            System.out.println("La mano del cpu es: ");
            
                for ( i = 1; i < 2; i++) {    
                    System.out.print("[?]");
                    System.out.print("["+cpu[i]+"]");
                }            
                
            System.out.println();
            System.out.println();
            
            //Ver la mano del jugador usuario
            System.out.println("La mano del usuario es: ");
            
                for (i = 0; i < 2; i++) {
                    System.out.print("["+usuario[i]+"]");
                }
            
            System.out.println();
            
            //Ahora condicionar para ver si quieren tomar una carta mas
            //Primero deberia ser el usuario
            do{
                if(sumatoria<=21){
                    
                    System.out.println();
                    System.out.println("Presiona S si quieres jalar otra carta:");
                    jalar=sc.next();
                    System.out.println();
                   
                    //tempusr=3
                    //tempcpu=4
                    
                    //Jala la carta el usuario
                    if(jalar.equals("S")){
                    //Lo suma en su acumulador sumatoria para ver si llega a 21 
                    sumatoria=sumatoria+baraja[tempusr]; 
                  
                    usuario[idxusuario]=baraja[tempusr];
                    idxusuario++;
                    tempusr=tempusr+2;
                    
                    System.out.println("La mano del usuario es: ");
                    
                        for (i = 0; i < usuario.length; i++) {
                            
                            System.out.print("["+usuario[i]+"]");
                        }
                        System.out.println();
                        System.out.println();
                        
                    System.out.println("La mano del cpu es: ");
                    System.out.print("[?]");
                        for (i = 1; i < cpu.length; i++) {
                            System.out.print("["+cpu[i]+"]");
                        }
                        System.out.println();
                        
                    }                   
                }
                
                if(sumatoriacpu<=21){
                    
                    System.out.println();
                    System.out.println("Presiona S si quieres que la CPU robe otra carta:");
                    jalar=sc.next();
                    System.out.println();
                    
                    if(jalar.equals("S")){
                        
                    //El cpu deberia jalar carta a fuerzas si considera que aun esta lejos del 21
                    sumatoriacpu=sumatoriacpu+baraja[tempcpu]; 
                           
                    
                    cpu[idxcpu]=baraja[tempcpu];
                    idxcpu++;
                    tempcpu=tempcpu+2;     
                      
                    System.out.println("La mano del cpu es: ");
                    System.out.print("[?]");
                        for (i = 1; i < cpu.length; i++) {
                            System.out.print("["+cpu[i]+"]");
                        }
                        System.out.println();
                        
                    System.out.println("La mano del usuario es: ");
                    
                        for (i = 0; i < usuario.length; i++) {
                            
                            System.out.print("["+usuario[i]+"]");
                        }
                        System.out.println();
                        System.out.println();
                        
                    }
                  
                }
                
            }while(sumatoria<=21&&sumatoriacpu<=21);
            
            System.out.println();
            System.out.println("La sumatoria del jugador usuario es: "+sumatoria);
            System.out.println("La sumatoria del jugador cpu es: "+sumatoriacpu);
            System.out.println("------------RESULTADOS-----------------------------");
            
            //Seleccionar el ganador del juego
            
            if(sumatoria==21&&sumatoriacpu!=21)
                System.out.println("El ganador de la partida es el usuario");
            
            if(sumatoriacpu==21&&sumatoria!=21)
                System.out.println("El ganador de la partida es el cpu");
            
            if(sumatoriacpu==21&&sumatoria==21){
                System.out.println("La partida quedo en un empate");
            }
            
            if(sumatoria<21&&sumatoriacpu>21){
                System.out.println("El ganador es el USUARIO ya que CPU se paso de 21");
            }else if(sumatoria>21&&sumatoriacpu<21){
                System.out.println("El ganador es el CPU ya que el USUARIO se paso de 21");
            }
            
            if(sumatoria<21&&sumatoriacpu<21){
                cercania=21-sumatoria;
                cercaniacpu=21-sumatoriacpu;
                if(cercania<cercaniacpu){
                    System.out.println("El ganador de la partida es el usuario por estar mas cerca del 21");
                }else
                     System.out.println("El ganador de la partida es el cpu por estar mas cerca del 21");
            }
            if(sumatoria>21&&sumatoriacpu>21){
                int lejania=0;
                int lejaniacpu=0;
                lejania=sumatoria-21;
                lejaniacpu=sumatoriacpu-21;
                    if(lejania<lejaniacpu){
                        System.out.println("El ganador de la partida es el USUARIO porque ambos jugadores se pasaron de 21 pero el USUARIO se acerco mas");
                    }else
                          System.out.println("El ganador de la partida es el CPU porque ambos jugadores se pasaron de 21 pero el CPU se acerco mas");
            }    
            System.out.println("---------------------------------------");
            System.out.println("Las manos finales son las siguientes: ");
            System.out.println();
            System.out.println("La mano del USUARIO es: ");
            
                for (i = 0; i < usuario.length; i++) {
                    System.out.print("["+usuario[i]+"]");
                }
                
            System.out.println();
            System.out.println();
            System.out.println("La mano del CPU es: ");
            
                for (i = 0; i < cpu.length; i++) {
                    System.out.print("["+cpu[i]+"]");
                }
            System.out.println();
            
    }

}