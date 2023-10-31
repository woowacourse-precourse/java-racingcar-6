package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.util.RacingCarUtilForTest;

public class WinnerTest {
	@Test
	void 우승자가_1명일때_우승자를_구한다() {
		List<Car> carList = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
		carList = RacingCarUtilForTest.getRacingCar(carList, List.of(3, 3, 5));
		Winner winner = new Winner(carList);

		assertThat(winner.getWinner()).hasSize(1)
			.extracting("name")
			.containsOnly("jun");
	}

	@Test
	void 우승자가_2명일때_우승자를_구한다() {
		List<Car> carList = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
		carList = RacingCarUtilForTest.getRacingCar(carList, List.of(3, 5, 5));
		Winner winner = new Winner(carList);

		assertThat(winner.getWinner()).hasSize(2)
			.extracting("name")
			.contains("jun", "woni");
	}
}
