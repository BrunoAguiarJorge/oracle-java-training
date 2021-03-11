package oracle.training;

import java.math.BigDecimal;
import java.util.Locale;

import oracle.training.data.Product;
import oracle.training.data.ProductManager;
import oracle.training.data.Rating;

public class AppShop {
	public static void main(String[] args) {
		
		ProductManager pm = new ProductManager(Locale.UK);
		
		Product p1 = pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_REATED);
		pm.printProductReport();
		p1 = pm.reviewProduct(p1, Rating.ONE_STAR, "Nice ");
		p1 = pm.reviewProduct(p1, Rating.ONE_STAR, "Nice cup ");
		p1 = pm.reviewProduct(p1, Rating.FOUR_STAR, "Nice cup of ");
		p1 = pm.reviewProduct(p1, Rating.FOUR_STAR, "Nice cup of coffee");
		p1 = pm.reviewProduct(p1, Rating.FOUR_STAR, "");
		p1 = pm.reviewProduct(p1, Rating.FOUR_STAR, "Nice cup of coffee");
		pm.printProductReport();
		
		
		
//		Product p2 = pm.createProduct(102, "Coffee", BigDecimal.valueOf(2.99), Rating.FOUR_STAR);
//		Product p3 = pm.createProduct(103, "Cake", BigDecimal.valueOf(3.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
//		Product p4 = pm.createProduct(103, "Cookie", BigDecimal.valueOf(3.99), Rating.FIVE_STAR, LocalDate.now());
//		//call applyRating method to update only 'RATING' and does not change p3 only reference to the same memory location
//		Product p5 = p3.applyRating(Rating.THREE_STAR);
//		Product p6 = pm.createProduct(104, "Chocolate", BigDecimal.valueOf(2.99), Rating.FOUR_STAR);
//		Product p7 = pm.createProduct(104, "Chocolate", BigDecimal.valueOf(2.99), Rating.FOUR_STAR, LocalDate.now().plusDays(2));
//		Product p8 = p4.applyRating(Rating.FIVE_STAR);
//		Product p9 = p1.applyRating(Rating.TWO_STAR);
//		
//       System.out.println(p1.getBestBefore());
//       System.out.println(p3.getBestBefore());
//		
//		System.out.println(p7.equals(p6));
//		System.out.println(p1);
//		System.out.println(p2);
//		System.out.println(p3);
//		System.out.println(p4);
//		System.out.println(p5);
//		System.out.println(p6);
//		System.out.println(p7);
//		System.out.println(p8);
//		System.out.println(p9);

		
	
	
	}
}