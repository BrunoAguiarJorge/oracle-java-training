package oracle.training;

import java.math.BigDecimal;
import java.security.cert.PolicyQualifierInfo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import oracle.training.data.Food;
import oracle.training.data.Product;
import oracle.training.data.Rating;

public class AppShop {
	public static void main(String[] args) {

		/**
		 * {@class App Shop} represents an application that manages Products
		 * @version 1.0
		 * @author brunoaguiar
		 */
		
	
		

		Product p1 = new Product(101, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_REATED);
		Product p2 = new Product(102, "Coffee", BigDecimal.valueOf(2.99), Rating.FOUR_STAR);
		Product p3 = new Product(103, "Cake", BigDecimal.valueOf(3.99), Rating.FIVE_STAR);
		Product p4 = new Product(103, "Cake", BigDecimal.valueOf(3.99), Rating.FIVE_STAR);
		//call applyRating method to update only 'RATING' and does not change p3 only reference to the same memory location
		Product p5 = p3.applyRating(Rating.THREE_STAR);

		System.out.println(p1.getId() + " " + p1.getName() + " " + p1.getPrice() + " " + p1.getDiscount() + " "
				+ p1.getRating().getStars());
		System.out.println(p2.getId() + " " + p2.getName() + " " + p2.getPrice() + " " + p2.getDiscount() + " "
				+ p2.getRating().getStars());
		System.out.println(p3.getId() + " " + p3.getName() + " " + p3.getPrice() + " " + p3.getDiscount() + " "
				+ p3.getRating().getStars());
		System.out.println(p4.getId() + " " + p4.getName() + " " + p4.getPrice() + " " + p4.getDiscount() + " "
				+ p4.getRating().getStars());
		System.out.println(p5.getId() + " " + p5.getName() + " " + p5.getPrice() + " " + p5.getDiscount() + " "
				+ p5.getRating().getStars());


		/*
		 * List<Product> products = new ArrayList<>(); for (Product all : products) {
		 * System.out.println("Products= " + all.toString()); }
		 */

	}
}