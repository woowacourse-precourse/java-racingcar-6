package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static void validateCarListInputBlank(List<String> inputList) {
        for (String name : inputList) {
            validateCarNameBlank(name);
        }
    }

    public static void validateCarNameBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름은 비어있을 수 없습니다.");
        }
    }

    public static void validateCarListInputLength(List<String> inputList) {
        for (String name : inputList) {
            validateCarNameLength(name);
        }
    }

    public static void validateCarNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateCarListInputUnique(List<String> inputList) {
        Set<String> seen = new HashSet<>();
        for (String name : inputList) {
            if (seen.contains(name)) {
                throw new IllegalArgumentException();
            }
            seen.add(name);
        }
    }
}
