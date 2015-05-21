package com.mina;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import com.util.ProxyUtil;

public class MinaHandler implements IoHandler{
	
	private static final String pix = "com.action.";

	public void exceptionCaught(IoSession arg0, Throwable arg1)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	public void messageReceived(IoSession session, Object arg1) throws Exception {
		System.out.println("param=="+new String((byte[])arg1));
		//对象形式(java)
		/*if(arg1 instanceof byte[]) {
			Map para = (Map) ByteUtil.byteToObject((byte[]) arg1);
			String class_ = (String) para.get("class");
			String method_ = (String) para.get("method");
			Map map = (Map) ProxyUtil.invoke(pix+class_, method_, null);
			session.write(ByteUtil.objectToByte(map));
			session.close();
		}*/
		//=========================================================================
		//byte形式(c++)
		String jsonStr = new String((byte[])arg1);
		JSONObject json = JSONObject.fromObject(jsonStr);
		Map<String,Object> map = null;
		if(json.containsKey("param"))
			map = (Map<String, Object>) ProxyUtil.invoke(pix+json.getString("class_"), json.getString("method_"), json.getString("param"));
		else
			map = (Map<String, Object>) ProxyUtil.invoke(pix+json.getString("class_"), json.getString("method_"));
		json = JSONObject.fromObject(map);
		int size = json.toString().getBytes("GBK").length;
		byte[] pix = ByteUtil.intToByte(size);
		byte[] msg = new byte[4+size];
		System.arraycopy(pix, 0, msg, 0, 4);
		System.arraycopy(json.toString().getBytes("GBK"), 0, msg, 4, size);
		session.write(msg);
		session.close();
	}

	public void messageSent(IoSession arg0, Object arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void sessionClosed(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void sessionCreated(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void sessionIdle(IoSession arg0, IdleStatus arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void sessionOpened(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args){
		String str = "{'method_':'cc','class_':'abc'}";
		JSONObject json = JSONObject.fromObject(str);
		Map map = new HashMap();
		for(Object key : json.keySet()){
			map.put(String.valueOf(key), json.get(key));
		}
		System.out.println(map.toString());
	}

}
