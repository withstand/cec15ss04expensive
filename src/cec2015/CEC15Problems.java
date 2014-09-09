
/*
CEC14 Test Function Suite for Single Objective Optimization
BO Zheng (email: zheng.b1988@gmail.com)
Dec. 19th 2013
Modified in Aug. 8th 2014
 */
package cec2015;

//~--- non-JDK imports --------------------------------------------------------

import cec2015.math.Constants;
import cec2015.math.Functions;

import cec2015.profiler.FEvCount;
import cec2015.profiler.ResultRecorder;

import input_data.DataReader;

//~--- JDK imports ------------------------------------------------------------

import java.util.ArrayList;
import java.util.Arrays;

public class CEC15Problems {
    private final ResultRecorder      rr;//               = new ResultRecorder("test");
    private final ArrayList<FEvCount> funcEvalCounters = new ArrayList<FEvCount>();
    double[]                          OShift, M, y, z, x_bound;
    int                               ini_flag, n_flag, func_flag;
    int[]                             SS;
    private int                       currentRun;

    public CEC15Problems(String resultFilePrefix) {
        rr = new ResultRecorder(resultFilePrefix);
        currentRun = 1;
    }
    public CEC15Problems() {
        rr = null;
        currentRun = 1;
    }

//  public FEvCount getFuncEvalCount() {
//      return fec;
//  }
//  public int getCount(int func_num, int nx) {
//      return fec.getCount(func_num, nx);
//  }
    public double[] getCurrentBestX(int func_num, int n) {
        return getCurrentBestX(func_num, n, currentRun);
    }

    public int getEvalCount(int func_num, int n) {
        return getEvalCount(func_num, n, currentRun);
    }

    public double getCurrentBest(int func_num, int n) {
        return getCurrentBest(func_num, n, currentRun);
    }

    public double[] getCurrentBestX(int func_num, int n, int run) {
        return getFuncEvalCounter(run).getCurrentBestX(func_num, n);
    }

    public int getEvalCount(int func_num, int n, int run) {
        return getFuncEvalCounter(run).getCount(func_num, n);
    }

    public double getCurrentBest(int func_num, int n, int run) {
        return getFuncEvalCounter(run).getCurrentBest(func_num, n);
    }

    private FEvCount getFuncEvalCounter(int run) {
        for (FEvCount counter : funcEvalCounters) {
            if (counter.getCurrentRun() == run) {
                return counter;
            }
        }

        return (new FEvCount(30, 100, run, rr));
    }

    public void addRecordRule(int dim, int[] recordPoints) {
        if (rr!=null)rr.addRecordRule(dim, recordPoints);
    }

//    public void setFilenamePrefix(String name) {
//        rr.setFilenamePrefix(name);
//    }

    public void setCurrentRun(int run) {
        currentRun = run;
    }

    public void flush() {
        rr.flush();
    }

    /*
     * @params:
     * x :         sample points
     * nx:         dimension
     * mx:         sample size
     * func_num:   function number
     */
    public double[] test_func(double[] x, int nx, int mx, int func_num) {
        double[] f = new double[mx];

        Arrays.fill(f, Constants.INF);

        // cf_num not correct for D2
        int cf_num = 10, i, j;

        // for func_num = 23-28 cf_num = 8
        if (ini_flag == 1) {
            if ((n_flag != nx) || (func_flag != func_num)) /* check if nx or func_num are changed, reinitialization */ {
                ini_flag = 0;
            }
        }

        if (ini_flag == 0) /* initiailization */ {
            y       = new double[nx];
            z       = new double[nx];
            x_bound = new double[nx];

            for (i = 0; i < nx; i++) {
                x_bound[i] = 100.0;
            }

            if (!((nx == 2) || (nx == 10) || (nx == 20) || (nx == 30) || (nx == 50) || (nx == 100))) {
                System.out.println("\nError: Test functions are only defined for D=2,10,20,30,50,100.");

                return null;
            }

            if ((nx == 2) && (((func_num >= 17) && (func_num <= 22)) || ((func_num >= 29) && (func_num <= 30)))) {
                System.out.println("\nError: hf01,hf02,hf03,hf04,hf05,hf06,cf07&cf08 are NOT defined for D=2.\n");

                return null;
            }

            /* Load Matrix M**************************************************** */
            M = DataReader.readRotation(func_num, nx, cf_num);

            /* Load shift_data************************************************** */
            OShift = DataReader.readShiftData(func_num, nx, cf_num);

            /* Load Shuffle_data****************************************** */
            SS        = DataReader.readShuffleData(func_num, nx, cf_num);
            n_flag    = nx;
            func_flag = func_num;
            ini_flag  = 1;
        }

        double[] t = new double[nx];

        for (i = 0; i < mx; i++) {
            for (j = 0; j < nx; j++) {
                t[j] = x[i * nx + j];
            }

            switch (func_num) {
            case 1 :
                f[i] = Functions.ellips_func(t, nx, OShift, M, 1, 1);
                f[i] += 100.0;

                break;

            case 2 :
                f[i] = Functions.bent_cigar_func(t, nx, OShift, M, 1, 1);
                f[i] += 200.0;

                break;

            case 3 :
                f[i] = Functions.discus_func(t, nx, OShift, M, 1, 1);
                f[i] += 300.0;

                break;

            case 4 :
                f[i] = Functions.rosenbrock_func(t, nx, OShift, M, 1, 1);
                f[i] += 400.0;

                break;

            case 5 :
                f[i] = Functions.ackley_func(t, nx, OShift, M, 1, 1);
                f[i] += 500.0;

                break;

            case 6 :
                f[i] = Functions.weierstrass_func(t, nx, OShift, M, 1, 1);
                f[i] += 600.0;

                break;

            case 7 :
                f[i] = Functions.griewank_func(t, nx, OShift, M, 1, 1);
                f[i] += 700.0;

                break;

            case 8 :
                f[i] = Functions.rastrigin_func(t, nx, OShift, M, 1, 0);
                f[i] += 800.0;

                break;

            case 9 :
                f[i] = Functions.rastrigin_func(t, nx, OShift, M, 1, 1);
                f[i] += 900.0;

                break;

            case 10 :
                f[i] = Functions.schwefel_func(t, nx, OShift, M, 1, 0);
                f[i] += 1000.0;

                break;

            case 11 :
                f[i] = Functions.schwefel_func(t, nx, OShift, M, 1, 1);
                f[i] += 1100.0;

                break;

            case 12 :
                f[i] = Functions.katsuura_func(t, nx, OShift, M, 1, 1);
                f[i] += 1200.0;

                break;

            case 13 :
                f[i] = Functions.happycat_func(t, nx, OShift, M, 1, 1);
                f[i] += 1300.0;

                break;

            case 14 :
                f[i] = Functions.hgbat_func(t, nx, OShift, M, 1, 1);
                f[i] += 1400.0;

                break;

            case 15 :
                f[i] = Functions.grie_rosen_func(t, nx, OShift, M, 1, 1);
                f[i] += 1500.0;

                break;

            case 16 :
                f[i] = Functions.escaffer6_func(t, nx, OShift, M, 1, 1);
                f[i] += 1600.0;

                break;

            case 17 :
                f[i] = Functions.hf01(t, nx, OShift, M, SS, 1, 1);
                f[i] += 1700.0;

                break;

            case 18 :
                f[i] = Functions.hf02(t, nx, OShift, M, SS, 1, 1);
                f[i] += 1800.0;

                break;

            case 19 :
                f[i] = Functions.hf03(t, nx, OShift, M, SS, 1, 1);
                f[i] += 1900.0;

                break;

            case 20 :
                f[i] = Functions.hf04(t, nx, OShift, M, SS, 1, 1);
                f[i] += 2000.0;

                break;

            case 21 :
                f[i] = Functions.hf05(t, nx, OShift, M, SS, 1, 1);
                f[i] += 2100.0;

                break;

            case 22 :
                f[i] = Functions.hf06(t, nx, OShift, M, SS, 1, 1);
                f[i] += 2200.0;

                break;

            case 23 :
                f[i] = Functions.cf01(t, nx, OShift, M, 1);
                f[i] += 2300.0;

                break;

            case 24 :
                f[i] = Functions.cf02(t, nx, OShift, M, 1);
                f[i] += 2400.0;

                break;

            case 25 :
                f[i] = Functions.cf03(t, nx, OShift, M, 1);
                f[i] += 2500.0;

                break;

            case 26 :
                f[i] = Functions.cf04(t, nx, OShift, M, 1);
                f[i] += 2600.0;

                break;

            case 27 :
                f[i] = Functions.cf05(t, nx, OShift, M, 1);
                f[i] += 2700.0;

                break;

            case 28 :
                f[i] = Functions.cf06(t, nx, OShift, M, 1);
                f[i] += 2800.0;

                break;

            case 29 :
                f[i] = Functions.cf07(t, nx, OShift, M, SS, 1);
                f[i] += 2900.0;

                break;

            case 30 :
                f[i] = Functions.cf08(t, nx, OShift, M, SS, 1);
                f[i] += 3000.0;

                break;

            default :
                System.out.println("\nError: There are only 30 test functions in this test suite!");
                f[i] = 0.0;

                break;
            }
        }

        getFuncEvalCounter(currentRun).eval(func_num, nx, x, f);

        return f;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
