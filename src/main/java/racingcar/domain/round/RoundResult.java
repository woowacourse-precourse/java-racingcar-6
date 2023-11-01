package racingcar.domain.round;

import java.util.Arrays;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;

public class RoundResult {

    private static final String MOVE_LOG = "-";
    private static final String SELECT = " : ";
    private int maxMoveCount = Integer.MIN_VALUE;
    private final Car[] cars;


    public RoundResult(Car[] cars) {
        this.cars = cars;
    }

    public String getRoundResult() {
        return Arrays.stream(cars)
            .map(car -> car.getName() + SELECT + getMileageResult(car.getMileage()) + "\n")
            .collect(Collectors.joining());
    }

    public String getMileageResult(int mileage) {
        maxMoveCount = Math.max(maxMoveCount, mileage);

        return MOVE_LOG.repeat(Math.max(0, mileage));
    }

    public int getMaxMoveCount() {
        return maxMoveCount;
    }
}