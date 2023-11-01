package racingcar.car;

import racingcar.Constant;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidateCar {
    public static void validator(List<CarInfo> carList) {
        checkNameLength(carList);
        checkDuplicateName(carList);
        checkListNull(carList);
    }

    private static void checkNameLength(List<CarInfo> carList){
        for (CarInfo carName : carList) {
            if (carName.getName().length() > Constant.CAR_NAME_LAST_LENGTH || carName.getName().length() < Constant.CAR_NAME_START_LENGTH) {
                throw new IllegalArgumentException("자동차 이름 길이 오류");
            }
        }
    }

    private static void checkDuplicateName(List<CarInfo> carList){
        Set<String> duplicator = new HashSet<>();

        for (CarInfo car : carList) {
            String carName = car.getName();
            if (!duplicator.add(carName)) {
                throw new IllegalArgumentException("자동차 이름 증복 오류");
            }
        }
    }

    private static void checkListNull(List<CarInfo> carList){
        if (carList.isEmpty()) {
            throw new IllegalArgumentException("경주할 자동차 비존재 오류");
        }
    }
}
