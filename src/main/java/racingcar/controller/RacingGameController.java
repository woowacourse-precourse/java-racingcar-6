package racingcar.controller;

import java.util.List;
import racingcar.controller.mapper.CarNameMapper;
import racingcar.model.CarName;
import racingcar.validation.NameValidator;

public class RacingGameController {

    private CarNameMapper carNameMapper;
    private NameValidator nameValidator;

    public RacingGameController() {
        this.carNameMapper = new CarNameMapper();
        this.nameValidator = new NameValidator();
    }

    public void setCarName(String carNames) {
        // convert String to CarName
        List<CarName> carNameGroup = carNameMapper.toCarName(carNames);
        // validate
        for (CarName name : carNameGroup) {
            nameValidator.validate(name);
        }
        // make Car

    }

    public void setAttempts(String attempts) {
        // validation
        // save attempts
    }

    public void startGame() {

    }
}
