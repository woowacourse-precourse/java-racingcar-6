package racingcar.game.unit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.game.message.ErrorMessage;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class CarTest {

	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;

	@Test
	@DisplayName("자동차의 이름이 5글자가 넘을 때 IllegalArgumentException 예외 발생")
	void 자동차_생성_이름글자수초과() {
		assertSimpleTest(() -> {
			// given
			String carName = "testName";
			// when, then
			assertThatThrownBy(() -> Car.of(carName))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessageContaining(ErrorMessage.CAR_NAME_NOT_LONGER_THAN_5.getMessage());
		});
	}

	@Test
	@DisplayName("자동차의 이름이 공백일 때 IllegalArgumentException 예외 발생")
	void 자동차_생성_이름공백() {
		assertSimpleTest(() -> {
			// given
			String carName = "  ";
			// when, then
			assertThatThrownBy(() -> Car.of(carName))
					.isInstanceOf(IllegalArgumentException.class)
					.hasMessageContaining(ErrorMessage.CAR_NAME_NOT_BLANK.getMessage());
		});
	}

	@Test
	@DisplayName("자동차 생성 시 이름과 position이 0인지 확인")
	void 자동차_생성() {
		assertSimpleTest(() -> {
			// given
			String firstCarName = "name1";
			String secondCarName = "name2";
			// when
			Car firstCar = Car.of(firstCarName);
			Car secondCar = Car.of(secondCarName);
			// then
			assertThat(firstCar.getName()).isEqualTo(firstCarName);
			assertThat(firstCar.getPosition()).isEqualTo(0);
			assertThat(secondCar.getName()).isEqualTo(secondCarName);
			assertThat(secondCar.getPosition()).isEqualTo(0);
		});
	}

	@Test
	@DisplayName("엔진 동력이 3이하일 때 정지")
	void 자동차_정지() {
		assertRandomNumberInRangeTest(() -> {
					Car car = Car.of("name");
					car.startEngine();
					assertThat(car.getPosition()).isEqualTo(0);
				},
				STOP
		);
	}

	@Test
	@DisplayName("엔진 동력이 4이상일 때 전진")
	void 자동차_전진() {
		assertRandomNumberInRangeTest(() -> {
					Car car = Car.of("name");
					car.startEngine();
					assertThat(car.getPosition()).isEqualTo(1);
				},
				MOVING_FORWARD
		);
	}
}