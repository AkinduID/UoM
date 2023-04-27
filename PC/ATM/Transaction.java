abstract class TransactionRec{ //template for transaction record
    String transactionId;
    String bankAccountId;
    String date;
    String status;
    TransactionRec(String transactionId,String bankAccountId,String date,String Status){
        this.bankAccountId=bankAccountId;
        this.transactionId=transactionId;
        this.date=date;
        this.status=Status;
    }
    void getTransactionData(){ //method to get transaction data
        System.out.println("Transaction ID: "+transactionId);
        System.out.println("Bank Account ID: "+bankAccountId);
        System.out.println("Date: "+date);
        System.out.println("Status: "+status);
    }
     
}

class DepositRec extends TransactionRec{ //template for deposit record. this inherits from transaction class
    double amount;
    DepositRec(String transactionId, String bankAccountId, String date, String status, double amount){
        super(transactionId, bankAccountId, date, status);
        this.amount = amount;
    }
}

class WithdrawRec extends TransactionRec{ //template for widthdraw record. this inherits from transaction class
    double amount;
    WithdrawRec(String transactionId, String bankAccountId, String date, String status, double amount){
        super(transactionId, bankAccountId, date, status);
        this.amount = amount;
    }
}

class BalanceInquiryRec extends TransactionRec{ //template for balance inquiry record. this inherits from transaction class
    double balance;  
    BalanceInquiryRec(String transactionId, String bankAccountId, String date, String status, double balance){
        super(transactionId, bankAccountId, date, status);
        this.balance = balance;
    }
}

class LoanRec { //template for loan
    double amount;
    double interest;
    int duration;
    String paymentMethod;
    String accountNumber;

    LoanRec(double amount, double interest, int duration, String paymentMethod, String accountNumber) {
        this.amount = amount;
        this.interest = interest;
        this.duration = duration;
        this.paymentMethod = paymentMethod;
        this.accountNumber = accountNumber;
    }

    void getLoanData() { //method to get loan data
        System.out.println("Amount: " + amount);
        System.out.println("Interest: " + interest);
        System.out.println("Duration: " + duration);
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Associated Acount:" + accountNumber);
    }

    void addLoanInterest(){ //mehtod to add interest to the loan
        amount += amount*interest; //this method should run every month
    }
    
}