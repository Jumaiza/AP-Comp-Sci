import java.util.Scanner;

public class Main {
	static Scanner bot = new Scanner(System.in);
	static BankAccount[] bAccounts = new BankAccount[5];

	public static void main(String[] args) {

		Scanner bot = new Scanner(System.in);
		Main atm = new Main();
		atm.mainMenu();
	}

	public void mainMenu() {
		String userInput = "";
		while (!userInput.equals("5")) {
			printHeader();
			userInput = bot.nextLine();
			if (userInput.equals("1")) {
				login();
			} else if (userInput.equals("2")) {
				list();
			} else if (userInput.equals("3")) {
				create();
			} else if (userInput.equals("4")) {
				delete();
			}
		}
	}

	public void login() {
		if (BankAccount.numAcc > 0) {
			boolean logged = false;
			System.out.println("Enter your username");
			String username = bot.nextLine();
			System.out.println("Enter your password");
			int password = bot.nextInt();
			bot.nextLine();
			for (int i = 0; i < bAccounts.length; i++) {
				if (bAccounts[i] != null) {
					if (username.equals(bAccounts[i].getName()) && password == bAccounts[i].getPinNum()) {
						logged = true;
						loggedin(bAccounts[i]);
					}
				}
			}
		} else {
			System.out.println("There are no accounts created");
		}
	}

	public void create() {
		if (BankAccount.numAcc <= 4) {
			System.out.println("Enter a username");
			String username = bot.nextLine();
			System.out.println("Enter a password");
			int password = bot.nextInt();
			System.out.println("Enter a deposit amount");
			double deposit = bot.nextDouble();
			bot.nextLine();
			bAccounts[BankAccount.numAcc] = new BankAccount(username, deposit, password);
			System.out.println(BankAccount.numAcc + " Account(s) Created");
		} else {
			System.out.println("You cannot make any more accounts");
		}
	}

	public void delete() {
		System.out.println("Enter your username");
		String username = bot.nextLine();
		System.out.println("Enter your password");
		int password = bot.nextInt();
		bot.nextLine();
		for (int i = 0; i < BankAccount.numAcc; i++) {
			if (username == bAccounts[i].getName() && password == bAccounts[i].getPinNum()) {
				bAccounts[i] = null;
			} else {
				System.out.println("Sorry we cannot find your account");
			}
		}
	}

	public void list() {
		for (int i = 0; i < BankAccount.numAcc; i++) {
			System.out.println("\nHere is the list of accounts");
			System.out.println(bAccounts[i].getName());
		}
	}

	public void loggedin(BankAccount x) {
		String userInput = "";
		while (!userInput.equals("4")) {
			System.out.println(
					"Enter a Number for what option you would like to perform!\n1.Get Balance\n2.Deposit\n3.Withdraw\n4.Exit");
			userInput = bot.nextLine();
			if (userInput.equals("1")) {
				System.out.println(x.getBalance());
			} else if (userInput.equals("2")) {
				deposit(x);
			} else if (userInput.equals("3")) {
				withdraw(x);
			}
		}
	}

	public void deposit(BankAccount x) {
		System.out.println("How much do you want to deposit");
		double amount = bot.nextDouble();
		bot.nextLine();
		x.deposit(amount);
	}

	public void withdraw(BankAccount x) {
		System.out.println("How much do you want to withdraw");
		double amount = bot.nextDouble();
		bot.nextLine();
		if (x.getIsLocked() == true) {
			System.out.println("Sorry your account is locked");
		} else {
			x.withdraw(amount);
		}
	}

	private void printHeader() {
		System.out.println(
				"\nWelcome to Los Santos Bank! Please choose an option from below! Input what number option you would like to perform!");
		System.out.print("1.Log In\n2.List\n3.Create\n4.Delete\n5.Exit\n");

	}
}
