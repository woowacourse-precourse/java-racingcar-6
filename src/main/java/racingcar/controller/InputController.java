package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.DataValidator;

public class InputController {
    private static final String BLANK_DELIMITER = ",";
    private final DataValidator dataValidator;

    public InputController() {
        this.dataValidator = new DataValidator();
    }

    public String readData() {
        return Console.readLine();
    }

    public String[] inputCarNames() {
        String[] carNames = readData().split(BLANK_DELIMITER);
        dataValidator.validateCarName(carNames);
        return carNames;
    }

    public int inputTrialNumber() {
        String trialNumber = readData();
        dataValidator.validateTrialNumber(trialNumber);
        return Integer.parseInt(trialNumber);
    }
}
