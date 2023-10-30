package racingcar;

import java.util.List;

public class InputValidator {
    public static void validateNamesIsEmpty(String[] input) {
        for (String name : input) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("입력 값이 없습니다. 프로그램 종료");
            }
        }
    }

    public static void validateNameContainSpace(String[] input) {
        for (String name : input) {
            if (name.contains(" ")) {
                throw new IllegalArgumentException("이름 사이에 공백이 있습니다. 프로그램 종료");
            }
        }
    }

    public static void validateNameLength(String[] input) {
        for (String name : input) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름의 길이가 5초과 됩니다. 프로그램 종료");
            }
        }
    }

    public static void duplicateName(List<Car> cars) {

    }

    public static void notNumber(int number) {

    }
}