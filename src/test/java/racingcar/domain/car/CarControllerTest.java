package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CarControllerTest {

    String carName = "name";
    private static final int MOVING_FORWARD = 4;
    int forwardNumber = MOVING_FORWARD;
    int stopNumber = MOVING_FORWARD - 1;

    @Test
    @DisplayName("random_숫자가_4_이상_전진")
    public void move_randomNumberOver4_forward() {
        //given
        Car expected = new Car(carName);
        expected.forward();

        Car actual = new Car(carName);

        //when
        CarController.move(actual, forwardNumber, MOVING_FORWARD);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("random_숫자가_4_미만_정지")
    public void move_randomNumberLessThan4_stop() {
        //given
        Car expected = new Car(carName);
        Car actual = new Car(carName);

        //when
        CarController.move(actual, stopNumber, MOVING_FORWARD);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}