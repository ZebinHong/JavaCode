/*
 	时间：2020/11/8 20：28
	目的：
	拆分浮点型数据的整数小数部分
*/

package works;
import java.io.*;
public class ParseDouble {   
	public static void main(String args[]) 
	{
		String s;
		double d;
		int i;
		boolean b = false;
		do {
			try {
				System.out.println("请输入一个浮点数: ");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				s = br.readLine();          // 以字符串方式读入        
				i = s.indexOf('.');         // 找到小数点的位置
				d = Double.parseDouble(s);  // 将字符串转换成浮点数
				System.out.println(d + " 整数部分为：" + (long)d);
				if(i == -1)                 // 若没有小数点，则没有小数部分          
					System.out.println(d + " 小数部分为：0.0");         
				else                        // 若有小数点，则截取小数点后的字符串合成浮点数           
					System.out.println(d +" 小数部分为：" +Double.parseDouble(((s.charAt(0)=='-') ? "-" : "") +"0." +s.substring(i+1,s.length())));
				b = false;     
				System.out.println(i);
				}      
			catch(NumberFormatException nfe) {
				System.out.println("输入浮点数格式有误。\n");
				b = true;
				}
			catch(IOException ioe) {
				b = false;
				}
		}
		while(b);// 浮点格式错误时重新输入   
	}           // end of main 
}       	// end of class

/*
	在Eclipse中的结果为：
	请输入一个浮点数: 
	-5.997
	-5.997 整数部分为：-5
	-5.997 小数部分为：-0.997
*/