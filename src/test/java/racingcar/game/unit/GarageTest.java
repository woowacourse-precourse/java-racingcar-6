package racingcar.game.unit;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GarageTest extends NsTest {

	private static Stream<Arguments> parameters() {
		return Stream.of(
				Arguments.arguments("name1,name2", 2, Arrays.asList("name1", "name2")),
				Arguments.arguments("name1,name2,name3", 3, Arrays.asList("name1", "name2", "name3")),
				Arguments.arguments("name1,name2,name3,name4", 4, Arrays.asList("name1", "name2", "name3", "name4"))
		);
	}

	@ParameterizedTest
	@MethodSource("parameters")
	@DisplayName("차 출고 시 입력으로 생성된 차량 개수 및 이름 확인")
	void 차_출고(String carNameList, int expectedCarSize, List<String> expectedCarName) {
		assertSimpleTest(() -> {
			// given
			Garage garage = Garage.newGarage();
			// when
			run(carNameList);
			List<Car> cars = garage.publishCars();
			// then
			assertThat(output())
					.contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			assertThat(cars)
					.hasSize(expectedCarSize);
			for (int i = 0; i < cars.size(); i++) {
				assertThat(cars.get(i).getName())
						.isEqualTo(expectedCarName.get(i));
			}
		});
	}

	@Override
	protected void runMain() {
	}
}