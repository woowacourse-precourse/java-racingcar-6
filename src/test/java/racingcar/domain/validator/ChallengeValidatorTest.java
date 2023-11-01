package racingcar.domain.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.util.validator.ChallengeValidator;

class ChallengeValidatorTest {
    @Test
    public void 정상적인_입력() {
        String number = "3";

        ChallengeValidator.validate(number);
    }

    @Nested
    class 예외_발생 {
        @Test
        public void 문자로_시작() {
            String input = "d12";

            exception_generator(input);
        }

        @Test
        public void 숫자로_시작하는데_중간에_문자가_있는_경우() {
            String input = "1a3";

            exception_generator(input);
        }

        @Test
        public void Integer_범위를_벗어나는_경우() {
            String input = "123456789123456789123456789123456789";

            exception_generator(input);
        }

        private static void exception_generator(String input1) {
            assertThatThrownBy(() -> ChallengeValidator.validate(input1))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("Invalid number of attempts input");
        }
    }
}