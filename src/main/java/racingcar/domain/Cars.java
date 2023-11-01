package racingcar.domain;

import racingcar.service.GameService;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carList) {
        this.cars = createCars(carList);
    }

    public void move() {
        for (Car car : cars) {
            car.move(GameService.generateRandomNumber());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    private List<Car> createCars(List<String> carList) {
        return carList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
