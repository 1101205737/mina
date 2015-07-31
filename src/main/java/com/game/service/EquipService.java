package com.game.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.bean.UserEquip;
import com.game.bean.UserHore;
import com.game.conf.EquipConfig;
import com.game.conf.bean.Equip;
import com.game.dao.EquipDAO;
import com.util.SpringUtil;

@Service
public class EquipService {

	//未使用的装备
	private final Map<Integer,List<Integer>> UID_IDS = new ConcurrentHashMap<Integer, List<Integer>>();
	
	private final Map<Integer,UserEquip> ID_OBJ = new ConcurrentHashMap<Integer, UserEquip>();
	
	
	@Autowired
	private EquipDAO equipDAO;
	
	public void init(){
		List<UserEquip> list = equipDAO.queryAll();
		if(null != list && list.size() > 0){
			for(UserEquip eq : list){
				ID_OBJ.put(eq.getId(), eq);
				if(eq.getUsed() == 1)
					continue;
				if(UID_IDS.containsKey(eq.getUserId()))
					UID_IDS.get(eq.getUserId()).add(eq.getConfId());
				else{
					List<Integer> ids = new ArrayList<Integer>();
					ids.add(eq.getConfId());
					UID_IDS.put(eq.getUserId(), ids);
				}
			}
		}
		System.out.println("user equip init over ...");
	}
	
	//
	public Map<String,Object> getEquipByHore(int horeId){
		HoreService service = (HoreService) SpringUtil.getBean("horeService");
		UserHore h = service.getById(horeId);
		Map<String,Object> map = new HashMap<String,Object>();
		UserEquip ueq;
		if(h.getEquip_1() > 0){
			ueq = ID_OBJ.get(h.getEquip_1());
			Equip eq = EquipConfig.get(ueq.getConfId());
			map.put("pos1", eq);
		}
		if(h.getEquip_2() > 0){
			ueq = ID_OBJ.get(h.getEquip_2());
			Equip eq = EquipConfig.get(ueq.getConfId());
			map.put("pos2", eq);
		}
		if(h.getEquip_3() > 0){
			ueq = ID_OBJ.get(h.getEquip_3());
			Equip eq = EquipConfig.get(ueq.getConfId());
			map.put("pos3", eq);
		}
		if(h.getEquip_4() > 0){
			ueq = ID_OBJ.get(h.getEquip_4());
			Equip eq = EquipConfig.get(ueq.getConfId());
			map.put("pos4", eq);
		}
		if(h.getEquip_5() > 0){
			ueq = ID_OBJ.get(h.getEquip_5());
			Equip eq = EquipConfig.get(ueq.getConfId());
			map.put("pos5", eq);
		}
		if(h.getEquip_6() > 0){
			ueq = ID_OBJ.get(h.getEquip_6());
			Equip eq = EquipConfig.get(ueq.getConfId());
			map.put("pos6", eq);
		}
		return map;
	}
	
	public List<Equip> getEquipBag(Integer userId){
		List<Integer> ids = UID_IDS.get(userId);
		List<Equip> list = new ArrayList<Equip>();
		for(Integer id : ids)
			list.add(EquipConfig.get(id));
		return list;
	}
}
