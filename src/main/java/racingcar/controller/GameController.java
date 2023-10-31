package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Name;
import racingcar.utils.CarListValidator;
import racingcar.utils.GeneratedRandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private static List<Car> cars;
    private static int attempts;

    public static void start() {

        cars = getCars(inputCarName());
        CarListValidator.validate(cars);
        attempts = inputAttempts();

        finalResult();
        while (attempts != 0) {
            play();
            attempts--;
        }
        finishGame();
        Console.close();
    }

    private static int inputAttempts() {
        return Integer.parseInt(InputView.attempts());
    }

    private static String inputCarName() {
        return InputView.carsName();
    }

    private static void finalResult() {
        OutputView.executionResult();
    }

    private static void play() {
        for (Car car : cars) {
            car.addPosition(GeneratedRandomNumber.getNumber());
        }

        OutputView.resultPerAttempt(cars);
        System.out.println();
    }

    private static void finishGame() {
        FindWinnerController findWinnerController = new FindWinnerController(cars);
        OutputView.winner(findWinnerController.getWinners());
    }

    private static List<Car> getCars(final String cars) {
        List<Car> convertCars = new ArrayList<>();

        for (String carName : cars.split(",")) {
            convertCars.add(new Car(new Name(carName)));
        }

        return convertCars;
    }
}
