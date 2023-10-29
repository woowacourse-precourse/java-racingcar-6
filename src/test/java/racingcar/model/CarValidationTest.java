package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class CarValidationTest {
    private CarValidation carValidation = new CarValidation();

    @Test
    void validateAll_correct() {
        String[] validCarNames = {"Car1", "Car2", "Car3"};

        ArrayList<String> carNames = carValidation.carValidateAll(validCarNames);

        assertEquals(validCarNames.length, carNames.size());
        assertTrue(carNames.containsAll(Arrays.asList(validCarNames)));
    }

    @Test
    void validateAll_too_longCarNames() {
        String[] tooLongCarNames = {"Car123454", "Car5", "Car1"};

        assertThrows(IllegalArgumentException.class, () -> {
            carValidation.carValidateAll(tooLongCarNames);
        });
    }

    @Test
    void validateAll_invalidCarNames() {
        String[] invalidCarNames = {"Car@4", "Car5$", "Car1"};

        assertThrows(IllegalArgumentException.class, () -> {
            carValidation.carValidateAll(invalidCarNames);
        });
    }

    @Test
    void testValidateDuplication() {
        String[] duplicateCarNames = {"Car2", "Car2", "Car1"};

        assertThrows(IllegalArgumentException.class, () -> {
            carValidation.carValidateAll(duplicateCarNames);
        });
    }

}