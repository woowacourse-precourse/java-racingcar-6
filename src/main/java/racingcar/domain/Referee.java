package racingcar.domain;

import java.util.List;

public class Referee {

    public String getWinner(List<Car> cars) {
        int max = cars.stream().mapToInt((car) -> car.getDistnace().length()).max().getAsInt();
        List<String> carNames = cars.stream().filter((car) -> car.getDistnace().length() == max)
                .map(Car::getName).toList();
        return String.join(", ", carNames);
    }
}
