package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Cars;
import racingcar.service.Service;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.stream.IntStream;

public class Controller {
    private Cars cars;
    private int numberOfTrial;

    public void run() {
        setCars();
        setTrialNumber();
        playRacing();
        showWinners();
    }

    private void setCars() {
        InputView.printCarNames();
        String UserCars = Console.readLine();
        cars = Service.setCars(UserCars);
    }

    private void setTrialNumber() {
        InputView.printNumberOfTrial();
        String trialNumber = Console.readLine();
        numberOfTrial = Service.setTrialNumber(trialNumber);
    }

    private void playRacing() {
        OutputView.printPlayResult();
        IntStream.range(0, numberOfTrial).forEach(i -> cars.playRacing());
    }

    private void showWinners() {
        cars.showWinners();
    }
}
