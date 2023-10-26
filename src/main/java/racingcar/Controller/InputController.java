package racingcar.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class InputController {
    private static final Pattern CAR_NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9,]+$");
    private static final String DELIMITER = ",";

    public List<String> getCarNames() {
        while (true) {
            String input = InputView.carInput();
            if (isValidCarNamesInput(input)) {
                List<String> carNames = splitInput(input);
                if (isValidCarNamesList(carNames)) {
                    return carNames;
                }
            }
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
        }
    }

    private List<String> splitInput(String input) {
        return new ArrayList<>(List.of(input.split(DELIMITER)));
    }

    private boolean isValidCarNamesInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력이 없습니다.");
        }
        if (!CAR_NAME_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("입력에 문자, 숫자, 쉼표 외의 문자가 포함되어 있습니다.");
        }
        return true;
    }

    private boolean isValidCarNamesList(List<String> carNames) {
        return !hasEmptyName(carNames) && !hasLongName(carNames) && !hasDuplicateName(carNames);
    }

    private boolean hasEmptyName(List<String> carNames) {
        if (carNames.stream().anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException("자동차 이름 길이가 0인 경우가 있습니다.");
        }
        return false;
    }

    private boolean hasLongName(List<String> carNames) {
        if (carNames.stream().anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException("자동차 이름 길이가 5자를 초과하는 경우가 있습니다.");
        }
        return false;
    }

    private boolean hasDuplicateName(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException("동일한 이름이 있는 경우가 있습니다.");
        }
        return false;
    }
}
