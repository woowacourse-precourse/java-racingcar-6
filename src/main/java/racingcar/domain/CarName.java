package racingcar.domain;

import static racingcar.constant.CarConstant.MAX_NAME_SIZE;
import static racingcar.constant.CarConstant.MIN_NAME_SIZE;
import static racingcar.constant.CarConstant.NAME_REGEX;

import racingcar.validator.Validator;

/*
 *   자동차의 이름 정보를 담당
 * */

public class CarName {
    private String name;

    public CarName(String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        Validator.commandLengthInRange(name, MIN_NAME_SIZE, MAX_NAME_SIZE);
        Validator.commandFollowRegex(name, NAME_REGEX);
    }

    public String getValue() {
        return name;
    }
}
