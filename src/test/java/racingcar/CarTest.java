package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class CarTest {

    @Test
    void 전진_판단() {
        Car car = new Car("testCar");
        boolean result = car.canMoveForward(3);
        assertThat(result).isEqualTo(false);
    }
}