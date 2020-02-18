import java.util.Scanner;

public class Main {
	static Scanner bot = new Scanner(System.in);
	static BankAccount[] bAccount = new BankAccount[5];
	
	public void mainMenu(){
		
		char quit = 'n';
		String temp;
		while(quit!='y'){
		System.out.println("Welcome to Los Santos Bank! Please choose an option from below! Input what number option you would like to perform!");
		System.out.print("1.Create an account\n2.Log In to Account\n3.List accounts\n4.Delete Account\n5.Exit\n");
		int menuChoice = bot.nextInt();
		switch(menuChoice){
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		}
		
		System.out.println("Would you like to quit");
		temp = bot.nextLine();
		quit = temp.charAt(0);
		
		
		}
	
	}
	
	
	
	
	public static void main(String[] args) {
		
		BankAccount bank = new BankAccount();
		Scanner bot = new Scanner(System.in);
		Main atm = new Main();
		atm.mainMenu();

	}

}
