package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.CarNameValidator;
import racingcar.validator.RoundNumberValidator;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidationTest {
    @Test
    @DisplayName("자동차 이름 특수문자 입력 테스트")
    void testCarNameValidationWithInvalidCharacters() {
        String input = "lee, kim. park%";
        assertThrows(IllegalArgumentException.class, () -> new CarNameValidator(input));
    }

    @Test
    @DisplayName("자동차 이름 길이 초과 테스트")
    void testCarNameValidationWithNamesOverRange() {
        String input = "longName, park, kim";
        assertThrows(IllegalArgumentException.class, () -> new CarNameValidator(input));
    }

    @Test
    @DisplayName("자동차 이름 입력 없음 테스트")
    void testCarNameValidationWithEmptyInput() {
        String input = "";
        assertThrows(IllegalArgumentException.class, () -> new CarNameValidator(input));
    }

    @Test
    @DisplayName("자동차 이름 중복 테스트")
    void testCarNameValidationWithDuplicateNames2() {
        String input = "lee,lee,park";
        assertThrows(IllegalArgumentException.class, () -> new CarNameValidator(input));
    }

    @Test
    @DisplayName("라운드 회수 숫자 의외의 값 입력 테스트")
    void testRoundNumberValidationWithNonNumericInput() {
        String input = "not a round number";
        assertThrows(IllegalArgumentException.class, () -> new RoundNumberValidator(input));
    }
}
