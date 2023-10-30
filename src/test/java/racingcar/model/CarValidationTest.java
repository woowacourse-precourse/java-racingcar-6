package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class CarValidationTest {
    private CarValidation carValidation = new CarValidation();

    @Test
    void validateAll_correct() {
        // given
        String[] validCarNames = {"Car1", "Car2", "Car3"};

        // when
        ArrayList<String> carNames = carValidation.carValidateAll(validCarNames);

        // then
        assertThat(carNames).containsExactly("Car1", "Car2", "Car3");
    }

    @Test
    void validateAll_too_longCarNames() {
        // given
        String[] tooLongCarNames = {"Car123454", "Car5", "Car1"};

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            carValidation.carValidateAll(tooLongCarNames);
        });
    }

    @Test
    void validateAll_invalidCarNames() {
        // given
        String[] invalidCarNames = {"Car@4", "Car5$", "Car1"};

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            carValidation.carValidateAll(invalidCarNames);
        });
    }

    @Test
    void testValidateDuplication() {
        // given
        String[] duplicateCarNames = {"Car2", "Car2", "Car1"};

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            carValidation.carValidateAll(duplicateCarNames);
        });
    }

}