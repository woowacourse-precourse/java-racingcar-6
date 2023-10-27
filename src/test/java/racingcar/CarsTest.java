package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

final class CarsTest {

    @Test
    void Cars는_하나_이상의_Car를_가지지_않는경우_예외를_던진다() {
        List<Car> cars = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> new Cars(cars));
    }

    class Cars {

        List<Car> cars = new ArrayList<>();

        Cars(List<Car> cars) {
            this.cars = cars;
            if(cars.size() < 1) throw new IllegalArgumentException();
        }


    }
}
