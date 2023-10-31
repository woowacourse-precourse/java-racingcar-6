package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CarList {

    private final List<Car> cars;

    public CarList(CarNameList carNameList) {
        this.cars = carNameList.stream()
                .map(Car::new)
                .toList();
    }

    public void moveEach(List<Integer> randomNumbers) {
        int size = size();
        for (int i = 0; i < size; i++) {
            cars.get(i)
                    .move(
                            randomNumbers.get(i)
                    );
        }
    }

    public int size() {
        return cars.size();
    }

    public List<String> calculateWinner() {
        return cars
                .stream()
                .filter(c ->
                        c.getDistance() == getMaxDistance()
                )
                .map(Car::getName)
                .toList();
    }

    private int getMaxDistance() {
        int zero = 0;
        Optional<Integer> maxDistance = cars.stream()
                .max(Comparator.comparing(Car::getDistance))
                .map(Car::getDistance);
        return maxDistance.orElse(zero);

    }

    public GameResult createResult() {
        GameResult result = new GameResult();
        cars.forEach(result::note);
        return result;
    }
}
