package com.mina;

import java.util.Map;

import org.apache.mina.core.buffer.IoBuffer;
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

	public void messageReceived(IoSession arg0, Object arg1) throws Exception {
		if(arg1 instanceof byte[]) {
			Map para = (Map) ByteUtil.byteToObject((byte[]) arg1);
			String class_ = (String) para.get("class");
			String method_ = (String) para.get("method");
			ProxyUtil.invoke(pix+class_, method_, null);
		}
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

}
