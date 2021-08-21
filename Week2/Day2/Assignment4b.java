package week2.day2.assignment;

public class Assignment4b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "We learn java basics as part of java sessions in java week1";
		int num = 0;
		String[] word = input.split(" ");
		for (int i = 0; i < word.length; i++) {
			num++;
			for (int j = i + 1; j < word.length; j++) {
				if (word[i].equals(word[j])) {
					num++;
					word[j] = "";
				}
			}
			if (num >= 1) {
				System.out.print(word[i] + " ");
			}
		}
	}

}
