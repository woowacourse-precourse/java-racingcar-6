package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;

    public Race(List<String> carNames) {
        checkDuplicateNames(carNames);
        this.cars = carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    public static void checkDuplicateNames(List<String> names) {
        Set<String> nameSet = new HashSet<>();
        for (String name : names) {
            if (!nameSet.add(name)) {
                throw new IllegalArgumentException("Duplicate name");

            }
        }
    }

    public void playRound() {
        cars.forEach(Car::move);
    }

    public void printProgress() {
        cars.forEach(car -> {
            System.out.println(car.getName() + " : " + car.getPositionInString());
        });
        System.out.println();
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}