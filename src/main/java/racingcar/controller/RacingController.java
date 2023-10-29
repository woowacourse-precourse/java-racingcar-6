package racingcar.controller;

import racingcar.utils.InputValidator;
import racingcar.view.InputView;

import java.util.List;

public class RacingController {
    InputValidator inputValidator = new InputValidator();
    InputView inputView = new InputView();

    public void proceedRacing() {
        List<String> validCarNames;
        int validTrialTimes;

        validCarNames = getValidCarNames();
        validTrialTimes = getValidTrialTimes();
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
}
