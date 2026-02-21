public class OrderItem {
    private String productId;
    private String productName;
    private int quantity;
    private double unitPrice;
    private double subtotal;

    public OrderItem(String productId, String productName, int quantity, double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subtotal = calculateSubtotal();
    }

    public String getProductId() {return productId;}
    public String getProductName() {return productName;}
    public int getQuantity() {return quantity;}
    public double getUnitPrice() {return unitPrice;}
    public double getSubtotal() {return subtotal;}

    public void setProductId(String productId) {this.productId = productId;}
    public void setProductName(String productName) {this.productName = productName;}
    public void setQuantity(int quantity) {this.quantity = quantity; calculateSubtotal();}
    public void setUnitPrice(double unitPrice) {this.unitPrice = unitPrice; calculateSubtotal();}

    @Override
    public String toString() {
        return "Product ID: " + this.productId + " | Product Name: " + this.productName  + " | Quantity: " +
                this.quantity + " | Unit Price: " + this.unitPrice + " | Subtotal: " + this.subtotal;
    }

    public double calculateSubtotal() {
        this.subtotal = this.unitPrice * this.quantity;
        return this.subtotal;
    }
}
