package racingcar.machine.car;

import org.junit.jupiter.api.Test;
import racingcar.machine.util.random.RandomsProvider;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void 자동차_전진_4이상일_경우() {
        // given
        RandomsProvider alwaysMoveRandomsProvider = (start, end) -> 9; // 항상 움직이게 하는 RandomsProvider
        Car car = new Car("car", alwaysMoveRandomsProvider);

        // when
        car.tryForwardMove();

        // then
        assertEquals(1, car.getDistance());

    }

    @Test
    void 자동차_전진_4미만일_경우() {
        // given
        RandomsProvider alwaysMoveRandomsProvider = (start, end) -> 2;
        Car car = new Car("car", alwaysMoveRandomsProvider);

        // when
        car.tryForwardMove();

        // then
        assertEquals(0, car.getDistance());

    }


}