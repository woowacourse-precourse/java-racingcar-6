package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    @DisplayName("자동차 이름에 공백이 입력되었을 시 예외 처리")
    public void checkEmptyName() {
        assertThatThrownBy(() -> {
            Car car = new Car("");
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("[ERROR] : 자동차 이름을 입력해주세요.");
    }

}