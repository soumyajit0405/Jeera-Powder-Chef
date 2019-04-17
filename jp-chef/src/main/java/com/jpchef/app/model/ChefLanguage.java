package com.jpchef.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the chef_languages database table.
 * 
 */
@Entity
@Table(name="chef_languages")
@NamedQuery(name="ChefLanguage.findAll", query="SELECT c FROM ChefLanguage c")
public class ChefLanguage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="chef_language_id")
	private Long chefLanguageId;

	@Column(name="language_known")
	private String languageKnown;

	//bi-directional many-to-one association to ChefDetail
	@ManyToOne
	@JoinColumn(name="chef_id")
	private ChefDetail chefDetail;

	public ChefLanguage() {
	}

	public Long getChefLanguageId() {
		return this.chefLanguageId;
	}

	public void setChefLanguageId(Long chefLanguageId) {
		this.chefLanguageId = chefLanguageId;
	}

	public String getLanguageKnown() {
		return this.languageKnown;
	}

	public void setLanguageKnown(String languageKnown) {
		this.languageKnown = languageKnown;
	}

	public ChefDetail getChefDetail() {
		return this.chefDetail;
	}

	public void setChefDetail(ChefDetail chefDetail) {
		this.chefDetail = chefDetail;
	}

}