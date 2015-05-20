package com.mina;

import java.util.Map;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import com.util.EncodeUtil;
import com.util.ProxyUtil;

public class MinaHandler implements IoHandler{
	
	private static final String pix = "com.action.";

	public void exceptionCaught(IoSession arg0, Throwable arg1)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

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
		String info = new String((byte[])arg1);
		String[] infos = info.split("#");
		String class_ = infos[0];
		String method_ = infos[1];
		Map<String,Object> map = (Map<String, Object>) ProxyUtil.invoke(pix+class_, method_, null);
		String ret=(String) map.get("report");
		int size = ret.getBytes("GBK").length;
		byte[] pix = ByteUtil.intToByte(size);
		byte[] msg = new byte[4+size];
		System.arraycopy(pix, 0, msg, 0, 4);
		System.arraycopy(ret.getBytes("GBK"), 0, msg, 4, size);
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
		byte[] pix = {1,3,5,6};
		
		byte[] ret = {55,88,99,5,7};
		
		byte[] msg = new byte[4+ret.length];
		
		System.arraycopy(pix, 0, msg, 0, 4);
		System.arraycopy(ret, 0, msg, 4, ret.length);
		
//		for(byte x : msg){
//			System.out.println(x);
//		}
	}

}
