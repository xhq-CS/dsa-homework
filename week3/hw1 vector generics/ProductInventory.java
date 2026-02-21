import java.util.Vector;

public class ProductInventory {
    private Vector<Product> products;

    public ProductInventory() {
        products = new Vector<>();
    }

    public void addProduct(Product product) {
        if (product == null) {
            return;
        }

        //get new product ID and check
        String id = product.getProductId();
        if (id == null) {
            return;
        }

        //duplicate check
        for (Product p : products) {
            if (p.getProductId().equals(id)) {
                return;
            }
        }
        products.add(product);
    }

    public boolean removeProduct(String productId) {
        if (productId == null) {
            return false;
        }
        for (int i = 0; i < products.size(); i++) {
            String currentId = products.get(i).getProductId();
            if (currentId != null && currentId.equals(productId)) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    public Product findProduct(String productId) {
        if (productId == null) {
            return null;
        }
        for (Product p : products) {
            String currentId = p.getProductId();
            if (currentId != null && currentId.equals(productId)) {
                return p;
            }
        }
        return null;
    }

    public Vector<Product> getProductsByCategory(String category) {
        Vector<Product> productFilter = new Vector<>();
        if (category == null) {
            return productFilter;
        }
        for (Product p : products) {
            String c = p.getCategory();
            if (c != null && c.equals(category)) {
                productFilter.add(p);
            }
        }
        return productFilter;
    }

    public Vector<Product> getLowStockProducts(int threshold) {
        Vector<Product> lowStockFilter = new Vector<>();
        if  (threshold <= 0) {
            return lowStockFilter;
        }
        for (Product p : products) {
            if (p == null) {
                continue;
            }
            int stock = p.getQuantityInStock();
            if (stock < threshold) {
                lowStockFilter.add(p);
            }

        }
        return lowStockFilter;
    }

    public double getTotalInventoryValue() {
        double totalValue = 0.0;
        for (Product p : products) {
            if (p == null) {
                continue;
            }
            totalValue += p.getQuantityInStock() * p.getPrice();
        }
        return totalValue;
    }

    public void updateStock(String productId, int quantityChange) {
        if (productId == null) {
            return;
        }
        Product p = findProduct(productId);
        if (p == null) {
            return;
        }
        int newStock = p.getQuantityInStock() + quantityChange;
        if (newStock < 0) {
            return;
        }
        p.setQuantityInStock(newStock);
    }

    public void printAllProducts() {
        if (products == null || products.isEmpty()) {
            System.out.println("No Product Found");
            return;
        }
        System.out.printf("--------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-10s | %-15s | %-15s | %-10s | %-8s | %-15s |%n", "ID", "Name", "Category", "Price", "Stock", "Supplier");
        System.out.printf("--------------------------------------------------------------------------------------------%n");
        for (Product p : products) {
            if  (p == null) {
                continue;
            }
            System.out.printf("| %-10s | %-15s | %-15s | $%-9.2f | %-8d | %-15s |%n",
                    p.getProductId(), p.getName(), p.getCategory(),
                    p.getPrice(), p.getQuantityInStock(), p.getSupplier());
        }
        System.out.printf("--------------------------------------------------------------------------------------------%n");
    }

    public int getTotalProducts() {
        if  (products == null || products.isEmpty()) {
            return 0;
        }
        return products.size();
    }

    public void printCapacityInfo() {
        if (products == null) {
            System.out.println("No Inventory Found");
            return;
        }
        System.out.println("Current Size: " + products.size());
        System.out.println("Current Capacity: " + products.capacity());
    }

    public void optimizeCapacity() {
        if (products == null) {
            System.out.println("No Inventory Found");
        }
        
    }
}