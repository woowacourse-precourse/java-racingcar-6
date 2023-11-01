package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;
import racingcar.model.InputData;

class ValidatorExceptionTest {
    @BeforeEach
    public void setUp() {
        new Car(Collections.singletonList(""));
    }

    @Test
    public void testValidateCarNamesValid() {
        Car car = new Car(Collections.singletonList("pobi"));
        assertDoesNotThrow(() -> ValidatorException.validateCarNames(car));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "pobi.woni!", "pobiwoni"})
    public void testValidateCarNamesInvalid(String invalidName) {
        Car car = new Car(List.of(invalidName));
        assertThrows(IllegalArgumentException.class, () -> ValidatorException.validateCarNames(car));
    }

    @Test
    public void testValidateInputAttemptsCountValid() {
        InputData inputData = new InputData("1");
        assertDoesNotThrow(() -> ValidatorException.validateInputAttemptsCount(inputData));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "one"})
    public void testValidateInputAttemptsCountInvalid(String invalidNumber) {
        InputData inputData = new InputData(invalidNumber);
        assertThrows(IllegalArgumentException.class, () -> ValidatorException.validateInputAttemptsCount(inputData));
    }
}