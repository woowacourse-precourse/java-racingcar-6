package racingcar.model;

import java.util.regex.Pattern;

public class RacingCount {
	private final int count;
	private static final String COUNT_FORMAT = "^[0-9]+$";
	
	public RacingCount(int count) {
		validateCountRange(count);
		//validateCountCharacter(count);
		this.count = count;
	}
	
	private void validateCountRange(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("반복 횟수는 자연수여야 합니다.");
        }
    }
	
	private void validateCountCharacter(String count) {
		if (!Pattern.matches(COUNT_FORMAT, count)) {
            throw new IllegalArgumentException("숫자 형태로 입력해주세요.".toString());
        }
	}
	
}
