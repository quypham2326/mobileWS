/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.cart.CartObj;
import sample.ws1dao.CreateMobileError;
import sample.ws1dao.tblMobileDAO;
import sample.ws1dao.tblUserDAO;

/**
 *
 * @author HP
 */
public class UserPayServlet extends HttpServlet {
private  final String searchPage="userSearch.jsp";
private  final String viewCart="ViewCart.jsp";
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
        String mobileID;
            int quantity;
            boolean err=false;
            int count=0;
            CreateMobileError errors=new CreateMobileError();
            String url=viewCart;
        try  {
            HttpSession session=request.getSession();
            String userid=session.getAttribute("USERNAME").toString();
            tblUserDAO dao=new tblUserDAO();
            CartObj cart=(CartObj)session.getAttribute("CART");
            if(cart!=null){
                Map<String,Integer> items=cart.getItems();
                if(items!=null){
                    for (Map.Entry<String,Integer> item : items.entrySet()) {
                        mobileID=item.getKey();
                        quantity=item.getValue();
                        boolean result=dao.checkItemExist(mobileID, quantity);
                        if(result){
                            
                        }else{
                            count++;
                            err=true;
                            errors.setAddItemstoCartErr(mobileID+" is out of store");
                            break;
                        }
                    }
                    if(count != 1){
                        for (Map.Entry<String,Integer> item : items.entrySet()) {
                            mobileID=item.getKey();
                            quantity=item.getValue();
                            boolean result=false;
                             result=dao.saveBillUser(userid, mobileID, quantity);
                            if(result){
                                err=false;
                                session.removeAttribute("CART");
                            }
                        }
                    }
                }
                if(err){
                    request.setAttribute("CREATEERROR", errors);
                    
                }else{
                    url=searchPage;
                }
            }
        } catch (SQLException ex) {
             log("UserPayServlet_ERRSQL"+ex.getMessage());
        } catch (NamingException ex) {
           log("UserPayServlet_ERRNAMING"+ex.getMessage());
        }finally{
            RequestDispatcher rd= request.getRequestDispatcher(url);
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
