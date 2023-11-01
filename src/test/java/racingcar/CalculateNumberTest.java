package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CalculateNumberTest {
    Game game = new Game();
    @AfterEach
    void close() {
        Console.close();
    }
    @Test
    void 최댓값_구하기_테스트_성공 (){
        //given
        Map<String,Integer> cars = new HashMap<>(){{
            put("car1",1);
            put("car2",2);
            put("car3",3);

        }};
        //when
        int result = game.findMaxValue(cars);

        //then
        Assertions.assertEquals(3,result);
    }
}
