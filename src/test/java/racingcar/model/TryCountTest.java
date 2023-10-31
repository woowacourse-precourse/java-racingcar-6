package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.model.TryCount.*;

public class TryCountTest {
    @Test
    void 입력_예외_테스트() {
        assertThatThrownBy(() -> new TryCount("a1#"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_TRYCOUNT);
    }
}
