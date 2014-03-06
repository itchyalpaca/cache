/*
 * Author: Auston Jin
 * Date: February 2, 2014
 * Revised: February 5th, 2014
 *   
 * */

package com.apple.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class MyCache implements Cache{
	
	//single instance of the cache
	private static MyCache instance = null; //explain why private static
	
	//LinkedHashMap for holding objects
	private Map<Object, Object> cacheMap = new ConcurrentHashMap<Object, Object>();//treeMap follows natural ordering, not fit for a cache. HashMap has no guaranteed ordering
	
	//used to test thread safety. Slows down first thread.
	static boolean firstThread = true;
	
	private MyCache() {}//explain why this is private
	
	public static MyCache getInstance() { //explain why public static
		if (instance == null) {
			
			/**********************************************************
			 * This portion was added to test thread safety by slowing 
			 * down the first thread.
			 * *******************************************************/
			if (firstThread) {
				firstThread = false;
				try {
					Thread.currentThread();
					Thread.sleep(1000);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			/*********************************************************/
			
			synchronized(MyCache.class){
				if (instance == null) {
					instance = new MyCache();					
				}
			}
			
		}
		return instance;
	}

	public synchronized void put(Object key, Object value) {		
		
		cacheMap.put(key, value);
	}

	public synchronized Object get(Object key) {
		
		//returns null if no mapping of the key is found
		return cacheMap.get(key);		
	}

}

