package com.game.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.game.bean.Army;
import com.game.bean.ArmysConfig;

public class WarService {


	private boolean isFinished = false;

	public void war(){
		while(!isFinished){
			
		}
	}
	
	
	public void speedListener(){
		
	}
	
	/**
	 * 取两个数最大的除数
	 * @param smalll
	 * @param big
	 * @return
	 */
	public static int maxDivisor(int smalll,int big){
		for(int i = smalll;i>0;i--){
			if(smalll%i == 0 && big%i ==0){
				return i;
			}
		}
		return 1;
	}
	
	
	public static void main(String[] args){
		
		ArmysConfig.initConfig();
		
		//================================
		
		Faction f1 = new Faction();
		f1.setSpeed(200);
		f1.setAttack(1500);
		f1.setAttackPlus(0.15);
		f1.setDefense(1200);
		f1.setDefensePlus(0.12);
		List<Army> armys1 = new ArrayList<Army>();
		Army a1 = new Army();
		a1.setPid(1);
		a1.setPos(1);
		a1.setNum(100);
		armys1.add(a1);
		
		Army a2 = new Army();
		a2.setPid(1);
		a2.setPos(1);
		a2.setNum(100);
		armys1.add(a2);
		
		Army a3 = new Army();
		a3.setPid(1);
		a3.setPos(1);
		a3.setNum(100);
		armys1.add(a3);
		
		Army a4 = new Army();
		a4.setPid(1);
		a4.setPos(1);
		a4.setNum(100);
		armys1.add(a4);
		
		Army a5 = new Army();
		a5.setPid(1);
		a5.setPos(1);
		a5.setNum(100);
		armys1.add(a5);
		f1.setArmys(armys1);
		
		
		
		Faction f2 = new Faction();
		f2.setSpeed(401);
		f1.setAttack(1600);
		f1.setAttackPlus(0.16);
		f1.setDefense(1400);
		f1.setDefensePlus(0.14);
		List<Army> armys2 = new ArrayList<Army>();
		Army b1 = new Army();
		b1.setPid(1);
		b1.setPos(1);
		b1.setNum(100);
		armys2.add(b1);
		
		Army b2 = new Army();
		b2.setPid(1);
		b2.setPos(1);
		b2.setNum(100);
		armys2.add(b2);
		
		Army b3 = new Army();
		b3.setPid(1);
		b3.setPos(1);
		b3.setNum(100);
		armys2.add(b3);
		
		Army b4 = new Army();
		b4.setPid(1);
		b4.setPos(1);
		b4.setNum(100);
		armys2.add(b4);
		
		Army b5 = new Army();
		b5.setPid(1);
		b5.setPos(1);
		b5.setNum(100);
		armys2.add(b5);
		f2.setArmys(armys2);
		
		
		//WarService.war(f1, f2);
	}
	
	/**
	 * log运算
	 * @param value
	 * @param base
	 * @return
	 */
	public static double log(int value,int base){
		return Math.log(value)/Math.log(base);
	}
}
