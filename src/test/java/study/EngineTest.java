package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import racingcar.domain.Engine;

public class EngineTest {

	@Test
	void createRandomMethod_메서드_사용시_0에서_9사이의_값만_생성된다() {
		Engine engine = new Engine();
		for(int i=0;i<1000;i++) {
			int randomNumber = engine.createRandomnumber();
			assertThat(randomNumber >= 0 && randomNumber<=9).isEqualTo(true);
		}
	}

	@Test
	void canMoveForward_메서드_사용시_생성되는_수가_4이상인_경우_true를_반환한다() {
		Integer MIN_FORWARD_NUM = 4;

		Engine engine = new Engine();
		for(int i=0;i<1000;i++) {
			int randomNumber = engine.createRandomnumber();
			assertThat(engine.canMoveForward(randomNumber)).isEqualTo(randomNumber >= MIN_FORWARD_NUM);
		}
	}
}
