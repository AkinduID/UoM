//package PC.ATM;
import java.util.List;
import java.util.Scanner;

class Client{  //template for client
    String id;
    String name;
    String nationality;
    String occupation;
    String address;
    int age;
    String gender;
    int pin;
    List<Account> accounts;

    Client(String id,String name,String nationality,String occupation,String address,int age,String gender,int pin,List<Account> accounts){
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.occupation = occupation;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.pin = pin;
        this.accounts = accounts;
    }
    //method for creating an current account
    public void CreateCurrentAccount(String accountNumber, String currency, String branch, double balance){ 
        for(Account account : accounts){
            if(account.currency.equals(currency)){
                if(account.accountNumber.equals(accountNumber)){
                    System.out.println("Account already exists!");
                    return;
                }
                Account newAccount = new CurrentAccount(accountNumber, currency, branch, balance);
                accounts.add(newAccount);
                System.out.println("Account created successfully!");
            }
            else{
                System.out.println("Invalid currency!");
            }
        }
        
    }
    //method for creating an savings account
    public void CreateSavingsAccount(String accountNumber, String currency, String branch, double balance,double interest){ 
        for(Account account : accounts){
            if(account.currency.equals(currency)){
                if(account.accountNumber.equals(accountNumber)){
                    System.out.println("Account already exists!");
                    return;
                }
                Account newAccount = new SavingsAccount(accountNumber, currency, branch, balance,interest);
                accounts.add(newAccount);
                System.out.println("Account created successfully!");
            }
            else{
                System.out.println("Invalid currency!");
            }
        }
        
    }

    //method for applying a loan
    public void applyLoan(double amount, double interest, int duration, String paymentMethod){
        for(Account account : accounts){
            System.out.println("Account Number: " + account.accountNumber);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");
        String InputAccountNumber = scanner.next();   //get the account to link tha loan
        for(Account account : accounts){
            if(account.accountNumber==InputAccountNumber){
                // create record of the new loan
                LoanRec newLoan = new LoanRec(amount, interest, duration, paymentMethod,InputAccountNumber); 
            }
            else{
                System.out.println("invalid Account");
            }
        }
    }

    public void getClientdata(){ // method to get client data
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Adress:" + address);
    }
}