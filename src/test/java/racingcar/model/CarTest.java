package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    public static final int FORWARD_NUMBER = 4;
    public static final int STOP_NUMBER = 3;

    @DisplayName("forward() 에 4 이상의 값을 입력할 경우, Car 위치를 전진시킨다.")
    @Test
    void 전진() {
        Car car = new Car("yeon");
        car.forward(FORWARD_NUMBER);

        assertThat(car.getLocation()).isEqualTo(1);
    }

    @DisplayName("forward() 에 3 이하의 값을 입력할 경우, Car 위치를 그대로 둔다.")
    @Test
    void 정지() {
        Car car = new Car("yeon");
        car.forward(STOP_NUMBER);

        assertThat(car.getLocation()).isEqualTo(0);
    }

    @DisplayName("isMaxLocation() 에 최대 위치값을 입력하여, 현재 객체의 위치값이 작다면 false 반환한다.")
    @Test
    void 최대_전진_횟수_미만() {
        Car car = new Car("yeon");
        int maxLocation = 5;

        assertFalse(car.isMaxLocation(maxLocation));
    }

    @DisplayName("isMaxLocation() 에 최대 위치값을 입력하여, 현재 객체의 위치값이 작지않다면 false 반환한다.")
    @Test
    void 최대_전진_횟수_이상() {
        Car car = new Car("yeon");
        int maxLocation = 0;

        assertTrue(car.isMaxLocation(maxLocation));
    }

    @DisplayName("이름에_대한_예외_처리")
    @Test
    void 이름에_대한_예외_처리() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Car("yeonJjang");
        });
    }
}