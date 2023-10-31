package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.strategy.AlwaysMoveStrategy;

class CarTest {
    private Car car1;
    private Car car2;

    @BeforeEach
    void setup() {
        // Given
        car1 = Car.of(Name.from("차이름1"), AlwaysMoveStrategy.getInstance());
        car2 = Car.of(Name.from("차이름2"), AlwaysMoveStrategy.getInstance());
    }

    @Test
    void 스텝_증가() {
        // When
        car1.attemptMove();

        // Then
        assertEquals(1, car1.getStep());
    }

    @Test
    void 두_차의_스텝_비교() {
        // When
        car1.attemptMove();
        car2.attemptMove();
        car2.attemptMove();

        // Then
        assertTrue(car1.compareTo(car2) < 0);
    }

    @Test
    void 두_차의_스텝이_같을때_비교() {
        // When
        car1.attemptMove();
        car2.attemptMove();

        // Then
        assertEquals(0, car1.compareTo(car2));
    }
}
