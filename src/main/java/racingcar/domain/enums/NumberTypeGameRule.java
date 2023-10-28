package racingcar.domain.enums;

public enum NumberTypeGameRule {
	MAX_CAR_NAME_LENGTH(5);

	private final int value;

	NumberTypeGameRule(int value) {
		this.value = value;
	}

	public String getKey() {
		return name();
	}

	public Integer getValue() {
		return value;
	}
}
