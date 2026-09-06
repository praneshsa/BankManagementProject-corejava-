class CurrentAccount extends Account {

    public CurrentAccount(int AccountNumber , String holdername , double balance){
        super(AccountNumber,holdername,balance);
    }

    @Override
    public void calculateInterest() {
        double interest = getBalance()* 0/100;
        System.out.println("Interest : " + interest);
    }

}
