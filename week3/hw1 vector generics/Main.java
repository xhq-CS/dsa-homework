import java.util.Vector;

public class Main {
    public static void main(String[] args) {
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

        System.out.println("Total inventory value: $" + inventory.getTotalInventoryValue());
    }
}