import java.util.Scanner;

public class Main {
	static Scanner bot = new Scanner(System.in);
	static BankAccount[] bAccount = new BankAccount[5];

	public static void main(String[] args) {

		Scanner bot = new Scanner(System.in);
		Main atm = new Main();
		atm.mainMenu();
	}

	public void mainMenu() {
		String userInput = "";
		while (!userInput.equals("Exit")) {
			printHeader();
			userInput = bot.nextLine();
			if (userInput.equals("Log In")) {
				login();
			} else if (userInput.equals("List")) {
				list();
			} else if (userInput.equals("Create")) {
				create();
			}
		}
	}

	public void login() {
		System.out.println("Enter your username and password.");
		String username = bot.nextLine();
		int password = bot.nextInt();
		if (username.equals(bAccount[BankAccount.numAcc - 1].getName())
				&& password == bAccount[BankAccount.numAcc - 1].getPinNum()) {
			int i = BankAccount.numAcc;
			loggedin(bAccount[i]);
		} else {
			System.out.println("Sorry we cannot find your account");
		}
	}

	public void create() {
		if (BankAccount.numAcc <= 4) {
			System.out.println("Enter a username, password, and deposit amount");
			String username = bot.nextLine();
			int password = bot.nextInt();
			double deposit = bot.nextDouble();
			bAccount[BankAccount.numAcc] = new BankAccount(username, deposit, password);
			System.out.println(BankAccount.numAcc);
		} else {
			System.out.println("You cannot make more accounts");
		}
	}

	public void delete() {
		System.out.println("Enter your username and password");
		String username = bot.nextLine();
		int password = bot.nextInt();
		if (username == bAccount[BankAccount.numAcc].getName()
				&& password == bAccount[BankAccount.numAcc].getPinNum()) {

		} else {
			System.out.println("Sorry we cannot find your account");
		}
	}

	public void list() {
		for (int i = 0; i < BankAccount.numAcc; i++) {
			System.out.println(bAccount[i].getName());
		}
	}

	public void loggedin(BankAccount x) {
		String userInput = "";
		while (!userInput.equals("Exit")) {
			System.out.println("Get Balance\nDeposit\nWithdraw\nExit");
			userInput = bot.nextLine();
			if (userInput.equals("Get Balance")) {
				System.out.println(x.getBalance());
			} else if (userInput.equals("Deposit")) {
				deposit(x);
			} else if (userInput.equals("Withdraw")) {
				withdraw(x);
			}
		}
	}

	public void deposit(BankAccount x) {
		System.out.println("How much do you want to deposit");
		double amount = bot.nextDouble();
		x.deposit(amount);
	}

	public void withdraw(BankAccount x) {
		System.out.println("How much do you want to withdraw");
		double amount = bot.nextDouble();
		if (x.getIsLocked() == true) {
			System.out.println("Sorry your account is locked");
		} else {
			x.withdraw(amount);
		}
	}

	private void printHeader() {
		System.out.println(
				"\nWelcome to Los Santos Bank! Please choose an option from below! Input what number option you would like to perform!");
		System.out.print("1.Log In\n2.Create\n3.List\n4.Delete\n5.Exit\n");

	}

}
