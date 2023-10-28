package racingcar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @DisplayName("시도횟수 입력 - 양수int범위 초과")
    @Test
    void checkAttempOutOfRangePlusInt() {
        String attempCount = "1231231241351351351325134123413431";
        AttemptCountValidator attemptCountValidator = new AttemptCountValidator(blankValidator);
        assertThrows(IllegalArgumentException.class, () -> attemptCountValidator.getValidatedAttemptCount(attempCount));
    }

    @DisplayName("시도횟수 입력 - 음수int범위 초과")
    @Test
    void checkAttempOutOfRangeMinusInt() {
        String attempCount = "-1231231241351351351325134123413431";
        AttemptCountValidator attemptCountValidator = new AttemptCountValidator(blankValidator);
        assertThrows(IllegalArgumentException.class, () -> attemptCountValidator.getValidatedAttemptCount(attempCount));
    }

    @DisplayName("시도횟수 입력 - 숫자 외 포함")
    @Test
    void checkAttempNotInt() {
        String attempCount = "!222A";
        AttemptCountValidator attemptCountValidator = new AttemptCountValidator(blankValidator);
        assertThrows(IllegalArgumentException.class, () -> attemptCountValidator.getValidatedAttemptCount(attempCount));
    }

    @DisplayName("시도횟수 입력 - 소수")
    @Test
    void checkAttempdecimal() {
        String attempCount = "3.5";
        AttemptCountValidator attemptCountValidator = new AttemptCountValidator(blankValidator);
        assertThrows(IllegalArgumentException.class, () -> attemptCountValidator.getValidatedAttemptCount(attempCount));
    }

    @DisplayName("시도횟수 입력 - int범위 내 음수")
    @Test
    void checkAttempMinus() {
        String attempCount = "-6";
        AttemptCountValidator attemptCountValidator = new AttemptCountValidator(blankValidator);
        assertThrows(IllegalArgumentException.class, () -> attemptCountValidator.getValidatedAttemptCount(attempCount));
    }
}
