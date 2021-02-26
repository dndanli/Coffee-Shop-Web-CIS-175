/**
 * @author Daniel De Lima - dcdelima
 * CIS 175 - Spring 2021
 * Feb 11, 2021
 */

package view;


import java.util.List;
import java.util.Scanner;

import controller.CoffeeBeanOrderHelper;
import model.CoffeeBeanOrder;

public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static CoffeeBeanOrderHelper lih = new CoffeeBeanOrderHelper();

	private static void addAnItem() {
		System.out.print("Enter a Coffee Bean name: ");
		String beanName = in.nextLine();

		System.out.print("Enter a package quantity to order: ");
		int quantity = in.nextInt();

		System.out.print("Enter a the amount of packages in stock: ");
		int packagesInStock = in.nextInt();

		System.out.print("Enter a supplier: ");
		String supplier = in.next();

		CoffeeBeanOrder toAdd = new CoffeeBeanOrder(beanName, quantity, packagesInStock, supplier);
		lih.insertOrder(toAdd);
	}


	private static void deleteAnItem() {
		System.out.print("Enter a Coffee Bean name to delete: ");
		String beanName = in.nextLine();

		System.out.print("Enter a the order quantity to delete: ");
		int quantity = in.nextInt();

		System.out.print("Enter a the amount of packages in stock to delete: ");
		int packagesInStock = in.nextInt();

		System.out.print("Enter a supplier to delete: ");
		String supplier = in.next();

		CoffeeBeanOrder toDelete = new CoffeeBeanOrder(beanName, quantity, packagesInStock, supplier);

		lih.deleteOrder(toDelete);
	}


	private static void editAnItem() {
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Supplier name");
		System.out.println("2 : Search by Bean name");
		int searchBy = in.nextInt();
		in.nextLine();
		List<CoffeeBeanOrder> foundItems;
		if (searchBy == 1) {
			System.out.print("Enter the Supplier name: ");
			String supplierName = in.nextLine();

			foundItems = lih.searchOrderBySupplier(supplierName);

		} else {
			System.out.print("Enter the Bean name: ");
			String beanName = in.nextLine();

			foundItems = lih.searchOrderByBeanName(beanName);
		}

		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (CoffeeBeanOrder l : foundItems) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			CoffeeBeanOrder toEdit = lih.searchForOrderByID(idToEdit);
			System.out.println("Retrieved " + toEdit.getBeanName() + " from " + toEdit.getSupplier());
			System.out.println("1 : Update Bean Name");
			System.out.println("2 : Update Supplier Name");
			System.out.println("3 : Update order quantity");
			System.out.println("4 : Update packages in stock");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Bean Name: ");
				String beanName = in.nextLine();
				toEdit.setBeanName(beanName);

			} else if (update == 2) {
				System.out.print("New supplier Name: ");
				String newSupplierName = in.nextLine();
				toEdit.setSupplier(newSupplierName);

			} else if (update == 3) {
				System.out.print("New quantity to be ordered: ");
				int newQuantity = in.nextInt();
				toEdit.setQuantityToOrder(newQuantity);

			}else if (update == 4) {
				System.out.print("New packages in stock: ");
				int newPackagesInStock = in.nextInt();
				toEdit.setPackagesInStock(newPackagesInStock);
			}

			lih.updateOrder(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void main(String[] args) {
		runMenu();
	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our awesome shopping list! ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add an order");
			System.out.println("*  2 -- Edit an order");
			System.out.println("*  3 -- Delete ab order");
			System.out.println("*  4 -- View the list of orders");
			System.out.println("*  5 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnItem();
			} else if (selection == 2) {
				editAnItem();
			} else if (selection == 3) {
				deleteAnItem();
			} else if (selection == 4) {
				viewTheList();
			} else {
				lih.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		List<CoffeeBeanOrder> allItems = lih.showAllOrderDetails();
		for(CoffeeBeanOrder singleItem : allItems){
			System.out.println(singleItem.returnCoffeeDetails());
		}
	}

}
