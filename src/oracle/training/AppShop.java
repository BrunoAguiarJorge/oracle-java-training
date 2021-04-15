package oracle.training;

import oracle.training.data.ProductManager;

public class AppShop {
	public static void main(String[] args) {

		ProductManager pm = ProductManager.getInstance(); // new ProductManager();

		pm.printProductReport(103, "en-GB");
		pm.printProductReport(101, "ru-RU");

	}
}