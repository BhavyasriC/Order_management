package com;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//        try {
//            OrderProcessingWithDataBase.createTable();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
		OrderProcessingWithDataBase store = new OrderProcessingWithDataBase();
		Admin admin = new Admin(store);
		CustomerOperation customer = new CustomerOperation(store);

		Scanner scanner = new Scanner(System.in);
		try {
			while (true) {
				System.out.println("1. Admin\n2. Customer\n3. Exit");
				System.out.print("Choose your role: ");
				int role = scanner.nextInt();
				scanner.nextLine();

				switch (role) {
				case 1:
					System.out.print("Enter admin username: ");
					String username = scanner.nextLine();
					System.out.print("Enter admin password: ");
					String password = scanner.nextLine();

					if (Admin.login(username, password)) {
						System.out.println("Login successful.");
						admin.itemsList();
					} else {
						System.out.println("Invalid username or password.");
					}
					break;
				case 2:
					System.out.print("Enter email: ");
					String email = scanner.nextLine().trim();
					System.out.print("Enter password: ");
					String cxPassword = scanner.nextLine().trim();
					if (OrderProcessingWithDataBase.validateLogin(email, cxPassword)) {
						System.out.println("Login successful.");
						customer.itemsList();
					} else {
						System.out.println("Invalid email or password.");
					}
					break;
				case 3:
					return;
				default:
					System.out.println("Invalid role.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}