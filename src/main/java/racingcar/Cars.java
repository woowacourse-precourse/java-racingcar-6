package racingcar;

import static racingcar.CarNameParser.splitAndStrip;

import java.util.List;

public class Cars {
	private List<Car> cars;

	public Cars(String input) {
		List<String> nameOfCars = splitAndStrip(input);

		checkDuplicated(nameOfCars);

		cars = nameOfCars.stream()
				.map(carName -> new Car(new CarName(carName)))
				.toList();
	}

	private void checkDuplicated(List<String> nameOfCars) {
		long sizeAfterDistinct = nameOfCars.stream().distinct().count();
		if (sizeAfterDistinct != nameOfCars.size()) {
			throw new IllegalArgumentException("중복된 이름입니다.");
		}
	}
}
