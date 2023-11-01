package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {

    @Test
    void moveFoward() {
        Car car = new Car("test");
        car.moveFoward(5);
        assertEquals(1, car.getPosition());

    }

}
