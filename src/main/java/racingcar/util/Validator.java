package racingcar.util;

import java.util.List;

public class Validator {
    private static final Validator instance = new Validator();

    public static Validator getInstance() {
        return instance;
    }

    public void validateCarName(List<String> inputs) {
        checkNameCount(inputs);
        checkNameLength(inputs);
    }

    private void checkNameLength(List<String> inputs) {
        for (String input : inputs) {
            if (input.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 입력할 수 있습니다.");
            }
        }
    }

    private void checkNameCount(List<String> inputs) {
        if (inputs.size() < 2) {
            throw new IllegalArgumentException("경주를 위해서 2개 이상의 이름을 입력해주세요.");
        }
    }
}
