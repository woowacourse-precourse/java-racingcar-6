package racingcar.Domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private Cars cars;
    private Result(Cars cars) {
        this.cars = cars;
    }
    public static Result of(Cars cars) {
        return new Result(cars);
    }

    public List<String> getWinner() {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();
        cars.getCars().forEach((s) -> {
            if (s.getPosition() == maxPosition) {
                winners.add(s.getName());
            }
        });
        return winners;
    }

    public int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars.getCars()) {
            if (maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
}
