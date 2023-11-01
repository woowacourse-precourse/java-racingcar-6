package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.game.validator.InputValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.game.validator.ExceptionMessage.*;

public class InputValidatorTest {

    @ParameterizedTest
    @DisplayName("5글자 이상 입력 할 경우 예외 발생")
    @ValueSource(strings = {"letter"})
    void lessThenFiveLetters(String input){
        assertThatThrownBy(()-> InputValidator.lessThenFiveLetters(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(LESS_THEN_FIVE_LETTERS.getMessage());
    }
}
