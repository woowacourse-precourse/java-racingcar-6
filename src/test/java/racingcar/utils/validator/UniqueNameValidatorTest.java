package racingcar.utils.validator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class UniqueNameValidatorTest {

    @Test
    public void givenUniqueNamesList_whenValidated_thenTrue() {
        assertTrue(UniqueNameValidator.validate(Arrays.asList("name1", "name2")));
    }

    @Test
    public void givenNonUniqueNamesList_whenValidated_thenFalse() {
        assertFalse(UniqueNameValidator.validate(Arrays.asList("name", "name")));
    }
}
