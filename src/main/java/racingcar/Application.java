package racingcar;

import static racingcar.Constant.ENTER_ATTEMPT_MESSAGE;
import static racingcar.Constant.ENTER_CAR_NAMES_MESSAGE;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static InputView inputView;
    private static OutputView outputView;
    private static List<String> carNames;
    private static List<Car> cars;
    private static int attemptCount;

    public static void main(String[] args) {
        init();
        getUserInput();
        getRacingCars();
        gameStart();
    }

    private static void init() {
        UserInputException userInputException = new UserInputException();
        inputView = new InputView(userInputException);
        outputView = new OutputView();
    }

    private static void getUserInput() {
        outputView.println(ENTER_CAR_NAMES_MESSAGE);
        carNames = inputView.getCarName();
        outputView.println(ENTER_ATTEMPT_MESSAGE);
        attemptCount = inputView.getAttemptCount();
    }

    private static void getRacingCars() {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    private static void gameStart() {
        RacingGame racingGame = new RacingGame(cars, attemptCount, outputView);
        racingGame.gameStart();
    }
}
