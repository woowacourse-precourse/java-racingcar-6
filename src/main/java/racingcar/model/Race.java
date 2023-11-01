package racingcar.model;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Race {

    private int roundCount;

    private final List<Car> cars;

    private final List<String> roundResult;

    public Race(
            List<Car> cars,
            final int roundCount
    ) {
        this.cars = cars;
        this.roundCount = roundCount;
        this.roundResult = new ArrayList<>();
    }

    public void play() {
        while (isRoundProgress()) {
            roundResult.add(getExecutionResult());
            repeatRace();
        }
    }

    public void repeatRace() {
        decreaseRoundCount();
        setCarNumber();
        addCarMovementCount();
        setCarMovementResult();
    }

    public void decreaseRoundCount() {
        this.roundCount--;
    }

    public void setCarMovementResult() {
        cars.forEach(Car::setMovementForwardResult);
    }

    public void setCarNumber() {
        cars.forEach(Car::setNumber);
    }

    public void addCarMovementCount() {
        cars.stream()
            .filter(car -> canMoveForward(car.getNumber()))
            .forEach(Car::setMovementCount);
    }

    public boolean canMoveForward(
            int number
    ) {
        return number > 3;
    }

    public boolean isRoundProgress() {
        return this.roundCount > 0;
    }

    public List<String> getWinners() {
        return cars.stream()
                .filter(car -> car.getMovementCount() == getMaxCount())
                .map(Car::getName)
                .toList();
    }

    public int getMaxCount() {
        return cars.stream()
                .mapToInt(Car::getMovementCount)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getExecutionResult() {
        return cars.stream()
                .map(Car::getMovementForwardResult)
                .collect(Collectors.joining("\n"));
    }
    public List<String> getExecutionResults() {
        return roundResult;
    }

    public String toString(List<String> list) {
        return String.join(", ", list);
    }
}
