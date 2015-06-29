package com.game.service;

import java.util.ArrayList;
import java.util.List;

import com.game.bean.Equip;
import com.game.bean.Hore;
import com.game.conf.EquipsConfig;
import com.util.ProxyUtil;

public class HoreService {
	
	public Hore getById(int id){
		return null;
	}

	public void modifyEquip(int userHoreId,int pos,int equipId){
		try {
			Hore hore = getById(userHoreId);
			ProxyUtil.setter(hore, "equip_"+pos, equipId, Integer.TYPE);
			countEquipAttr(hore);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void countBaseAttr(Hore hore) throws Exception{
		int power = 0;
		int speed = 0;
		int iq = 0;
		int attack = 0;
		List<Integer> skills = new ArrayList<Integer>();	
		/////////////////////////
		for(int i=1;i<=6;i++){
			int equipId = (Integer) ProxyUtil.getter(hore, "equip_"+i);
			if(equipId < 1)
				continue;
			Equip equip = EquipsConfig.get(equipId);
			skills.add(equip.getSkillId());
			power += equip.getPower();
			speed += equip.getSpeed();
			iq += equip.getIq();
			if(hore.getType() == 1)
				attack += equip.getPower();
			else if(hore.getType() ==2)
				attack += equip.getSpeed();
			else if(hore.getType() == 3)
				attack += equip.getIq();
		}
		hore.setEquip_power(power);
		hore.setEquip_speed(speed);
		hore.setEquip_iq(iq);
		hore.setEquip_attack(attack);
	}
	
	public void countEquipAttr(Hore hore) throws Exception{
		int power = 0;
		int speed = 0;
		int iq = 0;
		int attack = 0;
		List<Integer> skills = new ArrayList<Integer>();	
		/////////////////////////
		for(int i=1;i<=6;i++){
			int equipId = (Integer) ProxyUtil.getter(hore, "equip_"+i);
			if(equipId < 1)
				continue;
			Equip equip = EquipsConfig.get(equipId);
			skills.add(equip.getSkillId());
			power += equip.getPower();
			speed += equip.getSpeed();
			iq += equip.getIq();
			if(hore.getType() == 1)
				attack += equip.getPower();
			else if(hore.getType() ==2)
				attack += equip.getSpeed();
			else if(hore.getType() == 3)
				attack += equip.getIq();
		}
		hore.setEquip_power(power);
		hore.setEquip_speed(speed);
		hore.setEquip_iq(iq);
		hore.setEquip_attack(attack);
	}
}
