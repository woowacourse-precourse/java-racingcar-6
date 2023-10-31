package racingcar.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {
    @Test
    void validateCarNames_withValidNames() {
        assertDoesNotThrow(() -> InputValidator.validateCarNames("pobi,woni,jun"));
    }

    @Test
    void validateCarNames_withEmptyInput() {
        assertThatThrownBy(() -> InputValidator.validateCarNames(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름을 입력해주세요.");
    }

    @Test
    void validateCarNames_withNameExceedingMaxLength() {
        assertThatThrownBy(() -> InputValidator.validateCarNames("pobi,longname,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    void validateRaceCount_withValidCount() {
        assertDoesNotThrow(() -> InputValidator.validateRaceCount("5"));
    }

    @Test
    void validateRaceCount_withEmptyInput() {
        assertThatThrownBy(() -> InputValidator.validateRaceCount(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 회수를 입력해주세요.");
    }

    @Test
    void validateRaceCount_withNonNumericInput() {
        assertThatThrownBy(() -> InputValidator.validateRaceCount("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 회수는 숫자여야 합니다.");
    }

    @Test
    void validateRaceCount_withZeroOrNegativeCount() {
        assertThatThrownBy(() -> InputValidator.validateRaceCount("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 회수는 1 이상이어야 합니다.");
    }

}