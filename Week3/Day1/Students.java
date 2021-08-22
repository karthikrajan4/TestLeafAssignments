package week3.day1.assignment;

public class Students {

	public static void getStudentInfo(int id) {
		System.out.println("The student ID(1) is: " + id);

	}

	public static void getStudentInfo(int id, String name) {
		System.out.println("The stuent ID(2) is: " + id);
		System.out.println("The student name is: " + name);
	}

	public static void getStudentInfo(String email, double mobile) {
		System.out.println("The email ID is: " + email);
		System.out.println("The mobile nubmer is: " + mobile);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Students obj = new Students();
		obj.getStudentInfo(2365);
		obj.getStudentInfo(36321, "Karthik");
		obj.getStudentInfo("testmail@gmail.com", 986564646);

	}

}
