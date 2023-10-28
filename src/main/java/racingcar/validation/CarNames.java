package racingcar.validation;

import java.util.Arrays;
import java.util.List;

public class CarNames {
    List<String> splitNames(String in) {
        return Arrays.asList(in.split(",", -1));
    }

    void checkBlankInput(String in) throws IllegalArgumentException {
        List<String> names = splitNames(in);
        names.stream().forEach(name -> {
            if (isBlankName(name)) {
                throw new IllegalArgumentException("공백 입력입니다.");
            }
        });
    }

    boolean isBlankName(String name) {
        return name.trim().isEmpty();
    }

    void checkNameLength(String in) throws IllegalArgumentException {
        List<String> names = splitNames(in);
        names.stream().forEach(name -> {
            if (isLongName(name)) {
                throw new IllegalArgumentException("이름 길이가 5를 초과합니다.");
            }
        });
    }

    boolean isLongName(String name) {
        return name.length() > 5;
    }
}
