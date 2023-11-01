package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carList;


    private Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static Cars makeCarList(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public void move() {
        carList.forEach(Car::move);
    }

    public List<Car> getCarList() {
        return carList;
    }

    private int getMaxPosition() {
        return this.carList.stream().mapToInt(Car::getPosition).max().getAsInt();
    }

    private List<Car> getWinners() {
        return this.carList.stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .collect(Collectors.toList());
    }

    public String WinnersToString() {
        return getWinners().stream().map(Car::getCarName).collect(Collectors.joining(", "));
    }

}
