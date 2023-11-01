package racingcar;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class CarTest {
    private static final int FIRST_CAR_STATE = 0;

    @Test
    void 초기_자동차의_이동거리는_0이어야_한다(){
        Car car = new Car("pobi");
        assertThat(car.getCarState()).isEqualTo(FIRST_CAR_STATE);
    }
}
