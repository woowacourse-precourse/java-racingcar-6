package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.validation;

public class CarInfo {
    private final List<String> carName = new ArrayList<>();
    public void setCarName(String carName) {
        String[] splitStr = carName.split(",");
        Collections.addAll(this.carName, splitStr);
        for (String s : this.carName) {
            validation.checkCarName(s);
        }
    }
    public boolean isMove() {
        int randomNum = Randoms.pickNumberInRange(0,9);
        return randomNum >= 4;
    }
}
