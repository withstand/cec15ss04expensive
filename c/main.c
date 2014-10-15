/*
CEC14 Test Function Suite for Single Objective Optimization
Jane Jing Liang (email: liangjing@zzu.edu.cn; liangjing@pmail.ntu.edu.cn) 
Dec. 12th 2013
*/

#include <stdio.h>
#include <math.h>
#include <malloc.h>
#include "cec15_test_func.h"

//double *OShift,*M,*y,*z,*x_bound;
//int ini_flag=0,n_flag,func_flag,*SS;
#include <math.h>
#include <stdlib.h>


int main()
{
	int run, fun_num, i,j;
	double x10[10];
	double x30[30];
	double f;

	
	for (run =1; run <=20; run++)
	{
		set_number_of_run(run);
		for (fun_num=1; fun_num<=15; fun_num++)
		{
			for (i = 1; i<= 50 * 10; i++)
			{
				for (j=0; j<10; j++)
					x10[j] = -100.0 + 200.0 * ((double)rand()/(double)RAND_MAX);
				cec15_test_func(x10, &f, 10, 1,fun_num);
			}
			for (i=1; i<= 50 * 30; i++)
			{
				for (j=0; j<30; j++)
					x30[j] = -100.0 + 200.0 * ((double)rand()/(double)RAND_MAX);
				cec15_test_func(x30, &f, 30, 1, fun_num);
     		}

		}
	}

	write_result_statistics_to_file("result/randomsampling", "result");

}
