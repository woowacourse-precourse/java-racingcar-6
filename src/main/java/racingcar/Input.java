package racingcar;

import java.util.List;

public class Input {
    private List<String> carList;
    private Integer trialNumber;

    public Input(List<String> carList, Integer trialNumber) {
        this.carList = carList;
        this.trialNumber = trialNumber;
    }

    public List<String> getCarList() {
        return carList;
    }

    public Integer getTrialNumber() {
        return trialNumber;
    }
}