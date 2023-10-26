package controller;

import camp.nextstep.edu.missionutils.Randoms;
import model.Car;
import model.Cars;
import view.InputView;
import view.OutputView;

public class RacingController {
    private static final int MIN_RANGE_NUMBER = 1;
    private static final int MAX_RANGE_NUMBER = 9;
    private static final int MINIMUM_NUMBER = 4;
    private Cars cars;

    public void playGame() {
        String[] carNames = InputView.getCarsNameFromUserInput();
        int attempt = InputView.getAttemptsFromUserInput();
        cars = new Cars(carNames);

        OutputView.displayResult();
        for (int i = 0; i < attempt; i++) {
            carsPickRandomNumber();
            OutputView.displayCurrentRacingStatus(cars);
        }
        OutputView.displayFinalWinner(cars);
    }

    private void carsPickRandomNumber() {
        for (Car car : cars.getCars()) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER);
            car.increaseMovingCountIfGreater(MINIMUM_NUMBER, randomNumber);
        }
    }
}
