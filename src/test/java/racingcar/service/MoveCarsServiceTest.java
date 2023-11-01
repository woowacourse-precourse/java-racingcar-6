package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.Car;

public class MoveCarsServiceTest {
	
	@DisplayName("값이 4이상일떄 자동차가 이동한다.")
	@ValueSource(ints = { 4, 5, 6, 7, 8, 9 })
	@ParameterizedTest
	void checkMoveCar(int number) {
		MoveCarsService service = new MoveCarsService();
		Car car = new Car("pobi");
		
		service.moveCar(car, number);
		
		assertThat(car.getCarLocation()).isEqualTo(1);
	}
	
	@DisplayName("값이 4미만일떄 자동차는 이동하지 않는다.")
	@ValueSource(ints = { 1, 2, 3 })
	@ParameterizedTest
	void checkNotMoveCar(int number) {
		MoveCarsService service = new MoveCarsService();
		Car car = new Car("pobi");
		
		service.moveCar(car, number);
		
		assertThat(car.getCarLocation()).isEqualTo(0);
	}
}
