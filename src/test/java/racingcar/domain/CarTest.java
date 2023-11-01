package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {

    Car car;
    private static final String NAME = "pobi";
    private static final int MOVED_POSITION = 1;
    private static final int NOT_MOVED_POSITION = 0;
    private static final int MOVABLE_NUMBER = 4;
    private static final int NON_MOVABLE_NUMBER = 3;

    @BeforeEach
    void setUp() {
        car = Car.from(NAME);
    }

    @Test
    void createCar() {
        assertThat(car).isNotNull();
    }

    @Test
    void move() {
        car.move(MOVABLE_NUMBER);
        assertEquals(car.toDto().position(), MOVED_POSITION);
    }

    @Test
    void stop() {
        car.move(NON_MOVABLE_NUMBER);
        assertEquals(car.toDto().position(), NOT_MOVED_POSITION);
    }
}
