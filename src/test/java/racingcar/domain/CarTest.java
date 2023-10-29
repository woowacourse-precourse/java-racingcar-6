package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
    private Car car1;
    private Car car2;

    @BeforeEach
    void setup() {
        // Given
        car1 = Car.from(Name.from("차이름1"));
        car2 = Car.from(Name.from("차이름2"));
    }

    @Test
    void 스텝_증가() {
        // When
        car1.moveForward();

        // Then
        assertEquals(1, car1.getStep());
    }

    @Test
    void 두_차의_스텝_비교() {
        // When
        car1.moveForward();
        car2.moveForward();
        car2.moveForward();

        // Then
        assertTrue(car1.compareTo(car2) < 0);
    }

    @Test
    void 두_차의_스텝이_같을때_비교() {
        // When
        car1.moveForward();
        car2.moveForward();

        // Then
        assertEquals(0, car1.compareTo(car1));
    }
}
