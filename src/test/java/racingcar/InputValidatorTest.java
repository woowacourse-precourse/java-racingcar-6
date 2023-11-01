package racingcar;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 자동차의_이름은_길이가_5_이하여야_한다() {
        String input1 = "pobi";
        String input2= "pobibibi";
        InputValidator inputValidator = new InputValidator();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(inputValidator.validateCarName(input1)).contains("pobi");
        softAssertions.assertThatThrownBy(() -> inputValidator.validateCarName(input2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차의_이름은_영어로_이루어져야_한다() {
        String input1 = "pobi";
        String input2= "po123po";
        String input3= "12345";
        String input4= "po!@#";
        InputValidator inputValidator = new InputValidator();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(inputValidator.validateCarName(input1)).contains("pobi");
        softAssertions.assertThatThrownBy(() -> inputValidator.validateCarName(input2))
                .isInstanceOf(IllegalArgumentException.class);
        softAssertions.assertThatThrownBy(() -> inputValidator.validateCarName(input3))
                .isInstanceOf(IllegalArgumentException.class);
        softAssertions.assertThatThrownBy(() -> inputValidator.validateCarName(input4))
                .isInstanceOf(IllegalArgumentException.class);
    }

}