import java.util.*;

public class Bank {

    private Account[] accounts;
    private int c;

    public Bank(){
        accounts = new Account[10];
        c = 0;
    }


    public void createSavingsAccount(int AccountNumber, String holdername , int balance){

        if(accountExists(AccountNumber)){
            System.out.println("AccountNumber already exists.");
            return;
        }

        if(balance <= 0){
            System.out.println("Initial balance must greater than zero.");
            return ;
        }

        SavingsAccount account = new SavingsAccount(AccountNumber,holdername,balance);
        accounts[c] = account;
        c++;

        System.out.println("Saving account created successfully.");
    }

    public void createCurrentAccount(int AccountNumber , String holdername , int balance){

        if(accountExists(AccountNumber)){
            System.out.println("AccountNumber already exists.");
            return;
        }

        if(balance <= 0){
            System.out.println("Initial balance must greater than zero.");
            return ;
        }

        CurrentAccount account = new CurrentAccount(AccountNumber,holdername,balance);
        accounts[c] = account;
        c++;

        System.out.println("Current account created successfully.");
    }

    private boolean accountExists(int AccountNumber){
        for (int i = 0; i < c; i++) {
            if (accounts[i].getAccountNumber() == AccountNumber){
                return true;
            }
        }
        return false;
    }

    public Account findAccount(int AccountNumber)
            throws AccountNotFoundException {

        for (int i = 0; i < c; i++) {

            if (accounts[i].getAccountNumber() == AccountNumber) {
                return accounts[i];
            }
        }

        throw new AccountNotFoundException("Account not found.");
    }

    public void deposit(int AccountNumber, double amount)
            throws AccountNotFoundException,
            InvalidAmountException {

        Account account = findAccount(AccountNumber);

        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Deposit amount must be greater than zero."
            );
        }

        account.deposite(amount);

        System.out.println("Amount deposited successfully.");
        System.out.println(
                "Current Balance: " + account.getBalance()
        );
    }

    public void withdraw(int AccountNumber, double amount)
            throws AccountNotFoundException,
            InvalidAmountException,
            InsufficientBalanceException {

        Account account = findAccount(AccountNumber);

        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be greater than zero.");
        }

        if (amount > account.getBalance()) {
            throw new InsufficientBalanceException("Insufficient balance.");
        }

        account.withdraw(amount);

        System.out.println("Amount withdrawn successfully.");
        System.out.println("Current Balance: " + account.getBalance());
    }

    public void displayAccount(int AccountNumber)
            throws AccountNotFoundException {

        Account account = findAccount(AccountNumber);

        account.display();

        account.calculateInterest();
    }

    public void checkBalance(int AccountNumber)
            throws AccountNotFoundException {

        Account account = findAccount(AccountNumber);

        System.out.println(
                "Current Balance: " + account.getBalance()
        );
    }

    public void calculateInterest(int AccountNumber)
            throws AccountNotFoundException {

        Account account = findAccount(AccountNumber);

        account.calculateInterest();
    }

    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount)
            throws AccountNotFoundException,
            InvalidAmountException,
            InsufficientBalanceException {


        Account fromAccount = findAccount(fromAccountNumber);


        Account toAccount = findAccount(toAccountNumber);


        if (amount <= 0) {
            throw new InvalidAmountException("Transfer amount must be greater than zero.");
        }


        if (amount > fromAccount.getBalance()) {
            throw new InsufficientBalanceException("Insufficient balance for transfer.");
        }


        fromAccount.withdraw(amount);


        toAccount.deposite(amount);

        System.out.println("Transfer successful.");
    }
}