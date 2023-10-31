package racingcar.exception;

import java.util.ArrayList;
import java.util.List;

public class InputNameException {
    static final int NAME_LENGTH = 5;

    public void checkLength(String input) {
        if (input.length() > NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
        }
    }

    public void checkDuplication(List<String> name, String[] input, int index) {
        if (name.contains(input[index])) {
            throw new IllegalArgumentException("자동차의 이름은 중복될 수 없습니다.");
        }
        name.add(input[index]);
    }

    public void checkException(String[] input) {
        List<String> name = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            checkLength(input[i]);
            checkDuplication(name, input, i);
        }
    }
}
