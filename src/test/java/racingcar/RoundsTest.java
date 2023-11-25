package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

public class RoundsTest {
    @Test
    void validateRoundsInput_validInput() {
        InputView inputView = new InputView();
        int validRoundsInput = 100;

        Assertions.assertDoesNotThrow(() -> inputView.validateRoundsInput(validRoundsInput));
    }

    @Test
    void validateRoundsInput_validInput2() {
        InputView inputView = new InputView();
        int validRoundsInput = 1;

        Assertions.assertDoesNotThrow(() -> inputView.validateRoundsInput(validRoundsInput));
    }

    @Test
    void validateRoundsInput_invalidInput_throwsIllegalArgumentException() {
        InputView inputView = new InputView();
        int invalidRoundsInput = 0;

        Assertions.assertThrows(IllegalArgumentException.class, () -> inputView.validateRoundsInput(invalidRoundsInput));
    }

    @Test
    void validateRoundsInput_invalidInput_throwsIllegalArgumentException2() {
        InputView inputView = new InputView();
        int invalidRoundsInput = 101;

        Assertions.assertThrows(IllegalArgumentException.class, () -> inputView.validateRoundsInput(invalidRoundsInput));
    }
}
