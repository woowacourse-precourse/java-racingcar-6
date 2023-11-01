package racingcar.domain.car;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Movable;

public class Cars {
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void oneRoundProgress(Movable movable) {
        carList.forEach(car -> car.goForward(movable));
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> getWinners() {
        int maxDistance = getMaxDistance();

        return carList.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toList());
    }

    private int getMaxDistance() {
        int maxDistance = carList.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("차량 목록이 없습니다."));
        return maxDistance;
    }
}
