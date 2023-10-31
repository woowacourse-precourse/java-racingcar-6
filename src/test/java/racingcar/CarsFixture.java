package racingcar;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarsFixture {
    private final Cars cars;

    private CarsFixture() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("First"));
        carList.add(new Car("Secon"));
        carList.add(new Car("Third"));

        this.cars = new Cars(carList);
    }

    public static CarsFixture fixture() {
        return new CarsFixture();
    }

    public Cars build() {
        return cars;
    }
}
