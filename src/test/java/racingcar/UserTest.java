package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    void 자동차이름들과_시도횟수를_입력으로_받을수_있다() {
        User user = new User(){
            @Override
            protected String readCarsFromConsole(){
                return "pobi,woni";
            }

            @Override
            protected String readTryNumFromConsole(){
                return "5";
            }
        };

        user.readCarInput();
        user.readTryNumInput();

        assertEquals("pobi,woni", user.getCarNames());
        assertEquals(5, user.getTryNum());
    }
}