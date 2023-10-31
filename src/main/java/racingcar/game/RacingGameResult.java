package racingcar.game;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.io.GameConsoleOutput;

public class RacingGameResult {

    private final List<Car> cars;

    public static RacingGameResult of(List<Car> cars) {
        return new RacingGameResult(cars);
    }

    private RacingGameResult(List<Car> cars) {
        this.cars = cars;
    }

    public String getWinner() {
        int maxForwardCount = getMaxForwardCount();
        return findWinner(maxForwardCount);
    }

    public void print() {
        String winner = getWinner();
        GameConsoleOutput.print(String.format("최종 우승자 : %s", winner));
    }

    private int getMaxForwardCount() {
        return cars.stream()
                .mapToInt(car -> car.getProgress().length())
                .max()
                .orElse(-1);
    }

    private String findWinner(int maxForwardCount) {
        return cars.stream()
                .filter(car -> car.getProgress().length() == maxForwardCount)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
