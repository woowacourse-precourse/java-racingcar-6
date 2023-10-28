package racingcar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.AttemptCountValidator;
import racingcar.util.BlankValidator;

public class CarNameValidatorTest {
    BlankValidator blankValidator = new BlankValidator();

    @DisplayName("시도횟수 입력 - 정상입력")
    @Test
    void checkAttempNoramInt() {
        String attempCount = "21";
        AttemptCountValidator attemptCountValidator = new AttemptCountValidator(blankValidator);
        assertDoesNotThrow(() -> attemptCountValidator.getValidatedAttemptCount(attempCount));
    }
}
