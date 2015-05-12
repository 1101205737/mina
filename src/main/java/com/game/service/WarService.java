package com.game.service;

import java.util.Map;

import com.game.bean.ArmysConfig;

public class WarService {

	public static void war(Faction f1,Faction f2){
		int pos1 = 1;
		int pos2 =1;

		int time = 0;
		int t1 = (int) (1000.00/f1.getSpeed()*1000.00);//毫秒
		int t2 = (int) (1000.00/f2.getSpeed()*1000.00);//毫秒
		System.out.println(t1+"-------"+t2);
		int temp = 0;//单位时间
		if(t1 > t2)
			temp = maxDivisor(t2,t1);
		else
			temp = maxDivisor(t1,t2);
		System.out.println(temp);
		while(true){
			if(time/1000 >= 60)
				break;
			//=====================
			if(pos1%6 == 0)
				pos1 = 1;
			if(pos2%6 == 0)
				pos2 = 1;
			//=====================
			time+=temp;
			//=====================
			if(time%t1 == 0 && time%t2 == 0 && pos1 == pos2){
				System.out.println("1,2对击");
				warRound(pos1,f1,f2,3);
				pos1++;
				pos2++;
			}else if(time%t1 == 0){
				System.out.println("1攻击");
				warRound(pos1,f1,f2,1);
				pos1++;
			}else if(time%t2 == 0){
				System.out.println("2攻击");
				warRound(pos2,f1,f2,2);
				pos2++;
			}
		}
	}
	
	public static int findPos(int pos,Faction f){
		int num = f.getArmys().get(pos).getNum();
		if(num <= 0){
			pos++;
			if(pos >= 5)
				return 0;
			return findPos(pos,f);
		}else{
			return pos;
		}
	}
	
	
	public static void warRound(int pos,Faction f1,Faction f2,int type){
		int pos2 = findPos(pos,f2);
		if(pos2 == 0)
			return;
		
		int pid1 = f1.getArmys().get(pos).getPid();
		int num1 = f1.getArmys().get(pos).getNum();
		Map<String,Object> map1 = ArmysConfig.get(pid1);
		int hurt1 = (int) ((Integer)map1.get("attack")*num1*(1+f1.getAttackPlus()));
		int defense1 = (int) ((Integer) map1.get("defense")*(1+f1.getDefensePlus()));
		//==================================
		int pid2 = f2.getArmys().get(pos2).getPid();
		int num2 = f2.getArmys().get(pos2).getNum();
		Map<String,Object> map2 = ArmysConfig.get(pid2);
		int hurt2 = (int) ((Integer)map2.get("attack")*num2*(1+f2.getAttackPlus()));
		int defense2 = (int) ((Integer) map2.get("defense")*(1+f2.getDefensePlus()));
		//=====================================
		switch(type){
		case 1:{
			if(hurt1 - defense2 > 0){
				int count = (hurt1 - defense2)/(Integer)map2.get("power");
				f2.getArmys().get(pos2).setNum(num2 - count >0?num2-count:0);
			}
			break;
		}
		case 2:{
			if(hurt2 - defense1 > 0){
				int count = (hurt2 - defense1)/(Integer)map1.get("power");
				f1.getArmys().get(pos2).setNum(num1 - count >0?num1-count:0);
			}
			break;
		}
		case 3:{
			if(hurt1 - defense2 > 0){
				int count = (hurt1 - defense2)/(Integer)map2.get("power");
				f2.getArmys().get(pos).setNum(num2 - count >0?num2-count:0);
			}
			if(hurt2 - defense1 > 0){
				int count = (hurt2 - defense1)/(Integer)map1.get("power");
				f1.getArmys().get(pos).setNum(num1 - count >0?num1-count:0);
			}
			break;
		}
		default:
			return;
		}
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
		Faction f1 = new Faction();
		f1.setSpeed(200);
		Faction f2 = new Faction();
		f2.setSpeed(401);
		WarService.war(f1, f2);
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
