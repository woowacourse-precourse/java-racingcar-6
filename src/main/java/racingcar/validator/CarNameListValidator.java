package racingcar.validator;

import java.util.Arrays;
import java.util.List;

public class CarNameListValidator extends Validator {

    @Override
    public void validate(String carNames) throws IllegalArgumentException {
        List<String> nameList = Arrays.stream(carNames.split(",")).toList();

        validateCarNamesLength(nameList);

        validateCarNamesBlank(nameList);

        validateCarNamesDuplicate(nameList);
    }

    private void validateCarNamesLength(List<String> names) {
        if (names.stream().anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException("경주할 자동차 이름의 길이는 5 이하여야 합니다.");
        }
    }

    private void validateCarNamesBlank(List<String> names) {
        if (names.stream().anyMatch(name -> name.contains(" "))) {
            throw new IllegalArgumentException("경주할 자동차 이름에 공백이 포함되면 안됩니다.");
        }
    }

    private void validateCarNamesDuplicate(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException("경주할 자동차 이름은 중복되면 안됩니다.");
        }
    }
}
