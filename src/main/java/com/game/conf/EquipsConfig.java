package com.game.conf;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.game.bean.Equip;

public class EquipsConfig {

	private static Map<Integer, Object> equips = new ConcurrentHashMap<Integer, Object>();
	
	public static void initConfig(){
		
	}
	
	public static Equip get(int equipId){
		return null;
	}
}
