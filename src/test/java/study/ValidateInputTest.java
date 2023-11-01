package racingcar;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.assertj.core.api.Assertions.*;

public class ValidateInputTest {

    @Test
    public void shouldThrowExceptionForEmptyCarNames() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> ValidateInput.validateCarNames(Collections.emptyList()))
            .withMessage("Car names cannot be empty");
    }

    @Test
    public void shouldThrowExceptionForInvalidCarNameLength() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> ValidateInput.validateCarNames(Arrays.asList("", "VeryLongCarName", "abc")))
            .withMessage("Each car name should have 1 to 5 characters");
    }

    @Test
    public void shouldThrowExceptionForNonPositiveRaces() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> ValidateInput.validateNumberOfRaces(0))
            .withMessage("Number of races should be a positive integer.");
    }
}
