package com.game.dao;

import java.util.List;

import com.dao.core.MyBatisRepository;
import com.game.bean.Hore;


@MyBatisRepository
public interface HoreDAO {

	public List<Hore> queryAll();
}
