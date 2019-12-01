package com.osa.servlet;

import com.osa.database.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Solaiman
 */
public class UserRegistration extends HttpServlet {
            Connection conn;
            PreparedStatement pst;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
          String email,password,name,address,phone,birthday;
          email = request.getParameter("email");
          password = request.getParameter("password");
          name = request.getParameter("name");
          address = request.getParameter("address");
          phone = request.getParameter("phone");
          birthday = request.getParameter("birth-day");
          
          //out.print(email+password+name+address+phone+birthday);
          
          try{
              conn = DBConnection.connector();
              pst = conn.prepareStatement("insert into myusers (email,password,name,address,phone,birthday) values (?,?,?,?,?,?)");
              pst.setString(1, email);
              pst.setString(2, password);
              pst.setString(3, name);
              pst.setString(4, address);
              pst.setString(5, phone);
              pst.setString(6, birthday);
              int a = pst.executeUpdate();
              
              if(a>0){
                  out.print("Update successfull");
                  pst.close();
                  String tname =email.replaceAll("[^a-zA-Z0-9]", "");
                  out.print(tname);
                  String sql = "CREATE TABLE "+ tname  +
                   "(id INTEGER not NULL auto_increment, " +
                   " image VARCHAR(255), " + 
                   " pname VARCHAR(50), " + 
                   " price varchar(10), " + 
                   " PRIMARY KEY ( id ))"; 
                  pst=conn.prepareStatement(sql);
                  a = pst.executeUpdate();
                  pst.close();
                  response.sendRedirect("logIn.jsp");
              }else{
                  
                  out.print("Update faild");
              }
          }catch(Exception e){
              e.printStackTrace();
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
