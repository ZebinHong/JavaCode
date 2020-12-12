package works;

import java.util.Scanner;
public class Third {
	public static void main(String args[])
	{
		Scanner reader=new Scanner(System.in);
		int amount = 0;
		float price = 0,sum = 0;
		System.out.println("请输入产品数量（回车确认）：");
		amount=reader.nextInt();
		System.out.println("请输入产品价格（回车确认）");
		price=reader.nextFloat();
		sum=price*amount;
		System.out.printf("数量：%d,价格：%5.2f,总价值：%5.2f",amount,price,sum);
	}
}
