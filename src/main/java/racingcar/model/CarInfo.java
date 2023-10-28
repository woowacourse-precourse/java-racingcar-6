package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import org.w3c.dom.ls.LSInput;
import racingcar.util.validation;

public class CarInfo {
    private final List<String> carName = new ArrayList<>();
    private final List<Integer> carStatus = new ArrayList<>();
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
    public void updateCarStatus() {
        for (int i = 0; i < carName.size(); i++) {
            if(isMove()){
                int newValue = carStatus.get(i) + 1;
                carStatus.set(i, newValue);
            }
        }
    }
    public List<Integer> getCarStatus() {
        return carStatus;
    }

}
