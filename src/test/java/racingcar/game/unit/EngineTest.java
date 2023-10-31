package racingcar.game.unit;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EngineTest {

	@Test
	@DisplayName("엔진 동력만큼 숫자를 반환하는지")
	void 엔진시동() {
		assertRandomNumberInRangeTest(() -> {
					// given
					Engine engine = Engine.newEngine();
					// when
					int power = engine.activate();
					// then
					assertThat(power)
							.isEqualTo(1);
				},
				1
		);
	}
}