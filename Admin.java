package com;

import java.util.List;
import java.util.Scanner;

public class Admin implements ProductOperation, UserInterface {

    private static final String ADMIN_USERNAME = "Admin@User";
    private static final String ADMIN_PASSWORD = "Admin@Password";

    public Admin(OrderProcessingWithDataBase order) {
//        this.order = order;
    }

    public static boolean login(String username, String password) {
        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }

    @Override
    public void addProduct() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Set code of product");
            int productCode = sc.nextInt();
            sc.nextLine(); 
            System.out.println("Enter product Name");
            String productName = sc.nextLine();
            System.out.println("Set price");
            double price = sc.nextDouble();
            System.out.println("Fill the quantity");
            int quantity = sc.nextInt();
            sc.nextLine(); 
            OrderProcessingWithDataBase.insertValues(new Product(productCode, productName, price, quantity));
            System.out.println("Product added successfully");
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    @Override
    public void displayProduct() {
        try {
            List<Product> products = OrderProcessingWithDataBase.readAllProducts();
            for (Product product : products) {
                System.out.println(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduct() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter product code to update: ");
            int productCode = sc.nextInt();
            sc.nextLine();

            Product existingProduct = OrderProcessingWithDataBase.readProductByCode(productCode);

            if (existingProduct == null) {
                System.out.println("Product not found.");
                return;
            }

            System.out.print("Enter new product name: ");
            String newName = sc.nextLine();
            if (!newName.isEmpty()) {
                existingProduct.setProductName(newName);
            }

            System.out.print("Enter new product price: ");
            double newPrice = sc.nextDouble();
            existingProduct.setPrice(newPrice);

            System.out.print("Enter new product quantity: ");
            int newQuantity = sc.nextInt();
            sc.nextLine(); 
            existingProduct.setQuantity(newQuantity);

            OrderProcessingWithDataBase.updateProduct(existingProduct);
            System.out.println("Product updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter product code to delete: ");
            int productCode = sc.nextInt();
            sc.nextLine(); 

            boolean deleted = OrderProcessingWithDataBase.deleteValues(productCode);
            if (deleted) {
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("Failed to delete");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    public void addCustomer() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter new customer username:");
            String username = sc.nextLine();
            System.out.println("Enter new customer email:");
            String email = sc.nextLine();
            System.out.println("Enter new customer password:");
            String password = sc.nextLine();

            Customer newCustomer = new Customer(username, email, password); // ID will be auto-generated
            OrderProcessingWithDataBase.insertValues(newCustomer);
            System.out.println("Customer added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayCustomers() {
        try {
            List<Customer> customers = OrderProcessingWithDataBase.readAllCustomers();
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void itemsList() {
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("1. Add Product\n2. Delete Product\n3. Update Product\n4. Display Products"
                		+ "\n5. add customer\n6. Display customer\n7. Logout");
                System.out.print("Choose an operation: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        addProduct();
                        break;
                    case 2:
                        deleteProduct();
                        break;
                    case 3:
                        updateProduct();
                        break;
                    case 4:
                        displayProduct();
                        break;
                    case 5:
                        addCustomer();
                        break;
                    case 6:
                        displayCustomers();
                        break;
                    case 7:
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
            }
            catch(Exception e) {
            	
            e.printStackTrace();
            } 
    }
    public static void handleLogin() throws ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (OrderProcessingWithDataBase.validateLogin(email, password)) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Invalid email or password.");
        }
    }
}