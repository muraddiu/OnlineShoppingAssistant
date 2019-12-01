/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.osa.java;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.util.List;
public class CartPDF {
       public void makePDF(List<CartModel> cartItem) throws FileNotFoundException, DocumentException {
	  Document document = new Document();
	  PdfPTable table = new PdfPTable(new float[] { 2, 1, 2 });
	  table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
	  table.addCell("Name");
          table.addCell("Age");
          table.addCell("Location");
	  table.setHeaderRows(1);
	  PdfPCell[] cells = table.getRow(0).getCells(); 
	  for (int j=0;j<cells.length;j++){
	     cells[j].setBackgroundColor(BaseColor.GRAY);
	  }
          for (int i=0;i<cartItem.size();i++){
             table.addCell("Location:"+i);
    	     table.addCell("Name:"+cartItem.get(i).getName());
             table.addCell("Age:"+cartItem.get(i).getPrice());
             
          }
        
	  PdfWriter.getInstance(document, new FileOutputStream("pdf/sample3.pdf"));
	  document.open();
          document.add(table);
	  document.close();
	  System.out.println("Done");
      }
} 