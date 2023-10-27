package racingcar.dto;

public class Rule {
	public static void isStringBlank(String str) {
		if (str.isBlank()) {
			throw new IllegalArgumentException("이름이 비어있습니다.");
		}
	}
	
	public static void isUnderFive(String str) {
		if (str.length()>5) {
			throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
		}
	}
	
	public static void isRuleCorrect(String[] str) {
		for (int i=0; i<str.length; i++) {
			isStringBlank(str[i]);
			isUnderFive(str[i]);
		}
	}
}