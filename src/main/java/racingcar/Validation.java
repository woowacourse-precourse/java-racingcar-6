package racingcar;

import java.util.regex.Pattern;

public class Validation {
    public void validateDelimiterType(String input) {
        String[] carNames = input.split(",", -1);
        String regex = "[a-zA-Z]+";

        for (String carName : carNames) {
            if (!Pattern.matches(regex, carName)) {
                throw new IllegalArgumentException("구분자는 쉼표(,)만 사용 가능 합니다.");
            }
        }
    }
}
