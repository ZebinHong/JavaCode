package works;

import java.util.Random;
import java.util.Scanner;
public class RandNumber {
	public static void main (String args[])
	{	
		int isRestart = 1;
		while(isRestart == 1)
		{
		int a=0;
		Random rand=new Random();
		int n=rand.nextInt(100)+1;  //电脑生成的数字
		System.out.println("电脑随机生成的数字是："+n);
		Scanner read=new Scanner(System.in);
		System.out.println("请输入要猜的数字：");
		int m=read.nextInt();    //用户输入的数字
		while(m!=n)
		{
			a++;
			if(m>n)
				System.out.println("你猜的数字偏大");
			else if(m<n)
				System.out.println("你猜的数字偏小");
			System.out.println("请再次输入要猜的数字");
			m=read.nextInt();
		}
		System.out.println("猜对了！");
		System.out.println("你一共猜了"+a+"次");
		System.out.println("请输入数字以进行是否重新开始(1),或者退出(0)");
		isRestart=read.nextInt();
		}
		System.out.println("您已成功退出。");
	}
}
