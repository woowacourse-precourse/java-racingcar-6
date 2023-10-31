package racingcar.view;

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
	
	public static void isCarNameRuleCorrect(String[] carNameStringArray) {
		for (int i=0; i<carNameStringArray.length; i++) {
			isStringBlank(carNameStringArray[i]);
			isUnderFive(carNameStringArray[i]);
		}
	}
	
	public static void isRoundNumberRuleCorrect(String roundNumberString) {
		isStringBlank(roundNumberString);
		isStringNumber(roundNumberString);
	}
	
	private static void isStringNumber(String str) {
		int i=0;
		while (i!=str.length()) {
			char c = str.charAt(i);
			isCharacterNumber(c);
			i++;
		}
	}
	
	private static void isCharacterNumber(char c) {
		if (!Character.isDigit(c)) {
			throw new IllegalArgumentException("숫자가 아닙니다.");
		}
	}
}