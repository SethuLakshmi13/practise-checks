package com.cognizant.truyum.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu_item")
public class MenuItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "me_id", columnDefinition = "INT")
	private long id;
	@Column(name = "me_name")
	private String name;
	@Column(name = "me_price", columnDefinition = "DECIMAL(8,2)")
	private float price;
	@Column(name = "me_active", columnDefinition = "VARCHAR(3)")
	private String active;
	@Column(name = "me_date_of_launch")
	private Date dateOfLaunch;
	@Column(name = "me_category")
	private String category;
	@Column(name = "me_freeDelivery", columnDefinition = "VARCHAR(3)")
	private String freeDelivery;
	@Column(name = "me_image")
	private String image;

	public MenuItem() {

	}

	public MenuItem(long id, String name, float price, String active, Date dateOfLaunch, String category,
			String freeDelivery, String image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.category = category;
		this.freeDelivery = freeDelivery;
		this.image = image;
	}

	public String getActive() {
		return active;
	}

	public String getFreeDelivery() {
		return freeDelivery;
	}

	public long getId() {
		return id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String isActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String isFreeDelivery() {
		return freeDelivery;
	}

	public void setFreeDelivery(String freeDelivery) {
		this.freeDelivery = freeDelivery;
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", price=" + price + ", active=" + active + ", dateOfLaunch="
				+ dateOfLaunch + ", category=" + category + ", freeDelivery=" + freeDelivery + ", image=" + image + "]";
	}

}
