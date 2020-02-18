import java.util.Scanner;
class Lesson_24_Activity_Three {
	public static void main(String[] args) {

		Scanner bot = new Scanner(System.in);
		System.out.println("Enter a number between 0 and 100");
		int num = bot.nextInt();
		int count = 0;
		if(num<=0||num>=100){
			System.out.println("error");
		} else {
			for(int i=num;i<=100;i++){
				count++;
				System.out.print(i+" ");
				if(count%20==0)
					System.out.print("\n");
			}
		}
		}
	}