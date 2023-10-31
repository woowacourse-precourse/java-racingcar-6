package domain;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
	@Test
	public void 최대_이동한_거리를_찾는다() {
		//given
		List<String> namesList = Arrays.asList("pobi", "crong", "an");
		RacingGame racingGame = new RacingGame(namesList);

		List<Car> cars = racingGame.getCars();
		cars.get(0).moveByNumber(4);
		cars.get(0).moveByNumber(4);
		cars.get(1).moveByNumber(3);
		cars.get(2).moveByNumber(3);

		// when
		int maxLocation = racingGame.findLocationWithMostMovement(cars);

		//then
		Assertions.assertThat(maxLocation).isEqualTo(2);
	}

	@Test
	public void 최대_이동한_거리와_위치가_같은_자동차를_찾는다() {
		//given
		List<String> namesList = Arrays.asList("pobi", "crong", "an");
		RacingGame racingGame = new RacingGame(namesList);

		// pobi를 우승자로 설정하여 자동차들을 이동시킵니다.
		List<Car> cars = racingGame.getCars();
		cars.get(0).moveByNumber(4);
		cars.get(1).moveByNumber(3);
		cars.get(2).moveByNumber(3);

		int maxLocation = 1;

		// when
		List<Car> winners = racingGame.findCarWithMaxLocation(cars, maxLocation);

		//then
		Assertions.assertThat(winners.get(0).getName()).isEqualTo("pobi");
	}
}
