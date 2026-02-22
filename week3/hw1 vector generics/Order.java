import java.util.Vector;

public class Order {
    private String orderId;
    private String customerName;
    private String orderDate;
    private Vector<OrderItem> items;
    private String orderStatus;

    public Order(String orderId, String customerName, String orderDate, String orderStatus) {
        this.items = new Vector<>();
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    public String getOrderId() {return orderId;}
    public String getCustomerName() {return customerName;}
    public String getOrderDate() {return orderDate;}
    public String getOrderStatus() {return orderStatus;}

    public void addItem(OrderItem item) {
        if (item == null) {
            return;
        }
        items.add(item);
    }

    public boolean removeItem(String productId) {
        if (productId == null) {
            return false;
        }
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProductId() == null) {
                continue;
            }
            if (productId.equals(items.get(i).getProductId())) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    public OrderItem findItem(String productId) {
        if (productId == null) {
            return null;
        }
        for (OrderItem item : items) {
            if (item.getProductId() != null && item.getProductId().equals(productId)) {
                return item;
            }
            else {
                continue;
            }
        }
        return null;
    }

    public double calculateTotal() {
        double total = 0.0;
        for (OrderItem item : items) {
            if (item == null) {
                continue;
            }
            total += item.calculateSubtotal();
        }
        return total;
    }

    public int getTotalItems() {
        int total = 0;
        for (OrderItem item : items) {
            total += item.getQuantity();
        }
        return total;
    }

    public void updateStatus(String newStatus) {this.orderStatus = newStatus;}

    public void printOrder() {
        if (items == null) {
            System.out.println("No items in order");
            return;
        }
        System.out.println("Order ID: " + orderId + " | Customer Name: " +  customerName + " | Order Date: " + orderDate + " | Order Status: " + orderStatus);
        System.out.printf("-------------------------------------------------------------------------%n");
        System.out.printf("| %-10s | %-16s | %-10s | %-10s | %-8s |%n", "Product ID:", "Product Name:", "Quantity:", "Unit Price:", "Subtotal:");
        System.out.printf("-------------------------------------------------------------------------%n");
        for (OrderItem item : items) {
            if (item == null) {
                continue;
            }
            System.out.printf("| %-11s | %-16s | %-10s | $%-10.2f | $%-8.2f |%n", item.getProductId(), item.getProductName(), item.getQuantity(), item.getUnitPrice(), item.getSubtotal());
        }
        System.out.printf("-------------------------------------------------------------------------%n");
        System.out.println("Total Items: " + getTotalItems());
        System.out.printf("Order Total: $%.2f", calculateTotal());
        System.out.println();
    }

    public Vector<OrderItem> getItems() {
        if  (items == null) {
            items = new Vector<>();
        }
        return new  Vector<>(items);
    }
}
