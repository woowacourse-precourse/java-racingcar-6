package validation;

public class Validation {

	public void validateCarName(String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
		}
	}

	public void validateCarNamesFormat(String carNamesInput) {
		if (!carNamesInput.contains(",")) {
			throw new IllegalArgumentException("자동차 이름은 쉼표(,)로 구분되어야 합니다.");
		}
	}

}
