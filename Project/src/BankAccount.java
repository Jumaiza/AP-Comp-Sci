
class BankAccount {
	
	public static int numAcc = 0;
	
	private String name = "Zaid Abu Jumaiza";
	private double balance = 56.32;
	private int password = 1379;
	private boolean isLocked = false;

public BankAccount(){
	numAcc++;
}

public BankAccount(String name, double balance, int password, boolean isLocked){
	this.name = name;
	this.balance = balance;
	this.password = password;
	numAcc++;
}

public String transferAccount(String name){
	String oldName = name;
	this.name = name;
	return oldName;
}

public void deposit(double x){
	if(x>0.0)
		balance+=x;
	if(isLocked==true && balance >= 0.0)
		isLocked = false;
}

public void withdraw(double x){
	if(isLocked == false){
		if(x>0.0){
			balance-=x;
		}if(balance<0.0){
			balance-=30;
			isLocked = true;
		}
		else{
			System.out.println("You gotta withdraw something nigga");
		}
	}
	else{
		System.out.println("Yo shit locked my nigga");
	}
		
}




}