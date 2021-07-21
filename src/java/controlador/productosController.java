
package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.productos;
import modelo.productosDAO;



@WebServlet(name = "productosController", urlPatterns = {"/productosController"})
public class productosController extends HttpServlet {

  

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
            productosDAO productosDAO = null;
        try {
            productosDAO = new productosDAO();
        } catch (SQLException ex) {
            Logger.getLogger(productosController.class.getName()).log(Level.SEVERE, null, ex);
        }
            String  accion;
            RequestDispatcher dispatcher = null;
            accion = request.getParameter("accion");
            
            if(accion == null || accion.isEmpty()){
                dispatcher = request.getRequestDispatcher("Productos/index.jsp");
                List<productos> listaproductos = productosDAO.listarproductos();       
                request.setAttribute("lista", listaproductos);
            } else if("nuevo".equals(accion)){
               dispatcher = request.getRequestDispatcher("Productos/nuevo.jsp");
            }else if("insertar".equals(accion)){
                
                String codigo = request.getParameter("codigo");
                String nombre = request.getParameter("nombre");
                Double precio = Double.parseDouble(request.getParameter("precio"));
                int existencia = Integer.parseInt(request.getParameter("existencia"));
                
                productos prodcuto = new productos(0, codigo, nombre, precio, existencia);
                
                productosDAO.insertar(prodcuto);               
               dispatcher = request.getRequestDispatcher("Productos/index.jsp");
               List<productos> listaproductos = productosDAO.listarproductos();       
                request.setAttribute("lista", listaproductos);
            }
            else if("modificar".equals(accion)){
               dispatcher = request.getRequestDispatcher("Productos/modificar.jsp");
               int id = Integer.parseInt(request.getParameter("id"));
               productos producto = productosDAO.mostrarproductos(id);
               request.setAttribute("producto", producto);
            }
            else if("actualizar".equals(accion)){
                int id = Integer.parseInt(request.getParameter("id"));
                String codigo = request.getParameter("codigo");
                String nombre = request.getParameter("nombre");
                Double precio = Double.parseDouble(request.getParameter("precio"));
                int existencia = Integer.parseInt(request.getParameter("existencia"));
                
                productos producto = new productos(id, codigo, nombre, precio, existencia);
                
                productosDAO.actualizar(producto);               
               dispatcher = request.getRequestDispatcher("Productos/index.jsp");
               List<productos> listaproductos = productosDAO.listarproductos();       
                request.setAttribute("lista", listaproductos);
            }
             else if("eliminar".equals(accion)){
                int id = Integer.parseInt(request.getParameter("id"));                          
                productosDAO.eliminar(id);               
               dispatcher = request.getRequestDispatcher("Productos/index.jsp");
               List<productos> listaproductos = productosDAO.listarproductos();       
                request.setAttribute("lista", listaproductos);
            }           
             else{
             dispatcher = request.getRequestDispatcher("Productos/index.jsp");
                List<productos> listaproductos = productosDAO.listarproductos();       
                request.setAttribute("lista", listaproductos);
             }     
            dispatcher.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
