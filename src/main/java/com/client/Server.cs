using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net;
using System.Net.Sockets;

namespace socket
{
    class Server
    {
        static void Main(string[] args)
        {
            string sendMessage = "{'method_':'extract','class_':'CardAction'}";
            Server s = new Server();
            Console.Write(s.Communicate(sendMessage));
            Console.ReadLine();
        }

        private byte[] result = new byte[4];
        public string Communicate(string msg)
        {
            IPAddress address = IPAddress.Parse("127.0.0.1");
            Socket client = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
            try
            {
                client.Connect(new IPEndPoint(address, 8888));
                Console.WriteLine("连接服务器成功");  
            }
            catch (Exception e) {
                Console.WriteLine("连接服务器失败，请按回车键退出！");
                return null;
            }

            
            try
            {
                client.Send(Encoding.ASCII.GetBytes(msg));
            }
            catch (Exception e)
            {
                Console.WriteLine("发送失败！");
                return null;
            }
            
  
            client.Receive(result);
            int ctxLength = byteToInt(result);
            Console.WriteLine("length" + ctxLength);

            if (ctxLength > 0)
            {
                byte[] ctx = new byte[ctxLength];
                client.Receive(ctx);
                return System.Text.Encoding.Default.GetString(ctx);
            }
            return null;
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
    }

}
