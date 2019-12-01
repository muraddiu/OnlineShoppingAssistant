package com.osa.servlet;

import com.osa.java.UrlConnector;
import com.osa.java.model.Item;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Manage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                
            Document doc = UrlConnector.url(request.getParameter("search"));
            if(doc == null){
                System.out.println("reached doc");
                response.sendRedirect("underprocess");
            }else{
            String title = doc.title();
            System.out.println(title);
            Elements links = doc.select("span.name");
            Elements images = doc.select(".sku>.link>.image-wrapper .image");
            
            List<String> imageList = new ArrayList<String>();
            
            Elements prices = doc.select("span[data-price]");
            HttpSession sesson = request.getSession();
            
            RequestDispatcher requestDispatcher; 
            requestDispatcher = request.getRequestDispatcher("/products.jsp"); 
            
            List <Item> ProductList = new ArrayList <Item>();
            int j=0;
            for(int i=0;i<links.size();i++){
                String product = links.get(i).text();
                String price = prices.get(i).text();
                String image;
                while(true){
                    String[] imagePath = images.get(j).attr("src").split(":");
                    if("https".equals(imagePath[0])){
                        image = images.get(j).attr("src");
                        ProductList.add(new  Item(product,image,price));
                        imageList.add(image);
                        j++;
                        break;
                    }else{
                        j++;
                    }
                }
            }
            sesson.setAttribute("products", ProductList);
            //request.setAttribute("ProductList", ProductList);
            requestDispatcher.forward(request, response);
                
        }}
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
