package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.validator.UserInputValidator;

class UserInputValidatorTest {

    @Test
    void userInputLengthValidatorTest() {
        //given
        String userInput = "aaaaaa";

        //when
        //then
        assertThatThrownBy(() -> UserInputValidator.validCarNameLength(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CAR_NAME_LENGTH_EXCEPTION.getMessage());
    }
}
