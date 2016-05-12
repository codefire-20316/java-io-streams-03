/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastreams;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author human
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        try {
            URL file_url = new URL("http://www.ex.ua/load/164567575");
            String name = new File(file_url.getFile()).getName();
            System.out.println(name);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            URL file_url = new URL("http://www.ex.ua/load/164567575");
            URLConnection connection = file_url.openConnection();
            String contentType = connection.getContentType();
            System.out.println(contentType);
            URL lastUrl = connection.getURL();
            String name = new File(lastUrl.getFile()).getName();
            System.out.println(name);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
