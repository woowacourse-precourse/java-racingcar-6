package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputTurnNumTest {

    InputTurnNum inputTurnNum = new InputTurnNum();

    @Test
    @DisplayName("0이하의 값을 입력했을 때 에러 발생 테스트")
    void inputMinus() {
        // given
        String input = "-1";

        // when

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputTurnNum.inputTurn(input);
        });

    }

    @Test
    @DisplayName("숫자가 아닌 값을 입력했을 때 에러 발생")
    void inputTurn() {
        // given
        String input = "abc";

        // when

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputTurnNum.inputTurn(input);
        });

    }
}