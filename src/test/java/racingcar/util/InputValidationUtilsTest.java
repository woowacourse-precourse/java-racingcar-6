package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidationUtilsTest {

    @DisplayName("입력받은 문자열을 검증 시 공백만 존재하거나 빈 값이면 IllegalArgumentException을 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {" \n\t", "  ", " ", "  ", ""})
    public void validateHasInput_exception_empty(String input) throws Exception {
        // when, then
        assertThatThrownBy(() ->
                InputValidationUtils.validateHasInput(input)
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 값 혹은 공백만 입력되었습니다.");
    }

    @DisplayName("입력받은 문자열을 Integer로 변환 불가 시 IllegalArgumentException을 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"3 1", "3_000_000_000", "-3_000_000_000", "1234\n"})
    public void validateCanBeInt_exception_format(String input) throws Exception {
        // when, then
        assertThatThrownBy(() ->
                InputValidationUtils.validateCannotBeInt(input)
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값을 숫자로 변환할 수 없습니다.");
    }
}
