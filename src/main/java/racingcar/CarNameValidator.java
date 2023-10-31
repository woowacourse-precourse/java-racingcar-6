package racingcar;

public class CarNameValidator {
	public void validateCarName(String[] carArray) {
		for (int i = 0; i < carArray.length; i++) {
			if (carArray[i].length() == 0 || carArray[i].length() > 5) {
				throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다.");
			}
		}
	}
}
