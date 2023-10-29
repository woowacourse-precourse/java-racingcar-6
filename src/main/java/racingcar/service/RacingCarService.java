package racingcar.service;

import racingcar.domain.*;
import racingcar.domain.dto.RunningCarRecord;
import racingcar.domain.dto.WinnerRecord;
import racingcar.domain.validator.InputValidator;
import racingcar.util.StringManipulator;

import java.util.List;

public class RacingCarService {
    private final Cars cars;
    private final Judge judge;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingCarService(Cars cars, Judge judge, RandomNumberGenerator randomNumberGenerator) {
        this.cars = cars;
        this.judge = judge;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void inputValidate(String input, InputValidator inputValidator) {
        inputValidator.validate(input);
    }

    public void insertCarNames(String carNames) {
        List<String> names = StringManipulator.split(carNames);
        cars.insertCarsNames(names);
    }
}
