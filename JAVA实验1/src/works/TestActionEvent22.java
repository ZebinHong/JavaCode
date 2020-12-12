package works;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class TestActionEvent22 {

	public static void main(String[] args) {
		new TFFrame();
	}
}

class TFFrame extends JFrame {

	JTextField tf;

	TFFrame() {
		tf = new JTextField();
		tf.setFont(new Font("宋体", Font.BOLD, 40));
		add(tf);
		tf.addActionListener(new ActionListener() {		//匿名内部类
			public void actionPerformed(ActionEvent e) {
				String str = e.getActionCommand();
				System.out.println(str + "的长度:" + str.length());

				JTextField tf = (JTextField) e.getSource();
				// System.out.println(tf.getText());
				tf.setText("");
			}
		});
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

