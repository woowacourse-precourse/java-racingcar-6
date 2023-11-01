package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

class Race {
    private final List<Car> cars;
    private final int attempts;

    public Race(List<Car> cars, int attempts) {
        this.cars = cars;
        this.attempts = attempts;
    }

    public void start() {
        for (int i = 0; i < attempts; i++) {
            moveCars();
            printRaceState();
        }
    }

    public List<String> getWinners() {
        int farthestDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getDistance() == farthestDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void moveCars() {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.move();
            }
        }
    }

    private void printRaceState() {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }
}
