package racingcar.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RacingStatus {

    HashMap<String, String> carList = new HashMap<String, String>();
    int numberOfAttempt;
    List<String> carNames = new ArrayList<String>();

    public List<String> getCarNames() {
        return carNames;
    }

    public String getCarPosition(String carName) {
        return carList.get(carName);
    }

    public int getNumberOfAttempt() {
        return numberOfAttempt;
    }

    public void setCarNames(List<String> carNames) {
        this.carNames = carNames;
    }

    public void setCarList() {
        for (String carName : carNames) {
            carList.put(carName, "");
        }
    }

    public void moveCarPosition(String key) {
        String oldPosition = carList.get(key);
        carList.replace(key, oldPosition + "-");
    }

    public void setNumberOfAttempt(int numberOfAttempt) {
        this.numberOfAttempt = numberOfAttempt;
    }
}
