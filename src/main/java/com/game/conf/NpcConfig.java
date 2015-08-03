package com.game.conf;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.game.conf.bean.Npc;

public class NpcConfig {
	
	private static Map<Integer,Npc> ID_OBJ = new ConcurrentHashMap<Integer, Npc>();

	public static void init(){
		{
			Map e = new HashMap();
			e.put("id", 1);
			e.put("name", "怪物1");
			e.put("pic", 1);
			e.put("hores", new int[]{1,2,3,4,5});
			put(e);
		}
	}
	
	public static void put(Map e){
		Npc npc = new Npc();
		npc.setId((Integer)e.get("id"));
		npc.setName((String)e.get("name"));
		npc.setPic((Integer)e.get("pic"));
		npc.setHores((int[])e.get("hores"));
		ID_OBJ.put(npc.getId(), npc);
	}
	
	public static Npc get(int id){
		return ID_OBJ.get(id);
	}
}
