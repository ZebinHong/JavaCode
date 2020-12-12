package works;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ClassWindow {
	public static void main(String args [])
	{
		Windows windows =new Windows();
		windows.setSize(1000, 500);
		windows.setVisible(true);
		windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}

class Windows extends JFrame {
	Windows()
	{
		setTitle("带菜单的窗口");
		JMenuBar menuBar=new JMenuBar();
		JMenu menu1= new JMenu("文件F");
		JMenu menu2 =new JMenu("新建N");
		JMenu menu3 = new JMenu("Project");
		JMenuItem menuItem1 = new JMenuItem("打开（O）");
		JMenuItem menuItem2 = new JMenuItem("保存（S）");
		JMenuItem menuItem3 = new JMenuItem("class");
		JMenuItem menuItem4=new JMenuItem("Java");
		JMenuItem menuItem5=new JMenuItem("C");
		menu3.add(menuItem4);
		menu3.add(menuItem5);
		menu2.add(menuItem3);
		menu2.add(menu3);
		menu1.add(menu2);
		menu1.add(menuItem1);
		menu1.add(menuItem2);
		menuBar.add(menu1);
		setJMenuBar(menuBar);
	}
}
