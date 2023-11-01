package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DistanceTest {

    @Test
    @DisplayName("정수가 아니면 예외가 발생해야 한다.")
    void numberCheck() {
        assertThatThrownBy(() -> new Distance("abcs")).isInstanceOf(IllegalArgumentException.class);
    }

}