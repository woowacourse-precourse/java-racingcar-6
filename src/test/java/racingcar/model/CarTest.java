package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차가 명령을 받으면 이동한다")
    void 자동차_포지션_증가_테스트() {
        Car car = new Car("test");

        car.move();
        assertThat(car.getPosition()).isEqualTo(1);

        car.move();
        assertThat(car.getPosition()).isEqualTo(2);
    }
}