import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank();

        boolean running = true;

        while (running) {

            System.out.println("\n--- BANK MANAGEMENT SYSTEM ---");

            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Display Account");
            System.out.println("6. Check Balance");
            System.out.println("7. Calculate Interest");
            System.out.println("8. Transfer Money");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            try {

                switch (choice) {


                    case 1:

                        System.out.print("Enter Account Number: ");
                        int savingsAccountNumber = sc.nextInt();

                        System.out.print("Enter Holder Name: ");
                        String savingsHolderName = sc.next();

                        System.out.print("Enter Initial Balance: ");
                        double savingsBalance = sc.nextDouble();

                        bank.createSavingsAccount(
                                savingsAccountNumber,
                                savingsHolderName,
                                (int) savingsBalance
                        );

                        break;



                    case 2:

                        System.out.print("Enter Account Number: ");
                        int currentAccountNumber = sc.nextInt();

                        System.out.print("Enter Holder Name: ");
                        String currentHolderName = sc.next();

                        System.out.print("Enter Initial Balance: ");
                        double currentBalance = sc.nextDouble();

                        bank.createCurrentAccount(
                                currentAccountNumber,
                                currentHolderName,
                                (int) currentBalance
                        );

                        break;


                    case 3:

                        System.out.print("Enter Account Number: ");
                        int depositAccountNumber = sc.nextInt();

                        System.out.print("Enter Deposit Amount: ");
                        double depositAmount = sc.nextDouble();

                        bank.deposit(
                                depositAccountNumber,
                                depositAmount
                        );

                        break;


                    case 4:

                        System.out.print("Enter Account Number: ");
                        int withdrawAccountNumber = sc.nextInt();

                        System.out.print("Enter Withdrawal Amount: ");
                        double withdrawAmount = sc.nextDouble();

                        bank.withdraw(
                                withdrawAccountNumber,
                                withdrawAmount
                        );

                        break;


                    case 5:

                        System.out.print("Enter Account Number: ");
                        int displayAccountNumber = sc.nextInt();

                        bank.displayAccount(displayAccountNumber);

                        break;


                    case 6:

                        System.out.print("Enter Account Number: ");
                        int balanceAccountNumber = sc.nextInt();

                        bank.checkBalance(balanceAccountNumber);

                        break;


                    case 7:

                        System.out.print("Enter Account Number: ");
                        int interestAccountNumber = sc.nextInt();

                        bank.calculateInterest(interestAccountNumber);

                        break;



                    case 8:

                        System.out.print("Enter Sender Account Number: ");
                        int fromAccountNumber = sc.nextInt();

                        System.out.print("Enter Receiver Account Number: ");
                        int toAccountNumber = sc.nextInt();

                        System.out.print("Enter Transfer Amount: ");
                        double transferAmount = sc.nextDouble();

                        bank.transferMoney(
                                fromAccountNumber,
                                toAccountNumber,
                                transferAmount
                        );

                        break;



                    case 9:

                        running = false;

                        System.out.println("Thank you for using the Bank System!");

                        break;


                    default:

                        System.out.println("Invalid choice!");
                }

            }

            catch (AccountNotFoundException e) {

                System.out.println("Error: " + e.getMessage());
            }

            catch (InvalidAmountException e) {

                System.out.println("Error: " + e.getMessage());
            }

            catch (InsufficientBalanceException e) {

                System.out.println("Error: " + e.getMessage());
            }

            finally {

                System.out.println("Transaction completed.");
            }
        }

        sc.close();
    }
}