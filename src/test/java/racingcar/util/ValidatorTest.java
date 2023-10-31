package racingcar.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    @DisplayName("자동차 이름이 5자 이하인지 확인")
    void checkValidCarNamesTest1() {
        String[] carNames = {"pobi", "woni", "jun", "abcde"};

        assertDoesNotThrow(
                () -> Validator.checkValidCarNames(carNames));
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과인지 확인")
    void checkValidCarNamesTest2() {
        String[] carNames = {"pobi", "woni", "junnie", "abcde"};

        assertThrows(
                IllegalArgumentException.class,
                () -> Validator.checkValidCarNames(carNames),
                "자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 0글자인지 확인")
    void checkValidCarNamesTest3() {
        String[] carNames = {"pobi", "woni", "", "abcde"};

        assertThrows(
                IllegalArgumentException.class,
                () -> Validator.checkValidCarNames(carNames),
                "자동차 이름은 1글자 이상만 가능합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 중복되는지 확인")
    void checkValidCarNamesTest4() {
        String[] carNames = {"pobi", "woni", "pobi", "abcde"};

        assertThrows(
                IllegalArgumentException.class,
                () -> Validator.checkValidCarNames(carNames),
                "자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름에 공백이 있는지 확인")
    void checkValidCarNamesTest5() {
        String[] carNames = {"pobi", "woni", "jun ", "abcde"};

        assertThrows(
                IllegalArgumentException.class,
                () -> Validator.checkValidCarNames(carNames),
                "자동차 이름에 공백이 있을 수 없습니다.");
    }

    @Test
    @DisplayName("시도 횟수가 1 이상인 경우 확인")
    void isValidNumberOfAttemptsTest1() {
        int trial = 1;

        assertDoesNotThrow(
                () -> Validator.isValidNumberOfAttempts(trial));
    }

    @Test
    @DisplayName("시도 횟수가 0 이하인 경우 확인")
    void isValidNumberOfAttemptsTest2() {
        int trial = 0;

        assertThrows(
                IllegalArgumentException.class,
                () -> Validator.isValidNumberOfAttempts(trial),
                "시도 횟수는 1 이상만 가능합니다.");
    }
}