package racingcar.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryTimesValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "5", "10"})
    @DisplayName("통과 - 올바른 시도 횟수 입력")
    void right_TryTimes(String tryTimes) {
        TryTimesValidator.validateNumber(tryTimes);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "g3", ""})
    @DisplayName("실패 - 음수, 공백, 숫자외의 값 입력")
    void input_Others_For_TryTimes(String tryTimes) {
        Assertions.assertThatThrownBy(() -> TryTimesValidator.validateNumber(tryTimes))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1이상의 숫자만 입력해주세요.\n");
    }
}