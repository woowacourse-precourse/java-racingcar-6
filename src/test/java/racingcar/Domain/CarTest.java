package racingcar.Domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test //3번 기능 테스트
    void move() {
        Car car = new Car("pobi");
        car.move(4);
        assertEquals(1, car.getPosition());
        car.move(3);
        assertEquals(1, car.getPosition());
    }
}