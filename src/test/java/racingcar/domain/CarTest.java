package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

	@Test
	void getName() {
		Car car = new Car("TestCar");
		assertThat(car.getName()).isEqualTo("TestCar");
	}

	@Test
	void getPosition() {
		Car car = new Car("TestCar");
		assertThat(car.getPosition()).isEqualTo(0);
	}

	@Test
	void moveForward() {
		Car car = new Car("TestCar");
		car.moveForward(4);
		assertThat(car.getPosition()).isEqualTo(1);

		car.moveForward(2);
		assertThat(car.getPosition()).isEqualTo(1);
	}
}
