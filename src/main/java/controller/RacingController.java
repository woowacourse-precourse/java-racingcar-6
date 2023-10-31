package controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import model.Attempts;
import model.Car;
import model.Cars;
import utils.Converter;
import view.InputView;
import view.OutputView;

public class RacingController {

    private static final int MINIMUM_NUMBER = 4;

    public void start() {
        List<Car> convertedCar = Converter.convertNameToCars(InputView.getCarsNameFromUserInput());
        Cars cars = new Cars(convertedCar);
        Attempts attempts = new Attempts(InputView.getAttemptsFromUserInput());

        OutputView.displayResult();
        for (int i = 0; i < attempts.getAttempts(); i++) {
            cars.updateMovingCount(MINIMUM_NUMBER);
            OutputView.displayCurrentRacingStatus(cars);
        }
        OutputView.displayFinalWinner(cars);
        Console.close();
    }
}
