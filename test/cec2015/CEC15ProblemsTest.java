/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cec2015;

//~--- non-JDK imports --------------------------------------------------------

import org.junit.After;
import org.junit.AfterClass;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author QIN
 */
public class CEC15ProblemsTest {
	public CEC15ProblemsTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of getCurrentBestX method, of class CEC15Problems.
	 */
	@Test
	public void testGetCurrentBestX_int_int() {
		System.out.println("getCurrentBestX");

		int func_num = 0;
		int n = 0;
		CEC15Problems instance = new CEC15Problems();
		double[] expResult = null;
		double[] result = instance.getCurrentBestX(func_num, n);
		assertArrayEquals(expResult, result);

		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getEvalCount method, of class CEC15Problems.
	 */
	@Test
	public void testGetEvalCount_int_int() {
		System.out.println("getEvalCount");

		int func_num = 0;
		int n = 0;
		CEC15Problems instance = new CEC15Problems();
		int expResult = 0;
		int result = instance.getEvalCount(func_num, n);

		assertEquals(expResult, result);

		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCurrentBest method, of class CEC15Problems.
	 */
	@Test
	public void testGetCurrentBest_int_int() {
		System.out.println("getCurrentBest");

		int func_num = 0;
		int n = 0;
		CEC15Problems instance = new CEC15Problems();
		double expResult = 0.0;
		double result = instance.getCurrentBest(func_num, n);

		assertEquals(expResult, result, 0.0);

		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCurrentBestX method, of class CEC15Problems.
	 */
	@Test
	public void testGetCurrentBestX_3args() {
		System.out.println("getCurrentBestX");

		int func_num = 0;
		int n = 0;
		int run = 0;
		CEC15Problems instance = new CEC15Problems();
		double[] expResult = null;
		double[] result = instance.getCurrentBestX(func_num, n, run);

		assertArrayEquals(expResult, result);

		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getEvalCount method, of class CEC15Problems.
	 */
	@Test
	public void testGetEvalCount_3args() {
		System.out.println("getEvalCount");

		int func_num = 0;
		int n = 0;
		int run = 0;
		CEC15Problems instance = new CEC15Problems();
		int expResult = 0;
		int result = instance.getEvalCount(func_num, n, run);

		assertEquals(expResult, result);

		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCurrentBest method, of class CEC15Problems.
	 */
	@Test
	public void testGetCurrentBest_3args() {
		System.out.println("getCurrentBest");

		int func_num = 0;
		int n = 0;
		int run = 0;
		CEC15Problems instance = new CEC15Problems();
		double expResult = 0.0;
		double result = instance.getCurrentBest(func_num, n, run);

		assertEquals(expResult, result, 0.0);

		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of addRecordRule method, of class CEC15Problems.
	 */
	@Test
	public void testAddRecordRule() {
		System.out.println("addRecordRule");

		int dim = 0;
		int[] recordPoints = null;
		CEC15Problems instance = new CEC15Problems();

		instance.addRecordRule(dim, recordPoints);

		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of setCurrentRun method, of class CEC15Problems.
	 */
	@Test
	public void testSetCurrentRun() {
		System.out.println("setCurrentRun");

		int run = 0;
		CEC15Problems instance = new CEC15Problems();

		instance.setCurrentRun(run);

		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getCurrentRun method, of class CEC15Problems.
	 */
	@Test
	public void testGetCurrentRun() {
		System.out.println("getCurrentRun");

		CEC15Problems instance = new CEC15Problems();
		int expResult = 0;
		int result = instance.getCurrentRun();

		assertEquals(expResult, result);

		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getRuns method, of class CEC15Problems.
	 */
	@Test
	public void testGetRuns() {
		System.out.println("getRuns");

		CEC15Problems instance = new CEC15Problems();
		int[] expResult = null;
		int[] result = instance.getRuns();

		assertArrayEquals(expResult, result);

		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of nextRun method, of class CEC15Problems.
	 */
	@Test
	public void testNextRun() {
		System.out.println("nextRun");

		CEC15Problems instance = new CEC15Problems();
		int expResult = 0;
		int result = instance.nextRun();

		assertEquals(expResult, result);

		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of flush method, of class CEC15Problems.
	 */
	@Test
	public void testFlush() {
		System.out.println("flush");

		CEC15Problems instance = new CEC15Problems();

		instance.flush();

		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of eval method, of class CEC15Problems.
	 */
	@Test
	public void testEval() {
		System.out.println("eval");

		double[] x = null;
		int nx = 0;
		int mx = 0;
		int func_num = 0;
		CEC15Problems instance = new CEC15Problems();
		double[] expResult = null;
		double[] result = instance.eval(x, nx, mx, func_num);

		assertArrayEquals(expResult, result);

		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
}

// ~ Formatted by Jindent --- http://www.jindent.com
