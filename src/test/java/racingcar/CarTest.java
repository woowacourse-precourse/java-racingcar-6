package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {


    @Test
    void increaseMovingCount_메서드로_전진횟수_증가() {
        Car car = new Car();

        int initialMovingCount = car.getMovingCount();
        assertThat(initialMovingCount).isEqualTo(0);

        car.increaseMovingCount();

        int increasedMovingCount = car.getMovingCount();
        assertThat(increasedMovingCount).isEqualTo(1);

    }

    @Test
    void toString_메서드로_차량이름출력() {
        Car car = new Car();
        car.setName("woowa");

        String result = car.toString();
        assertThat(result).isEqualTo("woowa");

    }

    @Test
    void toString_메서드_사용시_자동차의_이름이_없는경우() {
        Car car = new Car();
        String result = car.toString();
        assertThat(result).isEqualTo("null");

    }

}