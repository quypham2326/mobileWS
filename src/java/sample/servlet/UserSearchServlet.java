/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.ws1dao.tblMobileDTO;
import sample.ws1dao.tblUserDAO;

/**
 *
 * @author HP
 */
public class UserSearchServlet extends HttpServlet {
private final String usersearch="userSearch.jsp";
private  final String invalidsearch="manager.html";
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
        PrintWriter out = response.getWriter();
        String searchValueBegin=request.getParameter("txtSearchBegin");
        String searchValueEnd=request.getParameter("txtSearchEnd");
        String url="";
//         float begin=Float.parseFloat(searchValueBegin);
//           float end=Float.parseFloat(searchValueEnd);
          
        try {
//           if(begin>end || (begin<0&&end<0)){
//               url=invalidsearch;
//           }
          
                tblUserDAO dao= new tblUserDAO();
               dao.searchByUser(searchValueBegin, searchValueEnd);
               List<tblMobileDTO> result=dao.getList();
               request.setAttribute("SEARCH", result);
               url=usersearch;
           
           
            
        }
    catch (SQLException ex) {
         log("UserSearchServlet_ERRSQL"+ex.getMessage());
    } catch (NamingException ex) {
        log("UserSearchServlet_ERRNAMINGEX"+ex.getMessage());
    }           finally{
            RequestDispatcher rd=request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
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
