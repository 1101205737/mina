package com.mina;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.util.SpringUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	IoAcceptor acceptor = new NioSocketAcceptor();
    	//acceptor.getFilterChain().addLast( "codec", new ProtocolCodecFilter( new PrefixedStringCodecFactory(Charset.forName("UTF-8"))));  
    	acceptor.setHandler(new MinaHandler());
    	acceptor.bind(new InetSocketAddress(8888));
        System.out.println( "Hello World!" );
        SpringUtil.initSpringContext();
    }
}
