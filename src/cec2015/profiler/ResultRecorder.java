
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package cec2015.profiler;

//~--- JDK imports ------------------------------------------------------------

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author QIN
 */
public class ResultRecorder {
    private final ArrayList<OptimResults> results = new ArrayList<OptimResults>();
    private final ArrayList<int[]>        rps     = new ArrayList<int[]>();
    private final ArrayList<Integer>      dims    = new ArrayList<Integer>();
    private String                        filePrefix;

    public ResultRecorder(String resultfilePrefix) {
        filePrefix = resultfilePrefix;
    }

    private String makeupFilename(int func_num, int dim) {
        return filePrefix + "-f" + func_num + "-d" + dim;
    }

    public void setFilenamePrefix(String prx) {
        filePrefix = prx;

        for (int i = 0; i < results.size(); i++) {
            results.get(i).setFilename(makeupFilename(results.get(i).getFuncNum(), results.get(i).getDim()));
        }
    }

    OptimResults getResults(int func_num, int nx) {
        for (int i = 0; i < results.size(); i++) {
            if ((results.get(i).getFuncNum() == func_num) && (results.get(i).getDim() == nx)) {
                return results.get(i);
            }
        }

        OptimResults or = new OptimResults(makeupFilename(func_num, nx), func_num, nx);

        results.add(or);

        return or;
    }

    private int getRecordRule(int dim) {
        for (int i = 0; i < dims.size(); i++) {
            if (dims.get(i) == dim) {
                return i;
            }
        }

        return -1;
    }

    private boolean isRecord(int dim, int count) {
        int index = getRecordRule(dim);

        if (index == -1) {
            return false;
        }

        int[] rr = rps.get(index);

        for (int i = 0; i < rr.length; i++) {
            if (count == rr[i]) {
                return true;
            }
        }

        return false;
    }

    public void addRecordRule(int dim, int[] rp) {
        int[] points = Arrays.copyOf(rp, rp.length);

        if (getRecordRule(dim) == -1) {
            dims.add(dim);
            rps.add(points);
        } else {
            rps.set(getRecordRule(dim), points);
        }
    }

    public void flush() {
        for (int i = 0; i < results.size(); i++) {
            results.get(i).flush();
        }
    }

    void record(int func_num, int nx, int count, double[] x, double fx) {

        // lazy initialization
        OptimResults or = getResults(func_num, nx);

        if (isRecord(nx, count)) {
            or.record(count, x, fx);
        }

        // results[func_num-1].record(fvc.count(func_num), x,fx);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
