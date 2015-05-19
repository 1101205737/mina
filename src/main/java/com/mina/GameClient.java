package com.mina;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

class GameClient {

	public static void main(String[] args) throws IOException{
		Map map = new HashMap();
		map.put("class", "CardAction");
		map.put("method", "extract");
		sendToServer(map,"com.client.WarClient","parse");
	}
	
	
	public static void sendToServer(Map param,String _class,String callback){
		IoConnector connector = new NioSocketConnector();
		connector.getFilterChain().addLast( "codec", new ProtocolCodecFilter( new ByteArrayCodecFactory()));  
		connector.setHandler(new ClientHandler(_class,callback));
		IoSession session = null;
		ConnectFuture future = connector.connect(new InetSocketAddress("127.0.0.1", 8888));
		future.awaitUninterruptibly();
		session = future.getSession();
		try {
			session.write(ByteUtil.objectToByte(param));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
