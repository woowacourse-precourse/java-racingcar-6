package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 자동차_초기_위치는_0() {
        assertThat(new Car("pobi").getPosition()).isZero();
    }

    @Test
    void 자동차가_이동하면_위치는_1만큼_증가() {
        Car car = new Car("pobi");
        int past = car.getPosition();

        car.moveForward();
        assertThat(car.getPosition()).isEqualTo(past + 1);
    }
}
