package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
    @Test
    void 자동차_이름_입력_유효성_검사() {
        List<String> invalidNames = Arrays.asList("blackpink", "rose", "lisa", "jenny", "jisoo");
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
    void 전진_방식_유효성_검사() {
        Car jennyCar = new Car("jenny", 0);
        List<Car> carArr = Arrays.asList(jennyCar);
        List<Boolean> moveArr = MoveForward.moveCars(carArr);

        if (moveArr.get(0) == true) {
            assertEquals(1, jennyCar.getScore());
        } else {
            assertEquals(0, jennyCar.getScore());
        }
    }

    @Test
    void 우승자_선정_방식_검사() {
        List<Car> carArr = Arrays.asList(
                new Car("jenny", 1),
                new Car("rose", 2),
                new Car("lisa", 3),
                new Car("jisoo", 3)
        );
        SelectWinner.selectWinner(carArr);
        assertEquals(new ArrayList<String>(Arrays.asList("lisa", "jisoo")), SelectWinner.getWinners());
    }
}
