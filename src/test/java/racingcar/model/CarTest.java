package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car;

    @BeforeEach
    public void setUp() {
        car = Car.makeCar("TestCar");
    }

    @Test
    public void 자동차의_이름과_위치는_0으로_생성되는지_확인() {
        assertEquals("TestCar", car.getName());
        assertEquals(0, car.getPosition());
    }
}
