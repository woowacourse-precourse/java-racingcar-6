package racingcar;

import car.Car;
import car.CarCollection;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarCollectionTest {

    @Test
    void addCar_자동차_추가() {
        CarCollection carCollection = new CarCollection();

        Car car1 = new Car("car1");
        Car car2 = new Car("car2");

        carCollection.addCar(car1);
        carCollection.addCar(car2);

        List<Car> cars = carCollection.getCars();

        assertThat(cars).contains(car1);
        assertThat(cars).contains(car2);
    }
}
