import java.util.Scanner;
public class Lesson_22_Activity_One {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner bot = new Scanner(System.in);
		System.out.println("Enter a string:");
		String word = bot.nextLine();
		int length = word.length();
		int x = 0;
		while (x<length){
			System.out.println(word.charAt(x));
			x++;
		}
	}

}
