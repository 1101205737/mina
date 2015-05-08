package com.game.conf;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 1、统帅-力量
 * 2、速度-敏捷
 * 3、攻击-智力
 * @author dell
 *
 */
public class CardsConfig {
	
	public static Map<Integer, Object> card = new ConcurrentHashMap<Integer, Object>();

	public static void init(){
		{
			Map<String,Object> e = new HashMap<String,Object>();
			e.put("id", 1);
			e.put("star", 1);
			e.put("num", 1000);
			e.put("itemsId", new int[]{});
			e.put("need", 100);
		}
		
		{
			Map<String,Object> e = new HashMap<String,Object>();
			e.put("id", 1);
			e.put("star", 2);
			e.put("num", 100);
			e.put("itemsId", new int[]{});
			e.put("need", 200);
		}
	}
}
