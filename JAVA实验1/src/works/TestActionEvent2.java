package works;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class TestActionEvent2 {

	public static void main(String[] args) {
		new TFTrame();
	}
}

class TFTrame extends JFrame{

	JTextField tf;

	TFTrame() {
		tf = new JTextField();
		tf.setFont(new Font("宋体", Font.BOLD, 40));
		add(tf);
		TFActionListener listener = new TFActionListener();
		listener.setJTextField(tf);
		tf.addActionListener(listener);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class TFActionListener implements ActionListener {
	JTextField tf;
	public void setJTextField(JTextField tf)		//传递参数
	{
		this.tf = tf;
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println(tf.getText() + "的长度:" + tf.getText().length());
		tf.setText("");
	}
}
