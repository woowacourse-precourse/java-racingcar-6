package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingUtilTest {
    @Test
    void generateRandomPower_테스트() {
        int result = RacingUtil.generateRandomPower();

        assertThat(result).isBetween(0, 9);
    }
}
