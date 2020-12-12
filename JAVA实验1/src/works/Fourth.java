package works;

/*
 * 时间：2020/11/8 21：09
 * 目的：
 * 		查找200-300中的素数
 */
public class Fourth {
	public static void main (String arg[])
	{
		int i,j;
		boolean isPrime;
		for(i = 200;i <= 300;i++)
		{
			isPrime = true;
			for(j = 2;j <= i-1; j++)
			{
				if(i % j == 0)
				{
					isPrime = false;
					break;
				}
			}
			if(isPrime)
			{
				System.out.print(i+" ");
			}
		}
	}
}
