package racingcar.Validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.car.DivisionCarNamesException;
import racingcar.exception.InputNumericException;
import racingcar.validator.InputValidator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사용자의 입력 중")
class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi/woni/jun", "pobi-woni,jun", "pobi;woni;jun"})
    @DisplayName("자동차들 이름을 쉼표(,)로 구분하지 않는다면 에러가 발생한다.")
    void validate_division_car_names(String names) {
        assertThatThrownBy(() -> InputValidator.validateDivisionCarNames(names))
                .isInstanceOf(DivisionCarNamesException.class);
    }

    @Test
    @DisplayName("자동차 이름들을 정상적으로 입력한다.")
    void input_car_names_correct() {
        assertThatCode(() -> InputValidator.validateDivisionCarNames("pobi,woni,jun"))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"ㅂ5", "pob#i", "ju@n"})
    @DisplayName("시도할 횟수가 숫자가 아니면 에러가 발생한다.")
    void validate_attempt_count_numeric(String attemptCount) {
        assertThatThrownBy(() -> InputValidator.validateNumeric(attemptCount))
                .isInstanceOf(InputNumericException.class);
    }

    @Test
    @DisplayName("시도할 횟수를 정상적으로 입력한다.")
    void input_attempt_count_correct() {
        assertThatCode(() -> InputValidator.validateNumeric("5"))
                .doesNotThrowAnyException();
    }
}
