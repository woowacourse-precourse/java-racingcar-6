package racingcar.implementation;

import java.util.*;

public class ValidChecker {
    public static void isAlphabetic(String car) {
        for (int i = 0; i < car.length(); i++) {
            if (!(97 <= car.charAt(i) && car.charAt(i) <= 122)) {
                throw new IllegalArgumentException("알파벳 소문자가 아닌 값이 입력됐습니다.");
            }
        }
    }

    public static void isDuplicated(List<String> carList) {
        Set<String> carSet = new HashSet<>();

        for (String car : carList) {
            if (carSet.contains(car)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 입력됐습니다..");
            } else {
                carSet.add(car);
            }
        }
    }

    public static ArrayList<String> carListCheck(String input) {
        ArrayList<String> carList = new ArrayList<>(Arrays.stream(input.split(",")).toList());
        Iterator<String> iterator = carList.iterator();

        while (iterator.hasNext()) {
            String car = iterator.next();
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 다섯 글자 이하만 가능합니다.");
            }
        }
        return carList;
    }

    public static int numberOfTryCheck(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
    }
}
