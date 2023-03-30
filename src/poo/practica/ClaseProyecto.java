package poo.practica;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Calendar;

public class ClaseProyecto {

    private String nombre1, contraseñaOwner;

    Conexion cn = new Conexion();

    public ClaseProyecto() {

        this.nombre1 = null;

    }

    public ClaseProyecto(String nombre1) {

        this.nombre1 = nombre1;

    }

    public static String[][] comidasDias = {
        {"GUINEO CON SALCHICHA", "BOLLITOS CON HUEVO", "YUCA CON HUEVO", "AREPA DE CHOCLO CON QUESO", "SANDWICH CON QUESO", "GUINEO CON HUEVO"},
        {"POLLO, LENTEJAS, TAJADAS Y ARROZ", "CARNE, LENTEJAS, PATACONES Y ARROZ", "ARROZ CON POLLO, TAJADAS", "SOPA DE POLLO CON ARROZ", "POLLO ASADO, LENTEJAS, TAJADAS Y ARROZ", "CERDO, ARROZ, ENSALADA Y ARROZ"},
        {"ROSQUETES", "EMPANADAS", "PASTA CON SLACHICA", "ARROZ DE SALCHICA", "ARROZ CON LECHE", "PERRO CALIENTE"}

    };

    public static String[] diasSemana = {
        "LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO", "DOMINGO"

    };

    public static String[] stockFood = {
        "DESAYUNO", "ALMUERZO", "CENA"

    };

    public static String[][] n_servido = {
        {"1", "4", "7", "10", "13", "16"},
        {"2", "5", "8", "11", "14", "15"},
        {"3", "6", "9", "12", "15", "18"}

    };
    
    public static String[] servir_no = {
    
        "SERVIR", "NO SERVIR"
    
    
    };

    public String getNombre() {
        return nombre1;
    }

    public void setNombre(String nombre1) {
        this.nombre1 = nombre1;
    }

    //METODOS ESPECIALES PARA EL OWNER
    public void reinicio() throws InterruptedException {

        Thread.sleep(2000);

        int lineas = 15;

        for (int i = 0; i < lineas; i++) {

            System.out.println();

            //PUEDE REMPLAZARSE EL DO WHILE SI SE ENCUENTRA UNA FORMA DE LIMPIAR LA CONSOLA SIN TENER QUE AGREGAR UN MONTON DE ESPACIOS
        }

        System.out.println("\nComo Owner tiene acesso a todas estas funciones. Cual desea usar: \n");

        opcionesOwner();

    }

    public void opcionesOwner() {

        System.out.println("1. startDay. \n2. showMenu. \n3. changeMenu. \n4. Salir. ");

    }

    //UPDATE MENU MODEL
    public void changeMenuSQL() throws InterruptedException {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection conesion = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");

            int id = Integer.parseInt(JOptionPane.showInputDialog("¿Que comida desea a cambiar? \n1. Desayuno \n2. Almuerzo \n3. Cena"));

            int tipa = Integer.parseInt(JOptionPane.showInputDialog("¿De que dia? \n1. Lunes \n2. Martes \n3. Miercoles \n4. Jueves \n5. Viernes \n6. Sabado"));

            String comando = "Update comidas set nombre = ? where n_servido = " + n_servido[id - 1][tipa - 1];
            String newName = JOptionPane.showInputDialog("¿Por cual comida desea cambiar ?");

            PreparedStatement declaracion = conesion.prepareStatement(comando);

            declaracion.setString(1, newName);

            int resultado = declaracion.executeUpdate();
            if (resultado > 0) {

                JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente");

            }

        } catch (Exception e) {

            JOptionPane.showInternalMessageDialog(null, "error al conectar \n" + e);

        }

    }

    //SELECT MODEL
    public void showMenuSQL() throws InterruptedException {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            Connection conesion = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");

            int cd = Integer.parseInt(JOptionPane.showInputDialog("¿Que dia de la seman desea consultar? \n1. Lunes \n2. Martes \n3. Miercoles \n4. Jueves \n5. Viernes \n6. Sabado"));

            //Select * from Prueba
            Statement ejecutor = conesion.createStatement();
            ResultSet respuesta = ejecutor.executeQuery("select nombre, dia, tipo  from comidas where codigo_dia = " + cd);

            String texto = "";

            while (respuesta.next()) {

                texto = texto + respuesta.getString("tipo") + " del dia " + respuesta.getString("dia") + " es " + respuesta.getString("nombre") + "\n\n";
                //"El MENU del DIA " + diasSemana[cd - 1] +
            }

            JOptionPane.showMessageDialog(null, texto);

        } catch (Exception e) {

            JOptionPane.showInternalMessageDialog(null, "error al conectar \n" + e);

        }

    }

    // METODOS ESPECIALES PARA LOS PENSIONADOS
    public void opcionesPensionado() {

        System.out.println("\n1. getFoodDay \n2. getState \n3. solicitarCambio \n4. getHistorial \n5. showMenu \n6. SALIR ");

    }

    //CALENDAR STATUS MODEL
    public void updateStatusSunday() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection conesion = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");

            Calendar calendar = Calendar.getInstance();
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            if (dayOfWeek == 1) {

                for (int i = 1; i < 19; i++) {

                    String comando = "Update comidas set estado = ? where codigo_dia = " + i;
                    PreparedStatement declaracion = conesion.prepareStatement(comando);

                    declaracion.setString(1, "Servido");

                    int resultado = declaracion.executeUpdate();
                    if (resultado > 0 && i == 18) {

                        JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente");

                    }

                }

            }

        } catch (Exception e) {

            JOptionPane.showInternalMessageDialog(null, "error al conectar \n" + e);

        }

    }

    //SELECT UPDATE MENU MODEL
    public void setMenuDay() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection conesion = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");

            int apartamento = Integer.parseInt(JOptionPane.showInputDialog("¿Que apartamento desea modificar?"));

            int food = Integer.parseInt(JOptionPane.showInputDialog("¿Que comida va a modificar? \n\n1. Desayuno \n2. Almuerzo \n3. Cena"));

            if (apartamento == 4) {

                JOptionPane.showMessageDialog(null, "Puedes cambiar el estado del " + stockFood[food - 1] + " de estos pensionados: ");

                Statement ejecutor = conesion.createStatement();
                ResultSet respuesta = ejecutor.executeQuery("select nombre, id_apart from usuario where apartamento = " + apartamento);

                String texto = "";

                while (respuesta.next()) {

                    texto = texto + respuesta.getString("id_apart") + ". " + respuesta.getString("nombre") + "\n\n";

                }

                JOptionPane.showMessageDialog(null, texto);

            }

            if (food == 1) {

                int pension_id = Integer.parseInt(JOptionPane.showInputDialog("¿Cual va a escoger?"));
                String comando = "Update usuario set desayuno = ? where id_apart = " + pension_id;

                PreparedStatement declaracion = conesion.prepareStatement(comando);
                
                int eleccion = Integer.parseInt(JOptionPane.showInputDialog("¿Se le servira o no? \n1. SI \n2. NO"));
                
                if (eleccion == 1) {
                    
                    declaracion.setString(1, "SERVIR");
                    
                } else{
                    
                    declaracion.setString(1, "NO SERVIR");
                
                }

                

                int resultado = declaracion.executeUpdate();
                if (resultado > 0) {

                    JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente. El ");

                }

            }

            String comando = "Update usuario set desayuno = ?, almuerzo = ?, cena = ? where apartamento = " + apartamento;

        } catch (Exception e) {

            JOptionPane.showInternalMessageDialog(null, "error al conectar \n" + e);

        }

    }
}
