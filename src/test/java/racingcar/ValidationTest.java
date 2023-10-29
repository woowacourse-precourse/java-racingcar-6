package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.utils.Validation;

public class ValidationTest {
    @Test
    void testIsBlankWithNull() {
        assertThrows(IllegalArgumentException.class, () -> Validation.isBlank(null));
    }

    @Test
    void testIsBlankWithEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> Validation.isBlank(""));
    }

    @Test
    void testIsBlankWithBlankString() {
        assertThrows(IllegalArgumentException.class, () -> Validation.isBlank("   "));
    }

    @Test
    void testIsBlankWithNonBlankString() {
        Validation.isBlank("Car");
    }

    @Test
    void testIsLengthErrorWithinLimit() {
        Validation.isLengthError("Car");
    }

    @Test
    void testIsLengthErrorExceedsLimit() {
        assertThrows(IllegalArgumentException.class, () -> Validation.isLengthError("Car123"));
    }

    @Test
    void testIsDuplicatedWithDuplicate() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Car1"));
        assertThrows(IllegalArgumentException.class, () -> Validation.isDuplicated("Car1", carList));
    }

    @Test
    void testIsDuplicatedWithoutDuplicate() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Car1"));
        Validation.isDuplicated("Car2", carList);
    }

    @Test
    void testIsNumberWithValidInput() {
        int result = Validation.isNumber("5");
        assertEquals(5, result);
    }

    @Test
    void testIsNumberWithInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> Validation.isNumber("invalid"));
    }
}
