package racingcar.dto;

import java.util.HashMap;
import java.util.List;

public class RacingStatus {
    HashMap<String, String> carList = new HashMap<String, String>();
    int numberOfAttempt;

    public String getCarPosition(String carName) {
        return carList.get(carName);
    }

    public int getNumberOfAttempt() {
        return numberOfAttempt;
    }

    public void setCarList(List<String> carNames){
        for (String carName : carNames) {
            carList.put(carName, "");
        }
    }
    public void setCarPosition(String key){
        String oldPosition = carList.get(key);
        carList.replace(key, oldPosition + "-");
    }

    public void setNumberOfAttempt(int numberOfAttempt){
        this.numberOfAttempt = numberOfAttempt;
    }
}
