package racingcar.validator;

import racingcar.util.Utils;

import java.util.List;
import java.util.regex.Pattern;

public class CarNameValidator {
    private final String carNames;
    public final List<String> carNameList;

    public CarNameValidator(String carNames) {
        this.carNames = carNames;
        this.carNameList = Utils.toList(carNames);
        validate();

    }

    public void validate() {
        isNameValid();
        isNameDuplicated();
        isNameWithinRange();
    }

    public void isNameWithinRange() {
        if (carNameList.stream().anyMatch(name -> name.length() > 5 || name.isEmpty())) {
            throw new IllegalArgumentException("자동차의 이름은 1~5자이어야 합니다.");
        }
    }

    public void isNameValid() {
        Pattern pattern = Pattern.compile(".*[^a-zA-Z0-9 ,].*");
        if (pattern.matcher(carNames).matches()) {
            throw new IllegalArgumentException("쉼표 외의 특수문자를 입력하시면 안됩니다.");
        }
    }

    public void isNameDuplicated() {
        if (carNameList.stream().distinct().count() != carNameList.size()) {
            throw new IllegalArgumentException("자동차의 이름은 중복되지 않아야 합니다.");
        }
    }
}
