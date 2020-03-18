package part1.solution;

import java.util.ArrayList;
import java.util.List;

class Item {
    double getPrice() {
        return 0;
    }
}

class Order{

    private List<Item> listOfItems = new ArrayList<>();

    public void addItem(Item item){
        listOfItems.add(item);
    }

    public void removeItem(Item item){
        listOfItems.remove(item);
    }

    public List<Item> getListOfItems() {
        return listOfItems;
    }

    public double calculateOrderTotal(){
        double billAmount = 0.0;
        for (Item item : getListOfItems()) {
            billAmount += item.getPrice();
        }
        return billAmount;
    }
}

class OrderSummary{

    Customer customer;

    Order order;

    double billAmount;

    public OrderSummary(Customer customer, Order order, double billAmount) {
        this.customer = customer;
        this.order = order;
        this.billAmount = billAmount;
    }
}

class Biller{

    private static final float TAX_PERCENTAGE = 1.8f;

    private static Biller sInstance = new Biller();

    public static Biller getInstance() {
        return sInstance;
    }

    public void processOrder(Customer customer,Order order){
       double orderTotal =  order.calculateOrderTotal();
       double billAmount = orderTotal+getTax(orderTotal);

       ReportMaker.getsInstance().generateReport(new OrderSummary(customer,order,billAmount), ReportMaker.ReportType.CSV);
    }

    public double getTax(double orderTotal){
        return (orderTotal*TAX_PERCENTAGE)+orderTotal;
    }
}

class ReportMaker{

    private static ReportMaker sInstance =new ReportMaker();

    public static ReportMaker getsInstance() {
        return sInstance;
    }

    enum ReportType{
        CSV,
        XML
    }

    public void generateReport(OrderSummary orderSummary,ReportType reportType){
        switch (reportType){
            case CSV:
                System.out.println("Generate CSV report "+orderSummary);
                break;
            case XML:
                System.out.println("Generate XML report "+orderSummary);
                break;
            default:
                throw new IllegalStateException("");
        }
    }

}

class Customer {
    String name;
    int age;

    Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
