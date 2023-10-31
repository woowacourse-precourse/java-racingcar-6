package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.MoveCountValidator.Message;

public class MoveCountValidatorTest {
    @Nested
    @DisplayName("비정상 입력값")
    class 비정상_입력값_검사 {
        @ParameterizedTest
        @ValueSource(strings = {"한글", "english", "-1000", "-2322190000"})
        @DisplayName("입력값이 자연수가 아닐 경우 예외처리")
        void 자연수_검사(String input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> MoveCountValidator.validate(input))
                    .withMessageStartingWith(Message.EXCEPTION_NUMERIC.getMessage());
        }

        @Test
        @DisplayName("입력값이 0일 경우 예외처리")
        void 입력값_0_검사() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> MoveCountValidator.validate("0"))
                    .withMessageStartingWith(Message.EXCEPTION_NUMBER_RANGE.getMessage());
        }

    }
    @Nested
    @DisplayName("정상 입력값")
    class 정상_입력값_검사 {
        @ParameterizedTest
        @ValueSource(strings = {"222000", "22222000", "1000"})
        @DisplayName("올바른 입력값이 들어왔을 때 잘 작동하는지 검사한다.")
        void 정상_입력(String input) {
            assertThatCode(() -> MoveCountValidator.validate(input))
                    .doesNotThrowAnyException();
        }
    }
}
