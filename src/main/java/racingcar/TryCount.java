package racingcar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TryCount {

    private static final String ZERO = "0";
    private static final String ZEROS = "^0+$";
    private static final String ZERO_HOLDER = "^0+";
    Pattern pattern = Pattern.compile(ZEROS);
    private static final int MAX_LENGTH = 9;
    private static final int MIN_VALUE = 1;
    private int tryCount;

    public TryCount(String input) {
        String refinedInput = refine(input);
        tryCount = validate(refinedInput);
    }

    private int validate(String refinedInput) {
        checkBlank(refinedInput);
        checkLength(refinedInput);
        int count = checkNumber(refinedInput);
        checkValue(count);
        return count;
    }

    private String refine(String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return ZERO;
        }
        return input.replaceFirst(ZERO_HOLDER, "");
    }

    private void checkBlank(String refinedInput) {
        if (refinedInput.isBlank()) {
            throw new IllegalArgumentException("시도 횟수를 입력해주세요.");
        }
    }

    private void checkLength(String refinedInput) {
        if (refinedInput.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("시도 횟수는 " + MAX_LENGTH + "자리 이하의 수여야 합니다.");
        }
    }

    private int checkNumber(String refinedInput) {
        int ans;
        try {
            ans = Integer.parseInt(refinedInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
        return ans;
    }

    private void checkValue(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 " + MIN_VALUE + "번 이상이어야 합니다.");
        }
    }

    public int getTryCount() {
        return tryCount;
    }
}