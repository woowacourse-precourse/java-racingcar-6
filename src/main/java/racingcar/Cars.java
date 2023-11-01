package racingcar;

import static racingcar.CarNameParser.splitAndStrip;

import java.util.List;

public class Cars {

	public Cars(String input) {
		List<String> nameOfCars = splitAndStrip(input);

		checkDuplicated(nameOfCars);
	}

	private void checkDuplicated(List<String> nameOfCars) {
		long sizeAfterDistinct = nameOfCars.stream().distinct().count();
		if (sizeAfterDistinct != nameOfCars.size()) {
			throw new IllegalArgumentException("중복된 이름입니다.");
		}
	}
}
