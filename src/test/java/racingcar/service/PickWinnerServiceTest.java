package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class PickWinnerServiceTest {

	@DisplayName("우승자를 확인한다.")
	@MethodSource("createCheckWinnerTestValue")
	@ParameterizedTest
	void checkWinner(Cars cars, String winner) {
		PickWinnerService service = new PickWinnerService();
		String printWinner = service.printWinner(cars);

		assertEquals(printWinner, winner);
	}

	static Stream<Arguments> createCheckWinnerTestValue() {
		return Stream.of(
						Arguments.of(new Cars(List.of(new Car("one", 1), new Car("two", 2), new Car("three", 3))),
								"three"),
						Arguments.of(new Cars(List.of(new Car("one", 1), new Car("two", 2), new Car("three", 2))),
								"two, three"),
						Arguments.of(new Cars(List.of(new Car("one", 1), new Car("two", 1), new Car("three", 1))),
								"one, two, three"),
						Arguments.of(new Cars(List.of(new Car("one", 0), new Car("two", 0), new Car("three", 0))),
								"one, two, three")
						);
	}
}
