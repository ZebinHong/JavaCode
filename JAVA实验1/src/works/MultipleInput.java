package works;

import java.util.*;

public class MultipleInput {
	public static void main (String arg[])
	{
		int n = 0;
		double sum = 0;
		Scanner reader = new Scanner(System.in);
		while (reader.hasNextDouble())
		{
			sum += reader.nextDouble();
			n++;
		}
		System.out.printf ("%d个数的和为：%f",n,sum);
		System.out.printf ("%d的平均值为：%f",n,sum/n);
	}
}
