package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class CreateCarsServiceTest {

	@DisplayName(", 구분으로 자동차의 이름들을 가진 Cars객체인지 확인한다.")
	@ValueSource(strings = { "car1,car2,car3"})
	@ParameterizedTest
	void checkCreateCars(String str) {
		CreateCarsService service = new CreateCarsService();
		Cars cars = service.createCars(str);
		
		for(Car car : cars.getCars()) {
			if(!str.contains(car.getCarName())) {
				throw new IllegalArgumentException();
			}
		}		
	}
}
