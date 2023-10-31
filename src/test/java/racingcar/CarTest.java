package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

class CarTest {
	private Car car;

	@BeforeEach
	void setUp() {
		car = new Car();
	}

	@Test
	@DisplayName("랜덤 숫자가 3이하이면 전진하지 않는다.")
	void test1() {
		List<StringBuilder> steps = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			StringBuilder sb = new StringBuilder();
			steps.add(sb);
		}

		assertRandomNumberInRangeTest(
				() -> {
					car.moveForward(steps);
					for (int i = 0; i < steps.size(); i++) {
						if (steps.get(i).length() != 0) {
							throw new IllegalArgumentException();
						}
					}
				},
				0, 1, 2, 3
		);

	}

	@Test
	@DisplayName("랜덤 숫자가 4이상이면 전진한다.")
	void test2() {
		List<StringBuilder> steps = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			StringBuilder sb = new StringBuilder();
			steps.add(sb);
		}

		assertRandomNumberInRangeTest(
				() -> {
					car.moveForward(steps);
					for (int i = 0; i < steps.size(); i++) {
						if (steps.get(i).length() == 0) {
							throw new IllegalArgumentException();
						}
					}
				},
				4, 5, 6, 7, 8, 9
		);
	}
}