package racingcar.errorCheck;

import java.util.HashSet;
import java.util.Set;

public class ErrorCheck {
    public static void isCarNameFive(String[] cars) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].length() > 5) {
                throw new IllegalArgumentException("차 이름 길이가 5이하가 아닙니다");
            }
        }
    }
    public static void isDuplicationNameCar(String[] cars) {
        Set<String> set = new HashSet<String>();
        for (int i =0; i < cars.length; i++) {
            set.add(cars[i]);
        }
        if (set.size() != cars.length) {
            throw new IllegalArgumentException("중복된 이름이 있습니다");
        }

    }

}
