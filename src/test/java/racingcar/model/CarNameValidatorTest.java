package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarNameValidatorTest {
    @Test
    public void testValidateWithValidInput() {
        assertDoesNotThrow(() -> new CarNameValidator("Car1,Car2,Car3"));
    }

    @Test
    public void testValidateWithInvalidNamesString() {
        assertThrows(IllegalArgumentException.class, () -> new CarNameValidator("Car1, C ar 2, Car3"));
    }

    @Test
    public void testValidateWithInvalidNameSize() {
        assertThrows(IllegalArgumentException.class, () -> new CarNameValidator("Car1,Car2,Car3456"));
    }

    @Test
    public void testValidateWithDuplicateNames() {
        assertThrows(IllegalArgumentException.class, () -> new CarNameValidator("Car1,Car2,Car1"));
    }
}