/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarwstreams;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Scanner;
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
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Input some text (enter 'e' for exit):");
        
        File file = new File("file.txt");
        
        try (FileWriter fw = new FileWriter(file)) {
            
            while (true) {
                String input = scanner.nextLine();
                
                if ("e".equalsIgnoreCase(input)) {
                    break;
                }
                
                fw.append(input).append("\n");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try (FileReader fr = new FileReader(file)) {
            System.out.println(file.length());
            CharBuffer buff = CharBuffer.allocate((int) file.length());
            
            fr.read(buff);
            
            System.out.println(new String(buff.array()));
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
