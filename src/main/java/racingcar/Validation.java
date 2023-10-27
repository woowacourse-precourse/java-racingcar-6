package racingcar;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Validation {

    public void validateCarNames(String input) {
        String[] carNames = input.split(",", -1);

        validateDelimiterType(carNames);
        validateNameLength(carNames);
        int carNameCount = carNames.length;
        validateDuplicateName(carNameCount, carNames);
    }

    public void validateDelimiterType(String[] carNames) {
        String regex = "[a-zA-Z]+";

        for (String carName : carNames) {
            if (!Pattern.matches(regex, carName)) {
                throw new IllegalArgumentException("구분자는 쉼표(,)만 사용 가능 합니다.");
            }
        }
    }

    public void validateNameLength(String[] carNames) {

        for (String carName : carNames) {
            if (carName.length() > 5 || carName.length() < 1) {
                throw new IllegalArgumentException("자동차의 이름은 1 ~ 5자 사이로 지어주세요");
            }
        }
    }

    public void validateDuplicateName(int carNameCount, String[] carNames) {
        if (Arrays.stream(carNames).distinct().count() != carNameCount) {
            throw new IllegalArgumentException("중복된 자동차 이름은 사용할 수 없습니다.");
        }
    }

    public void validateGameRound(String input) {
        boolean result = input.chars().allMatch(Character::isDigit);

        if (!result) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }
}
