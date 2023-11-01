package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    Car car;
    private static final String NAME = "pobi";
    private static final int INITIAL_POSITION = 0;
    private static final int MOVED_POSITION = 1;
    private static final int MOVABLE_NUMBER = 4;
    private static final int NON_MOVABLE_NUMBER = 3;

    @BeforeEach
    void setUp() {
        car = Car.of(NAME, INITIAL_POSITION);
    }

    @Test
    void createCar() {
        assertThat(car).isNotNull();
    }

    @Test
    void move() {
        car.move(MOVABLE_NUMBER);
        assertThat(car).isEqualTo(Car.of(NAME,MOVED_POSITION));
    }

    @Test
    void stop() {
        car.move(NON_MOVABLE_NUMBER);
        assertThat(car).isEqualTo(Car.of(NAME,INITIAL_POSITION));
    }

    @ParameterizedTest
    @ValueSource(strings = {"다섯글자초과", ""})
    void createCarWithInvalidNames(String input) {
        assertThatThrownBy(() -> Car.of(input, INITIAL_POSITION)).isInstanceOf(IllegalArgumentException.class);
    }

}
