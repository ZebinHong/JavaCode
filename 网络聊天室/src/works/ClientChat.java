package works;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ClientChat {

	private JFrame mainWin = new JFrame("聊天窗口");

	// 消息展示框
	private JTextArea displayTa = new JTextArea(14, 40);
	// 在线用户名称展示框
	private DefaultListModel<String> userListModel = new DefaultListModel<>();
	private JList<String> userList = new JList<>(userListModel);
	// 消息发送框
	private JTextArea inputTF = new JTextArea(4, 40);
	// 消息按钮
	private JButton sendBn = new JButton("发送");
	// 用户记录当前聊天用户名
	private String curUser;

	public static void main(String[] args) {
		new ClientChat().init();
	}

	private void init() {
		try {
			// 通过弹出对话框获取用户输入的用户名
			String userName = JOptionPane.showInputDialog(mainWin, "请输入您的用户名：");
			// 把用户输入的用户名，赋给curUser
			curUser = userName;
			mainWin.setTitle("欢迎使用 "+curUser+"聊天室应用");

			// 创建套接字
			Socket socket = new Socket("192.168.193.1", 9999);
			// 向服务器声明
			DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
			//发送用户名到服务端
			dataOutputStream.writeUTF("①②③④"+userName+"①②③④");
			dataOutputStream.flush();

			// 开启线程，用于读取服务器发送的信息
			new ThreadClient(socket, this).start();

			JPanel bottomPanel = new JPanel();

			// 将消息框和按钮添加到窗口的底端
			mainWin.add(bottomPanel, BorderLayout.SOUTH);
			bottomPanel.add(inputTF);
			bottomPanel.add(sendBn);

			ActionListener listener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// 获取用户发送的消息
					String message = inputTF.getText();
					sendSms(message,socket);
				}
			};
			// 给发送消息按钮绑定点击事件监听器
			sendBn.addActionListener(listener);

			JPanel centerPanel = new JPanel();

			// 将展示消息区centerPanel添加到窗口的中间
			mainWin.add(centerPanel);
			// 让展示消息区可以滚动
			centerPanel.add(new JScrollPane(displayTa));
			displayTa.setEditable(false);
			// 用户列表和是否私聊放到窗口的最右边
			Box rightBox = new Box(BoxLayout.Y_AXIS);
			userList.setFixedCellWidth(60);
			userList.setVisibleRowCount(13);
			rightBox.add(new JLabel("用户列表："));
			rightBox.add(new JScrollPane(userList));

			centerPanel.add(rightBox);

			// 关闭窗口退出当前程序
			mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainWin.pack(); // swing加上这句就可以拥有关闭窗口的功能
			mainWin.setVisible(true);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
		//点击发送后将消息发送到服务器
		protected void sendSms(String sms, Socket socket) {
			try {
				//发送聊天消息到服务端
				DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
				dataOutputStream.writeUTF(sms);
				dataOutputStream.flush();	
				 
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		public DefaultListModel<String> getUserListModel() {
			return userListModel;
		}

		public JTextArea getDisplayTa() {
			return displayTa;
		}
		public JTextArea getInputTF()
		{
			return inputTF;
		}
}

// 定义线程类，用来读取服务器发送的信息
class ThreadClient extends Thread {
	private Socket socket;
	private ClientChat clientChat;

	ThreadClient() {
	}

	ThreadClient(Socket socket, ClientChat clientChat) {
		this.socket = socket;
		this.clientChat = clientChat;
	}

	@Override
	public void run() {

		try {
			while (true) {
				DataInputStream DataInputStream = new DataInputStream(socket.getInputStream());
				String message = DataInputStream.readUTF();

				if(message.startsWith("①②③④")&&message.endsWith("①②③④"))
				{
					//说明信息是用户名
					String[] names = message.replace("①②③④","").split(",");
					// 将用户列表先清空
					clientChat.getUserListModel().clear();
					for (int i = 0; i < names.length; ++i) {
						clientChat.getUserListModel().addElement(names[i]);
					}
				}
				else
				{
					//说明是聊天信息，将聊天信息放在displayTa中
					clientChat.getInputTF().setText("");
					clientChat.getDisplayTa().append(message+"\t\n");
				}

				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
