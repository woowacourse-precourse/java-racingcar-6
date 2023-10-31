package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UmpireTest {
	private Umpire umpire;

	@BeforeEach
	void setUp() {
		umpire = new Umpire();
	}

	@Test
	@DisplayName("승자 1명의 경우")
	void test1() {
		String[] cars = {"car1", "car2", "car3"};
		List<StringBuilder> steps = new ArrayList<>();

		steps.add(new StringBuilder("-"));
		steps.add(new StringBuilder("--"));
		steps.add(new StringBuilder("---"));

		String result = umpire.decideTheWinners(cars, steps);
		assertEquals("car3", result);
	}

	@Test
	@DisplayName("승자 여러 명의 경우 - 2명")
	void test2() {
		String[] cars = {"car1", "car2", "car3"};
		List<StringBuilder> steps = new ArrayList<>();

		steps.add(new StringBuilder("-"));
		steps.add(new StringBuilder("---"));
		steps.add(new StringBuilder("---"));

		String result = umpire.decideTheWinners(cars, steps);
		assertEquals("car2, car3", result);

	}

	@Test
	@DisplayName("승자 여러 명의 경우 - 3명")
	void test3() {
		String[] cars = {"car1", "car2", "car3"};
		List<StringBuilder> steps = new ArrayList<>();

		steps.add(new StringBuilder("---"));
		steps.add(new StringBuilder("---"));
		steps.add(new StringBuilder("---"));

		String result = umpire.decideTheWinners(cars, steps);
		assertEquals("car1, car2, car3", result);
	}
}