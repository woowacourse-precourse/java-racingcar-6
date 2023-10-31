package racingcar.repository;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {

    private CarRepository() {}

    private static class CarRepositoryCreater {
        private static final CarRepository INSTANCE = new CarRepository();
    }

    public static CarRepository getInstance() { return CarRepositoryCreater.INSTANCE; }

    private List<Car> cars;

    public void createCars(List<String> carNames) {
        this.cars = carNames.stream().map(carName -> new Car(carName)).collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
