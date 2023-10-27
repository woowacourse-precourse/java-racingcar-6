package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    public final List<Cars> cars;
    public final int tryCount;

    public Race(List<Cars> cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void startRace(ResultView resultView) {
        for (int i = 0; i < tryCount; i++) {
            for (Cars car : cars) {
                car.move(new MoveStatus());
            }
            resultView.printRace(cars);
        }
    }

    public List<Cars> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Cars::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
