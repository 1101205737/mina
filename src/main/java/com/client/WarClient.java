package com.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.mina.GameClient;

public class WarClient {

	public static void parse(HashMap map){
		System.out.println(map.get("report"));
		String report = (String) map.get("report");
		String[] items = report.split("#");
		System.out.println(items.length);
	}
	
	
	public static void main(String[] args) throws IOException{
		Map map = new HashMap();
		map.put("class", "CardAction");
		map.put("method", "extract");
		GameClient.sendToServer(map,"com.client.WarClient","parse");
	}
}
