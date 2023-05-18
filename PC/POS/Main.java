//package PC.POS;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Random;

class ItemCodeNotFound extends Exception {
    public ItemCodeNotFound(String message) {
        super(message);
    }
}

class POS implements Serializable{
    //cashier’s name, branch, customer name (if a registered customer), item list (unit price, 
    //quantity, discount, net price), total discount, total price, date, and time
    private String cashierName;
    private String branch;
    private String customerName;
    private static ArrayList<groceryItem> itemList;
    private double totalDiscount;
    private double totalPrice;
    private LocalDateTime dateTime;
    public static ArrayList<Thread> pendingBills;

    public POS(String cashierName, String branch, String customerName, ArrayList<groceryItem> itemList, double totalDiscount, double totalPrice, LocalDateTime dateTime){
        this.cashierName = cashierName;
        this.branch = branch;
        this.customerName = customerName;
        this.itemList = itemList;
        this.totalDiscount = totalDiscount;
        this.totalPrice = totalPrice;
        this.dateTime = dateTime;
    }

    public void handlePendingBill() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                addItem();
            }
        });
        thread.start();
        pendingBills.add(thread);
    }

    public void processPendingBills() {
        for (Thread thread : pendingBills) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        pendingBills.clear();
    }

    public void printBill(){
        System.out.println("Cashier Name: " + cashierName);
        System.out.println("Branch: " + branch);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Date and Time: " + dateTime);
        System.out.println("Item List: " + itemList);
        System.out.println("Item\t\tQuantity\tPrice\tDiscount\tNet Price");
        for(groceryItem item : itemList){
            double netPrice = item.getQuantity() * (item.getPrice()- item.getDiscount());
            System.out.printf("%s\t\t%d\t%.2f\t%.2f\t%.2f%n", item.getName(), item.getQuantity(), item.getPrice(),item.getDiscount(),netPrice);
            totalPrice = totalPrice + netPrice;
            totalDiscount = totalDiscount + item.getDiscount()*item.getQuantity();
        }
        System.out.println("Total Price: " + totalPrice);
        System.out.println("Total Discount: " + totalDiscount);
        
    }

    public static groceryItem getItemDetails() {
        while (true){
            try {
                InputStreamReader r = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(r);
                String item_code = br.readLine();
                groceryItem item = new groceryItem(item_code, item_code, 0, 0, null, null, item_code, 0, 0);// Fetch item details from the database
            if(item==null){
                throw new ItemCodeNotFound("item_code not found");
            }
                br.close(); 
                r.close();
                item.getQuantity();
                return item;
            }
            catch (ItemCodeNotFound e) {
                System.out.println("Item code not found");
            }
            catch(IOException e){
                System.out.println("IOException");
            }
        }
    }


       

    public static void addItem(){
        groceryItem item = getItemDetails();
        if (item!=null){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter quantity: ");
            int quantity = sc.nextInt();
            item.setQuantity(quantity);
            itemList.add(item);
            System.out.println("Item added successfully");
            sc.close();
        }
        else{
            System.out.println("Item not not found");
        }
    }

    public String getCashierName(){
        return cashierName;
    }

    public String getBranch(){
        return branch;
    }

    public String getCustomerName(){
        return customerName;
    }
    
    public ArrayList<groceryItem> getItemList(){
        return itemList;
    }

    public double getTotalDiscount(){
        return totalDiscount;
    }

    public double getTotalPrice(){
        return totalPrice;
    }

    public LocalDateTime getDateTime(){
        return dateTime;
    }

    public void setCashierName(String cashierName){
        this.cashierName = cashierName;
    }

    public void setBranch(String branch){
        this.branch = branch;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public void setItemList(ArrayList<groceryItem> itemList){
        this.itemList = itemList;
    }

    public void setTotalDiscount(double totalDiscount){
        this.totalDiscount = totalDiscount;
    }

    public void setTotalPrice(double totalPrice){
        this.totalPrice = totalPrice;
    }

    public void setDateTime(LocalDateTime dateTime){
        this.dateTime = dateTime;
    }
}

class groceryItem implements Serializable{
    //item code, information such as price, weight/size of the product, date of manufacturing and expiry, 
    //and manufacturer name
    private String code;
    private String name;
    private double price;
    private double weight;
    private LocalDateTime dateOfManufacturing;
    private LocalDateTime expiryDate;
    private String manufacturerName;
    private double discount;
    public int quantity;

    public groceryItem(String code, String name, double price, double weight, LocalDateTime dateOfManufacturing, LocalDateTime expiryDate, String manufacturerName, double discount,int quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.dateOfManufacturing = dateOfManufacturing;
        this.expiryDate = expiryDate;
        this.manufacturerName = manufacturerName;
        this.discount = discount;
        this.quantity = 1;
    }

    

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    public void setDiscount(){
        //from time to time, each item is given a discount which varies from 0-75%
        Random rand = new Random();
        int discount = rand.nextInt(76);
        this.discount = this.price*(discount/100);
    }
    public int getQuantity(){
        return quantity;
    }

    public String getCode(){
        return code;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public double getWeight(){
        return weight;
    }

    public LocalDateTime getDateOfManufacturing(){
        return dateOfManufacturing;
    }

    public LocalDateTime getExpiryDate(){
        return expiryDate;
    }

    public String getManufacturerName(){
        return manufacturerName;
    }
    
    public double getDiscount(){
        return discount;
    }
}

class Main{
    public static void main(String[] args){
        LocalDateTime now = LocalDateTime.now();
        ArrayList<groceryItem> itemList = new ArrayList<groceryItem>();
        POS.addItem();
        POS pos = new POS("Cashier 1", "Branch 1", "Customer 1", itemList, 10.0, 100.0, now);
        System.out.println(pos);
    }

}

