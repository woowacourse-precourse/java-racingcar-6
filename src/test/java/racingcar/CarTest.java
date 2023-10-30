package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 자동차_전진() {
        Car car = new Car("name");
        final int step = 3;
        for (int i=0; i < step; i++)
            car.move();
        assertThat(car.getStatus()).isEqualTo(step);
    }
}