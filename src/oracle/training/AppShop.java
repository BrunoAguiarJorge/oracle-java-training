package oracle.training;

import java.math.BigDecimal;
import java.time.LocalDate;

import oracle.training.data.Drink;
import oracle.training.data.Food;
import oracle.training.data.Product;
import oracle.training.data.Rating;

public class AppShop {
	public static void main(String[] args) {
		
		Product p1 = new Product(101, "Tea", BigDecimal.valueOf(1.99));
		Product p2 = new Drink(102, "Coffee", BigDecimal.valueOf(2.99), Rating.FOUR_STAR);
		Product p3 = new Food(103, "Cake", BigDecimal.valueOf(3.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
		Product p4 = new Product();
		//call applyRating method to update only 'RATING' and does not change p3 only reference to the same memory location
		Product p5 = p3.applyRating(Rating.THREE_STAR);
		Product p6 = new Drink(104, "Chocolate", BigDecimal.valueOf(2.99), Rating.FOUR_STAR);
		Product p7 = new Food(104, "Chocolate", BigDecimal.valueOf(2.99), Rating.FOUR_STAR, LocalDate.now().plusDays(2));
		System.out.println(p7.equals(p6));
		System.out.println("Product " + p1);
		System.out.println("Drink " +p2);
		System.out.println("Food " +p3);
		System.out.println("empty " +p4);
		System.out.println(p5);
		
	
	
	}
}