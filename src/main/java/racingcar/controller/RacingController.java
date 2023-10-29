package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.utils.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    TrialController trialController = new TrialController();
    InputValidator inputValidator = new InputValidator();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    private final Cars racingCars = new Cars();

    public void proceedRacing() {
        List<String> validCarNames;
        int validTrialTimes;
        List<Car> winnerCars;

        validCarNames = getValidCarNames();
        validTrialTimes = getValidTrialTimes();
        initCars(validCarNames);
        proceedRacingTrials(validTrialTimes);
        winnerCars = racingCars.calculateFastestCar();
        printWinnerCar(winnerCars);
    }

    private List<String> getValidCarNames() {
        String carsNameInput = inputView.askCarsName();
        String preprossedInputNames = inputValidator.preprocessInputString(carsNameInput);
        return inputValidator.validateCarsNameInput(preprossedInputNames);
    }

    private int getValidTrialTimes() {
        String trialTimesInput = inputView.askTrialTimes();
        String preprossedInputTrialTimes = inputValidator.preprocessInputString(trialTimesInput);
        return inputValidator.validateTrialTimesInput(preprossedInputTrialTimes);
    }

    private void initCars(List<String> validCarsName) {
        for (String carName : validCarsName) {
            racingCars.addCar(new Car(carName));
        }
    }

    private void proceedRacingTrials(int trialTimes) {
        for (int i = 0; i < trialTimes; i++) {
            trialController.applyTrialResult(racingCars);
            printTrialResults();
        }
    }

    private void printWinnerCar(List<Car> winnerCars) {
        StringBuilder winnerCarsName = new StringBuilder();
        if (racingCars.isCoFastestCars()) {
            String createdCoWinnerCarsName = createCoWinnerCarsName(winnerCars, winnerCarsName);
            winnerCarsName.append(createdCoWinnerCarsName);
        }
        winnerCarsName.append(winnerCars.get(0).provideCarStatus().get("name"));
        outputView.printWinnerCars(winnerCarsName.toString());
    }

    private String createCoWinnerCarsName(List<Car> winnerCars, StringBuilder winnerCarsName) {
        for (int i = 0; i < winnerCars.size(); i++) {
            addSeperator(winnerCarsName, i);
            winnerCarsName.append(winnerCars.get(0).provideCarStatus().get("name"));
        }
        return winnerCarsName.toString();
    }

    private void addSeperator(StringBuilder winnerCarsName, int i) {
        if (i != 0) {
            winnerCarsName.append(", ");
        }
    }

    private void printTrialResults() {
        for (Car racingCar : racingCars.provideRacingCars()) {
            String carName = (String) racingCar.provideCarStatus().get("name");
            int carPosition = (int) racingCar.provideCarStatus().get("position");
            outputView.printTrialResult(carName, carPosition);
        }
    }
}
