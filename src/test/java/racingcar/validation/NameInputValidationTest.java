package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameInputValidationTest {

    private final NameInputValidation nameInputValidation = new NameInputValidation();

    @Test
    @DisplayName("자동차 이름이 5자 이하인가?")
    public void isUnderFiveLettersTest() {
        assertThatThrownBy(() -> nameInputValidation.isUnderFiveLetters("overFive"))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("중복인 자동차 이름이 있는가?")
    public void isExistNameTest() {
        String[] nameList = {"pobi", "woni", "woni"};
        assertThatThrownBy(() -> nameInputValidation.isExistName(nameList))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름을 입력할 수 없습니다.");
    }
}
