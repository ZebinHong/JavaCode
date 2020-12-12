package works;

public class Fourteenth {
	public static void main(String args[])
	{
		 Machine machine = new Machine();
		 Goods apple = new Goods("苹果");
		 apple.setIsDanger(false);
		 
		 Goods explosive = new Goods("炸药");
		 explosive.setIsDanger(true);
		 
		 try {
			 machine.checkBag(explosive);
			 System.out.println(explosive.getName()+"检查通过");
			 }     
		 catch(DangerException e) {
			 e.toShow(); //e调用toShow()方法
			 System.out.println(explosive.getName()+"被禁止!");
				 }   
		 
		 try {
			 machine.checkBag(apple);
			 System.out.println(apple.getName()+"检查通过");
			 }
		 catch(DangerException e) {
			 e.toShow();
			 System.out.println(apple.getName()+"被禁止!");
			 }
		 }
}

class DangerException extends Exception {
	String message;

	public DangerException() {
		message = "是危险品！";
	}

	public void toShow() {
		System.out.println(message);
	}
}

class Goods {
	String name;
	Boolean boo;

	Goods(String name) {
		this.name = name;
	}

	void setIsDanger(Boolean boo) {
		this.boo = boo;
	}

	Boolean isDanger() {
		return boo;
	}

	String getName() {
		return name;
	}
}

class Machine {
	void checkBag(Goods good) throws DangerException {
		if (good.isDanger()) {
			DangerException danger = new DangerException();
			throw danger;
		}
	}
}