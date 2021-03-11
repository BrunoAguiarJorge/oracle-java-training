package oracle.training.data;

@FunctionalInterface
public interface Rateable<T> {

	public static final Rating DEFAULT_RATING = Rating.NOT_REATED;

	// I have ommited access modifier (public) and abstract because interfaces are
	// implicitly public and abstract
	T applyRating(Rating rating);

	public default T applyRating(int stars) {
		return applyRating(convert(stars));
	}

	public default Rating getRating() {
		return DEFAULT_RATING;
	}

	public static Rating convert(int stars) {
		return (stars >= 0 && stars <= 5) ? Rating.values()[stars] : DEFAULT_RATING;
	}

}
