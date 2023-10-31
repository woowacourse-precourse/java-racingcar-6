package racingcar.result;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.Car;
import racingcar.io.GameConsoleOutput;

public class RacingGameResult {

    private final List<Car> cars;

    public static RacingGameResult of(List<Car> cars) {
        return new RacingGameResult(cars);
    }

    private RacingGameResult(List<Car> cars) {
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
