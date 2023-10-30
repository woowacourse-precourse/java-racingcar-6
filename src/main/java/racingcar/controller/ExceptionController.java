package racingcar.controller;

import java.util.HashMap;

public class ExceptionController {

    public static void carNameMaxLengthException(String[] carNameArr) {
        for (String userCar : carNameArr) {
            if (userCar.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5글자를 초과할 수 없습니다.");
            }
        }
    }

    public static void carNameDuplicateException(HashMap<String, String> carName, String[] carNameArr) {
        if (carName.size() != carNameArr.length) {
            throw new IllegalArgumentException("중복된 이름의 차량이 존재합니다.");
        }
    }

}
