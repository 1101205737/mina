package com.game.conf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.game.conf.bean.NpcMap;

public class NpcMapConfig {
	
	private static Map<Integer,NpcMap> NPC_MAP = new ConcurrentHashMap<Integer,NpcMap>();
	private static Map<Integer,List<Integer>> LVL_IDS = new ConcurrentHashMap<Integer, List<Integer>>();

	public static void init(){
		{
			Map e = new HashMap();
			e.put("id", 1);
			e.put("name", "副本1");
			e.put("pic", 1);
			e.put("lvl", 10);
			e.put("npcs", new int[]{1});
			put(e);
		}
	}
	
	
	
	public static void put(Map e){
		NpcMap map = new NpcMap();
		map.setId((Integer)e.get("id"));
		map.setLvl((Integer)e.get("lvl"));
		map.setName((String)e.get("name"));
		map.setPic((Integer)e.get("pic"));
		map.setNpcs((int[])e.get("npcs"));
		
		NPC_MAP.put(map.getId(), map);
		if(LVL_IDS.containsKey(map.getLvl())){
			LVL_IDS.get(map.getLvl()).add(map.getId());
		}else{
			List<Integer> list = new ArrayList<Integer>();
			list.add(map.getId());
			LVL_IDS.put(map.getLvl(), list);
		}
	}
	
	public static NpcMap get(int id){
		return NPC_MAP.get(id);
	}
}
