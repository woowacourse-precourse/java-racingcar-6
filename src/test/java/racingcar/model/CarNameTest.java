package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.car.Car;
import racingcar.util.Validator;

public class CarNameTest {

	@Test
	@DisplayName("car name generation test 1 : normal generation")
	void validName() {
		// given
		String name = "pobi";
		// when
		Car newCar = new Car(name);
		// then
		assertThat(newCar).isNotNull();
		assertThat(newCar.getName()).hasToString(name);
	}

	@Test
	@DisplayName("car name generation test 2 : car name starts with comma")
	void validNameNotStartsWithComma() {
		String input = ",pobi,woni,jooni";
		assertThatThrownBy(() ->
			Validator.inputStartsWithComma(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("car name generation test 3 : car name ends with comma")
	void validNameNotEndsWithComma() {
		String input = "pobi,woni,jooni,";
		assertThatThrownBy(() ->
			Validator.inputEndsWithComma(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@DisplayName("car name generation test 4 : car name is over 5 length")
	@ValueSource(strings = {"pobiTheBestCar", "woniTheWorstCar"})
	void invalidNameOverFive(String name) {
		assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {""})
	@DisplayName("car name generation test 5 : car name is under 1 length")
	void invalidNameUnderOne(String name) {
		assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"  "})
	@DisplayName("car name generation test 6 : car name cannot be only whiteSpace")
	void invalidNameOnlyWhiteSpace(String name) {
		assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("car name generation test 7 : cars' names must be distinct")
	void invalidNameDuplicate(String name) {
		Car carOne = new Car("pobi");
		Car carTwo = new Car("pobi");
		Car carThr = new Car("woni");
		ArrayList<Car> cars = new ArrayList<>();
		cars.add(carOne);
		cars.add(carTwo);
		cars.add(carThr);
		assertThatThrownBy(() ->
			Validator.distinctNameOnly(cars))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
