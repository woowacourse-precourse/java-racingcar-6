package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void getName() {
        Car car = new Car("name");
        assertThat(car.getName()).contains("name");
    }

    @Test
    void testToString() {
        Car car = new Car("name");
        assertThat(car.toString()).contains("name : ");
    }
}