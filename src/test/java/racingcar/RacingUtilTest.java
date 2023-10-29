package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingUtilTest {
    @Test
    void generateRandomPower_테스트() {
        int result = RacingUtil.generateRandomPower();

        assertThat(result).isBetween(0, 9);
    }
}
