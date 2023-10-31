package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
	
	@DisplayName("printCarsStatus메소드 출력 형태를 확인한다.")
	@Test
	void checkPrintCarsStatusMethodPrintMessage() {
		Car car1 = new Car("one");
		Car car2 = new Car("two");
		Car car3 = new Car("three");
		
		car2.move();
		car2.move();

		car3.move();
		car3.move();
		car3.move();

		Cars cars = new Cars(List.of(car1, car2, car3));

		String carsStatusMessage = cars.printCarsStatus();

		assertThat(carsStatusMessage).contains("one : ", "two : --", "three : ---");
	}
}
