package racingcar.validator;


import java.util.Arrays;
import java.util.stream.Stream;

public class InputValidator {

    public void validateCarNameEmptyOrNull(String names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있으면 안됩니다.");
        }
    }

    public void validateCarNameLength(String names) {
        Stream<String> nameStream = Arrays.stream(names.split(",")).map(String::trim);

        nameStream.forEach(name -> {
            if (name.length() < 1 || name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름의 길이는 1에서 5 사이여야 합니다.");
            }
        });
    }
}
