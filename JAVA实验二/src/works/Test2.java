package works;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Test2 {
	public static void main(String args[])
	{
		JFrame f=new JFrame("Menu");
		
		JMenuBar menuBar=new JMenuBar();
		
		JMenu menu1=new JMenu("File");
		JMenu menu2 = new JMenu("Format");
		JMenu menu3 = new JMenu("Help");
		JMenu menu4 = new JMenu("进制");
		
		JMenuItem menuItem1 = new JMenuItem("中文");
		JMenuItem menuItem2 = new JMenuItem("二进制");
		JMenuItem menuItem3 = new JMenuItem("八进制");
		JMenuItem menuItem4 = new JMenuItem("十进制");

		menu4.add(menuItem1);
		menu4.add(menuItem2);
		menu4.add(menuItem3);
		menu4.add(menuItem4);
		
		menu2.add(menuItem1);
		menu2.add(menu4);
		
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		
		f.setJMenuBar(menuBar);
		f.setVisible(true);
		f.setSize(500,500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
