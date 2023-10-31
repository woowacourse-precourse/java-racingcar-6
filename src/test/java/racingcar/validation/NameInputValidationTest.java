package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameInputValidationTest {

    NameInputValidation nameInputValidation = new NameInputValidation();

    @Test
    @DisplayName("자동차 이름이 5자 이하인가?")
    public void isUnderFiveLettersTest() {
        assertThatThrownBy(() -> nameInputValidation.isUnderFiveLetters("overFive"))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }
}
