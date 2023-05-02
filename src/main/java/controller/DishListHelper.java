package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.DishList;

/**
 * @Viktoriia Denys - vdenys
 * CIS175 - Spring 2023
 * Mar 07, 2023
 */
public class DishListHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("NationalDishes");
	public void insertItem(DishList li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<DishList> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<DishList> allItems = em.createQuery("SELECT i FROM DishList i").getResultList();
		return allItems;
		}
	public void deleteItem(DishList toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<DishList> typedQuery = em.createQuery("select li from "
				+ "DishList li where li.country = :selectedCountry and li.dishName = :selectedName and li.dishDescription = :selectedDescription", DishList.class);
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedCountry", toDelete.getCountry());
		typedQuery.setParameter("selectedName",toDelete.getDishName());
		typedQuery.setParameter("selectedDescription",toDelete.getDishDescription());
		//we only want one result
		typedQuery.setMaxResults(1);
		//get the result and save it into a new list item
		DishList result = typedQuery.getSingleResult();
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	/**
	 * @param idToEdit
	 * @return
	 */
	public DishList searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		DishList found = em.find(DishList.class, idToEdit);
		em.close();
		return found;
	}
	/**
	 * @param toEdit
	 */
	public void updateItem(DishList toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		}
		
	/**
	 * @param countryName
	 * @return
	 */
	public List<DishList> searchForItemByCountry(String countryName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<DishList> typedQuery = em.createQuery("select li from DishList li where li.country = :selectedCountry", DishList.class);
		typedQuery.setParameter("selectedCountry", countryName);
		List<DishList> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	/**
	 * @param dishName
	 * @return
	 */
	public List<DishList> searchForItemByName(String dishName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<DishList> typedQuery = em.createQuery("select li from DishList li where li.dishName = :selectedName", DishList.class);
		typedQuery.setParameter("selectedName", dishName);
		List<DishList> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	public List<DishList> searchForItemByDescription(String dishDescription) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<DishList> typedQuery = em.createQuery("select li from DishList li where li.dishDescription = :selectedDescription", DishList.class);
		typedQuery.setParameter("selectedDescription", dishDescription);
		List<DishList> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
		}
	public DishList searchForDishById(int dishId) {
	    EntityManager em = emfactory.createEntityManager();
	    em.getTransaction().begin();
	    DishList found = em.find(DishList.class, dishId);
	    em.close();
	    return found;
	}

	public void cleanUp(){
		emfactory.close();
		}
	

}
