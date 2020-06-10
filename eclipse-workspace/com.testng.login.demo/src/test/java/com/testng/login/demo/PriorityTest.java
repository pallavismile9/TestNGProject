package com.testng.login.demo;

import org.testng.annotations.Test;

public class PriorityTest {
/*
 * PASSED: login2    (Priority was -1)
PASSED: Login		(Priority was default 0 and capital L in method name)
PASSED: login		(Priority was  0 and lowercase l)
PASSED: login_1		(Priority was 1)
 * 
 * 
 * 	//When you have SAME annotations for more than one methods, and if you used priority to it.It works on priority.
	//It works on priority. 
	//Higher the priority(in terms of number) higher the order 
	//When you have not given an priority to any of the method then Annotations by default it will assume the priority as 0 
 * 
 * 
 * 
 * 
 */
	
	
	
	@Test(priority=1)
	public void login_1() {
	System.out.println("login_1");	
	}
	
	
	@Test
public void Login() {
		System.out.println("login_1");	
	}
	
	
	@Test(priority=-1)
public void login2() {
		System.out.println("login_1");	
	}
	
	
	
	@Test
public void login() {
		System.out.println("login_1");	
	}
	
	
	
}
