package com.osa.servlet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.osa.database.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateLogIn extends HttpServlet {

    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ValidateLogIn</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Please wait..." + "</h1>");
            out.println("</body>");
            out.println("</html>");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            try {
                conn = (Connection) DBConnection.connector();
                pst = (PreparedStatement) conn.prepareStatement("select * from myusers where email = ?");
                pst.setString(1, email);
                rs = pst.executeQuery();
                while (rs.next()) {
                    if (password.equals(rs.getString("password"))) {
                        out.write("your are connected");
                        RequestDispatcher requestDispatcher;

                        //request.setAttribute("username", username);
                        HttpSession session = request.getSession();

                        String path = (String) session.getAttribute("path");
                        out.println(path);
                        requestDispatcher = request.getRequestDispatcher(path);
                        session.setAttribute("username", rs.getString("name").toString());
                        session.setAttribute("tName",email);
                        requestDispatcher.forward(request, response);
                    }
                }
               // response.sendRedirect("logIn.jsp");

            } catch (SQLException e) {
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
