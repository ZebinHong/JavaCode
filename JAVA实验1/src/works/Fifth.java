package works;

public class Fifth {
	public static void main(String[] args) {
		Student1 s1 = new Student1(90221, 2, "Tom", "male", 20);
		System.out.println(s1.toString());
	}
}
class Student1 {
	private long studentID;
	private int classID;
	private String name;
	private String sex;
	private int age;

	public Student1(long studentID, int classID, String name, String sex, int age) {
		this.studentID=studentID;
		this.classID=classID;
		this.name=name;
		this.sex=sex;
		this.age=age;
	}

	public long getStudentID() {
		return studentID;
	}

	public int getClassID() {
		return classID;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public int getAge() {
		return age;
	}

	public String toString() {
		return "学号：" + getStudentID() + "\n班号：" + getClassID() + "\n姓名：" + getName() + "\n性别：" + getSex() + "\n年龄："
				+ getAge();
	}
}

