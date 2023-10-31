package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.util.RacingCarUtilsForTest;

public class CarTest {
	@Test
	void 자동차이름리스트로_자동차객체를_생성한다() {
		List<Car> carList = List.of(
			new Car("pobi"), new Car("woni"), new Car("jun")
		);

		assertThat(carList).hasSize(3)
			.extracting("name", "position")
			.containsExactlyInAnyOrder(
				tuple("pobi",0),
				tuple("woni",0),
				tuple("jun",0)
			);
	}

	@Test
	void 랜덤값생성후_전진조건에_해당하면_전진한다() {
		List<Car> carList = List.of(
			new Car("pobi"), new Car("woni"), new Car("jun")
		);
		carList = RacingCarUtilsForTest.getRacingCar(carList, List.of(3, 4, 5));
		assertThat(carList).hasSize(3)
			.extracting("name", "position")
			.containsExactlyInAnyOrder(
				tuple("pobi",0),
				tuple("woni",1),
				tuple("jun",1)
			);
	}

}
