public class Product {
    private String productId;
    private String name;
    private String category;
    private double price;
    private int quantityInStock;
    private String supplier;

    public Product(String productId, String name, String category, double price, int quantityInStock, String supplier) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.supplier = supplier;
    }

    public void setProductId(String productId) {this.productId = productId;}
    public void setName(String name) {this.name = name;}
    public void setCategory(String category) {this.category = category;}
    public void setPrice(double price) {this.price = price;}
    public void setQuantityInStock(int quantityInStock) {this.quantityInStock = quantityInStock;}
    public void setSupplier(String supplier) {this.supplier = supplier;}

    public String getProductId() {return productId;}
    public String getName() {return name;}
    public String getCategory() {return category;}
    public double getPrice() {return price;}
    public int getQuantityInStock() {return quantityInStock;}
    public String getSupplier() {return supplier;}

    @Override
    public String toString() {
        return "Product ID: " + this.productId + " | " + "Product Name: " + this.name + " | " + "Product Category: " + this.category + " | " + "Product Price: " + this.price
                + " | " + "Quantity in Stock: " + this.quantityInStock + " | " + "Supplier Name: " + this.supplier;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (!(object instanceof Product)) return false;
        Product product = (Product) object;

        if (this.productId == null || product.productId == null) {
            return false;
        } else {
            return this.productId.equals(product.productId);
        }
    }

    @Override
    public int hashCode() {
        if (this.productId == null) {
            return 0;
        } else {
            return this.productId.hashCode();
        }
    }

}