package racingcar.validation;

import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidNameLengthException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidateStringLengthTest {

    ValidateStringLength validateStringLength;

    @Test
    void validate_이름이_5자_이상일때_예외처리() {
        String input = "abcde,fghij,klmnop";

        assertThatThrownBy(() -> validateStringLength.validate(input))
                .isInstanceOf(InvalidNameLengthException.class)
                .hasMessageContaining("[에러] 이름의 길이가 5자를 넘습니다.");
    }

}