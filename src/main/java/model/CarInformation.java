package model;

import java.util.List;

public class CarInformation {
    private static List<String> carNames;
    private static List<Integer> carForwardCount;

    public void setCarNames(List<String> carNames) {
        CarInformation.carNames = carNames;
    }

    public void setCarForwardCount(List<Integer> carForwardCount) {
        CarInformation.carForwardCount = carForwardCount;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public List<Integer> getCarForwardCount() {
        return carForwardCount;
    }
}
