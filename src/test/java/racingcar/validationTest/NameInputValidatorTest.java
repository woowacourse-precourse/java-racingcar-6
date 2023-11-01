package racingcar.validationTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.validation.NameInputValidator;

public class NameInputValidatorTest {
    private NameInputValidator nameInputValidator;

    @BeforeEach
    void setUp() {
        nameInputValidator = new NameInputValidator();
    }

    @Test
    void testValidateInputWithInvalidNameLength() {
        List<String> nameList = Arrays.asList("John", "Doe", "TooLongNameThatExceedsMaxLength");

        assertThrows(IllegalArgumentException.class, () -> {
            nameInputValidator.validateInput(nameList);
        });
    }

    @Test
    void testValidateInputWithDuplicateNames() {
        List<String> nameList = Arrays.asList("John", "Doe", "John");

        assertThrows(IllegalArgumentException.class, () -> {
            nameInputValidator.validateInput(nameList);
        });
    }

    @Test
    void testValidateInputWithEmptyString() {
        List<String> nameList = Arrays.asList("John", "Doe", "");

        assertThrows(IllegalArgumentException.class, () -> {
            nameInputValidator.validateInput(nameList);
        });
    }
}