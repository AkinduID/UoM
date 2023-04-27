import java.util.Scanner;

class Menu{ //template for menu
    Account account;

    Menu(Account AccountNumber){
        this.account=AccountNumber;
    }
    public void Activity(){ //method for interacting with account through menu
        Scanner scanner = new Scanner(System.in);
        //display menu items
        System.out.println("1. Deposit Money");
        System.out.println("2. Withdraw Money");
        System.out.println("3. View Balance");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter amount: ");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                break;
            case 2:
                System.out.print("Enter amount: ");
                double withdrawAmount = scanner.nextDouble();
                account.withdraw(withdrawAmount);
                break;
            case 3:
                account.balanceInquiry();
                break;
            case 4:
                System.out.println("Thank you for using our ATM!");
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
}