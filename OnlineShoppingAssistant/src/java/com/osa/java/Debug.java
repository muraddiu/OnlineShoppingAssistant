/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.osa.java;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Solaiman
 */
public class Debug {
    public void show(List<CartModel> cartItem) {
        CartPDF pdf =new CartPDF();
        
        for (int i=0;i<cartItem.size();i++){
            System.out.println("debug");
            System.out.println("Name:"+cartItem.get(i).getName());
            
        }
        try {
            pdf.makePDF(cartItem);
            System.out.println("ok");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Debug.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Debug.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    this  area is for debugging
    
    public static void main(String[] args) {
        CartPDF pdf =new CartPDF();
        List<CartModel> cartItem = new ArrayList();
        cartItem.add(new CartModel("hey","itz","me"));
        try {
            pdf.makePDF(cartItem);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Debug.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Debug.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}
