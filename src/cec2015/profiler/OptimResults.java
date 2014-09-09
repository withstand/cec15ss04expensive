
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package cec2015.profiler;

//~--- JDK imports ------------------------------------------------------------

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QIN
 */
public class OptimResults {
    private final ArrayList<double[]> xdata        = new ArrayList<double[]>();
    private final ArrayList<Double>   ydata        = new ArrayList<Double>();
    private final ArrayList<Integer>  recordnumber = new ArrayList<Integer>();
    private String                    filename;
    private final int                 func_num, dim;

    OptimResults(String resultfilename, int func_num, int dim) {
        filename      = resultfilename;
        this.func_num = func_num;
        this.dim      = dim;
    }

    void setFilename(String fn) {
        filename = fn;
    }

    public int getFuncNum() {
        return func_num;
    }

    public int getDim() {
        return dim;
    }

    void record(int count, double[] x, double fx) {
        xdata.add(x);
        ydata.add(fx);
        recordnumber.add(count);
    }

    void flush() {
        try {
            String fn      = filename + "-x.txt";
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

            out.print(reportX());
            out.close();
            out = new PrintStream(new FileOutputStream(new File(filename + "-fx.txt")));
            out.print(reportY());
            out.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found when open output file.");
        }
    }

    private String reportX() {
        String rep = "%count   \tx\n";

        for (int i = 0; i < recordnumber.size(); i++) {
            int rn = recordnumber.get(i);

            // double fx = ydata.get(i).doubleValue();
            double[] x = xdata.get(i);

            rep = rep + "  " + rn + "\t";

            for (int j = 0; j < x.length; j++) {
                rep = rep + x[j] + "\t";
            }

            rep = rep + "\n";
        }

        return rep;
    }

    private String reportY() {
        String rep = "%count   \ty\n";

        for (int i = 0; i < recordnumber.size(); i++) {
            int    rn = recordnumber.get(i);
            double fx = ydata.get(i);

            // double[] x = xdata.get(i);
            rep = rep + "  " + rn + "\t" + fx + "\n";
        }

        return rep;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
