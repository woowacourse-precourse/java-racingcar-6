package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    private CarName carName;

    @BeforeEach
    void setUp() {
        carName = new CarName("abc");
    }

    @Test
    @DisplayName("GO를 전달받으면 Distance값이 1이 되어야 한다.")
    void go() {
        Car car = new Car(carName);
        car.move(MoveStatus.GO);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("STOP을 전달받으면 Distance값이 0이 되어야 한다.")
    void stop() {
        Car car = new Car(carName);
        car.move(MoveStatus.STOP);
        assertThat(car.getDistance()).isEqualTo(0);
    }
}