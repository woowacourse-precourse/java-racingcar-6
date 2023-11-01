package racingcar.car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 자동차_생성_테스트() {
        Car car = new Car("test");
        assertEquals("test", car.getName());
        assertEquals(0, car.getPosition());
    }

    @Test
    void 자동차_전진_실패_테스트() {
        Car car = new Car("test");
        car.move(0);
        car.move(1);
        car.move(2);
        car.move(3);
        assertEquals(0, car.getPosition());
    }

    @Test
    void 자동차_전진_성공_테스트() {
        Car car = new Car("test");
        car.move(4);
        car.move(5);
        car.move(6);
        car.move(7);
        car.move(8);
        car.move(9);
        assertEquals(6, car.getPosition());
    }
}