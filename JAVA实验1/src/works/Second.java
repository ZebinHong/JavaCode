 package works;

public class Second {
	public static void main(String arg[])
	{
		System.out.println("你好，你只需编译我");
		A a=new A();
		a.fA();
		B b=new B();
		b.fB();
	}
	
}
class A
{
	void fA()
	{
		System.out.println("I am A");
	}
	
}
class B
{
	void fB()
	{
		System.out.println("I am B");
	}
}