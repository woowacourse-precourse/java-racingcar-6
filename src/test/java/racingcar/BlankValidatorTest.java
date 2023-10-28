package racingcar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.BlankValidator;

public class BlankValidatorTest {
    @DisplayName("공백 검증기 - 정상입력")
    @Test
    void checkNotEmpty() {
        String name = "car";
        BlankValidator blankValidator = new BlankValidator();
        assertDoesNotThrow(() -> blankValidator.isEmpty(name));
    }

}
