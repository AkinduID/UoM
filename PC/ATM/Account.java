import java.util.Random; 
import java.util.Date;   

abstract class Account {  //template for account
    String accountNumber;
    String currency;
    String branch;
    double balance;

    Account(String accountNumber, String currency, String branch, double balance) {
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.branch = branch;
        this.balance = balance;
    }

    void deposit(double amount) {  //method for depositing money

        //following 3 lines generates a random transaction id
        Random random = new Random(); 
        int randomNumber = random.nextInt(100) + 1;
        String randomString = String.valueOf(randomNumber);

        //code to get the current date and time
        Date date = new Date();
        String dateString = String.valueOf(date);
        String status;

        //error handling
        try{
            status = "success";  //if no eeror ocurrs transaction status is success
            balance += amount;
        }
        catch(Exception e){
            System.out.println("Error");
            status = "failure";   //if error ocurrs set transaction status to failure         
        }
        //create transaction record
        DepositRec DepositRecord = new DepositRec(randomString, this.accountNumber, dateString, status, amount);
        System.out.println("Remaining Balance: " + balance);//display balance
        DepositRecord.getTransactionData();//display transaction details
    }

    void withdraw(double amount) {  //method for withdrawing money

        //following 3 lines generates a random transaction id
        Random random = new Random(); 
        int randomNumber = random.nextInt(100) + 1;
        String randomString = String.valueOf(randomNumber);

        //code to get the current date and time
        Date date = new Date();
        String dateString = String.valueOf(date);
        String status;
        if(balance>amount){
            status = "success"; //if withdrawal is possible transaction status is success
            balance -= amount;
        }
        else{
            System.out.println("Balance not Sufficient"); //if withdrawal is not possible transaction status is failure
            status = "failure";
        }
        //creting a transaction record
        WithdrawRec WithdrawRecord = new WithdrawRec(randomString, this.accountNumber, dateString, status, amount);
        System.out.println("Remaining Balance: " + balance); // displaying balance
        WithdrawRecord.getTransactionData(); //displayig transaction details
    }

    void balanceInquiry() {
        Random random = new Random(); 
        int randomNumber = random.nextInt(100) + 1;
        String randomString = String.valueOf(randomNumber);
        //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();
        String dateString = String.valueOf(date);
        String status;
        try{
            status = "success";  //if action is possible set transaction status to sucess
        }
        catch(Exception e){
            System.out.println("Error"); 
            status = "failure";  //if error ocurrs set trnasaction status to failure
        }
        BalanceInquiryRec BalanceInquiryRecord = new BalanceInquiryRec(randomString, this.accountNumber, dateString, status, this.balance);
        System.out.println("Remaining Balance: " + balance);
        BalanceInquiryRecord.getTransactionData();
    }
}

class CurrentAccount extends Account {  // templte for current account
    CurrentAccount(String accountNumber, String currency, String branch, double balance) {
        super(accountNumber, currency, branch, balance);
    }
}

class SavingsAccount extends Account {  //template for savings account
    double interest; // saving account has an interest rate
    SavingsAccount(String accountNumber, String currency, String branch, double balance, double interest) {
        super(accountNumber, currency, branch, balance);
        this.interest = interest;
    }

    void addAccountInterest(){  //method to add interest to the account
        balance += balance*interest; //this method should run every month
    }
}

