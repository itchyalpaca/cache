/*
 * Author: Auston Jin 
 * Date: February 5th, 2014
 * */

package com.apple.cache;

public class MyCacheTest {
	public static void main(String[] args){//Printed instanceID for both thread should be the same
	
		Runnable firstThread = new ThreadTest();
		Runnable secondThread = new ThreadTest();
		
		new Thread(firstThread).start();
		new Thread(secondThread).start();		
	}
	
}

