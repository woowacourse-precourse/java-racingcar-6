package racingcar.validation;

import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidBlankNameException;
import racingcar.exception.InvalidNumberFormatException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidateNumberFormatTest {

    ValidateNumberFormat validateNumberFormat;
    @Test
    void validate_이름이_공백일때_예외처리() {
        String input = "숫자";

        assertThatThrownBy(() -> validateNumberFormat.validate(input))
                .isInstanceOf(InvalidNumberFormatException.class)
                .hasMessageContaining("[에러] 입력된 값이 올바른 숫자가 아닙니다.");
    }

}