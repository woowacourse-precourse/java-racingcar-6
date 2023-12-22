package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountTest {

    @Test
    void validateCountTest() {
        Assertions.assertThatThrownBy(() -> new Count(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
