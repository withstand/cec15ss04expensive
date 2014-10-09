/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cec2015;

//~--- non-JDK imports --------------------------------------------------------

import input_data.DataReader;
import ui.TextAreaOutputStream;

//~--- JDK imports ------------------------------------------------------------

import java.io.File;

import java.util.Arrays;

/**
 * 
 * @author QIN
 */
public class Test {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {

		// TODO code application logic here
		TextAreaOutputStream taos = new TextAreaOutputStream();
                
                System.out.println();
		double[] OShift, M, y, z, x_bound;
		int ini_flag = 0, n_flag, func_flag;
		int[] SS;
		int i, j, k, n, m, func_num;
		double[] f, x;
		File fpt;

		m = 3;
		n = 10;
		x = new double[m * n];

		CEC15Problems tf = new CEC15Problems("resultxxxx\\thisonefortest\\result");

		double[] xx = new double[10];

		for (i = 0; i < xx.length; i++) {
			xx[i] = 0.5;
		}



		for (i = 0; i < 15; i++) {
			func_num = i + 1;

                        double xtmp[] = DataReader.readShiftData(func_num, n, 1);
                        
                        System.arraycopy(xtmp, 0, x, 0, xtmp.length);
                        

			for (j = 0; j < n; j++) {
				x[1 * n + j] = 0.0;

			}

			for (j = 0; j < n; j++) {
				x[2 * n + j] = 10.0;

			}

      			System.out.println("Run: " + tf.getCurrentRun());

			for (k = 0; k < 1; k++) {
				f = tf.eval(x, n, m, func_num);

				for (j = 0; j < m; j++) {
					System.out.println("f" + func_num + "(x[" + (j + 1) + "])=" + f[j] + " @ "
							+ Arrays.toString(Arrays.copyOfRange(x, j * n, (j + 1) * n)));
				}
			}

			System.out.println("f" + func_num + "-d" + n + " has been evaluated " + tf.getEvalCount(func_num, n)
					+ " times.");
			System.out.println("\tCurrent best value = " + tf.getCurrentBest(func_num, n) + " @ "
					+ Arrays.toString(tf.getCurrentBestX(func_num, n)));
		}
                
                tf.nextRun();
                
		for (i = 0; i < 15; i++) {
			func_num = i + 1;

			//InputStream is = tf.getClass().getResourceAsStream("/input_data/shift_data_" + func_num + ".txt");
			//Scanner input = new Scanner(is);

			for (k = 0; k < x.length; k++) {
				x[k] = 50.0;
			}

			for (int ii = 0; ii < x.length; ii++) {

				// System.out.println(x[i]);
			}

			//input.close();

			for (j = 0; j < n; j++) {
				x[1 * n + j] = 0.0;

				// System.out.println(x[1*n+j]);
			}

			for (j = 0; j < n; j++) {
				x[2 * n + j] = 10.0;

				/* printf("%Lf\n",x[1*n+j]); */
			}

			// fpt = new File("randdata_"+func_num+".txt");
			// input = new Scanner(fpt);
			// for(j=0;j<n;j++)
			// {
			// x[3*n+j] = input.nextDouble();
			// }
			// input.close();
			for (k = 0; k < 1; k++) {
				f = tf.eval(x, n, m, func_num);

				for (j = 0; j < m; j++) {
					System.out.println("f" + func_num + "(x[" + (j + 1) + "])=" + f[j] + " @ "
							+ Arrays.toString(Arrays.copyOfRange(x, j * n, (j + 1) * n)));
				}
			}

			System.out.println("Run: " + tf.getCurrentRun());
			System.out.println("f" + func_num + "-d" + n + " has been evaluated " + tf.getEvalCount(func_num, n)
					+ " times.");
			System.out.println("\tCurrent best value = " + tf.getCurrentBest(func_num, n) + " @ "
					+ Arrays.toString(tf.getCurrentBestX(func_num, n)));
		}                
                
                
                
                
                
                

		tf.writeResultToFiles();
	}
}

