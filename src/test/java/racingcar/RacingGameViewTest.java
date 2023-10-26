package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingGameViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"a,ab,abc,abcd,abcde", "1,12,안녕,abc"})
    @DisplayName("입력받은 자동차의 이름이 정상적인 값만 들어오는 경우를 테스트.")
    void testValidateCarNames(String value) {
        //given
        RacingGameView racingGameView = new RacingGameView();
        //then
        assertDoesNotThrow(() -> racingGameView.validateCarNames(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456", "a,ab,abc,abcd,abcde,abcdef"})
    @DisplayName("입력받은 자동차의 이름 중 5글자를 초과하는 이름이 있으면 에러를 발생시킨다.")
    void testValidateCarNamesOver(String value) {
        //given
        RacingGameView racingGameView = new RacingGameView();
        //then
        assertThrows(IllegalArgumentException.class, () -> racingGameView.validateCarNames(value));
    }

    @Test
    @DisplayName("라운드 입력시 유효한 숫자면 예외가 발생하지 않는다")
    void testValidPositiveNumber() {
        String validInput = "42";
        RacingGameView racingGameView = new RacingGameView();

        assertDoesNotThrow(() -> racingGameView.validatePositiveNumber(validInput));
    }

    @Test
    @DisplayName("라운드 입력시 0 이하의 숫자 입력이 발생하면 예외")
    void testZeroOrNegativeInput() {
        String invalidInput = "0";
        RacingGameView racingGameView = new RacingGameView();

        assertThrows(IllegalArgumentException.class, () -> racingGameView.validatePositiveNumber(invalidInput));
    }

    @Test
    @DisplayName("라운드 입력시 숫자가 아닌 입력이 발생하면 예외")
    void testNonNumericInput() {
        String invalidInput = "abc";
        RacingGameView racingGameView = new RacingGameView();

        assertThrows(IllegalArgumentException.class, () -> racingGameView.validatePositiveNumber(invalidInput));
    }
}