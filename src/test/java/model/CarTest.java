package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class CarTest {
    @Test
    void 자동차이름_5글자_이상_경우() {
        String carLengthOverFive = "자동차자동차";

        assertThatThrownBy(() -> new Car(carLengthOverFive))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5글자 이하여야 합니다.");
    }

    @Test
    void 자동차이름_숫자_포함_경우() {
        String carNumeric = "자동차1";

        assertThatThrownBy(() -> new Car(carNumeric))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름에 숫자는 넣을 수 없습니다.");
    }
}
