package racingcarFPMVC;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;
    private final int tries;

    public Race(List<String> carNames, int tries) {
        this.cars = carNames.stream().map(Car::new).collect(Collectors.toList());
        this.tries = tries;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTries() {
        return tries;
    }

    public void moveCars() {
        cars.forEach(car -> car.move(Randoms.pickNumberInRange(0, 9)));
    }

    public List<String> findWinners() {
        int maxDistance = cars.stream().mapToInt(Car::getDistance).max().orElse(-1);
        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}