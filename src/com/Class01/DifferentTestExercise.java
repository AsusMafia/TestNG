package com.Class01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DifferentTestExercise {
	
	@BeforeClass
	public void bClass() {
		System.out.println("Before Class");
	}
	
	@AfterClass
	public void aClass() {
		System.out.println("After Class");
	}
	
	@BeforeMethod
	public void bMethod() {
		System.out.println("Before Method");
	}
	
	@AfterMethod
	public void aMethod() {
		System.out.println("After Method");
	}
	
	@Test
	public void test1() {
		System.out.println("Real Test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("Real Test 2");
	}

}
