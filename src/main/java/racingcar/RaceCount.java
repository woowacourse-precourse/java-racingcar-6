package racingcar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RaceCount {

    public void validateNumber(String count) {
        if (!isNumber(count)) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자로 입력해야 합니다.");
        }
    }

    private boolean isNumber(String count) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(count);
        return matcher.matches();
    }

    public void validateRange(String number) {
        if (!isInRange(number)) {
            throw new IllegalArgumentException("[ERROR] 0보다 큰 숫자를 입력해야합니다.");
        }
    }

    private boolean isInRange(String number) {
        return Integer.parseInt(number) > 0;
    }
}
