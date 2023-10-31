package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.RandomNumberValidator.Message;

public class RandomNumberValidatorTest {
    @Nested
    @DisplayName("비정상 입력값")
    class 비정상_입력값_검사 {
        @ParameterizedTest
        @ValueSource(ints = {-2, -1, 10, 11})
        @DisplayName("입력값이 0 미만 9 초과의 수인 경우 예외처리")
        void 범위_0미만_9초과_검사(int input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> RandomNumberValidator.validate(input))
                    .withMessageStartingWith(Message.EXCEPTION_NUMBER_RANGE.getMessage());
        }
    }

    @Nested
    @DisplayName("정상 입력값")
    class 정상_입력값_검사 {
        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
        @DisplayName("입력값이 정상일 경우")
        void 정상_입력(int input) {
            assertThatCode(() -> RandomNumberValidator.validate(input))
                    .doesNotThrowAnyException();
        }
    }
}
