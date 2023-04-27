import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //creeating the list of clients of the ABC Bank
        List<Client> clientList = new ArrayList<>();
    
        List<Account> NipunsAccounts = new ArrayList<>();
        SavingsAccount NipunsAccount_1 = new SavingsAccount("001","LKR","Moratuwa",50000,0.05);
        NipunsAccounts.add(NipunsAccount_1);
        Client nipun = new Client("0001","Nipun","Sri Lankan","Software Architect","Katubedda", 29, "Male",5678,NipunsAccounts);
        
        List<Account> KevinsAccounts = new ArrayList<>();
        SavingsAccount KevinsAccount_1 = new SavingsAccount("002","LKR","Moratuwa",55000,0.05);
        KevinsAccounts.add(KevinsAccount_1);
        Client kevin = new Client("0002","Kevin","Sri Lankan","Software Engineer","Katubedda", 27, "Male",1234,KevinsAccounts);
        
        clientList.add(nipun);
        clientList.add(kevin);

        System.out.println("Welcome!");
        System.out.print("Enter PIN: ");
        int inputPin = scanner.nextInt();
        for (Client client : clientList) {
            if (client.pin == inputPin) {  
                // if input pin equals the pin of a client display accounts of the client
                System.out.println("Choose Account");
                for(Account account : client.accounts){
                    System.out.println(account.accountNumber);
                }
                System.out.print("Enter account number: ");
                String InputAccountNumber = scanner.next();
                for(Account account : client.accounts){
                    //System.out.println(account.accountNumber + InputAccountNumber);
                    if(account.accountNumber.equals(InputAccountNumber)){
                        System.out.println("Hello");
                        System.out.println("Account Chosen: " + account.accountNumber);
                        //creating a menu for the instance with chosen account number
                        Menu menu = new Menu(account); 
                        menu.Activity();   //accesing the Activity method in the menu instance
                    }
                }
            }
        }
    }
}




/*Suppose you are asked to simulate an ATM for ABC Bank. 
For each client, ABC Bank keeps a record of the client’s id, name, nationality, occupation, address, age, and gender.
A client should obtain a PIN (Personal Identification Number) to access the ATM. 
ABC offers saving accounts, current accounts, and loans for its clients. 
A client can have multiple bank accounts. 
Each account has an account number, the currency in which the account is operated, the branch, and the balance. 
The bank pays interest for saving accounts. 
ABC has a restriction that all the accounts of a given client should be operated in a single currency. 
A client with any bank account can request a loan, and a loan is linked to an account. 
A loan has the amount, interest, duration, and payment method.

Using the ATM, the clients of ABC Bank can do many transactions. 
Each transaction is recorded with a transaction id, bank account id, date, and status (if the transaction is a success, failure, or cancellation). 
The possible transactions are deposits, withdrawals, and balance inquiries. 
The transaction amount should be recorded for deposits and withdrawals, whereas the balance should be recorded for balance inquiries.

Upon visiting the website of the ABC ATM, the client should experience the following sequence of events.

First of all the client is shown “Welcome!” and asked to enter the PIN.
Then the client is shown his accounts in ABC Bank and asked to select one account to proceed.
Then the client is shown the main menu below:
Main Menu
View Balance.
Withdraw money.
Deposit money.
Exit.
The client will enter the choice. If Option 2 or 3 is selected, the client will be asked to enter the amount, and once the transaction is completed, the remaining balance should be displaced. */