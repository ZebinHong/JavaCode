package works;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class Thirteenth {
	public static void main(String args[]) {
		ComputerFrame cf = new ComputerFrame();
		cf.setSize(1000, 500);
		cf.setVisible(true);
		cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class ComputerFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1447563584037528969L;

	ComputerFrame() {
		Teacher teacher = new Teacher(); // 定义监听器
		setTitle("算术测试");
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("选择级别");
		JMenuItem menuItem1 = new JMenuItem("儿童级别");
		JMenuItem menuItem2 = new JMenuItem("幼儿级别");

		menu.add(menuItem1);
		menu.add(menuItem2);
		menuBar.add(menu);
		setJMenuBar(menuBar);
		menuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacher.setMaxInteger(50);
			}
		});
		menuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacher.setMaxInteger(10);
			}
		});
		setLayout(new FlowLayout()); // 设置为浮动布局
		JTextField num1 = new JTextField(5);
		JLabel ch1 = new JLabel("+");
		ch1.setFont(new Font("Arial", Font.BOLD, 20)); // 设置字体
		JTextField num2 = new JTextField(5);
		JLabel ch2 = new JLabel("=");
		ch2.setFont(new Font("Arial", Font.BOLD, 20));
		JTextField answer = new JTextField(5);
		JButton confirm = new JButton("确认答案");
		JLabel prompt = new JLabel("你还没有回答呢!");
		prompt.setFont(new Font("宋体", Font.BOLD, 15)); // 设置字体
		prompt.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(180, 180, 180))); // 设置输入框下线和颜色
		JButton gain = new JButton("获取题目");
		num1.setEditable(false);
		num2.setEditable(false);
		add(num1);
		add(ch1);
		add(num2);
		add(ch2);
		add(answer);
		add(confirm);
		add(prompt);
		add(gain);

		teacher.setJTextField(num1, num2, answer);
		teacher.setJLabel(prompt, ch1);
		gain.addActionListener(teacher);
		confirm.addActionListener(teacher);
		gain.setActionCommand("gain");
		confirm.setActionCommand("confirm");
		answer.setActionCommand("answer");
	}
}

class Teacher implements ActionListener {
	JTextField num1, num2, answer;
	JLabel operatorLabel, prompt;
	int n3, n4, sum;
	String operator = "";
	int maxInteger = 0; // 题目中出现的最大的数
	Random random;

	Teacher() {
		random = new Random();
	}

	public void setMaxInteger(int n) {
		maxInteger = n;
	}

	public void setJLabel(JLabel... l) {
		// TODO Auto-generated method stub
		prompt = l[0];
		operatorLabel = l[1];
	}

	public void setJTextField(JTextField... n) {
		// TODO Auto-generated method stub
		this.num1 = n[0];
		this.num2 = n[1];
		this.answer = n[2];
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = e.getActionCommand();
		if (str.equals("gain")) {
			if (maxInteger != 0) {
				n3 = random.nextInt(maxInteger) + 1;
				n4 = random.nextInt(maxInteger) + 1;
				double d = Math.random();
				if (d < 0.5)
					operator = "+";
				else
					operator = "-";
				num1.setText("" + n3);
				num2.setText("" + n4);
				operatorLabel.setText(operator);
				prompt.setText("请回答");
				answer.setText(null);
			} else {
				prompt.setText("请选择级别");
			}

		} else if (str.equals("confirm")) {
			String s = answer.getText();
			try {
				sum = Integer.parseInt(s);
				if (operator == "+") {
					if (sum == (n3 + n4)) {
						prompt.setText("答对啦！");
					} else {
						prompt.setText("答错啦！");
					}
				} else if (operator == "-") {
					if (sum == (n3 - n4)) {
						prompt.setText("答对啦！");
					} else {
						prompt.setText("答错啦！");
					}
				}
			} catch (NumberFormatException ex) {
				prompt.setText("请输入字符");
			}
		}
	}
}