package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.validator.AttemptCountValidator;
import racingcar.util.validator.CarNameValidator;

class ValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"one 1 1 11,t  wo2222", "어어어어어엄청나아아아게에에에기이이인이이이이르으으음, 나는 평범 해  "})
    void 자동차_이름_길이_테스트(String input) {
        assertThatThrownBy(() -> CarNameValidator.getInstance().validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_CAR_NAME_LENGTH.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"one,", "", "나혼자"})
    void 자동차_이름_개수_테스트(String input) {
        assertThatThrownBy(() -> CarNameValidator.getInstance().validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_CAR_COUNT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "gmspogkewr", "51113209830481235908123123"})
    void 시도할_회수_입력값_형식_테스트(String input) {
        assertThatThrownBy(() -> Util.convertStringToInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_ATTEMPT_COUNT_FORMAT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    void 시도할_회수_입력값_범위_테스트(String input) {
        assertThatThrownBy(() -> AttemptCountValidator.getInstance().validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_ATTEMPT_COUNT_RANGE.getMessage());
    }
}