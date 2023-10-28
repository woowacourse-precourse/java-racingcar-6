package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("move()와 toString()")
    void car_move_toString() {
        // given
        Car carA = new Car("car");
        Car carB = new Car("race");

        // when
        carA.move();
        carA.move();
        carA.move();

        // then
        assertThat(carA.toString()).isEqualTo("car : ---");
        assertThat(carB.toString()).isEqualTo("race : ");
    }

    @Test
    @DisplayName("compareTo() 테스트")
    void car_compareTo() {
        // given
        Car carA = new Car("carA");
        Car carB = new Car("carB");
        Car carC = new Car("carC");
        Car carD = new Car("carC");

        List<Car> cars = new ArrayList<>();
        cars.add(carA);
        cars.add(carB);
        cars.add(carC);
        cars.add(carD);

        // when
        carA.move();
        carA.move();
        carB.move();
        carB.move();
        carB.move();
        carC.move();

        // then
        assertThat(Collections.max(cars)).isEqualTo(carB);
    }
}