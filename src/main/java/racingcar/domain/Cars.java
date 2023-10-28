package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> names, MovingStrategy movingStrategy) {
        validateDuplicateName(names);
        this.cars = createCars(names, movingStrategy);
    }

    public void raceAllCars() {
        for (Car car : cars) {
            car.goForward();
        }
    }


    public Integer findWinnerPosition() {
        List<Car> sorted = cars.stream()
                .sorted()
                .collect(Collectors.toList());

        return sorted.get(sorted.size()-1).getPosition();
    }

    public List<Car> findWinner(Integer winnerPosition) {
        return cars.stream()
                .filter(car -> car.isWinner(winnerPosition))
                .collect(Collectors.toList());
    }



    private List<Car> createCars(List<String> names, MovingStrategy movingStrategy) {
        return names.stream()
                .map(name -> new Car(movingStrategy, name, 0))
                .collect(Collectors.toList());
    }

    private void validateDuplicateName(List<String> names) {
        if (names.stream()
                .collect(Collectors.toSet()).size() != names.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름으로 차를 생성할 수 없습니다.");
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }


}
