package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {

    @Nested
    class invalidInputTest {
        @ParameterizedTest
        @ValueSource(strings = {"", " "})
        public void 빈값이_존재하는지_검증(String input) {
            assertThatThrownBy(() -> Validator.getValidatedCarName(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.EMPTY_VALUE.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"pobii,crongg", "crongg"})
        public void 이름의_길이가_5자_이하인지_검증(String input) {
            assertThatThrownBy(() -> Validator.getValidatedCarName(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_LENGTH.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"pobi,pobi,crong", "crong,crong"})
        public void 중복된_이름이_존재하는지_검증(String input) {
            assertThatThrownBy(() -> Validator.getValidatedCarName(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.DUPLICATED.getMessage());
        }
    }

    @Nested
    class validInputTest {
        @ParameterizedTest
        @ValueSource(strings = {"pobi,crong"})
        public void 정상_입력_검증(String input) {
            assertThatCode(() -> Validator.getValidatedCarName(input))
                    .doesNotThrowAnyException();
        }
    }

}
