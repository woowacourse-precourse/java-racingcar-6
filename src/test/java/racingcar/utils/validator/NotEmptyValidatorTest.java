package racingcar.utils.validator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class NotEmptyValidatorTest {

    @Test
    public void givenNonEmptyList_whenValidated_thenTrue() {
        assertTrue(NotEmptyValidator.validate(Arrays.asList("test", "input")));
    }

    @Test
    public void givenListWithEmptyString_whenValidated_thenFalse() {
        assertFalse(NotEmptyValidator.validate(Arrays.asList("test", "")));
    }

    @Test
    public void givenEmptyList_whenValidated_thenTrue() {
        assertTrue(NotEmptyValidator.validate(Collections.emptyList()));
    }
}
