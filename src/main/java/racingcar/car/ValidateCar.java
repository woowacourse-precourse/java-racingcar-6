package racingcar.car;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidateCar {
    private static final int START_LENGTH = 1;
    private static final int LAST_LENGTH = 5;

    private void checkNameLength(List<CarInfo> carList){
        for (CarInfo carName : carList) {
            if (carName.getName().length() > LAST_LENGTH || carName.getName().length() < START_LENGTH) {
                throw new IllegalArgumentException("자동차 이름 길이 오류");
            }
        }
    }
}
