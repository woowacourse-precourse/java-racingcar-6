package racingcar.model;

import static java.util.Arrays.asList;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.exception.RacingCarException;

public class User {

    private final String SEPERATE_NAME_CHAR = ",";
    private final int MAX_NAME_LENGTH = 5;

    List<String> carNames = new ArrayList<>();
    private int tryCount = 0;

    public void inputCarName() {
        String input = Console.readLine();
        List<String> carNames = asList(split(input));
        validateCarNames(carNames);
        this.carNames = carNames;
    }

    public void inputTryCount() {
        String count = Console.readLine();
        validateTryCount(count);
        this.tryCount = Integer.parseInt(count);
    }

    public String[] split(String input) {
        return input.split(SEPERATE_NAME_CHAR);
    }

    private void validateCarNames(List<String> carNames) {
        checkNameLength(carNames);
        checkNameEmpty(carNames);
    }

    private void checkNameEmpty(List<String> carNames) {
        for (String split : carNames) {
            if (split.isBlank()) {
                throw new IllegalArgumentException(RacingCarException.INVALID_BLANK_NAME_MSG);
            }
        }
    }

    private void validateTryCount(String count) {
        checkCountLength(count);
        checkCountNumber(count);
    }

    private void checkCountLength(String count) {
        if (count.isEmpty()) {
            throw new IllegalArgumentException(RacingCarException.INVALID_TRY_COUNT_LENGTH_MSG);
        }
    }

    private void checkNameLength(List<String> splits) {
        for (String split : splits) {
            if (split.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(RacingCarException.INVALID_CAR_NAME_LENGTH_MSG);
            }
        }
    }

    private void checkCountNumber(String count) {
        try {
            int i = Integer.parseInt(count);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(RacingCarException.INVALID_NUMBER_MSG);
        }
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getTryCount() {
        return tryCount;
    }
}
