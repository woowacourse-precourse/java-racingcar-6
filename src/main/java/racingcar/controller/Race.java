package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Race {
    private final List<Car> cars = new ArrayList<>();
    private int moveCnt;
    public void run() {
        OutputView.printRacingStart();
        callCarNames();
        OutputView.printAskCount();
        moveCnt = getMoveCount();
    }

    private static int getMoveCount() {
        String userInput = InputView.userInput();
        return Integer.parseInt(userInput);
    }


    private void callCarNames() {
        String input = InputView.userInput();
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

}

