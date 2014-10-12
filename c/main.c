/*
CEC14 Test Function Suite for Single Objective Optimization
Jane Jing Liang (email: liangjing@zzu.edu.cn; liangjing@pmail.ntu.edu.cn) 
Dec. 12th 2013
*/

#include <stdio.h>
#include <math.h>
#include <malloc.h>
#include "cec15_test_func.h"
#include "evaluation_count_record.h"

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

	initialize_recording();


	for (run =1; run <=20; run++)
	{
		set_number_of_run(run);
		for (fun_num=1; fun_num<=15; fun_num++)
		{
			for (i = 1; i<= 50 * 10; i++)
			{
				for (j=0; j<10; j++)
					x10[j] = -100 + 200 * ((double)rand()/(double)RAND_MAX);
				cec15_test_func(x10, &f, 10, 1,fun_num);
			}
			for (i=1; i<=50*30; i++)
			{
				for (j=0; j<30; j++)
					x30[j] = -100 + 200 * ((double)rand()/(double)RAND_MAX);
				cec15_test_func(x30, &f, 30, 1,fun_num);
			}
		}
	}

	write_result_statistics_to_file("test", "result");
	free_memory();

}


//int main()
//{
//	int i,j,k,n,m,func_num;
//	double *f,*x;
//	FILE *fpt;
//	char FileName[256];
//	char cwd[1024];
//
//
//
//	m=3;
//	n=10;
//	x=(double *)malloc(m*n*sizeof(double));
//	f=(double *)malloc(sizeof(double)  *  m);
//	for (i = 0; i < 15; i++)
//	{
//		func_num=i+1;
//		sprintf(FileName, "../../../src/input_data/shift_data_%d_D%d.txt", func_num, n);
//		//if (_getcwd(cwd, sizeof(cwd)) != NULL)
//		//    fprintf(stdout, "Current working dir: %s\n", cwd);
//		//else
//		//    perror("_getcwd() error");
//
//		//printf("%s\n", FileName);
//
//
//		fpt = fopen(FileName,"r");
//		if (fpt==NULL)
//		{
//			printf("\n Error: Cannot open input file for reading \n");
//		}
//
//		if (x==NULL)
//			printf("\nError: there is insufficient memory available!\n");
//
//		for(k=0;k<n;k++)
//		{
//			fscanf(fpt,"%Lf",&x[k]);
//			/*printf("%Lf\n",x[k]);*/
//		}
//
//		fclose(fpt);
//
//		for (j = 0; j < n; j++)
//		{
//			x[1*n+j]=0.0;
//			/*printf("%Lf\n",x[1*n+j]);*/
//		}
//
//		for (j = 0; j < n; j++)
//		{
//			x[2*n+j]=10.0;
//			/*printf("%Lf\n",x[1*n+j]);*/
//		}
//
//
//		cec15_test_func(x, f, n,m,func_num);
//		for (j = 0; j < m; j++)
//		{
//			printf(" f%d(x[%d]) = %Le,",func_num,j+1,f[j]);
//		}
//		printf("\n");
//
//
//	}
//	free(x);
//	free(f);
//
//	return 0;
//}


