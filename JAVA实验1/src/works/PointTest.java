package works;

class Point {
	double x, y;
	public void setXY(double a,double b)
	{
		x=a;
		y=b;
	}
	public double getX()
	{
		return x;
	}
	public double getY()
	{
		return y;
	}
	public void disp()
	{
		System.out.println("点的坐标为：("+x+","+y+")");
	}
}

public class PointTest {
	public static void main(String arg[])
	{
		Point p=new Point();
		p.setXY(3.8,4.0);
		p.disp();
		System.out.println(p.x);
	}
}
