package racingcar.domain;

import java.util.List;

public class Validator {
    public boolean checkCarNameLength(List<String> carNameList) {
        for (String carName : carNameList) {
            if (carName.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public boolean isForward(int number) {
        return number >= 4;
    }
}
