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
        car.move(4);
        assertThat(car).extracting("position").isEqualTo(1);
    }

    @Test
    void stop() {
        car.move(3);
        assertThat(car).extracting("position").isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"다섯글자초과", ""})
    void createCarWithInvalidNames(String input) {
        assertThatThrownBy(() -> {
            Car.of(input, POSITION);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
