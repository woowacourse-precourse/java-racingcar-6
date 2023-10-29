package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private String name;
    private Car car;

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
        car.move(parameter);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void move_stop(int parameter) {
        car.move(parameter);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,default,default : ", "1,default,default : -", "2,default,default : --"},
                ignoreLeadingAndTrailingWhitespace = false)
    void testToString(int distance, String name, String expected) {
        int forwardNumber = 5;

        for (int i = 0; i < distance; i++) {
            car.move(forwardNumber);
        }

        assertThat(car.getDistance()).isEqualTo(distance);
        assertThat(car.getName()).isEqualTo(name);

        String result = car.toString();
        assertThat(result).isEqualTo(expected);
    }
}