package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class OilTest {

    @Test
    public void 전진횟수_0이하() {
        assertThatThrownBy(() -> new Oil(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
