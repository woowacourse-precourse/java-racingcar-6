package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.utils.Random;
public class GameTest {

    @Test
    void 최솟값_최댓값사이의_랜덤한_수_생성하기() {
        int result = Random.setRandNum();
        Assertions.assertTrue(result >= Config.MIN_VALUE && result <= Config.MAX_VALUE);
    }
}
