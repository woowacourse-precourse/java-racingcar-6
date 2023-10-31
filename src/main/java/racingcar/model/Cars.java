package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carList = new ArrayList<>();

    public void initCars(List<String> carNames) {
        carNames.stream()
                .map(name -> new Car(new Name(name), new Position()))
                .forEach(carList::add);
    }

    public List<String> doRound() {
        go();
        return roundResult();
    }

    public void go() {
        carList.forEach(Car::go);
    }

    public List<String> roundResult() {
       return carList.stream()
                .map(Car::positionToString)
                .collect(Collectors.toList());
    }

    public int maxDistance() {
        Optional<Integer> maxPositionOptional = carList.stream()
                .map(Car::position)
                .max(Comparator.naturalOrder());

        return maxPositionOptional.orElse(0);
    }

    public List<Car> checkWinner() {
        int maxDistance = maxDistance();
        return carList.stream()
                .filter(car -> car.position() == maxDistance)
                .collect(Collectors.toList());
    }
}
