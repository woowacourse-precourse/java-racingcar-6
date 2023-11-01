package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ForwardConditionTest {

    @DisplayName("MOVABLE_OFFSET 이상의 값이 주어지면 참을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9, 10})
    void isMovableNumber(int value) {
        // given & when
        boolean isMovable = ForwardCondition.isMovableNumber(value);

        // then
        assertThat(isMovable).isTrue();
    }
}