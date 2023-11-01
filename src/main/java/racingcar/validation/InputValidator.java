package racingcar.validation;

import racingcar.domain.Car;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static racingcar.Constants.CAR_NAME_MAX_LENGTH;

public class InputValidator {
    public static void validateCarName(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름이 "+CAR_NAME_MAX_LENGTH+"글자를 초과해선 안됩니다.");
        }

        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 비어있거나 공백입니다.");
        }
    }

    public static void validateMovement(String movementInput) {
        int movement = Integer.parseInt(movementInput);
        if (movement <= 0) {
            throw new IllegalArgumentException("시도횟수가 0 이하입니다.");
        }
    }

    public static void validateInputFormat(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException("입력형식이 올바르지 않습니다. 콤마(,)로 끝나면 안됩니다");
        }
    }

    public static void validateDuplicateCarNames(List<String> carNames){
        Set<String> carNameSet = new HashSet<>(carNames);
        if (carNameSet.size() != carNames.size()){
            throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
        }
    }

    public static void validateCarNamesSeparator(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)로만 구분해야 합니다.");
        }
        if (!input.matches("[a-zA-Z0-9, ]*")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,) 이외의 다른 문자로 구분되어서는 안 됩니다.");
        }

    }

    public static void validateMovementString(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력해야 합니다.", e);
        }
    }
}
