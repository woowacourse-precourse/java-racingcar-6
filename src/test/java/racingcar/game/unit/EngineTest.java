package racingcar.game.unit;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class EngineTest {

	@ParameterizedTest
	@CsvSource(value = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}, delimiter = ',')
	@DisplayName("엔진 동력만큼 숫자를 반환하는지 확인")
	void 엔진시동(int expectedPower) {
		assertRandomNumberInRangeTest(() -> {
					// given
					Engine engine = Engine.newEngine();
					// when
					int power = engine.activate();
					// then
					assertThat(power)
							.isEqualTo(expectedPower);
				},
				expectedPower
		);
	}
}