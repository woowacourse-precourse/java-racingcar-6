package racingcar.service;

import racingcar.domain.validator.InputValidator;

public class RacingCarService {

    public void inputValidate(String input, InputValidator inputValidator) {
        inputValidator.validate(input);
    }
}
