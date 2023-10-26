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

    
}
