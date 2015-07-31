package com.game.conf;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.game.conf.bean.Equip;

public class EquipConfig {

	private static Map<Integer, Equip> equips = new ConcurrentHashMap<Integer, Equip>();
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String ATTACK = "attack";
	public static final String POWER = "power";
	public static final String SPEED = "speed";
	public static final String IQ = "iq";
	public static final String SKILL_ID = "skillId";
	public static final String POWER_RECOVER = "powerRecover";
	public static final String IQ_RECOVER = "iqRecover";
	
	public static void initConfig(){
		{
			Map<String,Object> e = new HashMap<String,Object>();
			e.put(ID, 1);
			e.put(NAME, "散失");
			e.put(ATTACK, 50);
			e.put(POWER, 20);
			put(e);
		}
		
		{
			Map<String,Object> e = new HashMap<String,Object>();
			e.put(ID, 2);
			e.put(NAME, "暗灭");
			e.put(ATTACK, 100);
			put(e);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void put(Map<String,Object> e){
		Equip p = new Equip();
		p.setId(Integer.parseInt(String.valueOf(e.get(ID))));
		p.setName(String.valueOf(e.get(NAME)));
		p.setAttack(e.get(ATTACK)==null?0:Integer.parseInt(String.valueOf(e.get(ATTACK))));
		p.setPower(e.get(POWER)==null?0:Integer.parseInt(String.valueOf(e.get(POWER))));
		p.setSpeed(e.get(SPEED)==null?0:Integer.parseInt(String.valueOf(e.get(SPEED))));
		p.setIq(e.get(IQ)==null?0:Integer.parseInt(String.valueOf(e.get(IQ))));
		p.setSkillId(e.get(SKILL_ID)==null?0:Integer.parseInt(String.valueOf(e.get(SKILL_ID))));
		p.setPowerRecover(e.get(POWER_RECOVER)==null?0:Integer.parseInt(String.valueOf(e.get(POWER_RECOVER))));
		p.setIqRecover(e.get(IQ_RECOVER)==null?0:Integer.parseInt(String.valueOf(e.get(IQ_RECOVER))));
		equips.put(p.getId(), p);
	}
	
	public static Equip get(int equipId){
		return equips.get(equipId);
	}
}
