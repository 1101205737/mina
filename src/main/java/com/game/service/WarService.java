package com.game.service;

public class WarService {

	public static void war(Faction f1,Faction f2){

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
			time+=temp;
			if(time%t1 == 0 && time%t2 == 0){
				System.out.println("1,2对击");
			}else if(time%t1 == 0){
				System.out.println("1攻击");
			}else if(time%t2 == 0){
				System.out.println("2攻击");
			}
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
}
