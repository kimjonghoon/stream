package net.java_school.examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class MovieTest {

	public static void main(String[] args) throws Exception {
		
		String fileName = "movies.txt";
		String str = null;
		List<Movie> movies = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			while ((str = br.readLine()) != null) {
				String[] arr = str.split(",");
				Movie movie = new Movie(arr[0], Integer.parseInt(arr[1]), Double.parseDouble(arr[2]));
				movies.add(movie);
			}
		}

		List<String> threeHighRatingMovieNames =
				movies.parallelStream()
				.filter(m -> m.getUserRatings() >= 8.0)
				.sorted(comparing(Movie::getUserRatings).reversed())
				.map(Movie::getTitle)
				.limit(3)
				.collect(toList());

		threeHighRatingMovieNames.forEach(m -> System.out.println(m));
		System.out.println();
		
		Predicate<Movie> popularMovies = m -> m.getUserRatings() >= 8.0;
		Predicate<Movie> complexCondition = popularMovies.negate().and(m -> m.getReleaseDate() > 2015);

		List<Movie> result =
				movies.parallelStream()
				.filter(complexCondition)
				.sorted(comparing(Movie::getUserRatings).reversed())
				.limit(3)
				.collect(toList());

		result.forEach(m -> System.out.println(m));
		System.out.println();
		
		OptionalDouble averageRating =
				movies.parallelStream()
				.mapToDouble(m -> m.getUserRatings())
				.average();

		System.out.println("Average Rating: " + averageRating.getAsDouble());
	}

}
