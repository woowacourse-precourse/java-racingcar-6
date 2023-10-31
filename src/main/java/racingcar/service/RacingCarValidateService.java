package racingcar.service;

import racingcar.validator.InputCarNameValidator;
import racingcar.validator.InputNumberOfGameValidator;

public class RacingCarValidateService {
    private static final InputCarNameValidator inputCarNameValidator = new InputCarNameValidator();
    private static final InputNumberOfGameValidator inputNumberOfGameValidator = new InputNumberOfGameValidator();

    public void validateInputCarName(String inputCarNames) {
        inputCarNameValidator.validateCarName(inputCarNames);
    }
    public void validateInputNumberOfGame(String numberOfGame){
        inputNumberOfGameValidator.validateNumberOfGame(numberOfGame);
    }
}
