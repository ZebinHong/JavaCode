package works;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Seventeenth {
	public static void main(String args[]) {
		new ThreadFrame().setTitle("汉字打字练习");
	}
}

class WordThread extends Thread {
	char word;
	int startPosition = 19968; // Unicode表的19968位置至32320上的汉字
	int endPosition = 32320;
	JTextField showWord;
	int sleepLength = 6000;

	public void setJTextField(JTextField t) {
		showWord = t;
		showWord.setEditable(false);
	}

	public void setSleepLength(int n) {
		sleepLength = n;
	}

	public void run() {
		int k = startPosition;
		while (true) {
			word = (char) k;
			showWord.setText("" + word);
			try {
				Thread.sleep(sleepLength);// 调用sleep方法使得线程中断sleepLength豪秒
			} catch (InterruptedException e) {
			}
			k++;
			if (k >= endPosition) {
				k = startPosition;
			}
		}
	}
}

class ThreadFrame extends JFrame implements ActionListener {
	JTextField showWord;
	JButton button;
	JTextField inputText, showScore;
	WordThread giveWord;// 用WordThread声明一个giveWord线程象
	int score = 0;

	ThreadFrame() {
		showWord = new JTextField(6);
		showWord.setFont(new Font("", Font.BOLD, 72));
		showWord.setHorizontalAlignment(JTextField.CENTER);
		giveWord = new WordThread();// 创建giveWord线程
		giveWord.setJTextField(showWord);
		giveWord.setSleepLength(5000);
		button = new JButton("开始");
		inputText = new JTextField(10);
		showScore = new JTextField(5);
		showScore.setEditable(false);
		button.addActionListener(this);
		inputText.addActionListener(this);
		add(button, BorderLayout.NORTH);
		add(showWord, BorderLayout.CENTER);
		JPanel southP = new JPanel();
		southP.add(new JLabel("输入汉字（回车）:"));
		southP.add(inputText);
		southP.add(showScore);
		add(southP, BorderLayout.SOUTH);
		setBounds(100, 100, 350, 180);
		setVisible(true);
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

public void actionPerformed(ActionEvent e) {
	if(e.getSource()==button) {  
		if(!(giveWord.isAlive())){    
			giveWord=new WordThread();//创建giveWord   
			giveWord.setJTextField(showWord);  
			giveWord.setSleepLength(5000);   
			}          
		try {          
			giveWord.start();//giveWord调用方法start()  
			}           
		catch(Exception exe){}    
		}       
	else if(e.getSource()==inputText) {   
		if(inputText.getText().equals(showWord.getText()))
			score++;    
		showScore.setText("得分:"+score);     
		inputText.setText(null);     
   }   
}
}