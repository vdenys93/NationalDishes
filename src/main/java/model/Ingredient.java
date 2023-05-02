package model;

/**
 * @Viktoriia Denys - vdenys
 * CIS175 - Spring 2023
 * May 2, 2023
 */

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="ingredient")
public class Ingredient implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="ingredient_name")
    private String ingredientName;

    @ManyToOne
    @JoinColumn(name="dishlist_id")
    private DishList dishList;

    public Ingredient() {}

    public Ingredient(String ingredientName, DishList dishList) {
        this.ingredientName = ingredientName;
        this.dishList = dishList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public DishList getDishList() {
        return dishList;
    }

    public void setDishList(DishList dishList) {
        this.dishList = dishList;
    }
}
