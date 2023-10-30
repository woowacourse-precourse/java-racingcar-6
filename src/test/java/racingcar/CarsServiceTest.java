package racingcar;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.model.Car;
import racingcar.model.CarsService;

public class CarsServiceTest {

	CarsService carsService = new CarsService();

	List<Car> testCars;
	List<List<Integer>> randoms;

	@BeforeEach
	void createCars() {
		testCars = carsService.make("Faker, Chovy, Show, Bdd, Zeka");
	}

	@DisplayName("List<Car>가 정확히 만들어지는지 확인")
	@Test
	void makeTest() {

		//given
		String inputCars = "wade, curry, james, paul";

		//when
		CarsService carsServiceTest = new CarsService();
		List<Car> actualCars = carsServiceTest.make(inputCars);

		//then
		final String[] EXPECTED_CARS_NAME = {"wade", "curry", "james", "paul"};

		assertThat(actualCars)
			.extracting("NAME")
			.containsExactly(EXPECTED_CARS_NAME);
	}

	@DisplayName("구분자(,)를 이용하지 않고 자동차 명단을 넣었을 때 오류 발생")
	@Test
	void makeCarsWithoutSeparator() {

		//given
		final String EXPECTED_MESSAGE = "자동차 이름을 구분자(,)를 이용해 나눠주세요.";

		//when, then
		assertThatThrownBy(() -> carsService.make("wade + curry"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(EXPECTED_MESSAGE);

	}

	@DisplayName("입력한 값에 맞게 각각의 자동차들이 움직이거나 정지하는지 확인")
	@Test
	void moveOrStopTest() {

		//given
		randoms = asList(
			asList(9, 9, 9, 9, 0),
			asList(9, 9, 9, 0, 0),
			asList(9, 9, 0, 0, 0),
			asList(9, 0, 0, 0, 0)
		);

		//when
		for (List<Integer> inputRandoms : randoms) {
			carsService.moveOrStop(inputRandoms);
		}

		List<Integer> actualCarsDistance = new ArrayList<>();

		for (Car car : testCars) {
			actualCarsDistance.add(car.getDistance());
		}

		//then
		final List<Integer> EXPECTED_CARS_DISTANCE = asList(4, 3, 2, 1, 0);

		assertEquals(EXPECTED_CARS_DISTANCE, actualCarsDistance);

	}

	@DisplayName("단독 우승자 찾기")
	@Test
	void findSingleWinnerTest() {

		//given
		randoms = asList(
			asList(9, 9, 9, 9, 0),
			asList(9, 9, 9, 0, 0),
			asList(9, 9, 0, 0, 0),
			asList(9, 0, 0, 0, 0)
		);

		for (List<Integer> inputRandoms : randoms) {
			carsService.moveOrStop(inputRandoms);
		}

		//when
		String actualWinner = carsService.findWinner();

		//then
		final String EXPECTED_WINNER = "Faker";
		assertEquals(EXPECTED_WINNER, actualWinner);
	}

	@DisplayName("공동 우승자 찾기")
	@Test
	void findMultipleWinnerTest() {

		//given
		randoms = asList(
			asList(9, 9, 9, 9, 0),
			asList(9, 9, 9, 0, 0),
			asList(9, 9, 9, 0, 0),
			asList(9, 9, 9, 0, 0)
		);

		for (List<Integer> inputRandoms : randoms) {
			carsService.moveOrStop(inputRandoms);
		}

		//when
		String actualWinner = carsService.findWinner();

		//then
		final String EXPECTED_WINNER = "Faker, Chovy, Show";
		assertEquals(EXPECTED_WINNER, actualWinner);
	}

	@DisplayName("Cars 초기화")
	@Test
	void clearTest() {
		//given, when
		carsService.clear();

		boolean actualResult = testCars.isEmpty();

		//then
		assertTrue(actualResult);
	}

}
