package racingcar.validation;

import static racingcar.constant.ValidationConstants.MAX_LENGTH_OF_NAME;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NameInputValidation {

    public void isUnderFiveLetters(String input) {
        if (input.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void isExistName(String[] input) {
        List<String> inputList = Arrays.asList(input);
        Set<String> inputSet = new HashSet<>(inputList);
        if (inputList.size() != inputSet.size()) {
            throw new IllegalArgumentException("중복된 이름을 입력할 수 없습니다.");
        }
    }
}
