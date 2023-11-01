package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @DisplayName("앞으로 이동")
    @Test
    void front() {
        Car car = new Car("pobi", 2);
        car.move(4);
        assertEquals(3, car.getPosition());
    }

    @DisplayName("뒤로 이동")
    @Test
    void back1() {
        Car car = new Car("pobi", 4);
        car.move(3);
        assertEquals(3, car.getPosition());
    }

    @DisplayName("position 0일 떄 뒤로 ㅇ동")
    @Test
    void back2() {
        Car car = new Car("pobi", 0);
        car.move(1);
        assertEquals(0, car.getPosition());
    }
}