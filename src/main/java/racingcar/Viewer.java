package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Viewer {
    private final String CAR_NAME_DELIMITER = ",";
    private final String INVALID_CAR_NAME_LENGTH = "자동차 이름은 5자 이하만 가능합니다.";
    private final String INVALID_CAR_NAME_DELIMITER = "쉼표(,)로 구분해주세요.";

    public List<String> inputCarNames() {
        List<String> carNameList = Arrays
                .stream(readLine().split(CAR_NAME_DELIMITER))
                .toList();
        validateCarNameList(carNameList);
        return carNameList;
    }

    private void validateCarNameList(List<String> carNames) {
        carNames.forEach(this::validateCarName);
    }

    private void validateCarName(String carName) {
        validateCarNameLength(carName);
        validateCarNameType(carName);
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH);
        }
    }
    private void validateCarNameType(String carName) {
        if (Pattern.matches("^[a-zA-Z]*$", carName)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_DELIMITER);
        }
    }
}
