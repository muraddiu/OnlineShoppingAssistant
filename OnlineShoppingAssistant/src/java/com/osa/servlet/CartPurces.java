/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.osa.servlet;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.osa.java.CartModel;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartPurces extends HttpServlet {

    private final Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private final Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private final Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException, DocumentException {
        response.setContentType("text/html;charset=UTF-8");
        //response.setContentType("application/pdf");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CartPurces</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Please wait....</h1>");
            HttpSession session = request.getSession();
            List<CartModel> cartItem = new ArrayList();
            String pdfName = (String) session.getAttribute("table");
            cartItem = (List<CartModel>) session.getAttribute("cartList");
            //  out.println(pdfName);

            Document document = new Document();
            document.addAuthor("Onlineshoppingassistant.com");
            document.addTitle("Your order");

            PdfWriter.getInstance(document, new FileOutputStream(request.getServletContext().getRealPath("pdf/" + pdfName + ".pdf")));
            document.open();

            Anchor anchor = new Anchor("Online Shopping Assistant", catFont);
            anchor.setName("Online Shopping Assistant");
            Chapter catPart = new Chapter(new Paragraph(anchor), 1);

            Paragraph subPara = new Paragraph("www.onlineshoppingassistant.com");
            Section subCatPart = catPart.addSection(subPara);
            subCatPart.add(new Paragraph("You have to show this on delivery time"));

            subPara = new Paragraph("contact:", redFont);
            subCatPart = catPart.addSection(subPara);
            subCatPart.add(new Paragraph("smensulaiman@gmail.com"));
            subCatPart.add(new Paragraph("+880 1914667359"));
            subCatPart.add(new Paragraph(" \n"));
            subCatPart.add(new Paragraph(" \n"));

            Paragraph paragraph = new Paragraph();
            //addEmptyLine(paragraph, 5);
            subCatPart.add(paragraph);

            // add a table
            // createTable(subCatPart);
            PdfPTable table = new PdfPTable(new float[]{2, 1, 2});
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell("Item");
            table.addCell("Age");
            table.addCell("Location");
            table.setHeaderRows(1);
            PdfPCell[] cells = table.getRow(0).getCells();
            for(int j = 0; j < cells.length; j++) {
                cells[j].setBackgroundColor(BaseColor.GRAY);
            }
            for (int i = 0; i < cartItem.size(); i++) {
                table.addCell("" + i);
                table.addCell(cartItem.get(i).getName());
                table.addCell(cartItem.get(i).getPrice());

            }
            catPart.add(table);
            document.add(catPart);
            document.close();
            out.println("Successfull...");
            
            session.setAttribute("file", pdfName);
            response.sendRedirect("download.jsp");
            
            out.println("</body>");
            
            out.println("</html>");
            
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
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(CartPurces.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(CartPurces.class.getName()).log(Level.SEVERE, null, ex);
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
