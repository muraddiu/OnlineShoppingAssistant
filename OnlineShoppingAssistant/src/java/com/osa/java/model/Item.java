package com.osa.java.model;

public class Item {
    private String Pname;
    private String Pimage;
    private String Pprice;

    public Item(String pname , String pimage,String pprice){
        this.Pname =pname;
        this.Pimage =pimage;
        this.Pprice =pprice;
    }
    public String getPname() {
        return Pname;
    }

    /**
     * @param Pname the Pname to set
     */
    public void setPname(String Pname) {
        this.Pname = Pname;
    }

    /**
     * @return the Pimage
     */
    public String getPimage() {
        return Pimage;
    }

    /**
     * @param Pimage the Pimage to set
     */
    public void setPimage(String Pimage) {
        this.Pimage = Pimage;
    }

    /**
     * @return the Pprice
     */
    public String getPprice() {
        return Pprice;
    }

    /**
     * @param Pprice the Pprice to set
     */
    public void setPprice(String Pprice) {
        this.Pprice = Pprice;
    }
    
}
