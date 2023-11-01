package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {
    @Test
    void 객체_변경() {
        Car car = new Car("자동차");
        car.movable(5);
        assertThat(car.equals(new Car("자동차"))).isFalse();
    }

    @Test
    void 같은_객체() {
        Car car = new Car("자동차");
        assertThat(car.equals(new Car("자동차"))).isTrue();
    }

    @Test
    void 진행도_리턴() {
        Car car = new Car("자동차");
        assertThat(car.indicate()).contains("자동차");
    }

    @Test
    void 진행도_업데이트() {
        Car car = new Car("자동차");
        car.movable(5);
        assertThat(car.indicate()).contains("자동차").contains("-");
    }

    @Test
    void 객체_비교() {
        Car car = new Car("자동차");
        car.movable(5);
        Car compareCar = new Car("비교차");

        assertThat(car.isLesser(compareCar)).isFalse();
    }

}
