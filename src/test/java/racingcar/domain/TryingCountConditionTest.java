package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryingCountConditionTest {

    @DisplayName("이동 횟수가 1미만, 10초과라면 참을 반환합니다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 11})
    void validateCount_exception_withInvalidRange(int invalidInputCount) {
        // given & when
        boolean isNotInRange = TryingCountCondition.isNotInRange(invalidInputCount);

        // then
        assertThat(isNotInRange).isTrue();
    }
}