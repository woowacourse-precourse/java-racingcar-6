package racingcar;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingUtilTest {
    @Test
    void generateRandomPower_테스트() {
        assertRandomNumberInRangeTest(() -> assertEquals(5, RacingUtil.generateRandomPower()), 5);
    }
}
