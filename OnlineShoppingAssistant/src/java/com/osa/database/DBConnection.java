package com.osa.database;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
    static Connection conn = null;
    public static Connection connector(){
        try{System.out.println("ok");
            String url ="jdbc:mysql://127.0.0.1:3306/osa";
            String user ="root";
            String pass ="";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pass);
            System.out.println("connected");
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
