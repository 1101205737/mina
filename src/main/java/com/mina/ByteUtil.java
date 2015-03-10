package com.mina;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ByteUtil {

	public static byte[] shortToByte(short value){
		int temp = value;  
        byte[] b = new byte[2];  
        for (int i = 0; i < b.length; i++) {  
            b[i] = (byte) (temp & 0xff);// 将最低位保存在最低位  
            temp = temp >> 8;// 向右移8位  
        	System.out.println(b[i]);
        }  
        return b; 
	}
	
	
	public static short byteToShort(byte[] b) {  
        short s = 0;  
        short s0 = (short) (b[0] & 0xff);// 最低位  
        short s1 = (short) (b[1] & 0xff);  
        s1 <<= 8;  
        s = (short) (s0 | s1);  
        return s;  
    }  
	
	
	public static byte[] intToByte(int value){
		int temp =value;
		byte[] b = new byte[4];
		for(int i=0;i<b.length;i++){
			b[i] = (byte) (temp & 0xff);
			temp = temp>>8;
			System.out.println(b[i]);
		}
		return b;
	}
	
	
	public static int byteToInt(byte[] b){
		int a1 = b[0] & 0xff;
		int a2 = b[1] & 0xff;
		int a3 = b[2] & 0xff;
		int a4 = b[3] & 0xff;
		a4 = a4 <<24;
		a3 = a3 <<16;
		a2 = a2 <<8;
		return a4|a3|a2|a1;
	}
	
	public static byte[] objectToByte(Object obj) throws IOException{
		  ByteArrayOutputStream bos = new ByteArrayOutputStream();   
		  ObjectOutputStream oos = new ObjectOutputStream(bos);   
		  oos.writeObject(obj);   
		  byte[] b =  bos.toByteArray();  
		  oos.close();
		  bos.close();
		  return b;
	}
	
	 public static Object byteToObject(byte[] bytes) throws IOException, ClassNotFoundException {  
		 Object obj;  
		 ByteArrayInputStream bi = new ByteArrayInputStream(bytes);  
		 ObjectInputStream oi = new ObjectInputStream(bi);  
		 obj = oi.readObject();  
		 bi.close();  
		 oi.close();  
		 return obj;  
	}  
	 
	 
	 
	
	public static void main(String[] args){
		int s = 960;
		System.out.println(byteToInt(intToByte(s)));
	}
}
