package racingcar.controller;

import racingcar.domain.CarRacingGame;
import racingcar.model.Car;
import racingcar.repository.CarRepository;
import racingcar.utils.InputValidator;
import racingcar.utils.StringUtils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private final InputView inputview;
    private final OutputView outputView;
    private final CarRacingGame carRacingGame;
    private final CarRepository carRepository;

    public RacingController() {
        inputview = new InputView();
        outputView = new OutputView();
        carRacingGame = new CarRacingGame();
        carRepository = new CarRepository();
    }

    public void playCarRacingGame() {
        String inputCars = inputview.readInputCars();
        int trialNumber = inputview.readTrialNumber();

        preprocessInput(inputCars);
         playEachRacing(trialNumber);
        // StringBuilder winners = formatWinnersList();
        // outputView.printWinners(winners.toString());
    }

    private void preprocessInput(String inputCars) {
        String[] carArray = StringUtils.splitByComma(inputCars);
        InputValidator.checkValidStringLength(carArray);

        carRacingGame.saveCars(carArray);
    }

    private void playEachRacing(int trialNumber) {
        for (int i = 0; i < trialNumber; i++) {
            List<Car> cars = carRepository.findAll();
            carRacingGame.eachCarRacing();
            outputView.printEachRacingResult(cars, cars.size());
        }
    }
}
