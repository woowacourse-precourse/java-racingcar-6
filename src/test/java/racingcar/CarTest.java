package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {


    @Test
    void increaseMovingCountTest() {
        Car car = new Car();

        int initialMovingCount = car.getMovingCount();
        assertThat(initialMovingCount).isEqualTo(0);

        car.increaseMovingCount();

        int increasedMovingCount = car.getMovingCount();
        assertThat(increasedMovingCount).isEqualTo(1);

    }

    @Test
    void toStringTest() {
        Car car = new Car();

        String result = car.toString();
        assertThat(result).isEqualTo("null");

        car.setName("woowa");

        result = car.toString();
        assertThat(result).isEqualTo("woowa");

    }

}