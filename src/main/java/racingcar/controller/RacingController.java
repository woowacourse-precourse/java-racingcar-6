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
        StringBuilder sb = new StringBuilder();
        if (racingCars.isCoFastestCars()) {
            createCoWinnerCarsName(winnerCars, sb);
        }
        if (!racingCars.isCoFastestCars()) {
            sb.append(winnerCars.get(0).provideCarStatus().get("name"));
        }
        outputView.printWinnerCars(sb.toString());
    }

    private String createCoWinnerCarsName(List<Car> winnerCars, StringBuilder sb) {
        for (int i = 0; i < winnerCars.size(); i++) {
            addSeperator(sb, i);
            sb.append(winnerCars.get(i).provideCarStatus().get("name"));
        }
        return sb.toString();
    }

    private void addSeperator(StringBuilder sb, int i) {
        if (i != 0) {
            sb.append(", ");
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
