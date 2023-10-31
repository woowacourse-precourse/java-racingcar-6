package racingcar.game;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.io.GameConsoleOutput;

public class Result {

    private final List<Car> cars;

    public Result(List<Car> cars) {
        this.cars = cars;
    }

    public void print() {
        int maxForwardCount = getMaxForwardCount();
        String result = getResult(maxForwardCount);
        GameConsoleOutput.print(String.format("최종 우승자 : %s", result));
    }

    private String getResult(int maxForwardCount) {
        return cars.stream()
                .filter(car -> car.getProgress().length() == maxForwardCount)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private int getMaxForwardCount() {
        return cars.stream()
                .mapToInt(car -> car.getProgress().length())
                .max()
                .orElse(-1);
    }
}
