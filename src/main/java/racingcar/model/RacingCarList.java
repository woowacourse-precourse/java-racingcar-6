package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCarList {
    private final List<String> carList = new ArrayList<>();

    public RacingCarList(List<String> carNameList) {
        for (String carName : carNameList) {
            validateDuplicate(carName);
            RacingCar racingCarInfo = new RacingCar(carName);
            carList.add(carName);
        }
    }

    private void validateDuplicate(String carName) {
        if (carList.contains(carName)) {
            throw new IllegalArgumentException();
        }
    }
}
