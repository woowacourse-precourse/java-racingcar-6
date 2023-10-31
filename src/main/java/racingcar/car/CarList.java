package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private List<Car> cars;

    public CarList(List<String> carNames) {
        this.cars = new ArrayList<>();
        createCarList(carNames);
    }

    private void createCarList(List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            cars.add(createCar(carNames.get(i)));
        }
    }

    private Car createCar(String carName) {
        return new Car(carName);
    }

    public List<Car> getCarList() {
        return this.cars;
    }
}
