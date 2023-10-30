package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    @DisplayName("자동차 이름이 5자 이하인지 확인")
    void checkValidCarNamesTest1() {
        String[] carNames = {"pobi", "woni", "jun", "abcde"};

        Assertions.assertDoesNotThrow(
                () -> Validator.checkValidCarNames(carNames));
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과인지 확인")
    void checkValidCarNamesTest2() {
        String[] carNames = {"pobi", "woni", "junnie", "abcde"};

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Validator.checkValidCarNames(carNames),
                "자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 0글자인지 확인")
    void checkValidCarNamesTest3() {
        String[] carNames = {"pobi", "woni", "", "abcde"};

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Validator.checkValidCarNames(carNames),
                "자동차 이름은 1글자 이상만 가능합니다.");
    }
}