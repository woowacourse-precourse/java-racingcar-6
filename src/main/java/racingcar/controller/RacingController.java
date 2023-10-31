package racingcar.controller;

import java.util.List;
import racingcar.service.ValidationService;
import racingcar.view.InputView;

public class RacingController {

    ValidationService validationService = new ValidationService();
    InputView inputView = new InputView();

    public void startRacing() {
        List<String> carNames = getCarNameList();
        int trialCount = getTrialCount();

    }

    private List<String> getCarNameList() {
        String carNames = inputView.insertCarName();
        List<String> validatedCarNames = validationService.checkCarNames(carNames);
        return validatedCarNames;
    }

    private int getTrialCount() {
        String inputTrialCount = inputView.insertTrialCount();
        int trialCount = validationService.checkTrialCount(inputTrialCount);
        return trialCount;
    }

}
