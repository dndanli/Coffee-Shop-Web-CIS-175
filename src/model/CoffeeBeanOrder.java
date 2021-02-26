/**
 * @author Daniel De Lima - dcdelima
 * CIS 175 - Spring 2021
 * Feb 25, 2021
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coffee_beans")
public class CoffeeBeanOrder {

	//represents the id of the coffee bean (Primary key)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	//name of the coffee bean
	@Column(name = "bean_name")
	private String beanName;
	
	//represents how many bean packages should be ordered
	@Column(name = "quantity_to_order")
	private int quantityToOrder;
	
	//keeps track of total packages in the shop's stock
	@Column(name = "packages_in_stock")
	private int packagesInStock;
	
	// represents the store where it should be ordered
	@Column(name = "supplier")
	private String supplier;

	//default constructor
	public CoffeeBeanOrder() {
		super();
	}

	// parametized constructor
	public CoffeeBeanOrder(String beanName, int quantityToOrder,int packagesInStock,String supplier) {
		super();
		this.beanName = beanName;
		this.quantityToOrder = quantityToOrder;
		this.packagesInStock = packagesInStock;
		this.supplier = supplier;
	}

	// getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public int getQuantityToOrder() {
		return quantityToOrder;
	}

	public void setQuantityToOrder(int quantityToOrder) {
		this.quantityToOrder = quantityToOrder;
	}

	public int getPackagesInStock() {
		return packagesInStock;
	}

	public void setPackagesInStock(int packagesInStock) {
		this.packagesInStock = packagesInStock;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String returnCoffeeDetails() {
		return "\n"+ "Bean name:" + beanName + ", " +
				"Quantity to order: " + quantityToOrder + ", " +
				"Packages in stock: " + packagesInStock + ", " + 
				"Supplier: " + supplier + "\n";
	}
}
