package com.osa.java;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class UrlConnector {

    private static String catalog = null;
    private static String name = null;
    private static String color = null;
    private static String price = null, firstPrice = null, secondPrice = null;

    private static String getColor(String text) {
        if (text.contains("red")) {

            color = "red";

        } else if (text.contains("white")) {

            color = "white";

        } else if (text.contains("black")) {

            color = "black";

        } else if (text.contains("white")) {

            color = "white";

        } else if (text.contains("blue")) {

            color = "blue";

        } else if (text.contains("green")) {

            color = "green";

        } else if (text.contains("yellow")) {

            color = "yellow";

        }else if (text.contains("phone")) {

            color = "phone";

        }else if (text.contains("mobile")) {

            color = "mobile";

        }else if (text.contains("laptop")) {

            color = "laptop";

        }else if (text.contains("computer")) {

            color = "computer";

        }else if (text.contains("tv")) {

            color = "tv";

        }
        else {
            color = null;
              }
        return color;
    }

    public static Document url(String text) {
        Document doc = null;
        if (text != null) {
            String temp = text;
            text = text.toLowerCase();
            name = getName(text);
            color = getColor(text);
            System.out.println(name);
            price = getPrice(temp);
            System.out.println(price);

        }
        if(name != null){
        
        ConnectDaraz cd = new ConnectDaraz(name, color, price);

        try {
            doc = cd.search();
        } catch (Exception e) {

        }
        }else{
            System.out.println("found null");
            doc =null;
        }

        return doc;

    }

    private static String getPrice(String temp) {
        String[] strArray = temp.split(" |-");
        boolean f = true, l = false;
        for (String p : strArray) {

            if (isStringNumeric(p)) {
                if (f) {
                    firstPrice = p;
                    l = true;
                    f = false;
                    continue;
                }
                if (l) {
                    secondPrice = p;
                    l = false;
                    break;
                }
            }

        }
        if ((secondPrice == null) && (firstPrice != null)) {
            secondPrice = firstPrice;
            firstPrice = "0";
            System.out.println("hey man");
        }
        String pattern = null;

        if ((firstPrice == null)&& (secondPrice == null)){
                    pattern = null;
        }else{
        
        pattern = firstPrice+"-"+secondPrice;
            }

        return pattern;
    }

    private static boolean isStringNumeric(String aString) {
        if (aString == null || aString.length() == 0) {
            return false;
        }
        for (char c : aString.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    /*
    
    public static void main(String[] args) {
        url("i need a black sunglass in range 100 to 200 taka");
    }
     */

    private static String getName(String text) {
        if (text.contains("sunglass") || text.contains("sunglasses")) {
            name = "sunglass";
        } else if (text.contains("shirt") || text.contains("shirts")) {
            name = "shirt";
        } else if (text.contains("pant") || text.contains("pants")) {
            name = "pant";
        } else if (text.contains("t-shirt") || text.contains("tshirt")) {
            name = "t-shirt";
        } else if (text.contains("watch") || text.contains("watches")) {
            name = "watch";
        } else if (text.contains("belt") || text.contains("belts")) {
            name = "belt";
        }else if (text.contains("coats") || text.contains("coat")) {
            name = "coat";
        }else if (text.contains("jacket") || text.contains("jackets")) {
            name = "jacket";
        }else if (text.contains("jeans") || text.contains("jean")) {
            name = "jean";
        }else if (text.contains("shoes") || text.contains("shoe")) {
            name = "shoes";
        }else if (text.contains("boots") || text.contains("boot")) {
            name = "boots";
        }else if (text.contains("hoodies") || text.contains("hoodie")) {
            name = "hoodie";
        }else if (text.contains("caps") || text.contains("cap")) {
            name = "cap";
        }else if (text.contains("bags") || text.contains("bag")) {
            name = "bag";
        }else if (text.contains("wallets") || text.contains("wallet")) {
            name = "wallet";
        }else if (text.contains("ties") || text.contains("tie")) {
            name = "tie";
        }else if (text.contains("saree") || text.contains("sarees")) {
            name = "saree";
        }else if (text.contains("shalwar-kameez") || text.contains("shalwar")|| text.contains("kameez")) {
            name = "shalwar";
        }else if (text.contains("lawns") || text.contains("lawn")) {
            name = "lawn";
        }else if (text.contains("lehengas") || text.contains("lehenga")) {
            name = "lehenga";
        }else if (text.contains("hijabs") || text.contains("hijab")) {
            name = "hijab";
        }else if (text.contains("borkas") || text.contains("borka")) {
            name = "borka";
        }else if (text.contains("earrings") || text.contains("earring")) {
            name = "earring";
        }else if (text.contains("ring") || text.contains("rings")) {
            name = "ring";
        }else if (text.contains("symphony")) {
            name = "symphony";
        }else if (text.contains("huawei")) {
            name = "huawei";
        }else if (text.contains("lg")) {
            name = "lg";
        }else if (text.contains("asus")) {
            name = "asus";
        }else if (text.contains("xiaomi")) {
            name = "xiaomi";
        }else if (text.contains("apple")) {
            name = "apple";
        }else if (text.contains("nokia")) {
            name = "nokia";
        }else if (text.contains("oneplus")) {
            name = "oneplus";
        }else if (text.contains("micromax")) {
            name = "micromax";
        }else if (text.contains("power-banks") || text.contains("power-bank")) {
            name = "power-bank";
        }else if (text.contains("memory-card") || text.contains("memory-card")) {
            name = "memory-card";
        }else if (text.contains("earphones") || text.contains("earphone")) {
            name = "earphone";
        }else if (text.contains("headsets") || text.contains("headset")) {
            name = "headset";
        }else if (text.contains("led-tvs") || text.contains("led-tv")) {
            name = "led-tv";
        }else if (text.contains("smart-tvs") || text.contains("smart-tv")) {
            name = "smart-tv";
        }else if (text.contains("3d-tv") || text.contains("3d-tvs")) {
            name = "3d-tv";
        }else if (text.contains("4k-tvs") || text.contains("4k-tv")) {
            name = "4k-tv";
        }else if (text.contains("projectors") || text.contains("projector")) {
            name = "projector";
        }else if (text.contains("dvd-player") || text.contains("dvd-players")) {
            name = "dvd-player";
        }else if (text.contains("smart-box") || text.contains("tv-card")) {
            name = "smart-box";
        }else if (text.contains("dslr")) {
            name = "dslr";
        }else if (text.contains("mp3-players") || text.contains("mp3-player")) {
            name = "mp3-player";
        }else if (text.contains("home-theater") || text.contains("home-theaters")) {
            name = "home-theater";
        }else if (text.contains("sony")) {
            name = "sony";
        }else if (text.contains("samsung")) {
            name = "samsung";
        }else if (text.contains("walton")) {
            name = "walton";
        }else if (text.contains("philips")) {
            name = "philips";
        }else if (text.contains("notebooks") || text.contains("notebook")) {
            name = "notebook";
        }else if (text.contains("jacket") || text.contains("jackets")) {
            name = "jacket";
        }else if (text.contains("macbooks") || text.contains("macbook")) {
            name = "macbook";
        }else if (text.contains("printer") || text.contains("laser-printer") || text.contains("office-printer")) {
            name = "printer";
        }else if (text.contains("external-hard-drives") || text.contains("hard-drives")|| text.contains("HD")|| text.contains("hard-disk")) {
            name = "hard-drive";
        }else if (text.contains("flash-drive") || text.contains("USB-flash-drive")|| text.contains("USB-pen-drive")|| text.contains("pen-drive")) {
            name = "flash-drive";
        }else if (text.contains("monitors") || text.contains("monitor")) {
            name = "monitor";
        }else if (text.contains("speakers") || text.contains("speaker")) {
            name = "speaker";
        }else if (text.contains("keyboard") || text.contains("keyboards")) {
            name = "keyboard";
        }else if (text.contains("mouses") || text.contains("mouse")) {
            name = "mouse";
        }else if (text.contains("lenovo")) {
            name = "lenovo";
        }else if (text.contains("hp")) {
            name = "hp";
        }else if (text.contains("washing-machines") || text.contains("washing-machine")) {
            name = "washing-machine";
        }else if (text.contains("air-conditioner") || text.contains("air-conditioners")|| text.contains("ac")) {
            name = "air-conditioners";
        }else if (text.contains("blenders") || text.contains("blender")) {
            name = "blender";
        }else if (text.contains("refrigerator") || text.contains("refrigerators")) {
            name = "refrigerator";
        }else if (text.contains("coffee-machines") || text.contains("coffee-machine")) {
            name = "coffee-machine";
        }else if (text.contains("juicers") || text.contains("juicer")) {
            name = "juicer";
        }else if (text.contains("toasters") || text.contains("toaster")) {
            name = "toaster";
        }else if (text.contains("microwaves") || text.contains("microwave")) {
            name = "microwave";
        }else if (text.contains("rice-cookers") || text.contains("rice-cooker")) {
            name = "rice-cooker";
        }else if (text.contains("bread-makers") || text.contains("bread-maker")) {
            name = "bread-maker";
        }else if (text.contains("bedsheets") || text.contains("bedsheet")) {
            name = "bedsheet";
        }else if (text.contains("pillows-covers") || text.contains("pillows-cover")) {
            name = "pillows-cover";
        }else if (text.contains("blankets") || text.contains("blanket")) {
            name = "blanket";
        }else if (text.contains("furniture")) {
            name = "furniture";
        }else if (text.contains("grilling")) {
            name = "grilling";
        }else if (text.contains("clocks") || text.contains("clock")) {
            name = "clock";
        }else if (text.contains("wall-art") || text.contains("wall-arts")) {
            name = "wall-art";
        }else if (text.contains("candles") || text.contains("candle")) {
            name = "candle";
        }else if (text.contains("badminton")) {
            name = "badminton";
        }else if (text.contains("tennis")) {
            name = "tennis";
        }else if (text.contains("table-tennis")) {
            name = "table-tennis";
        }else if (text.contains("cricket")) {
            name = "cricket";
        }else if (text.contains("football")) {
            name = "football";
        }else if (text.contains("yoga-mats") || text.contains("yoga-mat")) {
            name = "yoga-mat";
        }else if (text.contains("face-makeup") || text.contains("makeup")) {
            name = "face-makeup";
        }else if (text.contains("eye-shadow")) {
            name = "eye-shadow";
        }else if (text.contains("eye-liner")) {
            name = "eye-liner";
        }else if (text.contains("lipstick") || text.contains("lipsticks")) {
            name = "lipstick";
        }else if (text.contains("lipliner") || text.contains("lipliners")) {
            name = "lipliner";
        }else if (text.contains("lip-gloss") || text.contains("lip-glosses")) {
            name = "lip-gloss";
        }else if (text.contains("dolls") || text.contains("doll")) {
            name = "doll";
        }else if (text.contains("rice")) {
            name = "rice";
        }else if (text.contains("flours")) {
            name = "flours";
        }else if (text.contains("pulses") || text.contains("pulse")) {
            name = "pulses";
        }else if (text.contains("oils") || text.contains("oil")) {
            name = "oils";
        }else if (text.contains("vinegar")) {
            name = "vinegar";
        }else if (text.contains("ghee")) {
            name = "ghee";
        }else if (text.contains("spices") || text.contains("spice")) {
            name = "spices";
        }else if (text.contains("masala") || text.contains("masalas")) {
            name = "masala";
        }else if (text.contains("salt")) {
            name = "salt";
        }else if (text.contains("tea")) {
            name = "tea";
        }else if (text.contains("coffee")) {
            name = "coffee";
        }else if (text.contains("milk")) {
            name = "milk";
        }else if (text.contains("car") || text.contains("cars")) {
            name = "car";
        }else if (text.contains("drums") || text.contains("drum")) {
            name = "drums";
        }else if (text.contains("guitars") || text.contains("guitar")) {
            name = "guitar";
        }
        else{
            name = null;
        }
        return name;
    }

}
