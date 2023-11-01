package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarNameValidatorTest {

    Validator<List<String>> nameValidator = new RacingCarNameValidator();

    @Test
    @DisplayName("정상적인 자동차 이름")
    void validateRacingCarNameSuccess() {
        List<String> names = Arrays.asList("Jehun", "is", "eager", "to", "go", "woo", "te", "co");
        assertDoesNotThrow(() -> nameValidator.validate(names));
    }

    @Test
    @DisplayName("자동차 이름이 너무 긴 경우")
    void validateRacingCarNameLongName() {
        List<String> names = Arrays.asList("abcdefghijklmnopqrstuvwxyz");
        assertThatThrownBy(() -> nameValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 너무 깁니다. 현재 길이 : " + names.get(0).length());
    }

    @Test
    @DisplayName("자동차 이름이 너무 짧은 경우")
    void validateRacingCarNameShortName() {
        List<String> names = Arrays.asList("");
        assertThatThrownBy(() -> nameValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 너무 짧습니다. 현재 길이 : " + names.get(0).length());
    }

    @Test
    @DisplayName("자동차 이름에 올바르지 않은 문자가 입력된 경우")
    void validateRacingCarNameInvalidCharacter() {
        List<String> names = Arrays.asList("ab*de");
        assertThatThrownBy(() -> nameValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름으로 올바르지 않은 문자가 입력되었습니다.");
    }

    @Test
    @DisplayName("자동차 이름이 중복된 경우")
    void validateRacingCarNameDuplicateNames() {
        List<String> names = Arrays.asList("hello", "name", "world", "name");
        assertThatThrownBy(() -> nameValidator.validate(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 중복되었습니다.");
    }
}