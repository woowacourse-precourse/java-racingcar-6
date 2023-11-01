package racingcar.domain.game.round;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarFactory;
import racingcar.domain.car.Cars;
import racingcar.domain.car.Position;
import racingcar.domain.car.strategy.MoveStrategy;

class RoundTest {

	@Test
	@DisplayName("한 라운드를 시작하면 차가 움직인다.")
	void round_play_move_car() {
		// given
		int initialPosition = 0;

		List<String> names = List.of("김수민", "안녕", "하이");
		Cars cars = new Cars(CarFactory.generateCar(names, initialPosition));
		Round round = new Round(cars);
		MoveStrategy moveStrategy = () -> 1;

		// when
		Cars movedCars = round.play(moveStrategy);

		// then
		Position movedPosition = new Position(1);

		for (Car movedCar : movedCars.getCars()) {
			Assertions.assertAll(
					() -> assertEquals(movedPosition, movedCar.getPosition())
			);
		}
	}
}