/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sample.ws1dao.tblMobileDTO;

/**
 *
 * @author HP
 */
public class CartObj implements Serializable{
    private String username;
    private Map<String, Integer> items;

    public CartObj() {
    }

    public CartObj(String username, Map<String, Integer> items) {
        this.username = username;
        this.items = items;
    }

   

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
   
          /**
     * @return the items
     */
    public Map<String, Integer> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(Map<String, Integer> items) {
        this.items = items;
    }
    
    public void adddItems(String title){
        if(this.items==null){
            this.items=new HashMap<>();
        }
        int quantity=1;
        if(this.items.containsKey(title)){
            quantity=this.items.get(title)+1;
        }
        this.items.put(title, quantity);
    }
    
    public void removeItems(String title){
        if(this.items == null){
            return;
        }
        if(this.items.containsKey(title)){
            this.items.remove(title);
            if(this.items.isEmpty()){
                this.items=null;
            }
        }
    }
}
