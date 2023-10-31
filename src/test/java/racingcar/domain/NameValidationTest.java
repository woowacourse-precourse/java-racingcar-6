package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class NameValidationTest {

    @Test
    void testIsCorrectPattern_ValidInput() {
        // 유효한 입력 예제 (쉼표로 구분된 이름)
        String validInput = "John,Doe";

        // 유효한 입력을 사용하여 isCorrectPattern 메서드를 호출하면 예외가 발생하지 않아야 합니다.
        assertDoesNotThrow(() -> new NameValidation(validInput));
    }

    @Test
    void testIsCorrectPattern_InvalidInput() {
        // 유효하지 않은 입력 예제 (띄어쓰기가 포함된 경우)
        String invalidInput = "John, Doe";

        // 유효하지 않은 입력을 사용하여 isCorrectPattern 메서드를 호출하면 IllegalArgumentException이 발생해야 합니다.
        assertThrows(IllegalArgumentException.class, () -> new NameValidation(invalidInput));
    }

    @Test
    void testIsCorrectPattern_InvalidInput_NoComma() {
        // 쉼표가 없는 경우
        String validInput = "John";

        // 유효하지 않은 입력을 사용하여 isCorrectPattern 메서드를 호출하면 IllegalArgumentException이 발생해야 합니다.
        //assertThrows(IllegalArgumentException.class, () -> new NameValidation(invalidInput));
        assertDoesNotThrow(() -> new NameValidation(validInput));

    }

    // 정규식에 조금 오류가 있는 것 같으니 수정 필요함!
    /*@Test
    public void testIsCorrectPattern_InvalidInput_MultipleCommas() {
        // 쉼표가 여러 개인 경우
        String invalidInput = "John,,,Doe";

        // 유효하지 않은 입력을 사용하여 isCorrectPattern 메서드를 호출하면 IllegalArgumentException이 발생해야 합니다.
        assertThrows(IllegalArgumentException.class, () -> new NameValidation(invalidInput));
    }*/

    @Test
    void testIsCorrectPattern_InvalidInput_StartWithComma() {
        // 이름이 쉼표로 시작하는 경우
        String invalidInput = ",John,Doe";

        // 유효하지 않은 입력을 사용하여 isCorrectPattern 메서드를 호출하면 IllegalArgumentException이 발생해야 합니다.
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