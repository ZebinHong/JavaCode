package works;


public class Example12_1 { 
   public  static void main(String args[]) { //主线程
	   Speak speak1=new Speak("大象");
	   Speak speak2=new Speak("轿车");
	   Thread speakElephant =new Thread(speak1);
	   Thread speakCar = new Thread(speak2);
       speakElephant.start();                          //启动线程 
       speakCar.start();                         //启动线程
       for(int i=1;i<=15;i++) {
          System.out.print("主人"+i+"  ");
       }  
   }
}

class Speak implements Runnable
{
	String name;
	Speak(String name)
	{
		this.name=name;
	}
	public void run()
	{
		for(int i=1;i<=20;i++)
		{
			System.out.print(name+i+"  ");
		}
	}
}