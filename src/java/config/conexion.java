
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    

public Connection getconexion() throws SQLException {
         
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/almacen? useSSl=false ?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT", "root", "matias1998");
           
          return conexion;
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
             
              } 
              
       return  null;
}
}
