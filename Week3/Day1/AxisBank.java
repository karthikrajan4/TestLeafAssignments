package week3.day1.assignment;

public class AxisBank extends BankInfo {
	@Override
	public void deposit() {
		// TODO Auto-generated method stub
		System.out.println("This deposit is from override method");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankInfo obj1 = new BankInfo();
		obj1.saving();
		obj1.fixed();
		obj1.deposit();

		AxisBank obj2 = new AxisBank();
		obj2.deposit();
	}

}
