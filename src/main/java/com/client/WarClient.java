package com.client;

import java.util.HashMap;

public class WarClient {

	public static void parse(HashMap map){
		System.out.println(map.get("report"));
		String report = (String) map.get("report");
		String[] items = report.split("#");
		System.out.println(items.length);
	}
}
