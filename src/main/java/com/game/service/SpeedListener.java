package com.game.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.game.bean.Army;

public class SpeedListener {
	
	public static final int maxDiff = 200;

	public List<Army> armys = new ArrayList<Army>();
	
	public void registe(Faction f,int point){
		for(Army a : f.getArmys()){
			a.setPoint(point);
			armys.add(a);
		}
	}
	
	List<Integer> times;
	
	private int dstance = 0;
	private int time = 0;
	
	public List<Army> forward(StringBuffer report){
		List<Army> ret = new ArrayList<Army>();
		int minTime = getMinTime();
		if(minTime == 0)
			minTime = 1000;//秒
		report.append(minTime+"/");
		int i=0;
		times = new ArrayList<Integer>();
		for(Army a : armys){
			if(a.getNum() <= 0)
				continue;
			dstance = (int) (a.getDistance()+(a.getSpeed()*minTime/1000));
			if(dstance >= maxDiff){
				dstance = dstance%maxDiff;
				ret.add(a);
				report.append(a.getPoint()+","+a.getPos()+"/");
			}
			a.setDistance(dstance);
			time = (int) Math.ceil((maxDiff - dstance)*1000/(double)a.getSpeed());
			times.add(time);
		}
		return ret;
	}
	
	
	public int getMinTime(){
		if(times == null)
			return 0;
		Integer[] temp = new Integer[times.size()];
		times.toArray(temp);
		Arrays.sort(temp);
		return temp[0];
	}
}
