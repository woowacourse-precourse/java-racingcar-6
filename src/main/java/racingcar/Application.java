package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.controller.GameController;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        try {
            ConsoleView consoleView = new ConsoleView();
            List<String> carNames = getCarNames(consoleView);
            List<Car> cars = Car.createCars(carNames);
            int numberOfAttempts = getNumberOfAttempts(consoleView);
            consoleView.printMessage("");

            RacingGame racingGame = new RacingGame(cars);
            GameController gameController = new GameController(racingGame, consoleView);
            gameController.playGame(numberOfAttempts);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private static List<String> getCarNames(ConsoleView consoleView) {
        consoleView.printMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNamesArray = Console.readLine().split(",");
        return Arrays.asList(carNamesArray);
    }

    private static int getNumberOfAttempts(ConsoleView consoleView) {
        consoleView.printMessage("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}