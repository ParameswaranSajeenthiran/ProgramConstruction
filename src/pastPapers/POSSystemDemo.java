package pastPapers;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class POSSystemDemo {


    public static void main(String[] args) {
        Bill bill = new Bill("sajeenthiran");
        POS.getItemDetails();
        POS.getItemDetails();


        GroceryItem groceryItem= new GroceryItem(33.0,3,0.5);
        bill.getGroceryItems().add(groceryItem);
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("sajeenthiran.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(bill);
            objectOutputStream.close();

            FileInputStream fileInputStream = new FileInputStream("sajeenthiran.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream( fileInputStream);
            Bill bill1=(Bill)   objectInputStream.readObject();
            bill1.getGroceryItems().forEach(item->{
                System.out.println(item.getNetPrice());
            });
        }catch( IOException e){
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}

class GroceryItem implements Serializable{
    private double unitPrice;
    private double quantity ;
    private double discount;

    private  double netPrice;


    public GroceryItem(double unitPrice, double quantity, double discount) {
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.discount = discount;
        this.netPrice = unitPrice *(1-discount) * quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(double netPrice) {
        this.netPrice = netPrice;
    }
}


class Bill implements Serializable {
    transient  private String cashierName;
    transient private String branch ;
    private String customerName;

     transient  private  double totalDiscount ;
     transient private LocalDate date;

     transient private LocalDateTime time;

     private List<GroceryItem>groceryItems= new ArrayList<>();

    public Bill(String customerName) {
        this.customerName = customerName;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public List<GroceryItem> getGroceryItems() {
        return groceryItems;
    }

    public void setGroceryItems(List<GroceryItem> groceryItems) {
        this.groceryItems = groceryItems;
    }
}

class  POS {

    public  static GroceryItem getFromDB() throws ItemNotFound {
        throw new ItemNotFound("item not found dear");
//        return new GroceryItem( 2.3,33.22,0.4);
    }
    public static GroceryItem getItemDetails(){
        GroceryItem groceryItem= null;

        try {
            InputStreamReader r= new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);
            String item_code  = br.readLine();

            getFromDB();


            br.close();
            r.close();

        } catch (IOException | ItemNotFound e) {
            e.printStackTrace();
        }
        return groceryItem;
    }
}

class ItemNotFound extends RuntimeException {
    public ItemNotFound (String message ){
        super(message);
    }
}