package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    private Car car;

    @BeforeEach
    void 자동차_객체_생성() {
        car = new Car("matia");
    }

    @Test
    void 자동차_이름_확인() {
        assertEquals(car.getName(), "matia");
    }

    @Test
    void 자동차_위치_초기값_확인() {
        assertEquals(car.getPosition(), 0);
    }

    @Test
    void 자동차_위치_멈춤_확인() {
        car.move(CarState.STOP);
        assertEquals(car.getPosition(), 0);
    }

    @Test
    void 자동차_위치_증가_확인() {
        car.move(CarState.MOVE);
        assertEquals(car.getPosition(), 1);
    }
}

