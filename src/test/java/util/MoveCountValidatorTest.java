package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.MoveCountValidator.Message;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MoveCountValidatorTest {

    @Nested
    @DisplayName("비정상 입력값이 들어온 케이스")
    class invalidInputTest {

        @ParameterizedTest
        @ValueSource(strings = {"한글", "moonja", "-1000", "-2322190000"})
        @DisplayName("자연수가 아닌 입력의 경우 예외 처리한다.")
        void 자연수가_아닌_입력(String input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> MoveCountValidator.validate(input))
                    .withMessageStartingWith(Message.EXCEPTION_NUMERIC.getMessage());
        }


        @ParameterizedTest
        @ValueSource(strings = {"2222222222222222222222222222000", "1294013905724312349120948120000"})
        @DisplayName("int 범위를 초과한 입력의 경우 예외 처리한다.")
        void int_범위를_벗어난_입력(String input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> MoveCountValidator.validate(input))
                    .withMessageStartingWith(Message.EXCEPTION_INT_RANGE.getMessage());
        }

        @Test
        @DisplayName("0을 입력하는 경우 예외 처리한다.")
        void 빵을_입력() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> MoveCountValidator.validate("0"))
                    .withMessageStartingWith(Message.EXCEPTION_NUMBER_RANGE.getMessage());
        }

    }

    @Nested
    @DisplayName("정상 입력값이 들어온 케이스")
    class validInputTest {
        @ParameterizedTest
        @ValueSource(strings = {"222000", "22222000", "1000"})
        @DisplayName("올바른 입력값이 들어왔을 때 잘 작동하는지 검사한다.")
        void 정상_입력(String input) {
            assertThatCode(() -> MoveCountValidator.validate(input))
                    .doesNotThrowAnyException();
        }

    }

}