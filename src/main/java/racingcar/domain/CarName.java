package racingcar.domain;

import racingcar.util.Utils;
import racingcar.validation.Validation;

import java.util.List;

public class CarName {
    private final List<String> carNameStrList;

    public CarName(String carNameStr) {
        Validation.validateEmptyInput(carNameStr);
        carNameStrList = Utils.stringToStringList(carNameStr);
        Validation.validateLength(carNameStrList);
        Validation.validateNameLength(carNameStrList);
        Validation.validateUnique(carNameStrList);
    }

    public List<String> getCarNameStrList() {
        return carNameStrList;
    }
}
