package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Validator 테스트")
public class ValidatorTest {

    @Test
    @DisplayName("5글자 초과 시 예외 처리")
    void isUnderFiveCharacterOrLessTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.isUnderFiveCharacterOrLess("Stephen"));
    }

    @Test
    @DisplayName("count에 숫자가 아닌 값이 들어왔을 때 예외 처리")
    void isNumberTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Validator.isNumber("abc"));
    }

    @Test
    @DisplayName("무작위 값이 4 이상인지 체크")
    void isFourOrMoreTest() {
        assertTrue(Validator.isFourOrMore(4));
        assertFalse(Validator.isFourOrMore(3));
    }

    @Test
    @DisplayName("우승자 결정")
    void isWinnerTest() {
        assertTrue(Validator.isWinner(4, 4));
        assertFalse(Validator.isWinner(5, 2));
    }
}
