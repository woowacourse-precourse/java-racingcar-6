package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static void validateCarListInputBlank(List<String> inputList) {
        for (String name : inputList) {
            validateCarInputBlank(name);
        }
    }

    public static void validateCarInputBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름은 비어있을 수 없습니다.");
        }
    }

    public static void validateCarListInputLength(List<String> inputList) {
        for (String name : inputList) {
            validateCarInputLength(name);
        }
    }

    public static void validateCarInputLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
