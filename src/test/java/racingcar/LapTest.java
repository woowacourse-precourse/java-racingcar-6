package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class LapTest {

    @Test
    public void 전진횟수_0이하() {
        assertThatThrownBy(() -> new Lap(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
