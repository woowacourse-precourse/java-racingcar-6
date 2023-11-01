package racingcar.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.controller.Validator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidatorTest {
    @Test
    public void testValidateInputCarListValid() {
        List<String> validList = new ArrayList<>();
        validList.add("Car1");
        validList.add("Car2");
        Validator.validateInputCarList(validList);
    }

    @Test
    public void testValidateInputCarListInvalid() {
        List<String> invalidList = new ArrayList<>();
        invalidList.add("Car1");
        invalidList.add("Car2WithALongName");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateInputCarList(invalidList);
        });

    }

    @Test
    public void testValidateInputAttemptNumValid() {
        String validInput = "5";
        int result = Validator.validateInputAttemptNum(validInput);
        assertEquals(5, result);
    }

    @Test
    public void testValidateInputAttemptNumInvalid() {
        String invalidInput = "invalid";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateInputAttemptNum(invalidInput);
        });
    }
}
