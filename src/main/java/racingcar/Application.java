package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.Car;
import racingcar.game.Game;
import racingcar.game.GameResult;
import racingcar.utils.InputUtil;
import racingcar.utils.OutputUtil;

public class Application {
    public static void main(String[] args) {
        OutputUtil.printStartMessage();
        List<String> carNames = List.of(InputUtil.readCarNames());
        List<Car> cars = createCars(carNames);

        OutputUtil.printAttemptMessage();
        int attemptNumber = InputUtil.readAttemptNumber();

        Game game = new Game(cars, attemptNumber);
        game.start();

        GameResult gameResult = new GameResult(cars);
        List<Car> winners = gameResult.findWinners();

        OutputUtil.printWinners(winners);
    }

    private static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
