package racingcar.validation;

import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidDuplicatedNamesException;
import racingcar.exception.InvalidNumberFormatException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidateDuplicatedNameTest {

    ValidateDuplicatedName validateDuplicatedName;
    @Test
    void validate_이름이_중복될때_예외처리() {
        String input = "중복이름,중복이름";

        assertThatThrownBy(() -> validateDuplicatedName.validate(input))
                .isInstanceOf(InvalidDuplicatedNamesException.class)
                .hasMessageContaining("[에러] 중복된 이름이 있습니다.");
    }

}