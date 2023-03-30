
package poo.practica;

import javax.swing.JOptionPane;

public class Proyecto {

    public static void main(String[] args) throws InterruptedException {
        
        String nombre1 = "", contraseñaOwner = "1", contraseñaPensionado = "2";
        
        int usuario, opcionOwner;
        boolean salir = false;
        
        //AÑADIR USUARIO BASE DE DATOS
        
        Conexion cn = new Conexion();
        
        /*String nombre = JOptionPane.showInputDialog("Ingresa nombre");
        String apellido = JOptionPane.showInputDialog("Ingresa apellido");
        
        boolean added = cn.addDatabase(nombre, apellido);
        if(added) {
            JOptionPane.showMessageDialog(null, "Agregado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
        
        */
        
        ClaseProyecto pension = new ClaseProyecto(nombre1);
       
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
                            
                                //pension.updateStatusSunday(); //ESTE METODO OCURRE EN EL BACKGROUND
                                pension.setMenuDay();
                                
                                break;
                        
                            case 2:
                                
                                pension.showMenuSQL();
                                
                            break;
                            
                            case 3:
                                
                                pension.changeMenuSQL();
                                
                                        
                            break;
                            
                            case 4:
                                
                                salir = true;
                                
                            }
       
                        } while(!salir);
                    
                    }
            
            } else if (usuario == 2){
                
                String contraseña = JOptionPane.showInputDialog(null, "Pensionado. ¿Cual es su contraseña?");

                if (contraseña.equals(contraseñaPensionado)) {
                    
//                    JOptionPane.showMessageDialog(null, "Welcome Pensionado");
//                    dia = Integer.parseInt(JOptionPane.showInputDialog("¿En que dia se encuentra?"));
//                    System.out.println("\nComo pensionado tiene acesso a todas estas funciones. Cual desea usar: \n");
//                    pension.opcionesPensionado();
//                    
//                    if (dia >= 1 && dia <= 6) {
                    
                    do{
                        
                        opcionOwner = Integer.parseInt(JOptionPane.showInputDialog("¿Que desea hacer?"));
                    
                        switch(opcionOwner){
                            
                            case 1:

                                    //Colocar showMenuSQL en case 1.
                                
                                
                            break;
                            
                            case 2:
                                
                                //Select estado de la base de datos de la posicion escogida del menu, e imprima tambien que comida es.
                                
                            break;
                            
                            case 3:
                                
                                //NECESITA LA BASE DE DATOS
                                
                            break;
                            
                            case 4:
                                
                                //NECESTIA LA BASE DE DATOS
                                
                            break;
                            
                            case 5:
                                
                                pension.showMenuSQL();
                                
                            break;
                            
                            case 6:
                                
                                salir = true;
                                
                            break;
                            
                            
                        }
                        
                    }while(!salir);
                    
                
                }
                    
                pension.opcionesPensionado();
            
            }
                
//            }else{
                
                System.out.println("Hoy no se sirve ninguna comida.");
                
                
            }

        }



 
