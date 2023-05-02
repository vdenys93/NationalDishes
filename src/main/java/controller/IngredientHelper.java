package controller;

import java.util.List;

/**
 * @Viktoriia Denys - vdenys
 * CIS175 - Spring 2023
 * May 2, 2023
 */


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Ingredient;

public class IngredientHelper {
    static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("NationalDishes");

    public void insertIngredient(Ingredient ingredient) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(ingredient);
        em.getTransaction().commit();
        em.close();
    }

    public List<Ingredient> showAllIngredients() {
        EntityManager em = emfactory.createEntityManager();
        TypedQuery<Ingredient> typedQuery = em.createQuery("SELECT i FROM Ingredient i", Ingredient.class);
        List<Ingredient> allIngredients = typedQuery.getResultList();
        em.close();
        return allIngredients;
    }

    public void updateIngredient(Ingredient toEdit) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(toEdit);
        em.getTransaction().commit();
        em.close();
    }
    public Ingredient searchForIngredientById(int id) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        Ingredient foundIngredient = em.find(Ingredient.class, id);
        em.close();
        return foundIngredient;
    }


    public void deleteIngredient(Ingredient toDelete) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Ingredient> typedQuery = em.createQuery("SELECT i FROM Ingredient i WHERE i.ingredientName = :selectedName", Ingredient.class);
        typedQuery.setParameter("selectedName", toDelete.getIngredientName());
        typedQuery.setMaxResults(1);
        Ingredient result = typedQuery.getSingleResult();
        em.remove(result);
        em.getTransaction().commit();
        em.close();
    }
}
