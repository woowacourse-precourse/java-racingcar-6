package racingcar.service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidCheck {
    public static void duplicate_check(Set<String> carList, String car) {
        if (carList.contains(car)) {
            throw new IllegalArgumentException();
        }
    }

    public static void emptyName_check(String car_name) {

        if (car_name.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (car_name.charAt(0) == ',' || car_name.charAt(car_name.length() - 1) == ',') {
            throw new IllegalArgumentException();
        }

        if (car_name.contains(",,")) {
            throw new IllegalArgumentException();
        }
    }

    public static void nameSpace_check(String car_name) {
        char[] splitCarName = car_name.toCharArray();
        Set<Character> spaceCheck = new HashSet<>();

        for (char c : splitCarName) {
            spaceCheck.add(c);
        }
        String name = spaceCheck.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        if (name.equals(" ")) {
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
