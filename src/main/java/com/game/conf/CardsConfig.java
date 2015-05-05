package com.game.conf;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CardsConfig {
	
	public static Map<Integer, Object> card = new ConcurrentHashMap<Integer, Object>();

	public static void init(){
		{
			Map<String,Object> e = new HashMap<String,Object>();
			e.put("id", 1);
		}
	}
}
