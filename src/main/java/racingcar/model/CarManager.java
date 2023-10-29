package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.validation.ValidatorCars;

public class CarManager {
    ValidatorCars validator = new ValidatorCars();
    private List<Car> cars = new ArrayList<>();

    public void createAndAddCars(String[] names) {
        for (String name : names) {
            validator.isValid(name);
            cars.add(new Car(name));
        }
        Settings.setCarAmount(cars.size());
    }

    public int getBiggestMove() {
        int biggest = 0;

        for (Car car : cars) {
            if (biggest < car.getMoves()) {
                biggest = car.getMoves();
            }
        }
        return biggest;
    }

    public Car getCarFromIndex(int index) {
        return cars.get(index);
    }

}
