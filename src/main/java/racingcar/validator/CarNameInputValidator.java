package racingcar.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameInputValidator implements BasicValidator<String> {
    @Override
    public void validate(String input) {
        isInputEmpty(input);
        hasMoreThanTwoCars(input);
        isCarNameLengthValid(input);
        hasCommaAtEnd(input);
        hasDuplicateCarNames(input);
        hasSpecialChar(input);
    }

    public void isInputEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다.");
        }
    }

    public void hasMoreThanTwoCars(String input) {
        String[] carNames = input.split(",");
        if (carNames.length < 2) {
            throw new IllegalArgumentException("자동차 이름은 최소 2개 이상이어야 합니다.");
        }
    }

    public void isCarNameLengthValid(String input) {
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            if (carName.isEmpty() || carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름의 길이는 1자 이상, 5자 이하여야 합니다.");
            }
        }
    }

    public void hasCommaAtEnd(String input) {
        if (input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException("입력값은 쉼표로 시작하거나 끝나면 안됩니다.");
        }
    }

    public void hasDuplicateCarNames(String input) {
        String[] carNames = input.split(",");
        List<String> carNameList = Arrays.asList(carNames);
        Set<String> uniqueCarNames = new HashSet<>(carNameList);

        if (uniqueCarNames.size() < carNameList.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복되면 안됩니다.");
        }
    }

    public void hasSpecialChar(String input) {
        if (input.matches(".*[^a-zA-Z0-9,].*")) {
            throw new IllegalArgumentException("입력값에 특수문자를 입력하면 안됩니다.");
        }
    }
}
