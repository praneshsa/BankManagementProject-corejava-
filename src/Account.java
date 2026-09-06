abstract class Account {

    private int AccountNumber;
    private String holdername;
    private double balance;

    public Account(int AccountNumber,String holdername , double balance){
        this.AccountNumber = AccountNumber;
        this.holdername = holdername;
        this.balance = balance;
    }


    public int getAccountNumber(){
        return AccountNumber;
    }

    public String getHoldername(){
        return holdername;
    }

    public double getBalance(){
        return balance;
    }

    public void setAccountNumber(int AccountNumber){
        this.AccountNumber = AccountNumber;
    }

    public void setHoldername(String holdername){
        this.holdername = holdername;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    public void deposite(double amount){
        balance += amount;
    }

    public void withdraw ( double amount){
        balance -= amount;
    }

    public void display(){
        System.out.println("Account Number : " + AccountNumber);
        System.out.println("User Name : " + holdername );
        System.out.println("Balance : " + balance);
    }

    public abstract void calculateInterest();

}
