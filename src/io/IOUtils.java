/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 *
 * @author QIN
 */
public class IOUtils {
    public static void flush(String filename, String contents) {
        try {
            String fn      = filename;
            String dirname = null;

            if (fn.contains("/")) {
                int slash = fn.lastIndexOf('/');

                dirname = fn.substring(0, slash);
            }

            if (fn.contains("\\")) {
                int slash = fn.lastIndexOf('\\');

                dirname = fn.substring(0, slash);
            }

            if (dirname != null) {
                File dir = new File(dirname);

                if (!dir.exists()) {
                    dir.mkdirs();
                }
            }

            File        f   = new File(fn);
            PrintStream out = new PrintStream(new FileOutputStream(f));

            out.print(contents);
            out.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found when open output file.");
        }
    }    
}
