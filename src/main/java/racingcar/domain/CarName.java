package racingcar.domain;

import java.util.List;
import racingcar.constraint.Constraint;
import racingcar.utils.Utils;

public class CarName {
    private final List<String> carNameList;

    public CarName(String carNameStr) {
        Constraint.constraintEmptyInput(carNameStr);
        carNameList = Utils.stringToStringList(carNameStr);
        Constraint.constraintLength(carNameList);
        Constraint.constraintNameLength(carNameList);
        Constraint.constraintUnique(carNameList);
    }

    public List<String> getCarNameList() {
        return carNameList;
    }
}
