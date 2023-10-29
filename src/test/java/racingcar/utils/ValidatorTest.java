package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.model.constants.Error.DUPLICATE;
import static racingcar.model.constants.Error.LENGTH_INVALID;
import static racingcar.model.constants.Error.NON_COMMA;
import static racingcar.model.constants.Error.NUMBER_NOT_INTEGER;
import static racingcar.model.constants.Error.NUMBER_RANGE_INVALID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {
    @ParameterizedTest
    @DisplayName("자동차 이름 입력에 콤마가 없을 때, 길이를 초과할 때, 중복이 있을 때 예외 발생을 통합 테스트 합니다.")
    @ValueSource(strings = {"pobi woni jun", "pobi123,woni,jun", "pobi,pobi,woni,jun"})
    void 자동차_이름_입력_통합_예외(String input) {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateCarName(input));
    }

    @ParameterizedTest
    @DisplayName("시도 횟수가 정수가 아닐 때, 시도 횟수가 1보다 작을 때 예외 발생을 통합 테스트 합니다.")
    @ValueSource(strings = {"3.5", "세번", "0", "-1"})
    void 시도_횟수_입력_통합_예외(String input) {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateTrial(input));
    }

    @Test
    @DisplayName("자동차 이름 입력에 콤마가 없을 때 예외 발생을 테스트 합니다.")
    void 자동차_이름_입력_콤마_예외() {
        String input = "pobi woni jun";

        assertThatThrownBy(() -> Validator.validateCarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NON_COMMA.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 길이를 초과할 때 예외 발생을 테스트 합니다.")
    void 자동차_이름_입력_길이_예외() {
        String input = "pobi123,woni,jun";

        assertThatThrownBy(() -> Validator.validateCarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_INVALID.getMessage());
    }

    @Test
    @DisplayName("자동차 이름에 중복이 있을 때 예외 발생을 테스트 합니다.")
    void 자동차_이름_입력_중복_예외() {
        String input = "pobi,pobi,woni,jun";

        assertThatThrownBy(() -> Validator.validateCarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE.getMessage());
    }

    @Test
    @DisplayName("시도 횟수가 정수가 아닐 때 예외 발생을 테스트 합니다.")
    void 시도_횟수_입력_정수_예외() {
        String input = "3.5";

        assertThatThrownBy(() -> Validator.validateTrial(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_NOT_INTEGER.getMessage());
    }

    @Test
    @DisplayName("시도 횟수가 1보다 작을 때 예외 발생을 테스트 합니다.")
    void 시도_횟수_입력_범위_예외() {
        String input = "0";

        assertThatThrownBy(() -> Validator.validateTrial(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_RANGE_INVALID.getMessage());
    }
}
