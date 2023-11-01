package racingcar.race;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.OutputView;

public class Race {
    private final List<Car> cars;
    private final int tryCount;
    private final MoveStatus moveStatus = new MoveStatus();

    public MoveStatus getMoveStatus() {
        return moveStatus;
    }

    public Race(List<Car> cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void startRace() {
        for (int i = 0; i < tryCount; i++) {
            carMove();
            OutputView.printRace(cars);
        }
    }

    private void carMove() {
        for (Car car : cars) {
            car.move(moveStatus);
        }
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
