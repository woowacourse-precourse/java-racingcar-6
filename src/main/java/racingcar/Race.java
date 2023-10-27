package racingcar;

import java.util.List;

public class Race {
    private final List<Cars> cars;
    private final int tryCount;

    public Race(List<Cars> cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void startRace() {
        for (int i = 0; i < tryCount; i++) {
            for (Cars car : cars) {
                car.move(new MoveStatus());
            }
        }
    }
}
