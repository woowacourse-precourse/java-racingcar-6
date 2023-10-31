package racingcar.domain;

import static racingcar.view.Messages.REGISTER_CAR_MESSAGE;

import java.util.ArrayList;
import java.util.List;
import racingcar.utils.Parser;
import racingcar.utils.RandomNumberPicker;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {

    private final List<Car> cars;

    private int trialNumber;

    private static final int MOVE_FORWARD_CONDITION_OF_CAR = 4;
    private static final int LOWER_BOUND_OF_RANDOM_NUMBER = 1;
    private static final int UPPER_BOUND_OF_RANDOM_NUMBER = 9;

    public Game() {
        cars = new ArrayList<>();
    }

    public void run() {
        registerCars();

        this.trialNumber = Parser.stringToInteger(InputView.readValue());
        for (int i = 0; i < trialNumber; i++) {
            moveCars();
        }
    }

    private void registerCars() {
        OutputView.println(REGISTER_CAR_MESSAGE);

        List<String> namesOfCars = Parser.stringToStringList(InputView.readValue(), ",");

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
        return RandomNumberPicker.pickNumber(LOWER_BOUND_OF_RANDOM_NUMBER,
                UPPER_BOUND_OF_RANDOM_NUMBER) >= MOVE_FORWARD_CONDITION_OF_CAR;
    }
}
