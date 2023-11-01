package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차 이름 5글자 이하 테스트")
    void 자동차_이름_5글자_이하_테스트() {
        assertThatThrownBy(() -> new Car("abcdef", 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}