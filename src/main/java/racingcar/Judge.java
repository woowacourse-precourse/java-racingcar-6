package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Judge {

    private List<Car> cars;

    public Judge(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> decideWinner() {
        Optional<Integer> maxPoistion = cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo);

        List<Car> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPoistion.get())
                .toList();

        return winners;
    }
}
