package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    String name;
    Car car;

    @BeforeEach
    void setUp() {
        name = "default";
        car = new Car(name);
    }

    @Test
    void getDistance() {
        int result = car.getDistance();
        assertThat(result).isEqualTo(0);
    }

    @Test
    void getName() {
        String result = car.getName();
        assertThat(result).isEqualTo("default");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void move_forward(int parameter) {
        int before = car.getDistance();
        car.move(parameter);
        assertThat(car.getDistance()).isEqualTo(before + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void move_stop(int parameter) {
        int before = car.getDistance();
        car.move(parameter);
        assertThat(car.getDistance()).isEqualTo(before);
    }

    @Test
    void testToString() {
    }
}