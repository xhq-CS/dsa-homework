import java.util.InputMismatchException;
import java.util.Vector;
import java.util.Scanner;

public class InventorySystemMain {

    public static void addProduct(Scanner input, ProductInventory menuInventory) {
        double price;
        int quantity;

        System.out.print("Enter Product ID: ");
        String id = input.nextLine().trim();

        System.out.print("Enter Product Name: ");
        String name = input.nextLine().trim();

        System.out.print("Enter Product Category: ");
        String category = input.nextLine().trim();

        while (true) {
            System.out.print("Enter Price: ");
            String line = input.nextLine().trim();

            try {
                price = Double.parseDouble(line);
                if (price < 0) {
                    System.out.println("Price cannot be negative gang! Try again!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Numbers only PLEASE!");
            }
        }

        while(true) {
            System.out.print("Enter Quantity In Stock: ");
            String line = input.nextLine().trim();

            try {
                quantity = Integer.parseInt(line);
                if (quantity < 0) {
                    System.out.println("Quantity cannot be negative gang! Try again!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Numbers only PLEASE!");
            }
        }

        System.out.print("Enter Supplier: ");
        String supplier = input.nextLine().trim();

        menuInventory.addProduct(new Product(id, name, category, price, quantity, supplier));
        System.out.println("Product Has Been Added Successfully!" + "\n");
    }

    public static void removeProduct(Scanner input, ProductInventory inventory) {
        System.out.print("Enter Product ID to remove: ");
        String id = input.nextLine().trim();

        boolean removed = inventory.removeProduct(id);
        System.out.println("Product Removed? " + removed + "\n");
    }

    public static void findProduct(Scanner input, ProductInventory inventory) {
        System.out.print("Enter Product ID to search: ");
        String id = input.nextLine().trim();

        Product product = inventory.findProduct(id);
        System.out.println(product == null ? "Not found. Try Again!" : product.toString() + "\n");
    }

    public static void processOrder(Scanner input, OrderManager orderManager) {
        System.out.print("Enter Order ID to Process: ");
        String id = input.nextLine().trim();

        Order order = orderManager.findOrder(id);
        if (order == null) {
            System.out.println("Order not found!");
            return;
        }

        System.out.print("Enter Your New Order Status. (Pending/Processing/Delivered/Cancelled): ");
        String status = input.nextLine().trim();

        if (status.equalsIgnoreCase("Cancelled")) {
            orderManager.cancelOrder(id);
            System.out.println("Order cancelled!" + "\n");
        } else {
            order.updateStatus(status);
            System.out.println("Order Status Updated!" + "\n");
        }
    }

    public static void createOrder(Scanner input, OrderManager orderManager) {
        int items;

        System.out.print("Enter Order ID: ");
        String orderId = input.nextLine().trim();

        System.out.print("Enter Customer Name: ");
        String customer = input.nextLine().trim();

        System.out.print("Enter Order Date (YYYY-MM-DD): ");
        String date = input.nextLine().trim();
        Order order = new Order(orderId, customer, date, "Pending");

        while (true) {
            System.out.print("How many items are in this order? ");
            String line = input.nextLine().trim();
            try  {
                items = Integer.parseInt(line);
                if (items <= 0) {
                    System.out.println("Cannot have 0 or less items in this order!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input! Please try again!");
            }
        }

        for (int i = 1; i <= items; i++) {
            System.out.println("\nItem " + i + ":");

            System.out.print("Product ID: ");
            String pid = input.nextLine().trim();

            System.out.print("Product Name: ");
            String pname = input.nextLine().trim();

            System.out.print("Quantity: ");
            int qty = input.nextInt();

            System.out.print("Unit Price: ");
            double unitPrice = input.nextDouble();
            input.nextLine();

            order.addItem(new OrderItem(pid, pname, qty, unitPrice));
        }

        orderManager.addOrder(order);
        System.out.println("Order Has Been Created!" + "\n");
    }

    private static void generateReports(Scanner input, ProductInventory inventory, OrderManager orderManager) {
        System.out.println("---------- Generated Reports ----------");
        System.out.println("Total Products: " + inventory.getTotalProducts());
        System.out.println("Total Inventory Value: $" + inventory.getTotalInventoryValue());

        System.out.print("Low Stock Threshold: ");
        int threshold = Integer.parseInt(input.nextLine().trim());
        Vector<Product> low = inventory.getLowStockProducts(threshold);
        System.out.println("Low Stock Count: " + low.size());

        System.out.println("Revenue: $" + orderManager.getTotalRevenue());
        System.out.println("Orders Pending: " + orderManager.getOrdersByStatus("Pending").size());
        System.out.println("Orders Processing: " + orderManager.getOrdersByStatus("Processing").size());
        System.out.println("Orders Delivered: " + orderManager.getOrdersByStatus("Delivered").size());
        System.out.println("Orders Cancelled: " + orderManager.getOrdersByStatus("Cancelled").size() + "\n");
    }

    public static int menuInt(Scanner input) {
        int option = 0;
        try {
            option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Add Product Selected");
                    break;
                case 2:
                    System.out.println("Remove Product Selected");
                    break;
                case 3:
                    System.out.println("Find Product Selected");
                    break;
                case 4:
                    System.out.println("List All Products Selected");
                    break;
                case 5:
                    System.out.println("Create Order Selected");
                    break;
                case 6:
                    System.out.println("View Orders Selected");
                    break;
                case 7:
                    System.out.println("Process Orders Selected");
                    break;
                case 8:
                    System.out.println("Generate Reports Selected");
                    break;
                case 9:
                    System.out.println("Exit Selected");
                    break;
                default:
                    System.out.println("Invalid option. Please enter a number from 1 - 9.");
            }

        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid option. Integer only!");
            input.nextLine();
        }
        return option;
    }


    public static void main(String[] args) {
        ProductInventory inventory = new ProductInventory();
        OrderManager orderManager = new OrderManager();

        //(PRODUCTINVENTORY) --------- ADD PRODUCTS ---------
        inventory.addProduct(new Product("A01", "MacBook Air", "Electronics", 2499.99, 3, "Apple"));
        inventory.addProduct(new Product("A02", "Lamzu Mouse", "Electronics", 24.50, 20, "Lamzu"));
        inventory.addProduct(new Product("A03", "Birkin Bag", "Accessory", 34450.00, 1, "Hermes"));
        inventory.addProduct(new Product("A04", "White Gatorade", "Beverage", 2.99, 15, "Gatorade"));

        //(PRODUCTINVENTORY) --------- PRINT INVENTORY ---------
        System.out.println("------------ PRODUCT INVENTORY -------------");
        System.out.println("Products Added: ");
        inventory.printAllProducts();

        //(PRODUCTINVENTORY) --------- REMOVE PRODUCT ---------
        boolean removed = inventory.removeProduct("A03");
        System.out.println("Item Removed?: " + removed);
        inventory.printAllProducts();

        //(PRODUCTINVENTORY) --------- FIND PRODUCT ---------
        System.out.print("Search Results: ");
        System.out.println(inventory.findProduct("A02") + "\n");

//============================================================================================================================

        //(ORDERMANAGER) --------- CREATING ORDERS ---------
        System.out.println("------------ ORDER MANAGER -------------");
           //Order #1
        Order order1 = new Order("C001", "Xiang", "2026-02-21", "Pending");
        order1.addItem(new OrderItem("A03", "Birkin Bag", 1, 34450.00));
        order1.addItem(new OrderItem("A02", "Lamzu Mouse", 1, 24.50));
        orderManager.addOrder(order1);
           //Order #2
        Order order2 = new Order("C002", "Justin Bieber", "1990-02-21", "Pending");
        order2.addItem(new OrderItem("P002", "Barbie-Doll", 3, 19.99));
        orderManager.addOrder(order2);
        System.out.println("ORDER DETAILS(PENDING): ");
        orderManager.printAllOrders();

        //(ORDERMANAGER) --------- PROCESSING ORDERS ---------
        Order process1 = orderManager.findOrder("C001");
        process1.updateStatus("Processing");
        Order process2 = orderManager.findOrder("C002");
        process2.updateStatus("Delivered");

        System.out.println("ORDER DETAILS(PROCESSING): ");
        orderManager.printAllOrders();

        //(ORDERMANAGER) --------- GENERATING REPORTS ---------
        System.out.println("---------- GENERATED REPORT ----------");
           //Revenue
        System.out.println("Total Revenue: $" + orderManager.getTotalRevenue());
           //Order Status
        Vector<Order> oStatusPnd = orderManager.getOrdersByStatus("Pending");
        System.out.println("Orders Pending: " + oStatusPnd.size());
        Vector<Order> oStatusPc = orderManager.getOrdersByStatus("Processing");
        System.out.println("Orders Processing: " + oStatusPc.size());
        Vector<Order> deliveredOrders = orderManager.getOrdersByStatus("Delivered");
        System.out.println("Orders Delivered: " + deliveredOrders.size());
           //Orders by Customer Name
        Vector<Order> custOrders = orderManager.getOrdersByCustomer("Xiang");
        System.out.println("Total Customer Orders Placed: " + custOrders.size() + "\n");

//============================================================================================================================

        System.out.println("------------ VECTOR CAPACITY -------------");
        // --------- (VECTOR CAPACITY MANAGEMENT) ---------
        System.out.println("Original Capacity:");
        inventory.printCapacityReport();

           //Increased capacity
        System.out.println("\nIncreased Capacity:");
        inventory.ensureCapacity(67);
        inventory.printCapacityReport();

           //Trimmed capacity
        System.out.println("\nTrimmed Capacity:");
        inventory.optimizeCapacity();
        inventory.printCapacityReport();

//============================================================================================================================

        // --------- GENERIC UTILITY METHODS ---------
        System.out.println("------------ GENERIC UTILITIES USAGE -------------");

          //Swaping Vectors
        Vector<String> vec = new Vector<>();
        vec.add("Love");
        vec.add("LeGoat");
        System.out.println("(before swap) " + vec);

        VectorUtils.swap(vec, 0, 1);
        System.out.println("(after swap) " + vec);

          //findMax
        Vector<Integer> nums = new Vector<>();
        nums.add(2005);
        nums.add(2010);
        nums.add(67);
        System.out.println("(findmax) Max num: " + VectorUtils.findMax(nums));

          //filterProducts
        Vector<Product> Electronics = inventory.getProductsByCategory("Electronics");
        Vector<Product> filtered = VectorUtils.filterProducts(Electronics, "Electronics");
        System.out.println("Filtered Products: " + filtered.size());

          //sumNumbers
        Vector<Integer> sumNums = new Vector<>();
        sumNums.add(1200);
        sumNums.add(1201);
        sumNums.add(1202);

        double sum = VectorUtils.sumNumbers(sumNums);
        System.out.println("Sum: " + sum);

          //averageNumbers
        double avg = VectorUtils.averageNumbers(sumNums);
        System.out.println("Avg: " + avg + "\n");

//============================================================================================================================
        //INTERACTIVE MENU AREA!!!
        Scanner input = new Scanner(System.in);
        ProductInventory menuInventory = new ProductInventory();
        OrderManager menuOrderManager = new OrderManager();

        int option;
        do {
            System.out.println("--------- Interactive Menu ---------");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Find Product");
            System.out.println("4. List All Products");
            System.out.println("5. Create Order");
            System.out.println("6. View Orders");
            System.out.println("7. Process Order");
            System.out.println("8. Generate Reports");
            System.out.println("9. Exit" + "\n");
            System.out.print("Choose an option: ");

            option = menuInt(input);   // YOUR method

            switch (option) {
                case 1:
                    addProduct(input, menuInventory);
                    break;
                case 2:
                    removeProduct(input, menuInventory);
                    break;
                case 3:
                    findProduct(input, menuInventory);
                    break;
                case 4:
                    menuInventory.printAllProducts();
                    break;
                case 5:
                    createOrder(input, menuOrderManager);
                    break;
                case 6:
                    menuOrderManager.printAllOrders();
                    break;
                case 7:
                    processOrder(input, menuOrderManager);
                    break;
                case 8:
                    generateReports(input, menuInventory, menuOrderManager);
                    break;
                case 9:
                    System.out.println("Exiting Now!!!");
                    break;
                default:
                    break;
            }

        } while (option != 9);

        input.close();

    }
}
