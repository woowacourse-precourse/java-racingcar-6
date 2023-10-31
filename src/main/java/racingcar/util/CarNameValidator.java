package racingcar.util;

import java.util.ArrayList;
import java.util.Collections;

public class CarNameValidator {

    private final String carNames;
    private final ArrayList<String> carList;

    public CarNameValidator(String carNames) {
        this.carNames = carNames;
        this.carList = new ArrayList<>();
        inputPatternValidate();
        splitNames();
        delimiterValidate();
        nameValidate();
    }

    private void inputPatternValidate() {
        if (!carNames.matches(Constant.REGEXP_CAR_NAME))
            throw new IllegalArgumentException();
    }

    private void splitNames() {
        Collections.addAll(carList, carNames.split(Constant.CAR_NAME_DELIMITER));
    }

    private void delimiterValidate() {
        if (carList.isEmpty() || carList.contains(Constant.BLANK) || carNames.endsWith(Constant.CAR_NAME_DELIMITER))
            throw new IllegalArgumentException();
    }

    private void nameValidate() {
        if (isStringOverLength() || !isDuplicateName())
            throw new IllegalArgumentException();
    }

    private boolean isStringOverLength() {
        return carList.stream().anyMatch(carName -> carName.length() > Constant.CAR_NAME_MAX_SIZE);
    }

    private boolean isDuplicateName() {
        return carList.size() == carList.stream().distinct().count();
    }


}
