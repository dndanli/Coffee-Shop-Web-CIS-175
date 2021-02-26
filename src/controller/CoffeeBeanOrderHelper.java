/**
 * @author Daniel De Lima - dcdelima
 * CIS 175 - Spring 2021
 * Feb 25, 2021
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CoffeeBeanOrder;

public class CoffeeBeanOrderHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CoffeeShop");


	//insert entity
	public void insertOrder( CoffeeBeanOrder cboToInsert) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(cboToInsert);
		em.getTransaction().commit();
		em.close();
	}

	//delete entity
	public void deleteOrder( CoffeeBeanOrder cboToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CoffeeBeanOrder> typedQuery = em.createQuery("select li from CoffeeBeanOrder li where li.beanName = :selectedBeanName "
																+ "and li.quantityToOrder = :selectedQtToOrder "
																+ "and li.packagesInStock = :selectedPkgInStock and li.supplier = :selectedSupplier", CoffeeBeanOrder.class);

		typedQuery.setParameter("selectedBeanName", cboToDelete.getBeanName());
		typedQuery.setParameter("selectedQtToOrder", cboToDelete.getQuantityToOrder());
		typedQuery.setParameter("selectedPkgInStock", cboToDelete.getPackagesInStock());
		typedQuery.setParameter("selectedSupplier", cboToDelete.getSupplier());
		typedQuery.setMaxResults(1);
		CoffeeBeanOrder result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	//edit entity
	public void updateOrder(CoffeeBeanOrder cboToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(cboToEdit);
		em.getTransaction().commit();
		em.close();		
	}

	//view entity
	@SuppressWarnings("unchecked")
	public List<CoffeeBeanOrder> showAllOrderDetails(){
		EntityManager em = emfactory.createEntityManager();
		List<CoffeeBeanOrder> orderDetails = em.createQuery("SELECT i FROM CoffeeBeanOrder i").getResultList();
		return orderDetails;
	}

	//search by supplier
	public List<CoffeeBeanOrder> searchOrderBySupplier(String supplier){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CoffeeBeanOrder> typedQuery = em.createQuery("select li from CoffeeBeanOrder li where li.supplier = :selectedSupplier", CoffeeBeanOrder.class);
		typedQuery.setParameter("selectedSupplier", supplier);
		List<CoffeeBeanOrder> foundOrders = typedQuery.getResultList();
		em.close();
		return foundOrders;
	}

	//search by bean name
	public List<CoffeeBeanOrder> searchOrderByBeanName(String beanName){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CoffeeBeanOrder> typedQuery = em.createQuery("select li from CoffeeBeanOrder li where li.beanName = :selectedBeanName", CoffeeBeanOrder.class);
		typedQuery.setParameter("selectedBeanName", beanName);
		List<CoffeeBeanOrder> foundOrders = typedQuery.getResultList();
		em.close();
		return foundOrders;
	}

	// search by order id
	public CoffeeBeanOrder searchForOrderByID(int orderId){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CoffeeBeanOrder found = em.find(CoffeeBeanOrder.class, orderId);
		em.close();
		return found;
	}

	//clean up 	
	public void cleanUp(){
		emfactory.close();
	}

}
