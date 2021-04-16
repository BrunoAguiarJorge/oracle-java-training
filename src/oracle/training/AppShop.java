package oracle.training;

import oracle.training.data.ProductManager;

public class AppShop {
	public static void main(String[] args) {
		ProductManager pm = ProductManager.getInstance(); // new ProductManager();
		/**
		 * simulate concurrent caller
		 */
//		AtomicInteger clientCount = new AtomicInteger(0);
//		Callable<String> client = () -> {
//			String clientId = "client " + clientCount.incrementAndGet();
//			String threadName = Thread.currentThread().getName();
//			int productId = ThreadLocalRandom.current().nextInt(63) + 101;
//			String languageTag = ProductManager.getSupportedLocale().stream()
//					.skip(ThreadLocalRandom.current().nextInt(4)).findFirst().get();
//			StringBuilder log = new StringBuilder();
//			log.append(clientId + " " + threadName + " " + "\n-\tstart of log\t-\n");
//			log.append(pm.getDiscounts(languageTag).entrySet().stream()
//					.map(entry -> entry.getKey() + "\t " + entry.getValue()).collect(Collectors.joining("\n")));
//			Product product = pm.reviewProduct(productId, Rating.FOUR_STAR, "Yet another review");
//			log.append((product != null) ? "\nProduct " + productId + " reviewd\n"
//					: "\nProduct " + productId + " not reviewd\n ");
//			pm.printProductReport(productId, languageTag, clientId);
//			log.append(clientId + " generated report for " + productId + "product");
//			log.append("\n-\tend of log\t-\n");
//			return log.toString();
//		};
//		List<Callable<String>> clients = Stream.generate(() -> client).limit(5).collect(Collectors.toList());
//		ExecutorService executorService = Executors.newFixedThreadPool(3);
//		try {
//			List<Future<String>> results = executorService.invokeAll(clients);
//			executorService.shutdown();
//			results.stream().forEach(result -> {
//				try {
//					System.out.print(result.get());
//				} catch (Exception e) {
//					((Throwable) e).printStackTrace();
//				}
//			});
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}