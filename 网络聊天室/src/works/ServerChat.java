package works;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ServerChat {

	//定义Map集合用于存储用户的Socket以及用户的名字   key:Socket    Value:用户名
	public final static Map<Socket,String> socketsMaps = Collections.synchronizedMap(new HashMap<Socket,String>());
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// 创建服务端套接字
			ServerSocket serverSocket = new ServerSocket(9999);
			System.out.println("------服务端暴露-------");
			while (true) {
				// 监听客户端套接字，若有客户端连接，则代码不会往下执行，否则会堵塞在此处。
				Socket socket = serverSocket.accept();

				// 开启线程，用于读取客户端发送的信息，并转发给每一个客户端
				new ThreadServer(socket).start();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

class ThreadServer extends Thread {
	private Socket socket;
	ThreadServer(){};
	ThreadServer(Socket socket)
	{
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			while(true)
			{
				DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
				String data = dataInputStream.readUTF();
				
				if(data.startsWith("①②③④")&&data.endsWith("①②③④"))
				{
					//发送过来的是用户名
					//将Socket以及用户名字都存放在Map集合中
					ServerChat.socketsMaps.put(socket, data.replace("①②③④",""));
					//获取所有的key(Socket)，将所有用户的名字发送至客户端
					Set<Socket> sockets = ServerChat.socketsMaps.keySet();
					//获取所有的用户的名字，将这些名字拼装成一个字符串
					Collection<String> names = ServerChat.socketsMaps.values();
					StringBuffer sbf = new StringBuffer();
					for(String userName :names)
					{
						sbf.append(userName).append(",");
					}
					System.out.println("sbf:"+sbf.toString());
					for(Socket soc:sockets)
					{
						DataOutputStream dataOutputStream = new DataOutputStream(soc.getOutputStream());
						dataOutputStream.writeUTF("①②③④"+sbf.toString()+"①②③④");
						dataOutputStream.flush();
					}
				}
				else{
					//发送过来的是聊天信息
					//获取所有的key(Socket)，将所有用户的名字发送至客户端
					Set<Socket> sockets = ServerChat.socketsMaps.keySet();
					//將聊天信息广播出去
					for(Socket soc:sockets)
					{
						DataOutputStream dataOutputStream = new DataOutputStream(soc.getOutputStream());
						dataOutputStream.writeUTF("[ "+ServerChat.socketsMaps.get(socket)+" ]说："+data);
						dataOutputStream.flush();
					}
					
					
				}
				
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
