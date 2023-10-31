package racingcar.domain;

import static racingcar.view.Messages.REGISTER_CAR_MESSAGE;
import static racingcar.view.Messages.RESULT_MESSAGE;
import static racingcar.view.Messages.TRIAL_NUMBER_MESSAGE;
import static racingcar.view.Messages.WINNER_MESSAGE;

import java.util.ArrayList;
import java.util.List;
import racingcar.utils.Parser;
import racingcar.utils.RandomNumberPicker;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {

    private final List<Car> cars;
    private final Winners winners;
    private int trialNumber;
    private static final int MOVE_FORWARD_CONDITION_OF_CAR = 4;
    private static final int LOWER_BOUND_OF_RANDOM_NUMBER = 1;
    private static final int UPPER_BOUND_OF_RANDOM_NUMBER = 9;
    private static final String SPLITTER = ",";

    public Game() {
        cars = new ArrayList<>();
        winners = new Winners();
    }

    public void run() {
        registerCars();
        readTrialNumber();
        moveCarsAndShowResults();
        findWinners();
        showWinners();
    }

    private void showWinners() {
        OutputView.print(WINNER_MESSAGE);
        OutputView.print(winners.toString());
    }

    private void moveCarsAndShowResults() {
        OutputView.println(RESULT_MESSAGE);
        for (int i = 0; i < trialNumber; i++) {
            moveCars();
            showResult();
        }
    }

    private void readTrialNumber() {
        OutputView.println(TRIAL_NUMBER_MESSAGE);
        this.trialNumber = Parser.stringToInteger(InputView.readValue());
    }

    private void showResult() {
        OutputView.printNewLine();
        for (Car car : cars) {
            OutputView.println(car.toString());
        }
    }

    private void findWinners() {
        int locationOfWinner = findLocationOfWinner();
        for (Car car : cars) {
            if (car.getLastLocation() == locationOfWinner) {
                car.addToWinner(winners);
            }
        }
    }

    private int findLocationOfWinner() {
        int maxArrivalPoint = 0;

        for (Car car : cars) {
            maxArrivalPoint = Math.max(maxArrivalPoint, car.getLastLocation());
        }

        return maxArrivalPoint;
    }

    private void registerCars() {
        OutputView.println(REGISTER_CAR_MESSAGE);

        List<String> namesOfCars = Parser.stringToStringList(InputView.readValue(), SPLITTER);

        for (String name : namesOfCars) {
            cars.add(new Car(name));
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            if (shouldMoveForward()) {
                car.moveForward();
            }
        }
    }

    private boolean shouldMoveForward() {
        return RandomNumberPicker.pickNumber(LOWER_BOUND_OF_RANDOM_NUMBER,
                UPPER_BOUND_OF_RANDOM_NUMBER) >= MOVE_FORWARD_CONDITION_OF_CAR;
    }
}
