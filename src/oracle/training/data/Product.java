package oracle.training.data;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * {@link DISCOUNT_RATE discount rate}
 * 
 * @author brunoaguiar
 *
 */
public class Product {
	public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
	private int id;
	private String name;
	private BigDecimal price;
	// add getter method
	private Rating rating;

	public Product() {
	}

	public Product(int id, String name, BigDecimal price, Rating rating) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.rating = rating;
	}

	public Product(int id, String name, BigDecimal price) {
		this(id, name, price, Rating.NOT_REATED);
	}

	public int getId() {
		return id;
	}

//	public void setId(int id) {
//		this.id = id;
//	}

	public String getName() {
		return name;
	}

//	public void setName(final String name) {
//		this.name = name;
//	}

	public BigDecimal getPrice() {
		return price;
	}

//	public void setPrice(final BigDecimal price) {
//		// price = BigDecimal.ONE;
//		this.price = price;
//	}

	public BigDecimal getDiscount() {
		return price.multiply(DISCOUNT_RATE).setScale(2, RoundingMode.HALF_UP);
	}

	public Rating getRating() {
		return rating;
	}
	
	public Product applyRating(Rating newRating) {
		return new Product(this.id, this.name, this.price, newRating);
		
	}

//	@Override
//	public String toString() {
//		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", discount=" + getDiscount() + ", rating="
//				+ getRating() + "]";
//	}

}
