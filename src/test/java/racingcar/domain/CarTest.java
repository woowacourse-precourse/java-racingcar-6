package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    public void testMove() {
        Car car = new Car("test");
        car.move(true);
        assertEquals(1, car.getPosition());
    }

    @Test
    public void testNoMove() {
        Car car = new Car("test");
        car.move(false);
        assertEquals(0, car.getPosition());
    }

    @Test
    public void testPositionRepresentation() {
        Car car = new Car("test");
        for (int i = 0; i < 5; i++) {
            car.move(true);
        }
        assertEquals("-----", car.getPositionRepresentation());
    }

    @Test
    public void testGeneratePositionString() {
        assertEquals("----", Car.generatePositionString(4));
    }

    @Test
    public void testToString() {
        Car car = new Car("test");
        assertEquals("test : ", car.toString());
        car.move(true);
        assertEquals("test : -", car.toString());
    }
}
