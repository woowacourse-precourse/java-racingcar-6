package racingcar.validator;

import java.util.List;

public class InputValidator {

	public static void validatePlayers(List<String> players) {
		for (String player : players) {
			if (player.length() > 5) {
				throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
			}
		}
	}

	public static void validateTryNumber(String tryNumber) {
		for(int i = 0 ; i < tryNumber.length(); i ++){
			if(tryNumber.charAt(i) < '0' || tryNumber.charAt(i) > '9'){
				throw new IllegalArgumentException("시도할 횟수는 정수로 주어져야 합니다.");
			}
		}
	}
}
