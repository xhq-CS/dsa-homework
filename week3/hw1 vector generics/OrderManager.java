import java.util.Vector;

public class OrderManager {
    private Vector<Order> orders;

    public OrderManager() {orders = new Vector<>();}

    public void addOrder(Order order) {
        if (order == null) {
            return;
        }
        orders.add(order);
    }

    public Order findOrder(String orderId) {
        if (orderId == null) {
            return null;
        }
        for (Order order : orders) {
            if (order == null) {
                continue;
            }
            if (order.getOrderId() != null && order.getOrderId().equals(orderId)) {
                return order;
            }
        }
        return null;
    }

    public Vector<Order> getOrdersByStatus(String status) {
        Vector<Order> statusFilter = new Vector<>();
        if (status == null) {
            return statusFilter;
        }
        for (Order order : orders) {
            if (order.getOrderStatus() != null && status.equals(order.getOrderStatus())) {
                statusFilter.add(order);
            }
        }
        return statusFilter;
    }

    public Vector<Order> getOrdersByCustomer(String customerName) {
        Vector<Order> customerFilter = new Vector<>();
        if (customerName == null) {
            return customerFilter;
        }
        for (Order order : orders) {
            if (order.getCustomerName() != null && customerName.equals(order.getCustomerName())) {
                customerFilter.add(order);
            }
        }
        return customerFilter;
    }

    public double getTotalRevenue() {
        double totalRevenue = 0.0;
        for (Order order : orders) {
            if (order == null) {
                continue;
            }
            if (order.getOrderStatus() != null && "Delivered".equals(order.getOrderStatus())) {
                totalRevenue += order.calculateTotal();
            }
        }
        return totalRevenue;
    }

    public void cancelOrder(String orderId) {
        if (orderId == null) {
            return;
        }
        if (findOrder(orderId) == null) {
            return;
        }
        findOrder(orderId).updateStatus("Cancelled");
    }

    public void printAllOrders() {
        if (orders == null ||  orders.isEmpty()) {
            System.out.println("No orders found");
            return;
        }
        for (Order order : orders) {
            if (order == null) {
                continue;
            }
            order.printOrder();
        }
    }

    public Vector<Order> getPendingOrders() {
        Vector<Order> pendingOrders = new Vector<>();
        for (Order order : orders) {
            if (order == null) {
                continue;
            }
            if (order.getOrderStatus() != null && "Pending".equals(order.getOrderStatus())) {
                pendingOrders.add(order);
            }
        }
        return pendingOrders;
    }

    public int getOrderCount() {
        if  (orders == null) {
            return 0;
        }
        return orders.size();
    }
}
