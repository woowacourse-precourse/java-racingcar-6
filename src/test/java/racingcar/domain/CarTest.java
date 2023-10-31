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
    private static final int POSITION = 0;

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    void setUp() {
        car = Car.of(NAME, POSITION);
    }

    @Test
    void createCar() {
        assertThat(car).isNotNull();
    }

    @Test
    void move() {
        car.move(MOVING_FORWARD);
        assertThat(car).isEqualTo(Car.of("pobi",1));
    }

    @Test
    void stop() {
        car.move(STOP);
        assertThat(car).isEqualTo(Car.of("pobi",0));
    }

    @ParameterizedTest
    @ValueSource(strings = {"다섯글자초과", ""})
    void createCarWithInvalidNames(String input) {
        assertThatThrownBy(() -> Car.of(input, POSITION)).isInstanceOf(IllegalArgumentException.class);
    }

}
