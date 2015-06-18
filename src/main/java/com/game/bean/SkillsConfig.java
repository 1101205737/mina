package com.game.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SkillsConfig {

	private static final int SUCK_SKILL = 1;
	
	
	private static final Map skills = new ConcurrentHashMap<String, Object>();
	
	public static void initConfig(){
		{
			Map e = new HashMap();
			e.put("id", 1);
			e.put("type", SUCK_SKILL);
			e.put("rate", 100);//产生的概率
			e.put("vale", 7);//伤害的100分比
		}
	}
	
	public static void put(Map e){
		Skill skill = new Skill();
		skill.setId(Integer.parseInt(String.valueOf(e.get("id"))));
		skill.setType(Integer.parseInt(String.valueOf(e.get("id"))));
		skill.setRate(Integer.parseInt(String.valueOf(e.get("id"))));
		skill.setValue(Integer.parseInt(String.valueOf(e.get("id"))));
		skills.put(skill.getId(), skill);
	}
}
