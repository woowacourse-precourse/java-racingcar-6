package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static racingcar.app.RacingGameConst.*;

public class RacingGameValidator {

    public static void validateCarNameInput(final List<String> carNames) {
        validateCarNameInputEmpty(carNames);
        validateCarNameIncludeEmpty(carNames);
        validateCarNameDuplicate(carNames);
        for (int i = 0; i < carNames.size(); i++) {
            String name = carNames.get(i);
            validateCarNameEmpty(name);
            validateCarNameLength(name);
        }
    }

    private static void validateCarNameInputEmpty(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(NAMES_EMPTY_ERROR_MESSAGE);
        }
    }

    private static void validateCarNameIncludeEmpty(List<String> names) {
        Optional<String> emptyName = names.stream()
                .filter(s -> s.equals(""))
                .findAny();

        if (emptyName.isPresent()) {
            throw new IllegalArgumentException(NAMES_INCLUDE_EMPTY_ERROR_MESSAGE);
        }
    }


    private static void validateCarNameEmpty(final String name) {
        if (name.equals("")) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateCarNameLength(final String name) {
        if (name.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
        }
    }

    private static void validateCarNameDuplicate(final List<String> carNames) {
        Set<String> carNameSet = new HashSet<>(carNames);
        if (carNameSet.size() != carNames.size()) {
            throw new IllegalArgumentException("중복된 이름은 입력할 수 없습니다.");
        }
    }

    public static void validateTrial(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

    }
}
