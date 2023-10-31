package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.DataValidator;
import racingcar.view.InputView;

public class InputController {

    private static final String COMMA_DELIMITER = ",";
    private final DataValidator dataValidator;
    private final InputView inputView;

    public InputController() {
        this.dataValidator = new DataValidator();
        this.inputView = new InputView();
    }

    public String[] inputCarNames() {
        inputView.showGameStartMessage();
        String[] carNames = readData().split(COMMA_DELIMITER);
        dataValidator.validateCarName(carNames);
        return carNames;
    }

    public int inputTrialNumber() {
        inputView.showTrialNumberInputMessage();
        String trialNumber = readData();
        dataValidator.validateTrialNumber(trialNumber);
        return Integer.parseInt(trialNumber);
    }

    private String readData() {
        return Console.readLine();
    }

}
