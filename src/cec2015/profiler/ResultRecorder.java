
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package cec2015.profiler;

//~--- JDK imports ------------------------------------------------------------

import java.util.ArrayList;

/**
 *
 * @author QIN
 */
public class ResultRecorder {
    private final ArrayList<OptimResults> results = new ArrayList<OptimResults>();
    private final RecordRule              rule    = new RecordRule();
    private String                        filePrefix;

    /**
     * Create a recorder for results of multiple function evaluation
     * @param resultfilePrefix
     */
    public ResultRecorder(String resultfilePrefix) {
        filePrefix = resultfilePrefix;
    }

    private String makeupFilename(int func_num, int dim, int runtime) {
        return filePrefix + "-f" + func_num + "-d" + dim + "-r" + runtime;
    }

    public void setFilenamePrefix(String prx) {
        filePrefix = prx;

        for (OptimResults result : results) {
            result.setFilename(makeupFilename(result.getFuncNum(), result.getDim(), result.getRuntime()));
        }
    }

    protected OptimResults getResults(int func_num, int nx, int runtime) {
        for (OptimResults result : results) {
            if ((result.getFuncNum() == func_num) && ((result.getDim() == nx) && (result.getRuntime() == runtime))) {
                return result;
            }
        }

        OptimResults or = new OptimResults(makeupFilename(func_num, nx, runtime), func_num, nx, runtime);

        results.add(or);

        return or;
    }

    public void addRecordRule(int dim, int[] rp) {
        rule.addRule(dim, rp);
    }

    public void flush() {
        for (OptimResults result : results) {
            result.flush();
        }
    }

    void record(int func_num, int nx, int runtime, int count, double[] x, double fx) {

        // lazy initialization
        OptimResults or = getResults(func_num, nx, runtime);

        if (rule.isRecord(nx, count)) {
            or.record(count, x, fx);
        }
    }
    
    
    
    
    
}


//~ Formatted by Jindent --- http://www.jindent.com
