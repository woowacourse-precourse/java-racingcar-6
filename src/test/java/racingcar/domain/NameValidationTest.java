package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class NameValidationTest {

    @Test
    void testIsCorrectPattern_ValidInput() {
        String validInput = "John,Doe";
        assertDoesNotThrow(() -> new NameValidation(validInput));
    }

    @Test
    void testIsCorrectPattern_InvalidInput() {
        String invalidInput = "John, Doe";
        assertThrows(IllegalArgumentException.class, () -> new NameValidation(invalidInput));
    }

    @Test
    void testIsCorrectPattern_InvalidInput_NoComma() {
        String validInput = "John";
        assertDoesNotThrow(() -> new NameValidation(validInput));
    }

    @Test
    void testIsCorrectPattern_InvalidInput_StartWithComma() {
        String invalidInput = ",John,Doe";
        assertThrows(IllegalArgumentException.class, () -> new NameValidation(invalidInput));
    }


    @Test
    @DisplayName("입력된 이름은 1자 이상, 5자 이하의 길이를 가져야 한다")
    void testIsCorrectLength() {
        String invalidNames = "Car1,Car2,Car333333333";
        assertThrows(IllegalArgumentException.class, () -> new NameValidation(invalidNames));

        String emptyNames = "Car1,,Car3";
        assertThrows(IllegalArgumentException.class, () -> new NameValidation(emptyNames));
    }

    @Test
    @DisplayName("중복된 자동차 이름은 사용할 수 없다")
    void testIsDuplicate() {
        String validNames = "Alice,Bob,Chris,1";
        assertDoesNotThrow(() -> new NameValidation(validNames));

        String duplicateNames = "Car1,Car2,Car1";
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new NameValidation(duplicateNames));
        assertEquals("ERROR: 중복되지 않는 이름을 입력하세요", exception.getMessage());
    }
}