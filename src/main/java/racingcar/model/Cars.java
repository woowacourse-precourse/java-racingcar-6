package racingcar.model;

import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> stringCars) {
        this.cars = stringCars.stream()
                .map(carName->new Car(carName))
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return cars.toString();
    }
}
