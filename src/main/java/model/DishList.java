package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @Viktoriia Denys - vdenys
 * CIS175 - Spring 2023
 * Mar 07, 2023
 */
@Entity
@Table(name="dishes")
public class DishList {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="COUNTRY")
	private String country;
	@Column(name="NAME")
	private String 	dishName;
	@Column(name="DESCRIPTION")
	private String 	dishDescription;
	@OneToMany(mappedBy="dishList", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Ingredient> ingredients;

	
	public DishList() {
		super();
	}

	
	public DishList(String country, String dishName, String dishDescription) {
		super();
		this.country = country;
		this.dishName = dishName;
		this.dishDescription = dishDescription;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	
	/**
	 * @return the dishName
	 */
	public String getDishName() {
		return dishName;
	}
	/**
	 * @param dishName the dishName to set
	 */
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	
	/**
	 * @return the dishDescription
	 */
	public String getDishDescription() {
		return dishDescription;
	}


	/**
	 * @param dishDescription the dishDescription to set
	 */
	public void setDishDescription(String dishDescription) {
		this.dishDescription = dishDescription;
	}


	public String returnDishDetails() {
		if (this.dishDescription!="") {
			return this.country + ": " + this.dishName+" ("+ this.dishDescription +")";
		}
		else {
			return this.country + ": " + this.dishName; 			
		}
	}


	@Override
	public String toString() {
		return "DishList [id=" + id + ", country=" + country + ", dishName=" + dishName + ", dishDescription="
				+ dishDescription + "]";
	}
	
	  public List<Ingredient> getIngredients() {
	        return ingredients;
	    }

	    public void setIngredients(List<Ingredient> ingredients) {
	        this.ingredients = ingredients;
	    }
	

}
