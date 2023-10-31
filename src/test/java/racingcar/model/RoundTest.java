package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RoundTest {

    @DisplayName("1 이하의 라운드 테스트")
    @Test
    void under_one_round() {
        assertThatThrownBy(() -> new Round(0)).isInstanceOf(IllegalArgumentException.class);
    }
}
