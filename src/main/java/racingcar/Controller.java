package racingcar;

import java.util.List;

public class Controller {
    private final View view;
    private final RacingGame racingGame;
    private Cars cars;

    public Controller(View view, RacingGame racingGame) {
        this.view = view;
        this.racingGame = racingGame;
    }

    public void start() {
        generateCars();
        attemptForward(setAttemptCount());
        printWinners();
    }

    private void generateCars() {
        view.printNameInputMessage();
        cars = new Cars(racingGame.inputCarNames(readFromConsole()));
    }

    private int setAttemptCount() {
        view.printAttemptCountInputMessage();
        return new AttemptCount(readFromConsole()).getAttemptCount();
    }

    private String readFromConsole() {
        return view.inputConsole();
    }

    private void attemptForward(int count) {
        view.printAttemptResultMessage();

        for (int current = 0; current < count; current++) {
            cars.attemptForward();
            view.printCurrentCarsResult(cars);
        }
    }

    private void printWinners() {
        view.printFinalWinnerMessage(getWinners(findWinningCars()));
    }

    private String getWinners(List<Car> winningCars) {
        return racingGame.printCarName(winningCars).getResultMessage();
    }

    private List<Car> findWinningCars() {
        return cars.findWiiningCars();
    }
}
