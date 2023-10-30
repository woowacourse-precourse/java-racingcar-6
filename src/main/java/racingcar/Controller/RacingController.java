package racingcar.Controller;

import racingcar.ValidateInput;
import racingcar.view.InputView;


public class RacingController {
    private final static String DELIMITER = ",";

    public void start() {

        String[] carNames = getCarNames();
        int trialNumber = getTrialNumber();


    }

    private String[] getCarNames() {
        String input = InputView.inputCarNames();
        ValidateInput.isNotNullOrEmpty(input);

        String[] carNames = input.split(DELIMITER);
        ValidateInput.isRightCarNames(carNames);

        return carNames;
    }

    private int getTrialNumber() {
        String input = InputView.inputTrialNumber();
        ValidateInput.isNotNullOrEmpty(input);
        ValidateInput.isNumeric(input);

        int trialNumber = Integer.parseInt(input);
        return trialNumber;
    }

}
