package oracle.training;

import java.util.Comparator;

import oracle.training.data.Product;
import oracle.training.data.ProductManager;

public class AppShop {
	public static void main(String[] args) {

		ProductManager pm = new ProductManager("en-GB");

		//pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_REATED);
		pm.parseProduct("D,101,Tea,1.99,0,2019-09-19");
		pm.printProductReport(101);
		pm.parseReview("101,4,Good tea");
		pm.parseReview("101,8,Nice tea");
		pm.parseReview("101,3,Nice hot tea");
		pm.parseReview("101,1,Nice hot cup of tea");
//		pm.reviewProduct(101, Rating.ONE_STAR, "Nice ");
//		pm.reviewProduct(101, Rating.ONE_STAR, "Nice cup ");
//		pm.reviewProduct(101, Rating.TWO_STAR, "Nice cup of ");
//		pm.reviewProduct(101, Rating.THREES_STAR, "Nice cup of coffee");
//		pm.reviewProduct(101, Rating.FOUR_STAR, "");
//		pm.reviewProduct(101, Rating.FOUR_STAR, "Nice cup of coffee");
		//pm.parseProduct("D,101,Tea,1.99,0,2019-09-19");
		pm.printProductReport(101);
		pm.parseProduct("F,103,cake,1.99,0,2019-09-19");
		pm.parseReview("103,4, nice cake");
		pm.printProductReport(103);
		
//		pm.changeLocale("pt-BR");
//		pm.createProduct(102, "Cake", BigDecimal.valueOf(2.99), Rating.NOT_REATED);
//		pm.reviewProduct(102, Rating.ONE_STAR, "cake ");
//		pm.reviewProduct(102, Rating.ONE_STAR, "Nice cake ");
//		pm.reviewProduct(102, Rating.FOUR_STAR, "good cake ");
//		pm.reviewProduct(102, Rating.FOUR_STAR, "Beautiful");
//		pm.reviewProduct(102, Rating.FOUR_STAR, "");
//		pm.reviewProduct(102, Rating.FOUR_STAR, "Happy days");
//		pm.printProductReport(102);
		
		pm.printProducts(p->p.getPrice().floatValue() <2 , (p1, p2) ->p2.getRating().ordinal());
		
		pm.getDiscounts().forEach((rating, discount) -> System.out.println(rating+"\t"+discount));
		
		Comparator<Product> ratingSorter= (p1, p2) -> p2.getRating().ordinal() - p1.getRating().ordinal();
		Comparator<Product> priceSorter = (p1, p2) -> p1.getPrice().compareTo(p2.getPrice());

//		pm.printProducts(ratingSorter.thenComparing(priceSorter));
//		pm.printProducts(priceSorter.thenComparing(priceSorter.reversed()));
	}
}