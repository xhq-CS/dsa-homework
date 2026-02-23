import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        //----------------- Product Inventory Test -----------------
        ProductInventory inventory = new ProductInventory();

        inventory.addProduct(new Product("P001", "Laptop", "Electronics", 999.99, 10, "TechCorp"));
        inventory.addProduct(new Product("P002", "T-Shirt", "Clothing", 19.99, 50, "FashionInc"));
        inventory.addProduct(new Product("P003", "Mouse", "Electronics", 29.99, 5, "TechCorp"));

        inventory.printAllProducts();
        inventory.printCapacityInfo();

        Vector<Product> electronics = inventory.getProductsByCategory("Electronics");
        System.out.println("Electronics: " + electronics.size());

        Vector<Product> lowStock = inventory.getLowStockProducts(10);
        System.out.println("Low stock items: " + lowStock.size());

        System.out.println("Total inventory value: $" + inventory.getTotalInventoryValue() + "\n");

        //----------------- Order Manager Test -----------------
        OrderManager orderManager = new OrderManager();

        Order order1 = new Order("O001", "Alice", "2024-01-15", "Delivered");
        order1.addItem(new OrderItem("P001", "Laptop", 1, 999.99));
        order1.addItem(new OrderItem("P003", "Mouse", 2, 29.99));
        orderManager.addOrder(order1);

        Order order2 = new Order("O002", "Bob", "2024-01-16",  "Delivered");
        order2.addItem(new OrderItem("P002", "T-Shirt", 3, 19.99));
        orderManager.addOrder(order2);

        orderManager.printAllOrders();
        System.out.println("Total revenue: $" + orderManager.getTotalRevenue());

        //----------------- Generic Container Test -----------------
        GenericContainer<String> stringContainer = new GenericContainer<>();
        stringContainer.add("Six");
        stringContainer.add("Seven");
        System.out.println("Total Strings: " + stringContainer.size());
        System.out.println("Get String: " + stringContainer.get(0));
        System.out.println("Contains String? " + stringContainer.contains("Seven"));
        System.out.println("Removed String? " + stringContainer.remove("Seven"));
        System.out.println("String Size After Removal: " + stringContainer.size() + "\n");

        GenericContainer<Integer> intContainer = new GenericContainer<>();
        intContainer.add(6);
        intContainer.add(7);
        System.out.println("Total Ints: " + intContainer.size());
        System.out.println("Get Int: " + intContainer.get(1));
        System.out.println("Contains Int? " + intContainer.contains(7) + "\n");

        GenericContainer<Product> productContainer = new GenericContainer<>();
        productContainer.add(new Product("B123", "Poland Spring", "Beverage", 1.89, 36, "WaterBoy"));
        productContainer.add(new Product("AP101", "Laptop", "Electronics", 599.99, 2, "ElectroBoy"));
        System.out.println("Total Products: " + productContainer.size());
        System.out.println("Get Product: " + productContainer.get(0));

        productContainer.clear();
        System.out.println("Product Size After Removal: " + productContainer.size() + "\n");

        //----------------- VectorUtils sumNumber & averageNumber Test -----------------
        Vector<Integer> ints = new Vector<>();
        ints.add(10);
        ints.add(20);
        ints.add(30);
        System.out.println("Sum: " + VectorUtils.sumNumbers(ints));  // 60.0
        System.out.println("Average: " + VectorUtils.averageNumbers(ints));  // 20.0
    }
}