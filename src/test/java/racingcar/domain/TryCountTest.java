package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class TryCountTest {
    @Test
    void createTryCountByInValidFormat() {
        assertThatThrownBy(() -> new TryCount("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createTryCountByUnderValue() {
        assertThatThrownBy(() -> new TryCount("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
