package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 전진_정상_이동() {
        Car car = Car.createFromName("pobi");
        car.moveForward(4);
        assertThat(car.getMoveForwardCount()).isEqualTo(1);
    }

    @Test
    void 전진_정상_이동_못함() {
        Car car = Car.createFromName("pobi");
        car.moveForward(3);
        assertThat(car.getMoveForwardCount()).isEqualTo(0);
    }

}