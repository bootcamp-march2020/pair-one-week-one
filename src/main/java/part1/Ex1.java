package part1;

import java.util.List;

class Item {
    double getPrice() {
        return 0;
    }
}

class Customer {
    String name;
    int age;
    long bill;//Could be Big Decimal for precision
    List<Item> listsOfItems; // Should be moved to Order class

    Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Calculate bill should not be responsibility of customer
    public long calculateBill(long tax) { //Should be moved to biller
        for (Item item : listsOfItems) {
            bill += item.getPrice();//should have a add method
        }
        bill += tax;//tax should be based on the bill amount(business logic)
        this.setBill(bill);
        return bill;
    }

    //Report generation should not be responsibility of customer
    public void generateReport(String reportType) { //Should be moved to biller
        //If should be transformed to switch, because any point of time only one condition can be true
        if (reportType.equalsIgnoreCase("CSV")) {//Should have made this value in a const varaible
            System.out.println("Generate CSV report");
        }
        if (reportType.equalsIgnoreCase("XML")) {
            System.out.println("Generate XML report");
        }
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

    public long getBill() {
        return bill;
    }

    public void setBill(long bill) {
        this.bill = bill;
    }

    public List<Item> getListsOfItems() {
        return listsOfItems;
    }

    public void setListsOfItems(List<Item> listsOfItems) {
        this.listsOfItems = listsOfItems;
    }
}



