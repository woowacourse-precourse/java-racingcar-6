package racingcar.game;

import java.util.List;
import racingcar.car.Car;
import racingcar.io.GameConsoleOutput;
import racingcar.result.RacingGameResult;

public class RacingGame {

    private final List<Car> cars;
    private final int threshold;
    private final int attempt;
    private final String command;
    private final NumberGenerator numberGenerator;

    public static RacingGame of(List<Car> cars, int attemptInput, int threshold, String command,
                                NumberGenerator numberGenerator) {
        return new RacingGame(cars, attemptInput, threshold, command, numberGenerator);
    }

    private RacingGame(List<Car> cars, int attemptInput, int threshold, String command,
                       NumberGenerator numberGenerator) {
        this.cars = cars;
        this.attempt = attemptInput;
        this.threshold = threshold;
        this.command = command;
        this.numberGenerator = numberGenerator;
    }

    public RacingGameResult process() {
        GameConsoleOutput.print("실행 결과");
        doProcess();
        return RacingGameResult.of(cars);
    }

    private void doProcess() {
        int gameRound = 0;
        while (gameRound++ < attempt) {
            moveForward();
            showProcess();
        }
    }

    private void moveForward() {
        for (Car car : cars) {
            int randomNumber = numberGenerator.generate(0, 9);
            car.forward(threshold, randomNumber, command);
        }
    }

    private void showProcess() {
        for (Car car : cars) {
            car.showProgress();
        }
        GameConsoleOutput.print();
    }
}
