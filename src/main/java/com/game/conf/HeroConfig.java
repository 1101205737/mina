package com.game.conf;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 1、力量
 * 2、速度-敏捷
 * 3、攻击-智力
 * @author dell
 *
 */
public class HeroConfig {
	
	public static Map<Integer, Object> horeConfig = new ConcurrentHashMap<Integer, Object>();

	public static void init(){
		{
			//
			Map<String,Object> e = new HashMap<String,Object>();
			e.put("id", 1);
			e.put("star", 1);
			
			e.put("type", 1);
			e.put("attack", 100);
			
			e.put("power", 1000);
			e.put("speed", 1000);
			e.put("iq", 1000);
			
			e.put("power_step", 10);
			e.put("speed_step", 8);
			e.put("iq_step", 2);
			
			e.put("skill_cast", 100);
			e.put("skill_cd", 5);
			e.put("sill_aoe", false);
			e.put("skill_hurt", 100);
			
			e.put("power_recover", 10);
			e.put("iq_recover", 10);
			
			e.put("crit", 8);
			e.put("dodge", 3);
		}
	}
	
	public static Map get(int id){
		return null;
	}
}
