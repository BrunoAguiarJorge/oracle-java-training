package oracle.training.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public abstract class Product implements Rateable<Product>, Serializable {
	public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
	private int id;
	private String name;
	private BigDecimal price;
	private Rating rating;

	Product(int id, String name, BigDecimal price, Rating rating) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.rating = rating;
	}

	Product(int id, String name, BigDecimal price) {
		this(id, name, price, Rating.NOT_REATED);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public BigDecimal getDiscount() {
		return price.multiply(DISCOUNT_RATE).setScale(2, RoundingMode.HALF_UP);
	}

	@Override
	public Rating getRating() {
		return rating;
	}

	@Override
	public String toString() {
		return " id= " + id + ", " + name + ", price= " + price + ", discount= " + getDiscount() + ", "
				+ getRating().getStars() + ", BBF= " + getBestBefore();
	}

	public LocalDate getBestBefore() {
		return LocalDate.now();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Product) {
			final Product other = (Product) obj;
			return this.id == other.id; //&& Objects.equals(this.name, other.name);
		}
		return false;
	}
}
