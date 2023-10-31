package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {
    Car car;

    @BeforeEach
    void setup(){
        car = new Car("name");
    }

    @Test
    void move() {
        int beforeMove = car.getDistance();

        car.move();

        assertThat(car.getDistance()).isEqualTo(++beforeMove);
    }

    @Test
    void getName() {
        String result = car.getName();

        assertThat(result).isEqualTo("name");
    }

    @Test
    void getDistance() {
        int result = car.getDistance();

        assertThat(result).isEqualTo(0);
    }

    @Test
    void compareTo() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("name1"));
        cars.add(new Car("name2"));
        cars.get(1).move();
        String moveCar = cars.get(1).getName();

        Collections.sort(cars, Collections.reverseOrder());

        assertThat(cars.get(0).getName()).isEqualTo(moveCar);
    }
}