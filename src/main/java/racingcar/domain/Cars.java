package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public List<String> findWinners() {
        Car farthestCar = findFarthestCar();
        return findCoWinner(farthestCar);
    }

    private Car findFarthestCar() {
        return carList.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("차량 리스트가 비었습니다."));
    }

    private List<String> findCoWinner(Car farthestCar) {
        return carList.stream()
                .filter(farthestCar::isSamePosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

}
