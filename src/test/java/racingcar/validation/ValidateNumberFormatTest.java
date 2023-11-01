package racingcar.validation;

import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidNumberFormatException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidateNumberFormatTest {

    ValidateNumberFormat validateNumberFormat;
    @Test
    void validate_시도할_횟수가_숫자형식이_아닐경우_예외발생() {
        String input = "숫자";

        assertThatThrownBy(() -> validateNumberFormat.validate(input))
                .isInstanceOf(InvalidNumberFormatException.class)
                .hasMessageContaining("[에러] 입력된 값이 올바른 숫자가 아닙니다.");
    }

}