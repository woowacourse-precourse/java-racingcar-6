package racingcar;

import static java.util.Arrays.asList;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {

    private final String SEPERATE_NAME_CHAR = ",";
    
    List<String> carNames = new ArrayList<>();
    private int tryCount = 0;

    public void inputCarName() {
        String input = Console.readLine();
        List<String> carNames = asList(input.split(SEPERATE_NAME_CHAR));
        validateCarNames(carNames);
        this.carNames = carNames;
    }

    public void inputTryCount() {
        String count = Console.readLine();
        validateTryCount(count);
    }

    private void validateCarNames(List<String> carNames) {
        checkCarNamesSeparatedByCommas(carNames);
        checkExceedNameLength(carNames);
    }

    private void validateTryCount(String count) {
        checkNumber(count);
    }

    private void checkCarNamesSeparatedByCommas(List<String> carNames) {
        boolean separatedByCommas = carNames.stream()
                .allMatch(s -> s.chars().allMatch(Character::isLetterOrDigit));

        if (!separatedByCommas) {
            throw new IllegalArgumentException(RacingCarException.NOT_SEPARATED_BY_COMMAS_MSG);
        }
    }

    private void checkExceedNameLength(List<String> splits) {
        for (String split : carNames) {
            if (split.length() > 5) {
                throw new IllegalArgumentException(RacingCarException.EXCEED_LENGTH_MSG);
            }
        }
    }

    private void checkNumber(String count) {
        try {
            int i = Integer.parseInt(count);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(RacingCarException.NOT_NUMBER_MSG);
        }
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getTryCount() {
        return tryCount;
    }
}
