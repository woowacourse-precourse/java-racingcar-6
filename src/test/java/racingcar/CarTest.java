package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class CarTest {
    private static final int FIRST_CAR_STATE = 0;
    private static final int MOVED_ONE_STEP_STATE = 1;
    private static final String MOVED_ONE_STEP_RESULT = "-";

    @Test
    void 초기_자동차의_이동거리는_0이어야_한다() {
        Car car = new Car("pobi");
        assertThat(car.getCarState()).isEqualTo(FIRST_CAR_STATE);
    }

    @Test
    void 자동차_이동이_잘_이루어지는지_확인() {
        Car car = new Car("jun");
        car.setCarState();
        car.setCarMovedResult();

        assertThat(car.getCarState()).isEqualTo(MOVED_ONE_STEP_STATE);
        assertThat(car.getCarMovedResult()).isEqualTo(MOVED_ONE_STEP_RESULT);
    }

    @Test
    void 자동차의_이름이_잘_저장되는지_확인() {
        String carName = "me";
        Car car = new Car(carName);

        assertThat(car.getName()).isEqualTo(carName);
    }
}