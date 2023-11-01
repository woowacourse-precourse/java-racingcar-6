package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Car 클래스")
class CarTest {

    private Car car;
    private final int INIT_POSITION_CRITERION = 0;
    private final int MOVING_FORWARD_CRITERION = 4;
    private final int STOP_CRITERION = 3;

    @BeforeEach
    void setup() {
        car = Car.fromName("pobi");
    }

    @Test
    void 이름으로_자동차를_생성() {
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void 이름이_5자_초과_시_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> Car.fromName("pororo"));
    }

    @Test
    void 무작위_값이_4_이상이면_전진() {
        car.moveForward(MOVING_FORWARD_CRITERION);
        assertThat(car.getPosition()).isEqualTo(INIT_POSITION_CRITERION+1);
    }

    @Test
    void 무작위_값이_4_미만이면_정지() {
        car.moveForward(STOP_CRITERION);
        assertThat(car.getPosition()).isEqualTo(INIT_POSITION_CRITERION);

    }
}