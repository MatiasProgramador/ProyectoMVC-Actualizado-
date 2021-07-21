
package modelo;

import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class productosDAO {
    
    Connection conexion;
    
    public productosDAO() throws SQLException  {
    conexion con = new conexion();
     conexion = con.getconexion();
}
    public List<productos> listarproductos()
    {
        PreparedStatement ps;
        ResultSet rs;
        List<productos> lista = new ArrayList<>();
        
        try{
            ps = conexion.prepareStatement("SELECT id, codigo, nombre, precio, existencia FROM productos");
            rs = ps.executeQuery();
            
            while(rs.next()){
             int id = rs.getInt("id");
             String codigo = rs.getString("codigo");
             String nombre = rs.getString("nombre");
             Double precio = rs.getDouble("precio");
              int existencia = rs.getInt("existencia");
              
              productos productos = new productos(id, codigo, nombre, precio, existencia);
              lista.add(productos);
            }
            return lista;
        } catch(SQLException e){
            System.out.println(e.toString());
            return null;
        }
    }
    
   

     public productos mostrarproductos(int _id)
    {
        PreparedStatement ps;
        ResultSet rs;
        productos producto = null;
        
        try{
            ps = conexion.prepareStatement("Select id, codigo, nombre, precio, existencia from productos WHERE id=?");
            ps.setInt(1, _id);
            rs = ps.executeQuery();
            
            while(rs.next()){
             int id = rs.getInt("id");
             String codigo = rs.getString("codigo");
             String nombre = rs.getString("nombre");
             Double precio = rs.getDouble("precio");
              int existencia = rs.getInt("existencia");
              
              producto = new productos(id, codigo, nombre, precio, existencia);
              
            }
            return producto;
        } catch(SQLException e){
            System.out.println(e.toString());
            return null;
        }
    }
    
     public boolean insertar(productos producto)
    {
        PreparedStatement ps;     
        try{
            ps = conexion.prepareStatement("Insert into productos (codigo, nombre, precio, existencia) values (?,?,?,?)");
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getExistencia());
             ps.execute();
            return true;
        
        } catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }

 public boolean actualizar(productos producto)
    {
        PreparedStatement ps;     
        try{
            ps = conexion.prepareStatement("UPDATE  productos SET codigo=?, nombre=?, precio=?, existencia=? WHERE id=?");
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre()); 
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getExistencia());
            ps.setInt(5, producto.getId());
             ps.execute();
            return true;
        
        } catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }

 public boolean eliminar(int _id)
    {
        PreparedStatement ps;     
        try{
            ps = conexion.prepareStatement("DELETE FROM productos WHERE id=?");
            ps.setInt(1, _id);
             ps.execute();
            return true;
        
        } catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
}
