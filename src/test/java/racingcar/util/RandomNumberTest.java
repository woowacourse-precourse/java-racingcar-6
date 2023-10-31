package racingcar.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    @Test
    void 랜덤_숫자_생성() {
        assertThat(RandomNumber.generate()).isBetween(0, 9);
    }
}
