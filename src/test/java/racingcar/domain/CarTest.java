package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	@DisplayName("printCarStatus메소드 출력 형태를 확인한다.")
	@Test
	void checkPrintCarStatusMethodPrintMessage() {
		Car car = new Car("pobi");
		String carStatusMessage = "";
		
		car.move();
		car.move();
		
		carStatusMessage = car.printCarStatus();
		
		assertThat(carStatusMessage).isEqualTo("pobi : --");
	}
}
