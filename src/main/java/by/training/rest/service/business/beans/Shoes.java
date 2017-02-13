package by.training.rest.service.business.beans;

import static by.training.rest.service.constants.Constants.*;

import by.training.rest.service.business.enums.Category;
import by.training.rest.service.business.enums.Rating;

public class Shoes {

	private int id;
	private String title;
	private int price;
	private Category category;
	private Rating rating;
	private String labels;
	private String description;

	public Shoes() {
		super();
		this.id = EMPTY_SHOES_ID;
		this.category = Category.ALL;
		this.rating = Rating.ONE;
	}

	private Shoes(Builder b) {
		this.id = b.id;
		this.title = b.title;
		this.price = b.price;
		this.category = b.category;
		this.rating = b.rating;
		this.labels = b.labels;
		this.description = b.description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public String getLabels() {
		return labels;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shoes other = (Shoes) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Shoes [id=" + id + ", title=" + title + ", price=" + price + "]";
	}

	public static class Builder {
		private int id;
		private String title;
		private int price;
		private Category category;
		private Rating rating;
		private String labels;
		private String description;

		public Builder(int id) {
			this.id = id;
		}

		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Builder price(int price) {
			this.price = price;
			return this;
		}

		public Builder category(Category category) {
			this.category = category;
			return this;
		}

		public Builder rating(Rating rating) {
			this.rating = rating;
			return this;
		}

		public Builder labels(String labels) {
			this.labels = labels;
			return this;
		}

		public Builder description(String description) {
			this.description = description;
			return this;
		}

		public Shoes build() {
			return new Shoes(this);
		}

	}

}