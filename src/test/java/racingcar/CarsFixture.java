package racingcar;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.Name;

import java.util.ArrayList;
import java.util.List;

public class CarsFixture {
    private final Cars cars;

    private CarsFixture() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(new Name("First")));
        carList.add(new Car(new Name("Secon")));
        carList.add(new Car(new Name("Third")));

        this.cars = new Cars(carList);
    }

    public static CarsFixture fixture() {
        return new CarsFixture();
    }

    public Cars build() {
        return cars;
    }
}
