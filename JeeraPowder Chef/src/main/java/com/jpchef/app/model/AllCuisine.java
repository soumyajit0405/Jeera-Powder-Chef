package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the all_cuisines database table.
 * 
 */
@Entity
@Table(name="all_cuisines")
@NamedQuery(name="AllCuisine.findAll", query="SELECT a FROM AllCuisine a")
public class AllCuisine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cusine_id")
	private Long cusineId;

	private String description;

	private String name;

	//bi-directional many-to-one association to AllDishe
	@OneToMany(mappedBy="allCuisine")
	private List<AllDishe> allDishes;

	public AllCuisine() {
	}

	public Long getCusineId() {
		return this.cusineId;
	}

	public void setCusineId(Long cusineId) {
		this.cusineId = cusineId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AllDishe> getAllDishes() {
		return this.allDishes;
	}

	public void setAllDishes(List<AllDishe> allDishes) {
		this.allDishes = allDishes;
	}

	public AllDishe addAllDishe(AllDishe allDishe) {
		getAllDishes().add(allDishe);
		allDishe.setAllCuisine(this);

		return allDishe;
	}

	public AllDishe removeAllDishe(AllDishe allDishe) {
		getAllDishes().remove(allDishe);
		allDishe.setAllCuisine(null);

		return allDishe;
	}

}