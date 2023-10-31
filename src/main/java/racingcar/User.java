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
            throw new IllegalArgumentException("이름은 쉼표(,)로 구분해주세요.");
        }
    }

    private void checkExceedNameLength(List<String> splits) {
        for (String split : carNames) {
            if (split.length() > 5) {
                throw new IllegalArgumentException("이름을 5자 이내로 입력해주세요.");
            }
        }
    }

    private void checkNumber(String count) {
        try {
            int i = Integer.parseInt(count);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getTryCount() {
        return tryCount;
    }
}
