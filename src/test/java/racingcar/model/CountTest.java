package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountTest {

    @Test
    void 실행횟수_유효성_검사_테스트() {
        Assertions.assertThatThrownBy(() -> new Count(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
