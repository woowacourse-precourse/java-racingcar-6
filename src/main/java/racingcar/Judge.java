package racingcar;

import java.util.List;
import java.util.Optional;

public class Judge {

    private List<Car> cars;

    public Judge(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> decideWinner() {
        int maxPoistion = getMaxPosition();

        List<Car> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPoistion)
                .toList();

        return winners;
    }

    private int getMaxPosition() {
        Optional<Integer> maxPoisition = cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo);
        return maxPoisition.get();
    }
}
