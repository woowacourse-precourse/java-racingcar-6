package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void advanceOrStop() {
        Car car = new Car("abc");
        for (int round = 0; round < 5; round++) {
            car.advanceOrStop();
        }
        Assertions.assertThat(car.getPosition()).isLessThanOrEqualTo(5);
        Assertions.assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
    }

    @Test
    void getName() {
        Car actual = new Car("abc");
        String expect = "abc";
        Assertions.assertThat(actual.getName()).isEqualTo(expect);
    }

    @Test
    void getPosition() {
        Car actual = new Car("abc");
        Integer expect = 0;
        Assertions.assertThat(actual.getPosition()).isEqualTo(expect);
    }

    @Test
    void testToString() {
        Car car = new Car("abc");
        for (int round = 0; round < 5; round++) {
            car.advanceOrStop();
        }
        String expect = "abc : " + "-".repeat(car.getPosition());
        Assertions.assertThat(car.toString()).isEqualTo(expect);
    }
}