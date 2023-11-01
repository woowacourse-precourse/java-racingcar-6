package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {


    public List<String> splitCarName(String carName) {
        return Arrays.stream(carName.split(",")).toList();
    }


    public List<String> judgeWinner(List<Car> cars) {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(Integer.MIN_VALUE);
        return cars.stream().filter(car -> car.getPosition() == maxPosition).map(Car::getName)
                .collect(Collectors.toList());
    }


}
