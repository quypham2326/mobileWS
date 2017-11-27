/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.ws1dao.CreateMobileError;
import sample.ws1dao.tblMobileDAO;

/**
 *
 * @author HP
 */
public class CreateMobileServlet extends HttpServlet {
 private final String searchPage = "staffsearch.jsp";
    private final String insertERR = "staffCreateMobile.jsp";
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
        String mobileID = request.getParameter("txtmobileId");
        String descript = request.getParameter("txtDescript");
        String price = request.getParameter("txtPrice");
        String mobileName = request.getParameter("txtmobileName");
        String yop = request.getParameter("txtYOP");
        String quantity = request.getParameter("txtQuantity");
        String notSale = request.getParameter("chkSale");
        float pricemb=0;
        int quantitymb=0;
        int yopmb=0;
        
        boolean checkSale = false;
        if (notSale != null) {
            checkSale = true;
        }
        boolean checkErr = false;
        
        
        String url = insertERR;
        CreateMobileError error = new CreateMobileError();
        
        try {
            
            if (mobileID.length() < 2 || mobileID.length() > 10) {
                checkErr = true;
                error.setMobileIdErrLength("The mobileID must have 2-10 characters");
            }
            if (descript.length() < 5 || descript.length() > 250) {
                checkErr = true;
                error.setDescriptErrLength("The description must have 5-250 characters");
            }
            if (!price.matches("\\d+[.]\\d+")) {
                checkErr = true;
                error.setPriceErr("The Price must be a double number. Example:1.0");
            }else{
                try {
                    pricemb=Float.parseFloat(price);
                } catch (Exception e) {
                }
            }
            if (mobileName.length() < 3 || mobileName.length() > 20) {
                checkErr = true;
                error.setMobileNameErrLength("The mobileName must have 3-20 characters");
            }
            if (!yop.matches("\\d{4}")) {
                checkErr = true;
                error.setYearofProductionErr("The Year of Production must be in format:yyyy");
            }else{
                 try {
                    yopmb=Integer.parseInt(yop);
                } catch (Exception e) {
                }
            }
            if (!quantity.matches("\\d+")) {
                checkErr = true;
                error.setQuantityErr("The Quantity must be a  number");
            }else{
                 try {
                    quantitymb=Integer.parseInt(quantity);
                } catch (Exception e) {
                }
            }

            if (checkErr) {
                request.setAttribute("CREATEERR", error);
            } else {
                System.out.println(""+mobileID);
                System.out.println(""+descript);
                System.out.println(""+pricemb);
                System.out.println(""+mobileName);
                System.out.println(""+yop);
                System.out.println(""+quantitymb);
                System.out.println(""+checkSale);
                tblMobileDAO dao = new tblMobileDAO();
                boolean result=dao.creatMobile(mobileID, descript, pricemb, mobileName, yopmb, quantitymb, checkSale);
                System.out.println("Result "+result);
                if(result)
                    
                    url=searchPage;
            }
        } catch (SQLException ex) {
            error.setMobileIDisExist(mobileID+" is Exist");
           request.setAttribute("CREATEERR", error);
            log("CreateMobileErrServlet_ERRSQL "+ex.getMessage());
        } catch (NamingException ex) {
            log("CreateMobileErrServlet_ERRNAMING "+ex.getMessage());
        } finally {
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
