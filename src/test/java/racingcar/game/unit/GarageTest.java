package racingcar.game.unit;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class GarageTest extends NsTest {

	@Test
	void 차_출고() {
		assertSimpleTest(() -> {
			// given
			Garage garage = Garage.newGarage();
			String CarNameListString = "name1,name2,name3";
			// when
			run(CarNameListString);
			List<Car> cars = garage.publishCars();
			// then
			assertThat(output())
					.contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			assertThat(cars)
					.hasSize(3);
			assertThat(cars.get(0).getName())
					.isEqualTo("name1");
			assertThat(cars.get(1).getName())
					.isEqualTo("name2");
			assertThat(cars.get(2).getName())
					.isEqualTo("name3");
		});
	}

	@Override
	protected void runMain() {
	}
}