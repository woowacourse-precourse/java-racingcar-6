package racingcar;

import java.util.List;
import racingcar.model.Car;

public class Validation {

    public static void duplication(List<String> nameList, String name) {
        if (nameList.contains(name)) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public static void empty(List<Car> carList) {
        if (carList.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 1개 이상 있어야 합니다.");
        }
    }

    public static void nameLength(String name) {
        if (name.length() > 5 || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 5자 이내로 지어야 합니다.");
        }
    }

    public static void isNumber(String input) {
        int number;

        try {
            number = Integer.parseInt(input);

        } catch (Exception e) {
            throw new IllegalArgumentException("숫자 값만 입력해야 합니다.");
        }

        if (number < 0) {
            throw new IllegalArgumentException("0 이상의 횟수를 입력해야 합니다.");
        }
    }

    public static void nullInEnd(String input) {
        if (input.charAt(input.length()-1) == ',') {
            throw new IllegalArgumentException("마지막 자동차 이름이 비었습니다.");
        }
    }
}
