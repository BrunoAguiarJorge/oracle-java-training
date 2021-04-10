package oracle.training.data;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.sound.midi.Receiver;

public class ProductManager {

	private Map<Product, List<Review>> products = new HashMap<>();

	private ResourceFormatter formatter;
	private ResourceBundle config = ResourceBundle.getBundle("oracle.training.data.config");
	private MessageFormat reviewFormat = new MessageFormat(config.getString("review.data.format"));
	private MessageFormat productFormat = new MessageFormat(config.getString("product.data.format"));

	/**
	 * JAVA I/O
	 */
	private Path reportsFolder = Path.of(config.getString("reports.folder"));
	private Path dataFolder = Path.of(config.getString("data.folder"));
	private Path tempFolder = Path.of(config.getString("temp.folder"));

	private static Map<String, ResourceFormatter> formatters = Map.of("en-GB", new ResourceFormatter(Locale.UK),
			"en-US", new ResourceFormatter(Locale.US), "fr-FR", new ResourceFormatter(Locale.FRANCE), "pt-BR",
			new ResourceFormatter(new Locale("pt", "BR")), "zh-CN", new ResourceFormatter(Locale.CHINA));

	public ProductManager(Locale locale) {
		this(locale.toLanguageTag());
	}

	public ProductManager(String languageTag) {
		changeLocale(languageTag);
	}

	public void changeLocale(String languageTag) {
		formatter = formatters.getOrDefault(languageTag, formatters.get("en-GB"));
	}

	public static Set<String> getSupportedLocale() {
		return formatters.keySet();
	}

	public Product createProduct(int id, String name, BigDecimal price, Rating rating, LocalDate bestBefore) {
		Product product = new Food(id, name, price, rating, bestBefore);
		products.putIfAbsent(product, new ArrayList<>());
		return product;
	}

	public Product createProduct(int id, String name, BigDecimal price, Rating rating) {
		Product product = new Drink(id, name, price, rating);
		products.putIfAbsent(product, new ArrayList<>());
		return product;
	}

	/**
	 * Search for specific product object in the collection of product using for
	 * loop and streams
	 * 
	 * @throws ProductManagerException
	 */
	public Product findProduct(int id) throws ProductManagerException {
//		Product result = null;
//		for (Product product : products.keySet()) {
//			if (product.getId() == id) {
//				result = product;
//				break;
//			}
//		}
//		return result;
		return products.keySet().stream().filter(p -> p.getId() == id).findFirst()
				.orElseThrow(() -> new ProductManagerException("Product with id " + id + "not found"));

	}

	public Product reviewProduct(int id, Rating rating, String comments) {
		try {
			return reviewProduct(findProduct(id), rating, comments);
		} catch (ProductManagerException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Product reviewProduct(Product product, Rating rating, String comments) {
		List<Review> reviews = products.get(product);
		products.remove(product, reviews);
		reviews.add(new Review(rating, comments));
		product = product.applyRating(Rateable.convert(
				(int) Math.round(reviews.stream().mapToInt(r -> r.getRating().ordinal()).average().orElse(0))));

//		int sum = 0;
//		for (Review review : reviews) {
//			sum += review.getRating().ordinal();
//		}
//		product = product.applyRating(Rateable.convert(Math.round((float) sum / reviews.size())));
		products.put(product, reviews);
		return product;

	}

	public void printProductReport(int id) {
		try {
			printProductReport(findProduct(id));
		} catch (ProductManagerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void printProductReport(Product product) throws IOException {
		List<Review> reviews = products.get(product);
		Collections.sort(reviews);
//		StringBuilder txt = new StringBuilder();
		Path productFile = reportsFolder
				.resolve(MessageFormat.format(config.getString("report.file"), product.getId()));
		try (PrintWriter out = new PrintWriter(
				new OutputStreamWriter(Files.newOutputStream(productFile, StandardOpenOption.CREATE), "UTF-8"))) {
			out.append(formatter.formatProduct(product) + System.lineSeparator());
			if (reviews.isEmpty()) {
				out.append(formatter.getText("no.reviews") + System.lineSeparator());
			} else {
				out.append(reviews.stream().map(r -> formatter.formatReview(r) + System.lineSeparator())
						.collect(Collectors.joining()));
			}
//		for (Review review : reviews) {
//			txt.append(formatter.formatReview(review));
//			txt.append('\n');
//		}
//		if (reviews.isEmpty()) {
//			txt.append(formatter.getText("no.reviews"));
//			txt.append('\n');
//		}
			// System.out.println(txt);
		}
	}

//  commented code was updated to streams.
	public void printProducts(Predicate<Product> filter, Comparator<Product> sorter) {
//		List<Product> productList = new ArrayList<>(products.keySet());
//		productList.sort(sorter);
		StringBuilder txt = new StringBuilder();
//		for (Product product : productList) {
//			txt.append(formatter.formatProduct(product));
//			txt.append('\n');
//		}

		products.keySet().stream().sorted(sorter).filter(filter)
				.forEach(p -> txt.append(formatter.formatProduct(p) + '\n'));
		System.out.println(txt);
	}

	public Review parseReview(String text) {
		Review review = null;
		try {
			Object[] values = reviewFormat.parse(text);
			review = new Review(Rateable.convert(Integer.parseInt((String) values[0])), (String) values[1]);
		} catch (ParseException | NumberFormatException ex) {
			ex.printStackTrace();
		}
		return review;
	}

	public Product parseProduct(String text) {
		Product product = null;
		try {
			Object[] values = productFormat.parse(text);
			int id = Integer.parseInt((String) values[1]);
			String name = (String) values[2];
			BigDecimal price = BigDecimal.valueOf(Double.parseDouble((String) values[3]));
			Rating rating = Rateable.convert(Integer.parseInt((String) values[4]));
			switch ((String) values[0]) {
			case "D":
				product = new Drink(id, name, price, rating);
				break;

			case "F":
				LocalDate bestBefore = LocalDate.parse((String) values[5]);
				product = new Food(id, name, price, rating, bestBefore);
			}
		} catch (ParseException | NumberFormatException | DateTimeParseException ex) {
			ex.printStackTrace();
		}
		return product;
	}

	public Map<String, String> getDiscounts() {
		return products.keySet().stream()
				.collect(Collectors.groupingBy(product -> product.getRating().getStars(),
						Collectors.collectingAndThen(
								Collectors.summingDouble(product -> product.getDiscount().doubleValue()),
								discount -> formatter.moneyFormat.format(discount))));
	}

	// nested class design to encapsulate management of text resources and
	// localisation
	private static class ResourceFormatter {
		private Locale locale;
		private ResourceBundle resources;
		private DateTimeFormatter dateFormat;
		private NumberFormat moneyFormat;

		private ResourceFormatter(Locale locale) {
			this.locale = locale;
			resources = ResourceBundle.getBundle("oracle.training.data.resources", locale);
			dateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).localizedBy(locale);
			moneyFormat = NumberFormat.getCurrencyInstance(locale);
		}

		private String formatProduct(Product product) {
			return MessageFormat.format(resources.getString("product"), product.getName(),
					moneyFormat.format(product.getPrice()), product.getRating().getStars(),
					dateFormat.format(product.getBestBefore()));
		}

		private String formatReview(Review review) {
			return MessageFormat.format(resources.getString("review"), review.getRating().getStars(),
					review.getComments());
		}

		private String getText(String key) {
			return resources.getString(key);
		}
	}

}
