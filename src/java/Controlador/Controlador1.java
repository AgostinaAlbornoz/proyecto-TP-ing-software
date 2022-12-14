/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ClasesBD.ModeloDAO;
import Modelo.Modelo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabri
 */
public class Controlador1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador1 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            String menu = request.getParameter("menu");
            String accion = request.getParameter("accion");
            
            if(menu.equals("principal")){
                request.getRequestDispatcher("principal.jsp").forward(request, response);
            }
            if(menu.equals("modelos")){
                Modelo mode = new Modelo();
                ModeloDAO mDAO = new ModeloDAO();
                request.getRequestDispatcher("modelos.jsp").forward(request, response);
                switch(accion){
                    case "Listar":
                        List lista = mDAO.listar();
                        request.setAttribute("modelos", lista);
                        break;
                        
                    case "Agregar":
                        
                        break;
                    case "Actualizar":
                        break;
                    case "Eliminar":
                        break;
                    default:
                        throw new AssertionError();
                }
            }
            if(menu.equals("OP")){
                request.getRequestDispatcher("OP.jsp").forward(request, response);
            }
            if(menu.equals("colores")){
                request.getRequestDispatcher("colores.jsp").forward(request, response);
            }
            if(menu.equals("semaforo")){
                request.getRequestDispatcher("semaforo.jsp").forward(request, response);
            }
            if(menu.equals("usuario")){
                request.getRequestDispatcher("usuario.jsp").forward(request, response);
            }
        
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
