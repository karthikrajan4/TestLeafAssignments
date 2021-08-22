package week3.day1.assignment.org.student;

import week3.day1.assignment.org.department.Department;

public class Student extends Department {
	public void StudentName(String Name) {
		System.out.println("Student name is: " + Name);
	}

	public void studentDept(String department) {
		System.out.println("Department is: " + department);
	}

	public void studentID(double id) {
		System.out.println("Student ID is: " + id);
	}

	public static void main(String[] args) {
		Student obj = new Student();
		obj.CollegeName("Sastra");
		obj.CollegeCode("N1239");
		obj.CollegeRank(232332);
		obj.deptName("SEEE");
		obj.StudentName("Karthik");
		obj.studentDept("E&I");
		obj.studentID(323432423);

	}
}
