package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    public static final int FORWARD_NUMBER = 4;

    @DisplayName("전진")
    @Test
    void 전진() {
        Car car = new Car("yeon");
        car.forward(FORWARD_NUMBER);

        assertThat(car.getLocation()).isEqualTo(1);
    }

    @DisplayName("우승_자동차_검증")
    @Test
    void 우승_자동차_검증() {
        Car car = new Car("yeon");
        int maxLocation = 5;

        assertFalse(car.isMaxLocation(maxLocation));
    }

    @DisplayName("이름에_대한_예외_처리")
    @Test
    void 이름에_대한_예외_처리() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Car("yeonJjang");
        });
    }
}