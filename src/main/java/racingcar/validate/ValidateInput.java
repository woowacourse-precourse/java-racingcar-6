package racingcar.validate;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class ValidateInput {

    private static final int MAX_INPUT_LENGTH = 5;
    private static final String EMPTY_STRING = "";
    private static final String NAME_DELIMITER = ",";
    private static final String NON_EMPTY_STRING_MESSAGE = "비어있는 값을 입력할 수 없습니다.";
    private static final String LENGTH_ERROR_MESSAGE = "각 자동차의 이름은 5자 이하만 가능합니다.";
    private static final String NAME_DUPLICATE_ERROR_MESSAGE = "자동차의 이름은 중복될 수 없습니다.";

    public static void validateCarNames(String carNames) {
        validateNotEmpty(carNames);
        validateLength(carNames);
        validateDuplicate(carNames);
    }

    private static void validateDuplicate(String carNames) {
        List<String> carNameList = List.of(carNames.split(NAME_DELIMITER));
        Set<String> carNameSet = Set.of(carNames.split(NAME_DELIMITER));
        if (carNameList.size() != carNameSet.size()) {
            throw new IllegalArgumentException(NAME_DUPLICATE_ERROR_MESSAGE);
        }
    }

    private static void validateNotEmpty(String carName) {
        if (EMPTY_STRING.equals(carName)) {
            throw new IllegalArgumentException(NON_EMPTY_STRING_MESSAGE);
        }
    }

    private static void validateLength(String carNames) {
        if (hasOverLength(carNames)) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    private static boolean hasOverLength(String carNames) {
        return Stream.of(carNames.split(NAME_DELIMITER))
                .anyMatch(name -> name.length() > MAX_INPUT_LENGTH);
    }

}
