package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.regex.Pattern;
import racingcar.car.Car;
import racingcar.car.CarFactory;
import racingcar.view.CarView;
import racingcar.view.ResultView;

public class GameController {
    private static final Pattern NON_DIGIT = Pattern.compile("^(-|0|\\D)");

    private GameController() {
    }

    private static List<Car> cars;

    public static void start() {
        CarView.printCarCreateMessage();
        inputCarName();
        CarView.printCarMoveMessage();
        moveCar(inputMoveCount());
        ResultView.printWinnerMessage(cars);
    }

    private static void inputCarName() {
        cars = CarFactory.createCar(Console.readLine());
    }

    private static int inputMoveCount() {
        String inputMoveCount = Console.readLine();
        validateInputMoveCount(inputMoveCount);

        return Integer.parseInt(inputMoveCount);
    }

    private static void validateInputMoveCount(String inputMoveCount) {
        validateEmptyInputMoveCount(inputMoveCount);
        validateDigitInputMoveCount(inputMoveCount);
    }

    private static void validateEmptyInputMoveCount(String inputMoveCount) {
        if (inputMoveCount.length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDigitInputMoveCount(String inputMoveCount) {
        if (NON_DIGIT.matcher(inputMoveCount).find()) {
            throw new IllegalArgumentException();
        }
    }

    private static void moveCar(int inputMoveCount) {
        ResultView.printResultCoverMessage();

        for (int tryCount = 0; tryCount < inputMoveCount; tryCount++) {
            moveCar();
            ResultView.printMoveResultMessage(cars);
        }
    }

    private static void moveCar() {
        for (Car car : cars) {
            car.move();
        }
    }
}
