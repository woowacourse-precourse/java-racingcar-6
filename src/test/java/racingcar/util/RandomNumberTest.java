package racingcar.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    private static final int MIN = 0;
    private static final int MAX = 9;

    @Test
    void 랜덤_숫자_생성() {
        assertThat(RandomNumber.generate()).isBetween(MIN, MAX);
    }
}
