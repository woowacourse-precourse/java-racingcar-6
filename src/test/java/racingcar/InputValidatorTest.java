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
    void carNameMoreThenFourLetters(String input){
        assertThatThrownBy(()-> InputValidator.lessThenFiveLetters(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(LESS_THEN_FIVE_LETTERS.getMessage());
    }

    @ParameterizedTest
    @DisplayName("정수 입력이 아닐 경우 예외 발생")
    @ValueSource(strings = {"11.1", "car", "3word"})
    void notIntegerInput(String input){
        assertThatThrownBy(()-> InputValidator.mustBeInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(VALUE_MUST_BE_INTEGER.getMessage());
    }

    @Test
    @DisplayName("입력 값이 없을 경우 예외 발생")
    void inputNullValue(){
        assertThatThrownBy(()-> InputValidator.mustHaveValue(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NULL_VALUE.getMessage());
    }
}
