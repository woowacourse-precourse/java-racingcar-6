package racingcar.domain.game.round;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Cars;
import racingcar.domain.car.Position;
import racingcar.support.round.RoundResult;

class RoundResultTest {

	@Test
	@DisplayName("자동차의 이름과 position을 매핑한다")
	void generate() {
		// given
		Map<CarName, Position> results = new LinkedHashMap<>();

		Car car1 = new Car(new Position(1), new CarName("name1"));
		Car car2 = new Car(new Position(2), new CarName("name2"));
		Cars cars = new Cars(List.of(car1, car2));

		// when
		RoundResult roundResult = RoundResult.generate(cars);

		// then
		assertAll(
				()->assertEquals(roundResult.getResults().size() , cars.getCars().size()),
				()->assertEquals(roundResult.getResults().get(car1.getCarName()), new Position(1)),
				()->assertEquals(roundResult.getResults().get(car2.getCarName()), new Position(2))
		);
	}
}