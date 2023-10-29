package racingcar.model.validator.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import racingcar.constants.GameInfo;
import racingcar.constants.Messages;
import racingcar.model.validator.InputValidator;

public class CarNameValidator implements InputValidator {

    private final List<String> carNameList;
    private final HashMap<String, Integer> carNameCount;

    public CarNameValidator(String carNamesInput) {
        this.carNameCount = new HashMap<>();
        this.carNameList = separateCars(validate(carNamesInput));
    }

    @Override
    public String validate(String input) {
        if (!input.matches(GameInfo.CAR_NAME_REGEX)){
            throw new IllegalArgumentException(Messages.INPUT_CAR_NAMES_ERROR.getMessage());
        };
        return input;
    }

    @Override
    public Object getValidatedInput() {
        return this.carNameList;
    }

    public List<String> separateCars(String carNamesInput) {
        List<String> tmpList = new ArrayList<>();
        for (String carName : carNamesInput.split(GameInfo.SEPARATOR)) {
            tmpList.add(handleDuplicatedCarName(carName));
        }
        return tmpList;
    }

    public String handleDuplicatedCarName(String carName) {
        int originCount = carNameCount.getOrDefault(carName, 0);
        carNameCount.put(carName, originCount + 1);
        if (originCount > 0) {
            carName += "_" + (originCount + 1);
        }
        return carName;
    }

}
