package com.game.dao;

import java.util.List;

import com.dao.core.MyBatisRepository;
import com.game.bean.UserEquip;

@MyBatisRepository
public interface EquipDAO {
	public List<UserEquip> queryAll();
}
