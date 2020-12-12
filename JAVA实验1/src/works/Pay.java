package works;

public class Pay {
	public static void main(String args[])
	{
		Employee e1;
		e1=new Manager("经理",5000);
		e1.ComputeSalary();
		e1=new Salesman("销售员",3000,10000,0.1);
		e1.ComputeSalary();
		e1=new Worker("工人",30);
		e1.ComputeSalary();
	}
}

abstract class Employee
{
	private String name;
	Employee(){}
	Employee(String name)
	{
		this.setName(name);
	}
	public abstract void ComputeSalary();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

class Manager extends Employee
{
	private double salary;
	Manager(){}
	Manager(String name,double salary)
	{
		super(name);
		this.salary=salary;
	}
	public void ComputeSalary()
	{
		System.out.println("经理：每月一份固定工资："+this.salary+"元");
	}
}
class Salesman extends Employee
{
	private double salary;  //基本工资
	private int salesVolume;//销售额
    private double royalty;//提成率
    private double sumS;   //总工资
	Salesman(String name,double salary,int salesVolume,double royalty)
	{
		super(name);
		this.salary=salary;
		this.salesVolume=salesVolume;
		this.royalty=royalty;
	}
	public void ComputeSalary()
	{
		sumS = this.salary+salesVolume*royalty;
		System.out.println("销售员：基本工资和提成为："+sumS+"元");
	}
}
class Worker extends Employee
{
	private int days;   //工作天数
	private double salary; 
	Worker(String name,int days)
	{
		super(name);
		this.days = days;
	}
	public void ComputeSalary()
	{
		salary=days*120;
		System.out.println("工人：工作"+days+"天，工资为"+salary+"元");
	}
}