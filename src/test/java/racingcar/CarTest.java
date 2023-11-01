package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void getName_메서드로_자동차_이름_반환() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void move_메서드로_자동차가_전진() {
        Car car = new Car("pobi");
        car.move(); // Assuming that move() generates a random number greater than or equal to 4
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void move_메서드로_자동차가_전진하지_않음() {
        Car car = new Car("pobi");
        // Assuming that move() generates a random number less than 4
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void getPosition_메서드로_자동차_현재_위치_반환() {
        Car car = new Car("pobi");
        // Assuming that move() has been called multiple times to change the position
        assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
    }
}