package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Racing;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    Racing racing = new Racing();

    @Test
    void moveForwardTest(){
        assertThat(racing.moveForward(5)).isTrue();
        assertThat(racing.moveForward(3)).isFalse();
    }

    @Test
    void printWinnerTest(){
        Map<String,Integer> racingResultMap = new LinkedHashMap<>();
        racingResultMap.put("맥퀸", 3);
        racingResultMap.put("메이터", 1);
        racingResultMap.put("샐리", 3);

        assertThat(racing.printWinner(racingResultMap)).isEqualTo("맥퀸, 샐리");
    }
}
