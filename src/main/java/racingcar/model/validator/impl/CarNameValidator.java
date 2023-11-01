package racingcar.model.validator.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.constants.GameInfo;
import racingcar.constants.Messages;
import racingcar.model.validator.CommonValidator;
import racingcar.model.validator.InputValidator;

public class CarNameValidator implements InputValidator {

    private final List<String> carNameList;
    private final HashMap<String, Integer> carNameCount;

    public CarNameValidator(String carNamesInput) {
        this.carNameCount = new HashMap<>();
        this.carNameList = separateCars(carNamesInput);
    }

    @Override
    public String validate(String input) {
        if (!CommonValidator.validateCarNameLength(input)) {
            throw new IllegalArgumentException(Messages.ERROR_CAR_NAMES_LENGTH.getMessage());
        }
        if (!CommonValidator.validateCarNameUnderBar(input)) {
            throw new IllegalArgumentException(Messages.ERROR_CAR_NAMES_UNDER_BAR.getMessage());
        }
        if (!CommonValidator.validateCarNameBlank(input)) {
            throw new IllegalArgumentException(Messages.ERROR_CAR_NAMES_BLANK.getMessage());
        }
        return input;
    }

    @Override
    public Object getValidatedInput() {
        return this.carNameList;
    }

    public List<String> separateCars(String carNamesInput) {
        return Arrays.stream(carNamesInput.split(GameInfo.SEPARATOR))
            .map(this::validate)
            .map(this::handleDuplicatedCarName)
            .collect(Collectors.toList());
    }

    public String handleDuplicatedCarName(String carName) {
        int originCount = carNameCount.getOrDefault(carName, 0);
        carNameCount.put(carName, originCount + 1);
        if (originCount > 0) {
            carName += GameInfo.CAR_DUPLICATED_SEPARATOR + (originCount + 1);
        }
        return carName;
    }

}
