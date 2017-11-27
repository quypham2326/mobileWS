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
public class tblMobileDAO implements Serializable {

    public int checkLogin(String username, int password) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int role = 0;
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                String sql = "Select * From tbl_User Where UserID =? and password=?";
                stm = con.prepareStatement(sql);

                stm.setString(1, username);
                stm.setInt(2, password);

                rs = stm.executeQuery();
                if (rs.next()) {
                    role = rs.getInt("role");
                }
            }//end if
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return role;
    }
    List<tblMobileDTO> listDevice;

    public List<tblMobileDTO> getListDevice() {
        return listDevice;
    }

    public void searchDevice(String searchValue) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                String sql = "Select * From tbl_Mobile Where mobileName Like ? or mobileID Like ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                stm.setString(2, "%" + searchValue + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String mobileID = rs.getString("mobileID");
                    String descript = rs.getString("description");
                    float price = rs.getFloat("price");
                    String name = rs.getString("mobileName");
                    int yop = rs.getInt("yearofProduction");
                    int quantity = rs.getInt("quantity");
                    boolean notSale = rs.getBoolean("notSale");

                    tblMobileDTO dto = new tblMobileDTO(mobileID, descript, price, name, yop, quantity, notSale);
                    System.out.println("" + dto.getMobilename());
                    if (listDevice == null) {
                        listDevice = new ArrayList<>();
                    }
                    listDevice.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

    }

    public boolean deleteMobile(String mobileID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                String sql = "Delete From tbl_Mobile Where mobileID =?";
                stm = con.prepareStatement(sql);

                stm.setString(1, mobileID);

                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }//end if 
        } catch (Exception e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return false;
    }

    public boolean updateMobile(String mobileID, String descript, float price, int quantity, boolean notSale) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                String sql = "Update tbl_Mobile "
                        + "Set description=?,price=?,quantity=?,notSale=? "
                        + "Where mobileID=? ";
                stm = con.prepareStatement(sql);
                stm.setString(1,descript);
                stm.setDouble(2,price);
                stm.setInt(3,quantity);
                stm.setBoolean(4,notSale);
                stm.setString(5,mobileID);
                
                int row=stm.executeUpdate();
                if(row>0)
                    return true;
            }//end if 
        } catch (Exception e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    public boolean creatMobile (String mobileID,String descript, float price, String mobileName
            ,int yearofPro , int quantity,boolean check) throws SQLException,NamingException{
        Connection con=null;
        PreparedStatement stm=null;
        try {
            con=DBUtilities.makeConnection();
            if(con!=null){
                String sql="Insert into tbl_Mobile(mobileID,description,price,mobileName,yearofProduction,quantity,notSale)"
                        + " Values(?,?,?,?,?,?,?)";
                stm=con.prepareStatement(sql);
                stm.setString(1, mobileID);
                stm.setString(2, descript);
                stm.setFloat(3, price);
                stm.setString(4, mobileName);
                stm.setInt(5, yearofPro);
                stm.setInt(6, quantity);
                stm.setBoolean(7, check);
                
                int row=stm.executeUpdate();
                if (row>0)
                    return true;
            }//end if
        } catch (Exception e) {
        }finally{
            if(stm !=null)
                stm.close();
            if(con!=null){
                con.close();
                
            }
        }
        
        return false;
    }
}
