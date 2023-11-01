package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.errormessage.InputError;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class RoundInputViewTest {
    RoundInputView roundInputView = new RoundInputView();

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @DisplayName("정상입력")
    @Test
    void isCorrectInput(){
        // Given
        String numberString ="102";
        System.setIn(createUserInput(numberString));

        // When
        int number = roundInputView.generateRoundNumber();

        // Then
        Assertions.assertThat(number).isEqualTo(Integer.parseInt(numberString));
    }

    @DisplayName("숫자가아닌_문자포함_예외처리")
    @Test
    void isNotNumber() {
        // Given
        String numberString ="1 2a";
        System.setIn(createUserInput(numberString));

        // When
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> roundInputView.generateRoundNumber());

        // Then
        Assertions.assertThat(exception.getMessage()).isEqualTo(InputError.INPUT_NOT_NUMBER_ERROR_MESSAGE);
    }

    @DisplayName("빈문자열_입력_예외처리")
    @Test
    void isSpaceName() {
        // Given
        String numberString ="\n";
        System.setIn(createUserInput(numberString));

        // When
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> roundInputView.generateRoundNumber());

        // Then
        Assertions.assertThat(exception.getMessage()).isEqualTo(InputError.INPUT_EMPTY_ERROR_MESSAGE);
    }
}