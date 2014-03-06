/*
 * Author: Auston Jin 
 * Date: February 5th, 2014
 * 
 * This class was created to test thread and type safety of the cache
 * */

package com.apple.cache;

public class ThreadTest implements Runnable {
	
	private int instanceID = 0;	
	
	public int getInstanceID() {
		return this.instanceID;
	}	
	
	public void run() {
		
		MyCache instance = MyCache.getInstance();
		instanceID = System.identityHashCode(instance);		
		System.out.print("instanceID: " + System.identityHashCode(instance) + "\n");
		
		instance.put(7, "7");
		if (!instance.get(7).equals(7)) {
			System.out.print("A string 7 doesn't equal an integer 7\n");
		}
	}

}
