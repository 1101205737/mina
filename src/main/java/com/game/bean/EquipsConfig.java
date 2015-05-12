package com.game.bean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EquipsConfig {

	private static Map<Integer, Object> equips = new ConcurrentHashMap<Integer, Object>();
	
	public static void initConfig(){
		
	}
}
