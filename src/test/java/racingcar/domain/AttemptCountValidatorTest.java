package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.BlankValidator;

public class AttemptCountValidatorTest {
    BlankValidator blankValidator = new BlankValidator();
    AttemptCountValidator attemptCountValidator = new AttemptCountValidator(blankValidator);

    @DisplayName("시도횟수 입력 - 정상입력")
    @Test
    void checkAttempNoramlInt() {
        String attempCount = "   21     ";
        int number = attemptCountValidator.getAttemptCount(attempCount);
        org.assertj.core.api.Assertions.assertThat(number).isEqualTo(21);
    }

    @DisplayName("시도횟수 입력 - 숫자 양 옆 공백제거 확인")
    @Test
    void checkAttempTrimInput() {
        String attempCount = "21";
        assertDoesNotThrow(() -> attemptCountValidator.getAttemptCount(attempCount));
    }

    @DisplayName("시도횟수 입력 - 양수int범위 초과시 예외발생")
    @Test
    void checkAttempOutOfRangePlusInt() {
        String attempCount = "1231231241351351351325134123413431";
        assertThrows(IllegalArgumentException.class, () -> attemptCountValidator.getAttemptCount(attempCount));
    }

    @DisplayName("시도횟수 입력 - 음수int범위 초과시 예외발생")
    @Test
    void checkAttempOutOfRangeMinusInt() {
        String attempCount = "-1231231241351351351325134123413431";
        assertThrows(IllegalArgumentException.class, () -> attemptCountValidator.getAttemptCount(attempCount));
    }

    @DisplayName("시도횟수 입력 - 숫자 외 포함시 예외발생")
    @Test
    void checkAttempNotInt() {
        String attempCount = "!222A";
        assertThrows(IllegalArgumentException.class, () -> attemptCountValidator.getAttemptCount(attempCount));
    }

    @DisplayName("시도횟수 입력 - 소수입력시 예외발생")
    @Test
    void checkAttempdecimal() {
        String attempCount = "3.5";
        assertThrows(IllegalArgumentException.class, () -> attemptCountValidator.getAttemptCount(attempCount));
    }

    @DisplayName("시도횟수 입력 - int범위 내 음수입력시 예외발생")
    @Test
    void checkAttempMinus() {
        String attempCount = "-6";
        assertThrows(IllegalArgumentException.class, () -> attemptCountValidator.getAttemptCount(attempCount));
    }

    @DisplayName("시도횟수 입력 - 0입력시 예외발생")
    @Test
    void checkAttempZero() {
        String attempCount = "0";
        assertThrows(IllegalArgumentException.class, () -> attemptCountValidator.getAttemptCount(attempCount));
    }

    @DisplayName("시도횟수 입력 - 숫자 사이 공백포함시 예외발생")
    @Test
    void checkAttempInternalSpaces() {
        String attempCount = "1 4";
        assertThrows(IllegalArgumentException.class, () -> attemptCountValidator.getAttemptCount(attempCount));
    }
}
