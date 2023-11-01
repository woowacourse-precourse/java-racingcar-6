package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static racingcar.RacingCarTestConstants.*;
import static validate.InputValidation.*;

public class ValidateTest {

    @Test
    void validateNumericInput_입력된_값에_숫자가_아닌_문자가_포함되어있으면_예외_발생() {
        String input = "1a";

        assertThatThrownBy(() -> validateNumericInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMERIC_INPUT_ERROR_MESSAGE);
     }

     @Test
    void validateInputLengthExceeded_입력된_자동차의_이름이_5글자를_초과했을때_예외_발생() {
        String name = "abcdef";

        assertThatThrownBy(() -> validateInputLengthExceeded(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_LENGTH_EXCEEDED_ERROR_MESSAGE);
     }

     @Test
    void validateInputIsEmpty_입력된_자동차의_이름이_공백일때_예외_발생() {
        String name = "";

         assertThatThrownBy(() -> validateInputIsEmpty(name))
                 .isInstanceOf(IllegalArgumentException.class)
                 .hasMessageContaining(INPUT_IS_EMPTY_ERROR_MESSAGE);
     }

     @Test
    void validateInputDoesNotContainSpecialCharacters_입력된_자동차의_이름이_공백이나_특수문자가_포함되었을때_예외_발생() {
        String name1 = "a*c";
        String name2 = "a b";
        String name3 = " ";

         assertThatThrownBy(() -> validateInputDoesNotContainSpecialCharacters(name1))
                 .isInstanceOf(IllegalArgumentException.class)
                 .hasMessageContaining(INPUT_DOES_NOT_CONTAIN_SPECIAL_CHARACTERS_ERROR_MESSAGE);

         assertThatThrownBy(() -> validateInputDoesNotContainSpecialCharacters(name2))
                 .isInstanceOf(IllegalArgumentException.class)
                 .hasMessageContaining(INPUT_DOES_NOT_CONTAIN_SPECIAL_CHARACTERS_ERROR_MESSAGE);

         assertThatThrownBy(() -> validateInputDoesNotContainSpecialCharacters(name3))
                 .isInstanceOf(IllegalArgumentException.class)
                 .hasMessageContaining(INPUT_DOES_NOT_CONTAIN_SPECIAL_CHARACTERS_ERROR_MESSAGE);
     }

     @Test
    void validateListIsEmpty_입력된_자동차가_한대도_없을때_예외_발생() {
        String input = ",,,";

        String[] list = input.split(",");

         assertThatThrownBy(() -> validateListIsEmpty(list))
                 .isInstanceOf(IllegalArgumentException.class)
                 .hasMessageContaining(LIST_IS_EMPTY_ERROR_MESSAGE);
     }
}
