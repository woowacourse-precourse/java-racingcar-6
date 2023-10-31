package racingcar.domain.enums;

public enum ValidationMsg {
	NULL_TYPE("입력하신 값은 NULL이 될 수 없습니다."),
	EMPTY_TYPE("자동차 경주 게임에서 사용될 값이 입력되지 않았습니다."),
	CAR_NAME_OVER_FIVE("자동차의 이름은 5자 이하만 가능합니다."),
	NOT_DUPLICATE_NAME("[ERROR] 자동차의 이름들은 중복될 수 없습니다."),
	NOT_NUMBER("[ERROR] 숫자만 입력해주세요."),
	ZERO_TYPE("[ERROR] 자동차 경주 게임에서 사용될 값은 0이 될 수 없습니다."),
	PROPER_TYPE("바르게 입력되었습니다.");

	private String value;
	ValidationMsg(String value) {
		this.value = value;
	}

	public String getKey() {
		return name();
	}

	public String getValue() {
		return value;
	}
}
