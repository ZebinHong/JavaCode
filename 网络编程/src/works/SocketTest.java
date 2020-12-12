package works;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest {
	
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			//创建客户端套接字，用于交互服务端
			Socket socket = new Socket("192.168.193.1",9999);
			new ThreadClient(socket).start();
			while(true)
			{
				//将字节输出流包装成 数据字节流
				DataOutputStream dataOutputStream  = new DataOutputStream(socket.getOutputStream());
				dataOutputStream.writeUTF(scanner.next());
				dataOutputStream.flush();//刷新缓冲区 
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
class ThreadClient extends Thread
{
	
	private Socket socket;
	ThreadClient()
	{}
	ThreadClient(Socket socket)
	{
		this.socket = socket;
	}
	public void run()
	{
		try {
			while(true)
			{
				DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
				String message = dataInputStream.readUTF();
				System.out.println("服务端说："+message);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}