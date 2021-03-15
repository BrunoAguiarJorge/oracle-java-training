package oracle.training;

import java.math.BigDecimal;
import java.util.Locale;

import oracle.training.data.Product;
import oracle.training.data.ProductManager;
import oracle.training.data.Rating;

public class AppShop {
	public static void main(String[] args) {

		ProductManager pm = new ProductManager(Locale.US);

		pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_REATED);
		pm.printProductReport(101);
		pm.reviewProduct(101, Rating.ONE_STAR, "Nice ");
		pm.reviewProduct(101, Rating.ONE_STAR, "Nice cup ");
		pm.reviewProduct(101, Rating.TWO_STAR, "Nice cup of ");
		pm.reviewProduct(101, Rating.THREE_STAR, "Nice cup of coffee");
		pm.reviewProduct(101, Rating.FOUR_STAR, "");
		pm.reviewProduct(101, Rating.FOUR_STAR, "Nice cup of coffee");
		pm.printProductReport(101);

		pm.createProduct(102, "Cake", BigDecimal.valueOf(2.99), Rating.NOT_REATED);
		pm.printProductReport(102);
		pm.reviewProduct(102, Rating.ONE_STAR, "cake ");
		pm.reviewProduct(102, Rating.ONE_STAR, "Nice cake ");
		pm.reviewProduct(102, Rating.FOUR_STAR, "good cake ");
		pm.reviewProduct(102, Rating.FOUR_STAR, "Beautiful");
		pm.reviewProduct(102, Rating.FOUR_STAR, "");
		pm.reviewProduct(102, Rating.FOUR_STAR, "Happy days");
		pm.printProductReport(102);

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