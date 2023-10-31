package racingcar.domain;

import static racingcar.constant.CarConstant.MAX_NAME_SIZE;
import static racingcar.constant.CarConstant.MIN_NAME_SIZE;
import static racingcar.constant.CarConstant.NAME_REGEX;

import racingcar.validator.Validator;

public class CarName {
    private String name;

    public CarName(String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        // Validator.commandsSizeBiggerThan(0, carNames); 입력받은 이름임 없을때는
        Validator.commandLengthInRange(name, MIN_NAME_SIZE, MAX_NAME_SIZE);
        Validator.commandFollowRegex(name, NAME_REGEX);
    }

    public String getValue() {
        return name;
    }
}
