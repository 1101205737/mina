package com.mina;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.util.SpringUtil;

/**
 * Hello world!
 *
 */
public class GameServer 
{
    public static void main( String[] args ) throws IOException
    {
    	IoAcceptor acceptor = new NioSocketAcceptor();
    	acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter( new ByteArrayCodecFactory()));
    	acceptor.setHandler(new MinaHandler());
    	acceptor.bind(new InetSocketAddress(8888));
       // SpringUtil.initSpringContext();
        System.out.println( "Server is running..." );
    }
}
