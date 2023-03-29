
package poo.practica;

import java.sql.*;


public class Conexion{
    
    public Connection Conectar(){
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error /n"+e);
        }
        return null;
    }
    
    public boolean addDatabase(String nombre, String apellido) {
        try{
            
            Connection cn = Conectar();
            PreparedStatement pst = cn.prepareStatement("insert into usuario values(?,?,?)");
            
            pst.setString(1, "0");
            pst.setString(2, nombre);
            pst.setString(3, apellido);
            //pst.setString(4, contraseña)
            pst.executeUpdate();
            
            return true;
            
        }catch (Exception e){
            
            System.out.println(e.toString());
            return false;
        }
    }
}
