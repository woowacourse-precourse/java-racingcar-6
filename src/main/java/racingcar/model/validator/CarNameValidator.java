package racingcar.model.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import racingcar.constants.GameInfo;
import racingcar.constants.Messages;

public class CarNameValidator {

    private final List<String> carNameList;
    private final HashMap<String, Integer> carNameCount;

    public CarNameValidator(String carNamesInput) {
        this.carNameList = separateCars(validateCarNames(carNamesInput));
        this.carNameCount = new HashMap<>();
    }

    public List<String> getCarNames() {
        return this.carNameList;
    }

    public List<String> separateCars(String carNamesInput) {
        List<String> tmpList = new ArrayList<>();
        for (String carName : carNamesInput.split(GameInfo.SEPARATOR)) {
            tmpList.add(handleDuplicatedCarName(carName));
        }
        return tmpList;
    }

    public String validateCarNames(String carNamesInput) {
        if (!carNamesInput.matches(GameInfo.CAR_NAME_REGEX)){
            throw new IllegalArgumentException(Messages.INPUT_CAR_NAMES_ERROR.getMessage());
        };
        return carNamesInput;
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
