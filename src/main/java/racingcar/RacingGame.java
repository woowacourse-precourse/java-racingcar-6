package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.Utils.*;

public class RacingGame {
    private final int MINIMUM_NUMBER_OF_NAME = 2;
    private final String ERROR_NOT_ENOUGH_NUMBER_OF_NAME = "충분한 수가 아닙니다. 최소 2개 이상 입력해주세요.";
    private final int MAXIMUM_LENGTH_OF_NAME = 5;
    private final String ERROR_EXCESS_LENGTH_OF_NAME = "5자 이하의 이름만 입력해주세요";
    private int howManyTries;
    private final Referee referee = new Referee();

    private List<String> mapToListAndValidateName(String carNames) {
        List<String> carNameList = splitToListBySeparator(carNames);
        checkIfExcessLengthOfName(carNameList);
        checkIfEnoughNumberOfName(carNameList);
        return carNameList;
    }

    private void checkIfEnoughNumberOfName(List<String> names) {
        if (names.size() < MINIMUM_NUMBER_OF_NAME) {
            throw new IllegalArgumentException(ERROR_NOT_ENOUGH_NUMBER_OF_NAME);
        }
    }

    private void checkIfExcessLengthOfName(List<String> names) {
        for (String name : names) {
            if (name.length() > MAXIMUM_LENGTH_OF_NAME) {
                throw new IllegalArgumentException(ERROR_EXCESS_LENGTH_OF_NAME);
            }
        }
    }
}
