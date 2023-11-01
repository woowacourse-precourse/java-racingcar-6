package racingcar.dto;

import racingcar.constant.GameConfig;

import static racingcar.validator.Validator.*;

public class CarNameRequst {
    private final String name;

    public CarNameRequst(final String name){
        validateLength(name, GameConfig.CAR_NAME.getLimitLength());
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
