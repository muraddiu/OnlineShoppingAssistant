package com.osa.java;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ConnectDaraz {

    private String name = null;
    private String color = null;
    private String price = null;

    public ConnectDaraz(String n, String c, String p) {
        this.name = n;
        this.color = c;
        this.price = p;
    }

    public Document search() {
        Document doc = null;
        
        if ((price != null) && (color != null)) {

            try {
                String pageUrl = "https://www.daraz.com.bd/catalog/?q=" + color + "%20" + name + "&price=" + price;
                System.out.println(pageUrl);
                doc = Jsoup.connect(pageUrl).get();
            } catch (IOException ex) {
                Logger.getLogger(UrlConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(color !=null) {

            try {
                doc = Jsoup.connect("https://www.daraz.com.bd/catalog/?q="+color+" "+ name).get();
            } catch (IOException ex) {
                Logger.getLogger(UrlConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                doc = Jsoup.connect("https://www.daraz.com.bd/catalog/?q="+ name).get();
            } catch (IOException ex) {
                Logger.getLogger(UrlConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

        return doc;
    }

}
