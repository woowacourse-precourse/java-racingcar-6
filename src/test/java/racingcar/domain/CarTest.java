package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    Car car;

    @BeforeEach
    void init() {
        car = new Car("test");
    }

    @Test
    void 자동차_이동_성공_테스트() {
        car.move(5);

        assertEquals(1, car.getPosition());
    }

    @Test
    void 자동차_이동_실패_테스트() {
        car.move(3);

        assertEquals(0, car.getPosition());
    }
}