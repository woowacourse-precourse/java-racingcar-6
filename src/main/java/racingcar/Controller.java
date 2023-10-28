package racingcar;

import java.util.List;

public class Controller {
    private final View view;
    private final RacingGame racingGame;

    public Controller(View view, RacingGame racingGame) {
        this.view = view;
        this.racingGame = racingGame;
    }

    public void start() {
        Cars cars = generateCars();
        attemptForward(cars, setAttemptCount());
        printWinners(cars);
    }

    private Cars generateCars() {
        view.printNameInputMessage();
        return createCars(racingGame.inputCarNames(readFromConsole()));
    }

    private Cars createCars(List<Car> cars) {
        return new Cars(cars);
    }

    private int setAttemptCount() {
        view.printAttemptCountInputMessage();
        return new AttemptCount(readFromConsole()).getAttemptCount();
    }

    private String readFromConsole() {
        return view.inputConsole();
    }

    private void attemptForward(Cars cars, int count) {
        view.printAttemptResultMessage();

        for (int current = 0; current < count; current++) {
            cars.attemptForward();
            view.printCurrentCarsResult(cars);
        }
    }

    private void printWinners(Cars cars) {
        view.printFinalWinnerMessage(getWinners(findWinningCars(cars)));
    }

    private String getWinners(List<Car> winningCars) {
        return racingGame.printCarName(winningCars).getResultMessage();
    }

    private List<Car> findWinningCars(Cars cars) {
        return cars.findWiiningCars();
    }
}
