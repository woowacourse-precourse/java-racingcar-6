package validation;

public class Validation {

	 /**
     * 자동차 이름의 유효성을 검사합니다. 이름이 5자 이상인 경우 예외를 발생시킵니다.
     *
     * @param name 자동차 이름
     */
    public void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    /**
     * 자동차 이름 형식의 유효성을 검사합니다. 이름이 쉼표(,)로 구분되지 않으면 예외를 발생시킵니다.
     *
     * @param carNamesInput 자동차 이름들의 입력 문자열
     */

	public void validateCarNamesFormat(String carNamesInput) {
		if (!carNamesInput.contains(",")) {
			throw new IllegalArgumentException("자동차 이름은 쉼표(,)로 구분되어야 합니다.");
		}
	}

}
