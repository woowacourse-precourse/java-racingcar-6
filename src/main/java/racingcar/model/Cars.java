package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private static final int MINIMUM_RANDOM_NUMBER = 0;
    private static final int MAXIMUM_RANDOM_NUMBER = 9;
    private static final int STANDARD_NUMBER = 4;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = copyList(cars);
    }

    public static Cars of(String names, String delimiter) {
        return new Cars(Arrays.stream(names.split(delimiter))
                .map(Car::new)
                .toList());
    }

    private List<Car> copyList(List<Car> cars) {
        return cars.stream()
                .map(car -> {
                    String name = car.getName();
                    int forwardCount = car.getForwardCount();
                    return new Car(name, forwardCount);
                }).toList();
    }

    public List<Car> copyList() {
        return copyList(cars);
    }

    public void race() {
        cars.forEach(car -> {
            if (Randoms.pickNumberInRange(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER) >= STANDARD_NUMBER) {
                car.moveForward();
            }
        });
    }

    public List<String> findWinners() {
        int maximumForwardCount = findMaximumForwardCount();
        return new ArrayList<>(cars.stream()
                .filter(car -> car.getForwardCount() == maximumForwardCount)
                .map(Car::getName)
                .toList());
    }

    private int findMaximumForwardCount() {
        return cars.stream()
                .map(Car::getForwardCount)
                .max(Integer::compare)
                .orElseThrow();
    }
}
