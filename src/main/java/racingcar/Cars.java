package racingcar;

import java.util.List;

public class Cars {

    List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void movePosition() {
        carList = carList.stream()
                .map(Car::movePosition)
                .toList();
    }

    public List<Car> getWinner() {
        int maxValue = carList.stream().mapToInt(Car::getPosition).max().getAsInt();
        return carList.stream()
                .filter(car -> car.getPosition() == maxValue)
                .toList();
    }
}
