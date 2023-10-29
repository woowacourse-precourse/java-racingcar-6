package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
	
	@DisplayName("printCarStatus메소드 출력 형태를 확인한다.")
	@Test
	void checkPrintCarStatusMethodPrintMessage() {
		Car car1 = new Car("car1");
		Car car2 = new Car("car2");
		Car car3 = new Car("car3");
		
		car2.move();
		car2.move();

		car3.move();
		car3.move();
		car3.move();

		Cars cars = new Cars(List.of(car1, car2, car3));

		String carsStatusMessage = cars.printCarsStatus();

		assertThat(carsStatusMessage).contains("car1 : ", "car2 : --", "car3 : ---");
	}
}
