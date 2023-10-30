package racingcar.domain;

import racingcar.util.Utils;
import racingcar.validation.Validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarName {
    private final List<String> carNameStrList;
    public CarName(String carNameStr) {
        Validation.validateEmptyInput(carNameStr);
//        carNameStrList = Arrays.asList(carNameStr.split(","));
        carNameStrList = Utils.stringToStringList(carNameStr);
        Validation.validateLength(carNameStrList);
        Validation.validateNameLength(carNameStrList);
        Validation.validateUnique(carNameStrList);
    }

    public List<String> getCarNameStrList() {
        return carNameStrList;
    }


}
