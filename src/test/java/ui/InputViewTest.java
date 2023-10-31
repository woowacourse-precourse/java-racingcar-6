package ui;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.Arrays;

public class InputViewTest {

    @Test
    public void testValidateCarNameLength_InvalidName() {
        String invalidCarName = "longcarname";
        assertThatThrownBy(() -> InputView.validateCarNameLength(invalidCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    public void testValidateCarNameNoSpace_InvalidName() {
        String invalidCarName = "name with space";
        assertThatThrownBy(() -> InputView.validateCarNameNoSpace(invalidCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름에 공백은 불가능합니다.");
    }

    @Test
    public void testValidateCarNameDuplicate_WithDuplicates() {
        String[] carNames = {"pobi", "woni", "pobi"};
        assertThatThrownBy(() -> InputView.validateCarNameDuplicate(Arrays.asList(carNames)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 중복은 불가능합니다.");
    }

    @Test
    public void testValidateInputNumbers_NegativeNumber() {
        int negativeNumber = -3;
        assertThatThrownBy(() -> InputView.validateInputNumbers(negativeNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수 라운드 입력은 불가능합니다.");
    }
}
