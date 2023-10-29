package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.utils.InputValidator;
import racingcar.view.InputView;

import java.util.List;

public class RacingController {
    TrialController trialController = new TrialController();
    InputValidator inputValidator = new InputValidator();
    InputView inputView = new InputView();
    private final Cars racingCars = new Cars();

    public void proceedRacing() {
        List<String> validCarNames;
        int validTrialTimes;

        validCarNames = getValidCarNames();
        validTrialTimes = getValidTrialTimes();
        initCars(validCarNames);
        proceedRacingTrials(validTrialTimes);
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
        }
    }
}
