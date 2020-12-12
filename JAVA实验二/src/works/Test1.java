package works;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Test1 {
	public static void main(String args[]) {
		new textpass();
	}
}

class textpass extends JFrame implements ActionListener {
	private JPanel jp = new JPanel();
	private JLabel[] jlArray = { new JLabel("用户名"), new JLabel("密　码"), new JLabel("") };
	private JButton jb = new JButton("登陆");
	private JTextField jtxtName = new JTextField();
	private JPasswordField jtxtPassword = new JPasswordField();

	public textpass() {
		jp.setLayout(null);
		for (int i = 0; i < 2; i++) {
			jlArray[i].setBounds(30, 20 + i * 50, 80, 26);
			jp.add(jlArray[i]);
		}
		jb.setBounds(100, 130, 80, 26);
		jb.addActionListener(this);
		jp.add(jb);
		jtxtName.setBounds(80, 20, 180, 30);
		jp.add(jtxtName);
		jtxtName.addActionListener(this);
		jtxtPassword.setBounds(80, 70, 180, 30);
		jp.add(jtxtPassword);
		jtxtPassword.setEchoChar('*');
		jtxtPassword.addActionListener(this);
		jlArray[2].setBounds(10, 180, 300, 30);
		jp.add(jlArray[2]);
		this.add(jp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("登陆");
		this.setResizable(false);
		this.setBounds(100, 100, 300, 250);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource()==jtxtName){
			jtxtPassword.requestFocus();
		}else if(e.getSource()==jb){
			if(jtxtName.getText().equals("小红")&&String.valueOf(jtxtPassword.getPassword()).equals("123")){
				jlArray[2].setText("登陆成功");
			}else{
				jlArray[2].setText("登陆错误");
			}	
		}
	}
}