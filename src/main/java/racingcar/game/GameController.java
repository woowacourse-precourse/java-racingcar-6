package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.car.Car;
import racingcar.car.CarFactory;
import racingcar.view.CarView;
import racingcar.view.ResultView;

public class GameController {
    private GameController() {
    }

    private static List<Car> cars;

    public static void start() {
        inputCarName();
        inputMoveCount();
        ResultView.printWinnerMessage(cars);
    }

    private static void inputCarName() {
        CarView.printCarCreateMessage();
        cars = CarFactory.createCar(Console.readLine());
    }

    private static void inputMoveCount() {
        CarView.printCarMoveMessage();
        int inputMoveCount = Integer.parseInt(Console.readLine());
        moveCar(inputMoveCount);
    }



    private static void moveCar(int inputMoveCount) {
        for (int tryCount = 0; tryCount < inputMoveCount; tryCount++) {
            for (Car car : cars) {
                car.move();
            }

            ResultView.printResultCoverMessage();
            ResultView.printMoveResultMessage(cars);
        }
    }
}
