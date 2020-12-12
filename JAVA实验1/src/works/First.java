package works;

public class First {
	 public static void main (String args[ ]){
		 System.out.println("你好，很高兴学习Java语言");  //命令行窗口输出"你好，很高兴学习Java语言"
		 Student zhang = new Student();
		 zhang.speak();
	 }
}
class Student
{
	public void speak()
	{
		System.out.println("We are students");   //命令行窗口输"We are students" 
	}
}
