
package poo.practica;

import javax.swing.JOptionPane;


public class ClasePractica {
    
    private String nombre, contraseñaOwner;
    private int hora, dia, opcionFood, opcionState, opcionCambio, diaCambio;
    private boolean desayuno, almuerzo, cena, pass;
    
    public ClasePractica(){
    
        this.nombre = null;
        this.almuerzo = false;
        this.cena = false;
        this.desayuno = false;
        this.hora = 0000;
        this.dia = 0;
        this.opcionFood = 0;
        this.opcionState = 0;
        this.opcionCambio = 0;
        this.diaCambio = 0;
    
    }
    
    public ClasePractica(String nombre, int hora, int dia, int opcionFood, int opcionState, int diaCambio, int opcionCambio, boolean desayuno, boolean almuerzo, boolean cena){
    
        this.nombre = nombre;
        this.desayuno = desayuno;
        this.almuerzo = almuerzo;
        this.cena = cena;
        this.hora = hora;
        this.dia = dia;
        this.opcionFood = opcionFood;
        this.opcionState = opcionState;
        this.diaCambio = diaCambio;
        this.opcionCambio = opcionCambio;
    
    
    }
    
    public static String[] nombresPensionados = {
    
        "FRANCISCO", "JUAN SOLO", "SAMUEL"
    
    
    };
    
    public static String[] estadoComida = {
    
        "SERVIDO", "NO SERVIDO"
     
    };
    
    public static String[][] comidasDias = {
    
        {"GUINEO CON SALCHICHA" , "BOLLITOS CON HUEVO", "YUCA CON HUEVO" , "AREPA DE CHOCLO CON QUESO", "SANDWICH CON QUESO", "GUINEO CON HUEVO"},
        {"POLLO, LENTEJAS, TAJADAS Y ARROZ", "CARNE, LENTEJAS, PATACONES Y ARROZ", "ARROZ CON POLLO, TAJADAS", "SOPA DE POLLO CON ARROZ", "POLLO ASADO, LENTEJAS, TAJADAS Y ARROZ", "CERDO, ARROZ, ENSALADA Y ARROZ"},
        {"ROSQUETES" , "EMPANADAS", "PASTA CON SLACHICA", "ARROZ DE SALCHICA", "ARROZ CON LECHE", "PERRO CALIENTE"}
    
    };
    
    public static String[] diasSemana = {

        "LUNES" , "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO", "DOMINGO"

    };
    
    public static String[] stockFood = {

        "DESAYUNO" , "ALMUERZO", "CENA"

    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isDesayuno() {
        return desayuno;
    }

    public void setDesayuno(boolean desayuno) {
        this.desayuno = desayuno;
    }

    public boolean isAlmuerzo() {
        return almuerzo;
    }

    public void setAlmuerzo(boolean almuerzo) {
        this.almuerzo = almuerzo;
    }

    public boolean isCena() {
        return cena;
    }

    public void setCena(boolean cena) {
        this.cena = cena;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getOpcionFood() {
        return opcionFood;
    }

    public void setOpcionFood(int opcionFood) {
        this.opcionFood = opcionFood;
    }

    public int getOpcionState() {
        return opcionState;
    }

    public void setOpcionState(int opcionState) {
        this.opcionState = opcionState;
    }
    
    
    
    //Menu Para Pensionados (Prototipo)
   
    public String menuPensionado(){
                
        for (int i = 0; i < comidasDias.length; i++) {
            for (int j = 0; j < comidasDias.length; j++) {
                
                return "Menu del Dia " + dia + "\n { " + "DESAYUNO: " + comidasDias[i][dia - 1] + " \t ESTADO: " + estadoComida[i];
                
            }
            
        }
        
        //TERMINAR DE COMPLETAR EL MENU QUE SE LE MOSTRARA A LOS PENSIONADOS
    
        return nombre;
    
    }
    
    
    //METODOS ESPECIALES PARA EL OWNER
    
    public void reinicio() throws InterruptedException{
        
        Thread.sleep(3500); 
        
        int lineas = 15;
            
        for (int i=0; i < lineas; i++){
                                        
        System.out.println();

        //PUEDE REMPLAZARSE EL DO WHILE SI SE ENCUNETRA UNA FORMA DE LIMPIAR LA CONSOLA SIN TENER QUE AGREGAR UN MONTON DE ESPACIOS
        
        }
        
        System.out.println("\nComo Owner tiene acesso a todas estas funciones. Cual desea usar: \n");
        
        opcionesOwner();
        
    }
    
    public void opcionesOwner(){
        
        System.out.println("1. setState. \n2. showMenu. \n3. changeMenu \n4. Salir");
    
    }
    
    public void changeMenu() throws InterruptedException{
        
        int opcioncambio = Integer.parseInt(JOptionPane.showInputDialog("¿Que plato desea cambiar? \n1. Desayuno \n2. Almuerzo \n3. Cena"));
        int diacambio = Integer.parseInt(JOptionPane.showInputDialog("¿De que dia?"));
        
        String nuevaComida = JOptionPane.showInputDialog("¿Cual es el nuevo plato que desea introducir?");
        comidasDias[opcioncambio - 1][diacambio - 1] = nuevaComida;
        
        System.out.println("\nUsted ha cambiado el " + stockFood [opcioncambio - 1] + " del DIA " + diasSemana [diaCambio] + " a " + nuevaComida);
        reinicio();
        
    }
    
    // METODOS DE USO GENERAL
    
    public void changeDia() throws InterruptedException{
    
        int dia = Integer.parseInt(JOptionPane.showInputDialog("¿Cual es el dia que desea consultar?"));
        setDia(dia);
        reinicio();
    
    
    }
    
    public void showMenu() throws InterruptedException{
        
        dia = Integer.parseInt(JOptionPane.showInputDialog("¿En que dia se encuentra?"));
    
        System.out.println("\nEl menu del Día " + diasSemana[dia - 1] + " es:\n");
        
            for (int i = 0; i < comidasDias.length; i++) {
                
                System.out.println(comidasDias[i][dia - 1] + "\n");
            
            }
            
            reinicio();
    }
    
    // METODOS ESPECIALES PARA LOS PENSIONADOS
    
    public void opcionesPensionado(){
    
        System.out.println("\n1. getFoodDay \n2. getState \n3. solicitarCambio \n4. getHistorial \n5. showMenu \n6. SALIR ");
    
    }
    
    public void reinicioPension() throws InterruptedException{
        
        Thread.sleep(3500); 
        
        int lineas = 15;
            
        for (int i=0; i < lineas; i++){
                                        
        System.out.println();

        //PUEDE REMPLAZARSE EL DO WHILE SI SE ENCUNETRA UNA FORMA DE LIMPIAR LA CONSOLA SIN TENER QUE AGREGAR UN MONTON DE ESPACIOS
        
        }
        
        System.out.println("\nComo Pensionado tiene acesso a todas estas funciones. Cual desea usar: \n");
        
        opcionesPensionado();
    
    }
    
    public void getState(){
        
        if (opcionState == 1 && desayuno == true) {
            
            System.out.println("El DESAYUNO esta SERVIDO.");
            
        } else {
        
            System.out.println("El DESAYUNO NO SERVIDO");
        
        }
        
        if (opcionState == 2 && almuerzo == true) {
            
            System.out.println("El ALMUERZO esta SERVIDO.");
        
        } else {
        
            System.out.println("El ALMUERZO NO SERVIDO");
            
        }
        
        if (opcionState == 3 && cena == true) {
        
            System.out.println("La CENA esta SERVIDA.");
            
        } else {
        
            System.out.println("La CENA NO SERVIDA");
        
        } 
        
    
    }
    
    public void getFoodDay() throws InterruptedException{
        
        int opcionFood = Integer.parseInt(JOptionPane.showInputDialog("\n¿Que plato desea concoer el menu? \n1. Desayuno \n2. Almuerzo \n3. Cena"));
        setOpcionFood(opcionFood);
        
        System.out.println("\n" + stockFood[opcionFood-1] + " del DIA " + diasSemana[dia] + " es: \n" + comidasDias[opcionFood-1][dia]);
        
        reinicioPension();
        
    }
    
   
    
   
    
}
