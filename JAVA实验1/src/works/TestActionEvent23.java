package works;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class TestActionEvent23 {

	public static void main(String[] args) {
		new TFFrame(); 	
	}
}
class TFrame extends JFrame{

	class TActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {  //内部实现
			tf.setText("");
		}	
	}
	JTextField tf;
	TFrame(){
		tf = new JTextField(); 
		tf.setFont(new Font("宋体",Font.BOLD,40));
		add(tf);	
		TActionListener listener = new TActionListener();
		tf.addActionListener(listener);
		pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
}



