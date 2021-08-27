package week3.day2.assignment;

public class Desktop implements HardWare, SoftWare {

	public void hardwareResources(String brand, String ram, String processor) {
		// TODO Auto-generated method stub
		System.out.println("*****This is from hardware interface*****");
		System.out.println("Brand:" + brand);
		System.out.println("RAM:" + ram);
		System.out.println("Processor:" + processor);
	}

	public void desktopModel(String model) {
		System.out.println("Current Model:" + model);
	}

	public void multipleInterface() {
		// TODO Auto-generated method stub
		System.out.println("This is from hardware interface");

	}

	public void softwareResources(String Os) {
		// TODO Auto-generated method stub
		System.out.println("Operating system: " + Os);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Desktop obj1 = new Desktop();
		obj1.hardwareResources("Lenovo", "8gb", "i5");
		obj1.desktopModel("Legion");
		obj1.softwareResources("Windows 10");
		obj1.multipleInterface();
	}

}
