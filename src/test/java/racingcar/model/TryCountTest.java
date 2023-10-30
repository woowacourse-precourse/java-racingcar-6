package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryCountTest {

    @Test
    @DisplayName("시도 횟수는 1 이상이다.")
    void testTryCountIsAtLeastOne() {
        String tryCount = "-1";
        assertThatThrownBy(() -> new TryCount(tryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}