/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.osa.servlet;

import com.osa.database.DBConnection;
import com.osa.java.model.Item;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CartHandler extends HttpServlet {
    
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String sposition = request.getParameter("position");
            int position = Integer.parseInt(sposition);
            out.println(position);
            HttpSession session = request.getSession();
            String name = (String) session.getAttribute("username");
            if(name == null){
                response.sendRedirect("logIn.jsp");
            }else{
            List <Item> list = (List) session.getAttribute("products");
            out.println();
            String tName = (String) session.getAttribute("tName");
            tName = tName.replaceAll("[^a-zA-Z0-9]", "");
            out.print(list.get(position).getPimage());
            conn = DBConnection.connector();
            pst = conn.prepareStatement("insert into "+tName+" (image,pname,price) values (?,?,?)");
            pst.setString(1,list.get(position).getPimage());
            pst.setString(2,list.get(position).getPname());
            pst.setString(3,list.get(position).getPprice());
            int a = pst.executeUpdate();
            pst.close();
            response.sendRedirect("profile.jsp");
            
            
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
            try {
                processRequest(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(CartHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            try {
                processRequest(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(CartHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
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
