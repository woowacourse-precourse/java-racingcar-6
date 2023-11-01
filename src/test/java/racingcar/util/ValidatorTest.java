package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ValidatorTest {

    String delimiter = Validator.DELIMITER;
    int carNameLengthLimit = Validator.CAR_NAME_LENGTH_LIMIT;


    @Nested
    @DisplayName("자동차 이름 입력 시")
    class ValidateCarNames {


        @Test
        @DisplayName("지정된 limit 길이 이하의 이름으로 입력시 성공")
        void success() {
            String input = generateCarNamesByLength(carNameLengthLimit);

            assertDoesNotThrow(() -> Validator.validateCarNames(input));
        }

        @Test
        @DisplayName("지정된 limit 길이를 초과하는 이름이 포함되어 있는 경우 실패")
        void errorByLengthOfCarName() {
            String input = generateCarNamesByLength(carNameLengthLimit + 1);

            assertThatThrownBy(() -> Validator.validateCarNames(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Validator.CAR_NAME_LENGTH_ERROR_MESSAGE);
        }

        private String generateCarNamesByLength(int maxLengthOfName) {
            List<String> nameList = new ArrayList<>();
            for (int i = 0; i <= maxLengthOfName; i++) {
                nameList.add("a".repeat(i));
            }
            return String.join(delimiter, nameList);
        }

    }

    @Nested
    @DisplayName("시도 회수 입력 시")
    class ValidateNumberOfAttempts {

        @ParameterizedTest
        @DisplayName("음수가 아닌 수를 입력하면 성공")
        @ValueSource(strings = {"0", "1", "100"})
        void success(String userInput) {
            assertDoesNotThrow(() -> Validator.validateNumberOfAttempts(userInput));
        }

        @ParameterizedTest
        @DisplayName("음수 혹은 숫자로 변환할 수 없는 값을 입력하는 경우 실패")
        @ValueSource(strings = {"-1", "abc", "1a"})
        void errorByWrongUserInput(String userInput) {
            assertThatThrownBy(() -> Validator.validateNumberOfAttempts(userInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Validator.NUMBER_OF_ATTEMPTS_ERROR_MESSAGE);
        }

    }


}