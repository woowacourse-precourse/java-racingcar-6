package racingcar.controller.validator;

import java.util.Arrays;
import java.util.List;

public class UserInputValidator {

    public Integer validateRoundCount(String rawInput) {
        int roundCountInt;

        try {
            roundCountInt = Integer.parseInt(rawInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

        validateNumberUnderZero(roundCountInt);

        return roundCountInt;
    }

    public List<String> validateCarNames(String rawInput) {
        List<String> carNames = Arrays.stream(rawInput.split(","))
                .toList();

        validateCarNamesFormat(rawInput, carNames);

        for (String carName : carNames) {
            validateNameLength(carName);
        }

        return carNames;
    }

    private void validateCarNamesFormat(String rawInput, List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
        }

        int splitterCount = rawInput.length() - rawInput.replace(",","").length();
        if (carNames.size() != splitterCount + 1) {
            throw new IllegalArgumentException("구분자 ',' 뒤에는 이름이 위치해야 합니다.");
        }

        if(carNames.contains("")) {
            throw new IllegalArgumentException("이름은 빈칸일 수 없습니다.");
        }
    }

    private void validateNumberUnderZero(int roundCount) {
        if (roundCount < 0) {
            throw new IllegalArgumentException("이동 횟수는 0회 이상입니다.");
        }
    }

    private void validateNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 최대 5글자입니다.");
        }
    }

}
