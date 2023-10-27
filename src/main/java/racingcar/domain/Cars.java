package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.Utils;

public record Cars(List<Car> carList) {
    public void moveRandomly() {
        carList.forEach(car -> {
            if (Utils.isTrueWithProbability60Percent()) {
                car.moveForward();
        }});
    }

    public List<Car> getWinnerList() {
        Integer maxPosition = carList.stream().map(Car::getPosition)
                .max(Comparator.naturalOrder())
                .orElse(0);
        return carList.stream()
                    .filter(car -> car.getPosition() == maxPosition)
                    .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return carList.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }

}
