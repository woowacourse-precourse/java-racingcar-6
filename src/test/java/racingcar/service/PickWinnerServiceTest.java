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
		List<Car> winnerList = service.pickWinner(cars);
		String printWinner = service.printWinner(winnerList);
		
		assertEquals(printWinner, winner, "test");
	}
	
	static Stream<Arguments> createCheckWinnerTestValue(){
		return Stream.of(
						Arguments.of(
								new Cars(List.of(new Car("car1", 1), new Car("car2", 2), new Car("car3", 3))),
								"car3"
								),
						Arguments.of(
								new Cars(List.of(new Car("car1", 1), new Car("car2", 2), new Car("car3", 2))),
								"car2, car3"
								)
						);
	}
}
