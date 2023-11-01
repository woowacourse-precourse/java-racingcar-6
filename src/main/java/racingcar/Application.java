package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.Car;
import racingcar.game.Game;
import racingcar.game.GameResult;
import racingcar.utils.InputUtil;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = List.of(InputUtil.readCarNames());
        List<Car> cars = createCars(carNames);

        int attemptNumber = InputUtil.readAttemptNumber();

        Game game = new Game(cars, attemptNumber);
        game.start();

        GameResult gameResult = new GameResult(cars);
        List<Car> winners = gameResult.findWinners();

        printWinners(winners);
    }

    private static void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    private static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
