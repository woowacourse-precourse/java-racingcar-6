package racingcar.domain.condition;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoveConditionTest {

    @ParameterizedTest
    @DisplayName("값이 4 이상인 경우 true를 반환한다.")
    @ValueSource(ints = {4, 5, 9})
    void checkNumberIfNumberIsOverFour(int given) {
        // given
        MoveCondition moveCondition = new MoveCondition();

        // when
        boolean result = moveCondition.check(given);

        // then
        assertThat(result).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("값이 4 미만인 경우 false를 반환한다.")
    @ValueSource(ints = {0, 2, 3})
    void checkNumberIfNumberLessThanFour(int given) {
        // given
        MoveCondition moveCondition = new MoveCondition();

        // when
        boolean result = moveCondition.check(given);

        // then
        assertThat(result).isEqualTo(false);
    }
}
