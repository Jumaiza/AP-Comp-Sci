import java.util.Scanner;
public class Lesson_22_Activity_Two {
	public static void main(String[] args) {

		Scanner bot = new Scanner(System.in);
		System.out.println("Enter a string:");
		String word = bot.nextLine();
		int length = word.length();
		int x = 0;
		while (x<length){
			System.out.print("\t");
			System.out.println(word.charAt(x));
			x++;
		}
	}

}