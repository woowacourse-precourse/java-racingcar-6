package controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import model.Attempts;
import model.Car;
import model.Cars;
import model.MovingCount;
import model.Name;
import view.InputView;
import view.OutputView;

public class RacingController {

    private static final int MINIMUM_NUMBER = 4;

    public void start() {
        Cars cars = new Cars(convertNameToCar());
        Attempts attempts = new Attempts(InputView.getAttemptsFromUserInput());

        OutputView.displayResult();
        for (int i = 0; i < attempts.getAttempts(); i++) {
            cars.updateMovingCount(MINIMUM_NUMBER);
            OutputView.displayCurrentRacingStatus(cars);
        }
        OutputView.displayFinalWinner(cars);
        Console.close();
    }

    private List<Car> convertNameToCar() {
        return InputView.getCarsNameFromUserInput().stream()
                .map(name -> new Car(new Name(name), new MovingCount(0)))
                .collect(Collectors.toList());
    }
}
