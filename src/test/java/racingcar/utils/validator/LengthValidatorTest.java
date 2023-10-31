package racingcar.utils.validator;

import org.junit.jupiter.api.Test;
import racingcar.config.GameConfig;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class LengthValidatorTest {
    private final int maxLength = GameConfig.MAX_CAR_NAME_LENGTH.getValue();

    @Test
    public void givenValidLengthStrings_whenValidated_thenTrue() {
        assertTrue(LengthValidator.validate(Arrays.asList("test1", "test2"), maxLength));
    }

    @Test
    public void givenSomeTooLongStrings_whenValidated_thenFalse() {
        assertFalse(LengthValidator.validate(Arrays.asList("Valid", "TooLongString"), maxLength));
    }

    @Test
    public void givenSingleTooLongString_whenValidated_thenFalse() {
        assertFalse(LengthValidator.validate(Collections.singletonList("TooLongString"), maxLength));
    }

    @Test
    public void givenAllValidLengthStrings_whenValidated_thenTrue() {
        assertTrue(LengthValidator.validate(Arrays.asList("test1", "test2", "test3"), maxLength));
    }
}
