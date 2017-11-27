/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.ws1dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import sample.utilities.DBUtilities;

/**
 *
 * @author HP
 */
public class tblUserDAO implements Serializable{
    
    List<tblMobileDTO> list;

    public List<tblMobileDTO> getList() {
        return list;
    }
    
    
    public void searchByUser(String min,String max) throws SQLException,NamingException{
        Connection con=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        try {
           
            con=DBUtilities.makeConnection();
            if(con!=null){
                String sql="Select * From tbl_Mobile Where  price Between ? and ?";
                stm=con.prepareStatement(sql);
                stm.setString(1, min);
                stm.setString(2, max);
                
                rs=stm.executeQuery();
                 while (rs.next()) {
                    String mobileID = rs.getString("mobileID");
                    String descript = rs.getString("description");
                    float price = rs.getFloat("price");
                    String name = rs.getString("mobileName");
                    int yop = rs.getInt("yearofProduction");
                    int quantity = rs.getInt("quantity");
                    boolean notSale = rs.getBoolean("notSale");
                    
                    tblMobileDTO dto=new tblMobileDTO(mobileID, descript, price, mobileID, yop, quantity, notSale);
                    if(list==null){
                        list=new ArrayList<>();
                    }
                 
                    list.add(dto);
                    
                 }
                
            }//end if
        } catch (Exception e) {
        }finally{
            if(rs!=null)
                rs.close();
            if(stm!=null)
                stm.close();
            if(con!=null)
                con.close();
        }
      
    }
    public boolean checkItemExist (String mobileID, int quantity) throws SQLException,NamingException{
        Connection con=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        try {
            con=DBUtilities.makeConnection();
            if(con!=null){
                String sql="Select quantity From tbl_Mobile Where mobileID=? ";
                stm=con.prepareStatement(sql);
                stm.setString(1, mobileID);
                rs=stm.executeQuery();
                if(rs.next()){
                    if(rs.getInt("quantity")<quantity)
                        return false;
                    else
                        return true;
                }
            }
        } catch (Exception e) {
        }finally{
            if(rs!=null)
                rs.close();
            if(stm!=null)
                stm.close();
            if(con!=null)
                con.close();
        }
        return false;
    }
    public boolean saveBillUser(String userID,String mobileID,int quantity) throws SQLException,NamingException{
        Connection con=null;
        PreparedStatement stmGetQuantity=null;
        PreparedStatement stmInsert=null;
        PreparedStatement stmUpdate=null;
        ResultSet rs=null;
        try {
            con=DBUtilities.makeConnection();
           if(con!=null){
               String sqlInsertBill="INSERT INTO tbl_UserPay(userID,mobileID,quantity) Values(?,?,?)";
               String sqlUpdateMobiletbl="Update tbl_Mobile "
                        + "Set quantity=? "
                        + "Where mobileID=? ";
               String sqlGetQuantity="Select quantity From tbl_Mobile Where mobileID=? ";
               stmGetQuantity=con.prepareStatement(sqlGetQuantity);
               stmGetQuantity.setString(1, mobileID);
               rs=stmGetQuantity.executeQuery();
               if(rs.next()){
                   int quantityOntbl=rs.getInt("quantity");
                   int result=quantityOntbl-quantity;
                   stmInsert=con.prepareStatement(sqlInsertBill);
                   stmInsert.setString(1, userID);
                   stmInsert.setString(2, mobileID);
                   stmInsert.setInt(3, quantity);
                   
                   int row=stmInsert.executeUpdate();
                   
                   if(row>0){
                       return true;
                   }
                   stmUpdate=con.prepareStatement(sqlUpdateMobiletbl);
                   stmUpdate.setInt(1,result);
                   stmUpdate.setString(2, mobileID);
                  int rowUpdate=stmUpdate.executeUpdate();
                  if(rowUpdate>0)
                      return true;
                   
               }//if isert
               
           }//end if
        } catch (Exception e) {
        }finally{
           if(rs!=null)
                rs.close();
            if(stmGetQuantity!=null)
                stmGetQuantity.close();
            if(stmInsert!=null)
                stmInsert.close();
            if(stmUpdate!=null)
                stmUpdate.close();
            if(con!=null)
                con.close();
        }
        return false;
    }
}
