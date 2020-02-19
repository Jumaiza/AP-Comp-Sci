
class BankAccount {

	public static int numAcc = 0;

	private String name = "Zaid Abu Jumaiza";
	private double balance = 56.32;
	private int pinNum = 1379;
	private boolean isLocked = false;

	public BankAccount() {
		numAcc++;
	}

	public BankAccount(String name, double balance, int pinNum) {
		this.name = name;
		this.balance = balance;
		this.pinNum = pinNum;
		numAcc++;
	}

	public String transferAccount(String name) {
		String oldName = this.name;
		this.name = name;
		return oldName;
	}

	public void deposit(double x) {
		if (x > 0.0) {
			this.balance += x;
			if (this.balance >= 0 && isLocked == true) {
				this.isLocked = false;
			}
		}
	}

	public void withdraw(double x) {
		if (this.isLocked == false && x > 0.0) {
			this.balance -= x;
			if (this.balance < 0) {
				this.balance -= 30;
				this.isLocked = true;
			}
		}
	}

	public String getName() {
		return this.name;
	}

	public double getBalance() {
		return this.balance;
	}

	public int getPinNum() {
		return this.pinNum;
	}

	public boolean getIsLocked() {
		return this.isLocked;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setPinNum(int pinNum) {
		this.pinNum = pinNum;
	}
}