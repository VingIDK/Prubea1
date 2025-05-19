/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;
import java.sql.*;

/**
 *
 * @author Hp
 */
public class ConexionLogin {
    String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url="jdbc:sqlserver://localhost:1433;databaseName=Login";
    String user="sa";
    String pass="12345678";
    
    ConexionLogin(){}  
    
    public Connection conectar(){      
        Connection cn = null;
        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(url, user, pass);
            System.out.println("Conectado");
        } catch (Exception e) {
           System.out.println("Error "+e.getLocalizedMessage());
        }
        
        return cn;
    }  

    public void CerrarConexion(Connection con){
        try {
            con.close();
        } catch (Exception e) {
             System.out.println("Error "+e);
        }
    }
    
    public void Ingreso(String Usuario, String Contraseña,String msj  ) throws SQLException
    {
       Connection conx =  conectar();
       
       PreparedStatement pt = conx.prepareStatement("Execute Ingreso ?,?,?");
       pt.setString(1,Usuario);
       pt.setString(2,Contraseña);
       pt.setString(3,msj);
       pt.execute();
       CerrarConexion(conx);
    }
}
