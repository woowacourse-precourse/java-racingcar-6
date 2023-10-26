package racingcar.UtilTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Util.Validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidatorTest {

    @Test
    @DisplayName("null 혹은 빈문자열 유효성검사 테스트")
    public void nullOrEmptyTest() {
        String nullString = null;
        String emptyString = "";

        IllegalArgumentException nullException = assertThrows(IllegalArgumentException.class,
            () -> Validator.validateNullOrEmpty(nullString));
        IllegalArgumentException emptyStringException = assertThrows(IllegalArgumentException.class,
            () -> Validator.validateNullOrEmpty(emptyString));

        assertThat(nullException.getMessage()).isEqualTo(Validator.NULL_OR_EMPTY_MESSAGE);
        assertThat(emptyStringException.getMessage()).isEqualTo(Validator.NULL_OR_EMPTY_MESSAGE);
    }

    @Test
    @DisplayName("쉼표로 구분된 문자열 유효성검사 테스트")
    public void validateCorrectPatternTest() {
        String validInput = "tico,damas";
        String invalidInput = "tico,";

        IllegalArgumentException invalidPatternException = assertThrows(
            IllegalArgumentException.class, () -> Validator.validateCorrectPattern(invalidInput));
        assertThat(invalidPatternException.getMessage()).isEqualTo(
            Validator.INVALID_PATTERN_MESSAGE);

        assertDoesNotThrow(() -> Validator.validateCorrectPattern(validInput));
    }

    @Test
    @DisplayName("숫자값 유효성검사 테스트")
    public void validateRounds() {
        String validInput = "15";
        String invalidateInput = "십오";

        IllegalArgumentException notNumberException = assertThrows(IllegalArgumentException.class,
            () -> Validator.validateRounds(invalidateInput));
        assertThat(notNumberException.getMessage()).isEqualTo(Validator.NOT_NUMBER_MESSAGE);

        assertDoesNotThrow(() -> Validator.validateRounds(validInput));
    }
}
