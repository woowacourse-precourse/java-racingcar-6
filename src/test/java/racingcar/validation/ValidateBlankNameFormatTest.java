package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidBlankNameException;

class ValidateBlankNameFormatTest {

    ValidateBlankNameFormat validateBlankNameFormat;

    @Test
    void validate_이름이_공백일때_예외처리() {
        String input = "abcd,   ,efghi";

        assertThatThrownBy(() -> validateBlankNameFormat.validate(input))
                .isInstanceOf(InvalidBlankNameException.class)
                .hasMessageContaining("[에러] 입력된 이름이 비어있습니다.");
    }
}