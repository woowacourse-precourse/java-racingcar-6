package racingcar.data;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 전진_성공_테스트() {
        Car car = new Car("yong", 0);
        car.move(true);

        assertThat(car.getMoveDistance()).isEqualTo(1);
    }

    @Test
    void 전진_실패_테스트() {
        Car car = new Car("soo", 0);
        car.move(false);

        assertThat(car.getMoveDistance()).isEqualTo(0);
    }
}
