package com.osa.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteCart {
    static Connection conn;
    static PreparedStatement pst;
    public static void delete(String name){
        try{
            conn = DBConnection.connector();
            pst = conn.prepareStatement("TRUNCATE "+name);
            pst.executeUpdate();
        }catch(Exception e){
            
        }finally{
            try {
                conn.close();
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(DeleteCart.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
