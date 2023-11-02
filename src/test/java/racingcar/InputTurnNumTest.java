package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class InputTurnNumTest {

    InputTurnNum inputTurnNum = new InputTurnNum();

    static List<Car> CARLIST;

    @BeforeEach
    void beforeEach() {
        CARLIST = new ArrayList<>();
        CARLIST.add(new Car("pobi", 0));
        CARLIST.add(new Car("woni", 0));
    }

    @Test
    @DisplayName("0이하의 값을 입력했을 때 에러 발생 테스트")
    void inputMinus() {
        // given
        String input = "-1";

        // when

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputTurnNum.inputTurn(input, CARLIST);
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
            inputTurnNum.inputTurn(input, CARLIST);
        });

    }
}