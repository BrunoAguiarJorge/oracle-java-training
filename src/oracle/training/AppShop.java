package oracle.training;

import java.math.BigDecimal;
import java.util.Comparator;

import oracle.training.data.Product;
import oracle.training.data.ProductManager;
import oracle.training.data.Rating;

public class AppShop {
	public static void main(String[] args) {

		ProductManager pm = new ProductManager("en-GB");

		pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_REATED);
		pm.reviewProduct(101, Rating.ONE_STAR, "Nice ");
		pm.reviewProduct(101, Rating.ONE_STAR, "Nice cup ");
		pm.reviewProduct(101, Rating.TWO_STAR, "Nice cup of ");
		pm.reviewProduct(101, Rating.THREE_STAR, "Nice cup of coffee");
		pm.reviewProduct(101, Rating.FOUR_STAR, "");
		pm.reviewProduct(101, Rating.FOUR_STAR, "Nice cup of coffee");
		pm.printProductReport(101);

		pm.changeLocale("pt-BR");
		pm.createProduct(102, "Cake", BigDecimal.valueOf(2.99), Rating.NOT_REATED);
		pm.reviewProduct(102, Rating.ONE_STAR, "cake ");
		pm.reviewProduct(102, Rating.ONE_STAR, "Nice cake ");
		pm.reviewProduct(102, Rating.FOUR_STAR, "good cake ");
		pm.reviewProduct(102, Rating.FOUR_STAR, "Beautiful");
		pm.reviewProduct(102, Rating.FOUR_STAR, "");
		pm.reviewProduct(102, Rating.FOUR_STAR, "Happy days");
		pm.printProductReport(102);
		
		Comparator<Product> ratingSorter= (p1, p2) -> p2.getRating().ordinal() - p1.getRating().ordinal();
		Comparator<Product> priceSorter = (p1, p2) -> p1.getPrice().compareTo(p2.getPrice());

		pm.printProducts(ratingSorter.thenComparing(priceSorter));
		pm.printProducts(priceSorter.thenComparing(priceSorter.reversed()));
	}
}