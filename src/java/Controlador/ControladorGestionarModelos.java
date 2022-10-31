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
public class ControladorGestionarModelos extends HttpServlet {

    Modelo m = new Modelo();
    ModeloDAO mDAO = new ModeloDAO();
    int skuM;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String menu = request.getParameter("menu");
            String accion = request.getParameter("accion");
            
            if(menu.equals("modelos")){                
                switch(accion){
                    case "Listar":
                        List lista = mDAO.listar();
                        request.setAttribute("modelos", lista);
                        request.getRequestDispatcher("modelos.jsp").forward(request, response);
                        break;
                    case "Agregar":
                        int sku = Integer.parseInt(request.getParameter("txtSKU"));
                        String den = request.getParameter("txtDenominacion");
                        int lir = Integer.parseInt(request.getParameter("txtLIR"));
                        int lsr = Integer.parseInt(request.getParameter("txtLSR"));
                        int lio = Integer.parseInt(request.getParameter("txtLIO"));
                        int lso = Integer.parseInt(request.getParameter("txtLSO"));
                        m.setSku(sku);
                        m.setDenominacion(den);
                        m.setLimiteInferiorReproceso(lir);
                        m.setLimiteSuperiorReproceso(lsr);
                        m.setLimiteInferiorObservado(lio);
                        m.setLimiteSuperiorObservado(lso);
                        //m = new Modelo(sku, den, lir, lsr, lio, lso);
                        mDAO.agregar(m);
                        request.getRequestDispatcher("ControladorGestionarModelos?menu=modelos&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        skuM = Integer.parseInt(request.getParameter("sku"));
                        Modelo me = mDAO.listarSKU(skuM);
                        request.setAttribute("modelo", me);
                        
                        request.getRequestDispatcher("ControladorGestionarModelos?menu=modelos&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        int sKu = Integer.parseInt(request.getParameter("txtSKU"));
                        String dEn = request.getParameter("txtDenominacion");
                        int lIr = Integer.parseInt(request.getParameter("txtLIR"));
                        int lSr = Integer.parseInt(request.getParameter("txtLSR"));
                        int lIo = Integer.parseInt(request.getParameter("txtLIO"));
                        int lSo = Integer.parseInt(request.getParameter("txtLSO"));
                        
                        m.setSku(sKu);
                        m.setDenominacion(dEn);
                        m.setLimiteInferiorReproceso(lIr);
                        m.setLimiteSuperiorReproceso(lSr);
                        m.setLimiteInferiorObservado(lIo);
                        m.setLimiteSuperiorObservado(lSo);
                        mDAO.actualizar(m);
                        request.getRequestDispatcher("ControladorGestionarModelos?menu=modelos&accion=Listar").forward(request, response);
                        break;
                    case "Eliminar":
                        skuM = Integer.parseInt(request.getParameter("sku"));
                        mDAO.eliminar(skuM);
                        request.getRequestDispatcher("ControladorGestionarModelos?menu=modelos&accion=Listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
                //request.getRequestDispatcher("modelos.jsp").forward(request, response);
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
