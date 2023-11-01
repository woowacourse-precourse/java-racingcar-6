package racingcar.game;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Dice 클래스 테스트")
class DiceTest {
	@Test
	@DisplayName("올바른 범위의 주사위 숫자가 던져진다.")
	void throwDice() {
		// given

		// when
		var result = Dice.throwDice();

		// then
		assertThat(result).isGreaterThanOrEqualTo(Dice.MIN_LIMIT).isLessThanOrEqualTo(Dice.MAX_LIMIT);
	}
}
