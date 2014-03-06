/*
 * Author: Auston Jin
 * Date: February 2, 2014
 * 
 * Cache implementation should provide the following :

    - Guarantee that there is a single instance of the cache
    - Type safety
    - Thread safety
   
 * */

package com.apple.cache;

public interface Cache {
	public void put(Object key, Object value);
    public Object get(Object key);

}



