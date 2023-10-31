package racingcar;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Ready {

	public static String[] checkCondition(String str) {
		if (str.isEmpty() == true) // 빈 문자열인 경우
			throw new IllegalArgumentException("입력값을 확인해 주세요.");

		// 빈 문자열이 아닌 경우
		String[] carList = str.split(",");
		String[] small = str.toLowerCase().split(",");
		String[] duplication = Arrays.stream(small).distinct().toArray(String[]::new);

		if (carList.length != duplication.length)// 중복 제거(대소문자 구분 없음)
			throw new IllegalArgumentException("중복된 이름의 자동차가 있습니다.");

		if ((str.contains(" ")) == true || (str.charAt(str.length() - 1) == ','))
			throw new IllegalArgumentException("이름은 쉼표(,) 기준으로 구분되며, 공백 입력 여부를 확인해 주세요.");

		for (int i = 0; i < carList.length; i++) {
			checkLength(carList[i]);
		}
		return carList;
	}

	private static void checkLength(String name) {
		if (name.length() > 5)
			throw new IllegalArgumentException("이름은 1글자 이상 5글자 이하로 작성해 주세요.");
	}

	public static void isDigit(String times) {
		String tmp = "^[0-9]*$";
		if (Pattern.matches(tmp, times) != true)
			throw new IllegalArgumentException("입력값을 확인해 주세요.");
	}
}