package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("자동차 이름이 5글자 초과인 경우 예외")
    void name_greater_than_5() {
        assertThatThrownBy(() -> new Car("123456", 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
