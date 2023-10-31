package racingcar.model;

import java.util.regex.Pattern;

public class TrialCount {
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("^[0-9]*$");
    private Integer count;

    public TrialCount(String count) {
        validateNumeric(count);
        validatePositiveNumber(count);
        this.count = Integer.parseInt(count);
    }

    private void validateNumeric(String input){
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    private void validatePositiveNumber(String input){
        if(Integer.parseInt(input) < 1){
            throw new IllegalArgumentException("숫자는 0보다 커야 합니다.");
        }
    }

    public boolean isNotZero(){
        return count != 0;
    }

    public void consumed(){
        count--;
    }
}
