
package poo.practica;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class POOPractica {

    public static void main(String[] args) throws InterruptedException {
        
        String nombre, contraseñaOwner = "1", contraseñaPensionado = "2";
        int hora, dia = 0, opcionFood = 0, opcionState = 0, diaCambio = 0, opcionCambio = 0;
        boolean desayuno, almuerzo, cena;
        
        int usuario, opcionOwner;
        boolean salir = false;
        
        nombre = "Francisco";
        hora = 700;
        desayuno = false;
        almuerzo = false;
        cena = false;
        
        
        Scanner sn = new Scanner (System.in);
        
        ClasePractica pension = new ClasePractica(nombre, hora, dia, opcionFood, opcionState, diaCambio, opcionCambio, desayuno, almuerzo, cena);
       
       //Inicio con el dueño de la pension
       
        usuario = Integer.parseInt(JOptionPane.showInputDialog("Desea Ingresar the owner o un pensionado: \n" + "1. Owner \n2. Pensionado"));
        
        if (usuario == 1) {
            
            int comp = 0;
            
            do{
                
                String contraseña = JOptionPane.showInputDialog(null, "Owner. ¿Cual es su contraseña?");
            
            if (contraseña.equals(contraseñaOwner)) {
                
                JOptionPane.showMessageDialog(null, "Welcome Owner");
                comp = 1;
                
            }else{
                
                JOptionPane.showMessageDialog(null, "Contraseña Incorrecta. Intente Otra vez.");
                contraseña = JOptionPane.showInputDialog(null, "Owner. ¿Cual es la Contraseña?");
                
            }
            
                
            
            
            }while(comp == 0);
            
                
                
                if (comp == 1) {
                    
                    System.out.println("\nComo owner tiene acesso a todas estas funciones. Cual desea usar: \n");
                    
                    pension.opcionesOwner();
                    
                    do{
                        
                        opcionOwner = Integer.parseInt(JOptionPane.showInputDialog("¿Que desea hacer?"));
                    
                        switch(opcionOwner){
                    
                            case 1:
                            
                                hora = Integer.parseInt(JOptionPane.showInputDialog("¿Que hora es?"));
                                pension.setHora(hora);
                        
                                if (hora >= 700 && hora <1200 ) {
                                
                                    pension.setDesayuno(true);
                                    pension.setAlmuerzo(false);
                                    pension.setCena(false);
                                    System.out.println("A todos los pensionados se les ha cambiado el estado a SERVIDO del DESAYUNO.");
                                    
                                    pension.reinicio();
                                    
                                }else if(hora >= 1200 && hora < 1800){
                                
                                    pension.setDesayuno(true);
                                    pension.setAlmuerzo(true);
                                    pension.setCena(false);
                                    System.out.println("A todos los pensionados se les ha cambiado el estado a SERVIDO del DESAYUNO y ALMUERZO."); 
                                     
                                    pension.reinicio();
                                    
                                }else if(hora >= 1800 && hora < 0000){
                                
                                    pension.setDesayuno(true);
                                    pension.setAlmuerzo(true);
                                    pension.setCena(true);
                                    System.out.println("A todos los pensionados se les ha cambiado el estado de TODAS LAS COMIDAS como SERVIDAS.");
                                    
                                    pension.reinicio();

                                }
                                
                                //SE NECESITA LA BASE DE DATOS 
                            
                                break;
                        
                            case 2:
                                
                                pension.showMenu();
                                
                            case 3:
                                
                                pension.changeMenu();
                                
                                        
                            break;
                            
                            case 4:
                                
                                salir = true;
                                
                            }
       
                        } while(!salir);
                    
                    }
            
            } else if (usuario == 2){
                
                String contraseña = JOptionPane.showInputDialog(null, "Pensionado. ¿Cual es su contraseña?");

                if (contraseña.equals(contraseñaPensionado)) {
                    
                    JOptionPane.showMessageDialog(null, "Welcome Pensionado");
                    dia = Integer.parseInt(JOptionPane.showInputDialog("¿En que dia se encuentra?"));
                    System.out.println("\nComo pensionado tiene acesso a todas estas funciones. Cual desea usar: \n");
                    pension.opcionesPensionado();
                    
                    if (dia >= 1 && dia <= 6) {
                    
                    do{
                        
                        opcionOwner = Integer.parseInt(JOptionPane.showInputDialog("¿Que desea hacer?"));
                    
                        switch(opcionOwner){
                            
                            case 1:

                                opcionFood = Integer.parseInt(JOptionPane.showInputDialog("\n¿Que plato desea concoer el menu? \n1. Desayuno \n2. Almuerzo \n3. Cena"));
                                pension.setOpcionFood(opcionFood);
                                pension.getFoodDay();
                                pension.reinicioPension();
                                
                                
                            break;
                            
                            case 2:
                                
                                opcionState = Integer.parseInt(JOptionPane.showInputDialog("Desea saber el estado de que comida. \n1. Desayuno \n2. Almuerzo \n3. Cena"));
                                pension.setOpcionState(opcionState);
                                pension.getState();
                                pension.reinicioPension();
                                
                            break;
                            
                            case 3:
                                
                                //NECESITA LA BASE DE DATOS
                                
                            break;
                            
                            case 4:
                                
                                //NECESTIA LA BASE DE DATOS
                                
                            break;
                            
                            case 5:
                                
                                pension.showMenu();
                                
                            break;
                            
                            case 6:
                                
                                salir = true;
                                
                            break;
                            
                            
                        }
                        
                    }while(!salir);
                    
                
                }
                    
                pension.opcionesPensionado();
            
            }
                
            }else{
                
                System.out.println("Hoy no se sirve ninguna comida.");
                
                
            }

        }



    }
