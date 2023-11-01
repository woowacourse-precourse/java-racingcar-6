package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
    @Test
    void 자동차_이름_입력_유효성_검사() {
        String[] invalidNames = {"blackpink", "rose", "lisa", "jenny", "jisoo"};
        NameInput.setNameArr(invalidNames);
        assertThrows(IllegalArgumentException.class, () -> NameInput.checkNameInput());
    }
    @Test
    void 회차_입력_유효성_검사_음수인_경우() {
        String invalidCount = "-1";
        assertThrows(IllegalArgumentException.class, () -> CountInput.checkCountInput(invalidCount));
    }

    @Test
    void 회차_입력_유효성_검사_소숫점있는_경우() {
        String invalidCount = "5.6";
        assertThrows(IllegalArgumentException.class, () -> CountInput.checkCountInput(invalidCount));
    }

    @Test
    void 회차_입력_유효성_검사_문자열인_경우() {
        String invalidCount = "notNumber";
        assertThrows(IllegalArgumentException.class, () -> CountInput.checkCountInput(invalidCount));
    }

    @Test
    void 우승자_선정_방식_검사() {
        Car[] carArr = {
                new Car("jenny", 1),
                new Car("rose", 2),
                new Car("lisa", 3),
                new Car("jisoo", 3)
        };
        SelectWinner.selectWinner(carArr);
        assertEquals(new ArrayList<String>(Arrays.asList("lisa", "jisoo")), SelectWinner.getWinners());
    }
}
