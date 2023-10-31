package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.utils.RandomNumberPicker;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {

    private final List<Car> cars;

    private final OutputView outputView;

    private final InputView inputView;

    private int trialNumber;

    private static final int FORWARD_CONDITION = 4;
    private static final int LOWER_BOUND_OF_NUMBER = 1;
    private static final int UPPER_BOUND_OF_NUMBER = 9;

    public Game(OutputView outputView, InputView inputView) {
        cars = new ArrayList<>();
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        outputView.printStartMessage();
        registerCars();
        this.trialNumber = inputView.readTrialNumber();
        for (int i = 0; i < trialNumber; i++) {
            moveCars();
        }
    }

    private void registerCars() {
        List<String> namesOfCars = inputView.readNamesOfCars();
        for (String name : namesOfCars) {
            cars.add(Car.getInstance(name));
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            if (carShouldMoveForward()) {
                car.moveForward();
            }
        }
    }

    private boolean carShouldMoveForward() {
        return RandomNumberPicker.pickNumber(LOWER_BOUND_OF_NUMBER, UPPER_BOUND_OF_NUMBER) >= FORWARD_CONDITION;
    }
}
