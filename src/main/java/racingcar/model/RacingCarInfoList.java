package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCarInfoList {
    private final List<String> carList = new ArrayList<>();

    public RacingCarInfoList(List<String> carNameList) {
        for (String carName : carNameList) {
            validateDuplicate(carName);
            RacingCarInfo racingCarInfo = new RacingCarInfo(carName);
            carList.add(carName);
        }
    }

    private void validateDuplicate(String carName) {
        if (carList.contains(carName)) {
            throw new IllegalArgumentException();
        }
    }
}
