package com.game.conf;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.game.conf.bean.Equip;

public class EquipConfig {

	private static Map<Integer, Equip> equips = new ConcurrentHashMap<Integer, Equip>();
	
	public static void initConfig(){
		{
			Map<String,Object> e = new HashMap<String,Object>();
			e.put("id", 1);
			e.put("name", "散失");
			
			put(e);
		}
	}
	
	public static void put(Map<String,Object> e){
		Equip p = new Equip();
		p.setIq(Integer.parseInt(String.valueOf(e.get("id"))));
		equips.put(p.getIq(), p);
	}
	
	public static Equip get(int equipId){
		return null;
	}
}
