package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 자동차를_생성자_이름_Null() {
        assertThatThrownBy(() -> new Car(null)) .isInstanceOf(NullPointerException.class);
    }

    @Test
    void 자동차는_움직일_수_있다() {
        Car car = new Car("테스트");
        int currentPosition = car.getPosition();
        int movingDistance = 1;

        car.move(movingDistance);
        int movedPosition = car.getPosition();

        assertThat(movedPosition - currentPosition).isEqualTo(movingDistance);
    }
}