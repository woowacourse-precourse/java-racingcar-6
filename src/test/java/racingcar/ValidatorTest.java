package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ValidatorTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        validator = new Validator();
    }

    @Test
    public void testIsValidCarNames() {

        validator.isValidCarNames("car1,car2");

        assertThrows(IllegalArgumentException.class, () -> {
            validator.isValidCarNames("car1");
        });
    }

    @Test
    public void testIsValidLength() {

        validator.isValidLength("car1,car2");

        assertThrows(IllegalArgumentException.class, () -> {
            validator.isValidLength("car123456789,car2");
        });
    }

    @Test
    public void testIsValidNumber() {

        validator.isValidNumber("5");

        assertThrows(IllegalArgumentException.class, () -> {
            validator.isValidNumber("0");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            validator.isValidNumber("abc");
        });
    }
}
