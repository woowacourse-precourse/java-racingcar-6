package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TrialCountValidatorTest {

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"1", "2147483647"})
    @DisplayName("시도할 회수 검증 통과")
    void givenTrialCount_whenValidate_thenNoException(String trialCount) {
        assertThatNoException()
                .isThrownBy(() -> TrialCountValidator.validate(trialCount));
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"0", "-1"})
    @DisplayName("시도할 회수 검증 실패: 양수가 아니다")
    void givenTrialCount_whenValidatePositiveNumber_thenThrowException(String trialCount) {
        assertThatThrownBy(() -> TrialCountValidator.validate(trialCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수가 아닙니다.");
    }

    @Test
    @DisplayName("시도할 회수 검증 실패: int 범위가 아니다")
    void givenTrialCount_whenValidateRange_thenThrowException() {
        String trialCount = "2147483648";

        assertThatThrownBy(() -> TrialCountValidator.validate(trialCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("int 범위 숫자가 아닙니다.");
    }

}
