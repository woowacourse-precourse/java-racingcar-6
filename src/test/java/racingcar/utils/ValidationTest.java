package racingcar.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ValidationTest {

    private Validation validation;

    @BeforeEach
    void setUp() {
        validation = new Validation();
    }

    @Test
    void isNumeric_ValidNumericString_ShouldNotThrowException() {
        assertDoesNotThrow(() -> validation.isNumeric("123"));
    }

    @Test
    void isNumeric_NonNumericString_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> validation.isNumeric("12a3"));
    }

    @Test
    void checkNameListSize_ValidSize_ShouldNotThrowException() {
        List<String> validNames = List.of("car1", "car2");
        assertDoesNotThrow(() -> validation.checkNameListSize(validNames));
    }

    @Test
    void checkNameListSize_InvalidSize_ShouldThrowException() {
        List<String> invalidNames = List.of("car1");
        assertThrows(IllegalArgumentException.class, () -> validation.checkNameListSize(invalidNames));
    }

    @Test
    void checkName_ValidName_ShouldNotThrowException() {
        assertDoesNotThrow(() -> validation.checkName("car1"));
    }

    @Test
    void checkName_InvalidName_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> validation.checkName("verylongname"));
    }

    @Test
    void checkPlayCount_ValidCount_ShouldNotThrowException() {
        assertDoesNotThrow(() -> validation.checkPlayCount(3));
    }

    @Test
    void checkPlayCount_InvalidCount_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> validation.checkPlayCount(-1));
    }

    @Test
    void hasDuplication_UniqueNames_ShouldNotThrowException() {
        List<String> uniqueNames = List.of("car1", "car2");
        assertDoesNotThrow(() -> validation.hasDuplication(uniqueNames));
    }

    @Test
    void hasDuplication_DuplicatedNames_ShouldThrowException() {
        List<String> duplicatedNames = List.of("car1", "car1");
        assertThrows(IllegalArgumentException.class, () -> validation.hasDuplication(duplicatedNames));
    }
}
