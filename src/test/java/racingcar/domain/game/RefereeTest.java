package racingcar.domain.game;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Cars;
import racingcar.domain.car.Position;

class RefereeTest {
	@Test
	@DisplayName("가장 멀리간 위치가 한 개일 때 해당 자동차가 우승자가 된다.")
	void pick_winner(){
		// given
		Car lowPositionCar = new Car(new Position(0), new CarName("김수민"));
		Car highPositionCar = new Car(new Position(1), new CarName("하이"));

		Cars cars = new Cars(List.of(lowPositionCar, highPositionCar));

		Referee referee = new Referee(cars);

		// when
		List<CarName> carNames = referee.pickWinners();

		// then
		Assertions.assertEquals(1, carNames.size());
		Assertions.assertEquals(highPositionCar.getCarName(), new CarName("하이"));
	}

	@Test
	@DisplayName("가장 멀리간 위치가 여러 개일때 해당 자동차들이 우승자가 된다.")
	void pick_winners(){
		// given
		Car lowPositionCar = new Car(new Position(0), new CarName("김수민"));
		Car highPositionCar1 = new Car(new Position(1), new CarName("하이1"));
		Car highPositionCar2 = new Car(new Position(1), new CarName("하이2"));

		Cars cars = new Cars(List.of(lowPositionCar, highPositionCar1, highPositionCar2));

		Referee referee = new Referee(cars);

		// when
		List<CarName> carNames = referee.pickWinners();

		// then
		Assertions.assertEquals(2, carNames.size());
		Assertions.assertEquals(highPositionCar1.getCarName(), new CarName("하이1"));
		Assertions.assertEquals(highPositionCar2.getCarName(), new CarName("하이2"));
	}
}