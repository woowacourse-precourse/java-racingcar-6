package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {
    private static final int BASELINE_MOVE_OR_STOP = 4;

    public boolean judgeMoveOrStop(int num) {
        return num >= BASELINE_MOVE_OR_STOP;
    }

    public List<String> judgeWinners(List<Car> cars, int max) {
        return cars.stream()
                .filter(car -> car.getTotalMoveLen() == max)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}