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

    private void checkDuplicateName(List<CarInfo> carList){
        Set<String> duplicator = new HashSet<>();

        for (CarInfo car : carList) {
            String carName = car.getName();
            if (!duplicator.add(carName)) {
                throw new IllegalArgumentException("자동차 이름 증복 오류");
            }
        }
    }

    private void checkListNull(List<CarInfo> carList){
        if (carList.isEmpty()) {
            throw new IllegalArgumentException("경주할 자동차 비존재 오류");
        }
    }
}
