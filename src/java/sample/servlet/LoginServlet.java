/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.ws1dao.tblMobileDAO;

/**
 *
 * @author HP
 */
public class LoginServlet extends HttpServlet {
private  final String staffPage="staffsearch.jsp";
private  final String managerPage="userSearch.jsp";
private  final String invalidPage="invalid.html";
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
        String username=request.getParameter("txtUsername");
        int password=Integer.parseInt(request.getParameter("txtPassword"));
        String url=invalidPage;
        try  {
            tblMobileDAO dao = new tblMobileDAO();
            int role=dao.checkLogin(username, password);
            if(role==0){
                url=managerPage;
                 Cookie cookies = new Cookie(username, String.valueOf(password));
                cookies.setMaxAge(60 * 3);
                response.addCookie(cookies);
                HttpSession session = request.getSession();
                session.setAttribute("USERNAME", username);
            }else if (role==2||role==1){
                url=staffPage;
                Cookie cookie=new Cookie(username, String.valueOf(password));
                cookie.setMaxAge(60*3);
                response.addCookie(cookie);
                HttpSession session=request.getSession();
                session.setAttribute("USERNAME", username);
            }
            
        } catch (SQLException ex) {
            log("LOGINSERVLET_ERRSQL"+ex.getMessage());
        } catch (NamingException ex) {
            log("LOGINSERVLET_ERRNaming"+ex.getMessage());
        }finally{
            response.sendRedirect(url);
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
