package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.error.Error.INVALID_CARNAME_LENGTH;

import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.util.RacingCarUtilForTest;

public class CarTest {
	@Test
	void 자동차이름리스트로_자동차객체를_생성한다() {
		List<Car> carList = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));

		assertThat(carList).hasSize(3)
			.extracting("name", "position")
			.containsExactlyInAnyOrder(
				tuple("pobi",0),
				tuple("woni",0),
				tuple("jun",0)
			);
	}

	@Test
	void 자동차이름이_주어진조건보다_길때_예외를_던진다() {
		assertThatThrownBy(() -> new Car("woninini"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(INVALID_CARNAME_LENGTH.getMessage());
	}

	@Test
	void 랜덤값생성후_전진조건에_해당하면_전진한다() {
		List<Car> carList = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
		carList = RacingCarUtilForTest.getRacingCar(carList, List.of(3, 4, 5));

		assertThat(carList).hasSize(3)
			.extracting("name", "position")
			.containsExactlyInAnyOrder(
				tuple("pobi",0),
				tuple("woni",1),
				tuple("jun",1)
			);
	}

}
