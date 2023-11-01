package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

	private Car car;

	@BeforeEach
	void init() {
		car = Car.createCar("sangilji");
	}

	@Test
	void checkEqualName() {
		assertThat(car.getName()).isEqualTo("sangilji");
	}

	@Test
	void move() {
		List<Integer> progressList = new ArrayList<>();
		int stopCondition = 0;
		int stopCondition2 = 3;
		int moveCondition = 4;
		int moveCondition2 = 10;
		progressList.add(car.getProgress());

		car.move(stopCondition);
		progressList.add(car.getProgress());

		car.move(moveCondition);
		progressList.add(car.getProgress());

		car.move(stopCondition2);
		progressList.add(car.getProgress());

		car.move(moveCondition2);
		progressList.add(car.getProgress());
		assertThat(progressList).containsExactly(0, 0, 1, 1, 2);
	}


	@Test
	void checkEqualProgress() {
		car.updateProgress(5);
		assertThat(car.getProgress()).isEqualTo(5);
	}
}