package works;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServerSocketTest {
	//定义集合存储每一个客户端Socket套接字
	public final static List<Socket> socketList =new ArrayList<>();

	public static void main(String args[]) {
		try{
			//创建ServerSocket(服务器套接字) 并指定端口号
			ServerSocket serverSocket = new ServerSocket(9999);

			
			while(true)
			{
				//通过服务器套接字监听客户端的连接，如果没有客户端连接，那么程序一直会停留再此处
				Socket socket=serverSocket.accept();
				System.out.println("-------服务器暴露成功-------");
				
				//将每一个客户端socket存放在集合中
				socketList.add(socket);
				
				System.out.println("当前在线人数："+socketList.size());
				
				new ThreadServer(socket).start();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
class ThreadServer extends Thread
{
	private Socket socket;
	ThreadServer(){}
	ThreadServer(Socket socket)
	{
		this.socket = socket;
	}
	public void run()
	{
		try{
			while(true)
			{
				DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
				String message = dataInputStream.readUTF();
				//广播信息给每一个客户端
				for(int i=0;i<ServerSocketTest.socketList.size();++i)
				{
					Socket socket = ServerSocketTest.socketList.get(i);
					DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
					dataOutputStream.writeUTF(message);
					dataOutputStream.flush();
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}