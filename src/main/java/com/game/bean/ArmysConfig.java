package com.game.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ArmysConfig {
	
	private static Map<Integer, Object> armys = new ConcurrentHashMap<Integer, Object>();

	public static void initConfig(){
		{
			Map<String, Object> e = new HashMap<String, Object>();
			e.put("id", 1);
			e.put("power", 100);//生命
			e.put("attack", 100);//攻击
			e.put("defense", 100);//防御
			e.put("speed", 100);//速度
			armys.put((Integer) e.get("id"), e);
		}
	}
	
	public static Map<String, Object> get(int pid){
		return (Map<String, Object>) armys.get(pid);
	}
}
