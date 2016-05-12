/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastreams;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author human
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        String file = "file.txt";
        String mode = "rw"; // "r", "rw", "rws", or "rwd"

        try (RandomAccessFile raf = new RandomAccessFile(file, mode)) {
            raf.setLength(36);

            raf.seek(6);

            for (int i = 0; i < 6; i++) {
                raf.write(97);
            }

            raf.seek(9);

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    int read = raf.read();
                    System.out.printf("%2d ", read);
                }
                System.out.println();
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
