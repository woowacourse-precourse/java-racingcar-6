package racingcar.Validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.io.InputValidator;
import racingcar.exception.DivisionCarNamesException;

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
    @DisplayName("정상적으로 입력한다.")
    void input_correct() {
        assertThatCode(() -> InputValidator.validateDivisionCarNames("pobi,woni,jun"))
                .doesNotThrowAnyException();
    }
}
