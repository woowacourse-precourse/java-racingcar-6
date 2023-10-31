package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.RacingGameController;

public class CarList {
    private final List<Car> carList = new ArrayList<>();

    public CarList(List<String> carNames) {
        carNames.forEach(carName -> carList.add(new Car(carName)));
    }

    public void moveAll() {
        carList.forEach(Car::move);
    }

    public void printAll() {
        carList.forEach(Car::print);
    }

    public List<String> getWinners() {
        int maxPosition = RacingGameController.getMaxPosition();
        return carList.stream()
            .filter(car -> isWinner(car.getPosition(), maxPosition))
            .map(Car::getCarName).collect(Collectors.toList());
    }

    public boolean isWinner(int position, int maxPosition) {
        return position == maxPosition;
    }

}
