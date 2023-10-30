package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars assemble(List<String> inputCarNames, CarEngine carEngine) {
        List<Car> carList = inputCarNames.stream()
                .map(carName -> new Car(new CarName(carName), carEngine))
                .collect(Collectors.toList());
        return new Cars(carList);
    }

    public void move() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    public List<Car> getReadOnlyCarList() {
        return cars.stream()
                .map(car -> new Car(new CarName(car.getCarName()), car.getCarEngine(), new Position(car.getPosition())))
                .collect(Collectors.toUnmodifiableList());
    }
}
