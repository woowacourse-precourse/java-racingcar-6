package racingcar.Controller;

import racingcar.ValidateInput;
import racingcar.view.InputView;


public class RacingController {
    private final static String DELIMITER = ",";

    public void start() {

        String[] carNames = getCarNames();


    }

    private String[] getCarNames() {
        String input = InputView.inputCarNames();
        ValidateInput.isRightInput(input);

        String[] carNames = input.split(DELIMITER);
        ValidateInput.isRightCarNames(carNames);

        return carNames;
    }


}
