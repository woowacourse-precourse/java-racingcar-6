package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.util.RacingCarUtilsForTest;

public class WinnerTest {
	@Test
	void 우승자가_1명일때_우승자를_구한다() {
		List<Car> carList = List.of(
			new Car("pobi"), new Car("woni"), new Car("jun")
		);
		carList = RacingCarUtilsForTest.getRacingCar(carList, List.of(3, 3, 5));
		Winner winner = new Winner();
		List<String> winnerList = winner.get(carList);

		assertThat(winnerList).hasSize(1)
			.containsOnly("jun");
	}

	@Test
	void 우승자가_2명일때_우승자를_구한다() {
		List<Car> carList = List.of(
			new Car("pobi"), new Car("woni"), new Car("jun")
		);
		carList = RacingCarUtilsForTest.getRacingCar(carList, List.of(3, 5, 5));
		Winner winner = new Winner();
		List<String> winnerList = winner.get(carList);

		assertThat(winnerList).hasSize(2)
			.contains("jun", "woni");
	}
}
