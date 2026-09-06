class SavingsAccount extends Account {

    public SavingsAccount(int AccountNumber , String holdername , double balance){
        super(AccountNumber,holdername,balance);
    }

    public void calculateInterest(){
        double interest = getBalance()* 4/100;
        System.out.println("Interest : " + interest);
    }
}
