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

    private final InputView inputView;
    private final OutputView outputView;
    private static final int MINIMUM_NUMBER = 4;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        List<Car> convertedCar = Converter.convertNameToCars(inputView.getCarsNameFromUserInput());
        Cars cars = new Cars(convertedCar);
        Attempts attempts = new Attempts(inputView.getAttemptsFromUserInput());

        outputView.displayResult();
        for (int i = 0; i < attempts.getAttempts(); i++) {
            cars.updateMovingCount(MINIMUM_NUMBER);
            outputView.displayCurrentRacingStatus(cars);
        }
        outputView.displayFinalWinner(cars);
        Console.close();
    }
}
