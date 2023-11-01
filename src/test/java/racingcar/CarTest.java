package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void decideGo() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");

        assertEquals("-",car1.decideGo(4));
        assertEquals("",car2.decideGo(1));
    }
}