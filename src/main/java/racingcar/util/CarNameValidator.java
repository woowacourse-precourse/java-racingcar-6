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
    }

    private void inputPatternValidate() {
        if (!carNames.matches("^[0-9a-zA-Zㄱ-ㅎ가-힣,]*$"))
            throw new IllegalArgumentException();
    }

    private void splitNames() {
        Collections.addAll(carList, carNames.split(","));
    }

    private void delimiterValidate() {
        if(carList.isEmpty() || carList.contains("") || carNames.endsWith(",")) throw new IllegalArgumentException();
    }


}
