package racingcar.service;

import java.util.Set;

public class ValidCheck {
    public static void duplicate_check(Set<String> carList, String car) {
        if (carList.contains(car)) {
            throw new IllegalArgumentException();
        }
    }

    public static void nameSize_check(String car_name) {
        if (car_name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public static int moveTypeCheck(String move) {
        try {
            return Integer.parseInt(move);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}
