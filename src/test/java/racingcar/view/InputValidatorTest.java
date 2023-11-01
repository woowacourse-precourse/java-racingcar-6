package racingcar.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("InputValidator의")
public class InputValidatorTest {

    private final InputValidator validator = new InputValidator();

    @Nested
    @DisplayName("차이름 입력시")
    class ValidateDelimiter {

        @Test
        @DisplayName("여러대의 차가 입력시 예외를 던지지 않는가")
        void validate_many_cars() {
            //given
            String input = "pobi,woni";
            //when
            //then
            assertThatCode(() -> validator.validateDelimiter(input))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("한대의 차만 입력시 예외를 던지는가")
        void validate_one_car() {
            //given
            String input = "pobi";

            //when
            //then
            assertThatThrownBy(() -> validator.validateDelimiter(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("숫자 입력시")
    class ValidateNumber {

        @Test
        @DisplayName("숫자 입력시 예외를 던지지 않는가")
        void validate_is_number() {
            //given
            String input = "3";

            //when
            //then
            assertThatCode(() -> validator.validateNumber(input))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("숫자가 아닌 것을 입력시 예외를 던지는가")
        void validate_is_not_number() {
            //given
            String input = "윤호";

            //when
            //then
            assertThatThrownBy(() -> validator.validateNumber(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
