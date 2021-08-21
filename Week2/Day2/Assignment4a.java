package week2.day2.assignment;

public class Assignment4a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "Tes12Le79af65";
		int x=0;
		char[] character=word.toCharArray();
		for(int i=0;i<character.length;i++) {
			char charValue=character[i];
			if(Character.isDigit(charValue)) {
					int a=Character.getNumericValue(charValue);
					x=x+a;
			}
		}
		System.out.println("sum =  "+ x);
	}


}
