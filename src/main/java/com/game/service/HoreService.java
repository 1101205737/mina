package com.game.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.bean.UserHore;
import com.game.conf.EquipConfig;
import com.game.conf.bean.Equip;
import com.game.dao.HoreDAO;
import com.game.dto.Hore;
import com.util.ProxyUtil;

@Service
public class HoreService {
	
	
	private final Map<Integer,List<Integer>> UID_HIDS = new ConcurrentHashMap<Integer,List<Integer>>();
	private final Map<Integer,UserHore> ID_OBJ = new ConcurrentHashMap<Integer, UserHore>();
	
	
	@Autowired
	private HoreDAO horeDAO;
	
	
	/**
	 * init
	 */
	public void init(){
		List<UserHore> list = horeDAO.queryAll();
		if(list != null && list.size() > 0){
			for(UserHore h : list){
				ID_OBJ.put(h.getId(), h);
				if(UID_HIDS.containsKey(h.getUserId())){
					UID_HIDS.get(h.getUserId()).add(h.getId());
				}else{
					List<Integer> ids = new ArrayList<Integer>();
					ids.add(h.getId());
					UID_HIDS.put(h.getUserId(), ids);
				}
			}
		}
		System.out.println("hore init over ....");
	}
	
	public Hore getById(int id){
		return null;
	}
	
	
	public List<UserHore> getHoreByUser(int userId){
		List<Integer> ids = UID_HIDS.get(userId);
		List<UserHore> list = new ArrayList<UserHore>();
		if(ids != null && ids.size() > 0){
			for(Integer id : ids){
				UserHore h = ID_OBJ.get(id);
				list.add(h);
			}
		}
		return list;
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
			Equip equip = EquipConfig.get(equipId);
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
			Equip equip = EquipConfig.get(equipId);
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
