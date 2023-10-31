package racingcar.domain.enums;

public enum NumberTypeGameRule {
	MAX_CAR_NAME_LENGTH(5),
	MOVING_FORWARD(4),
	MIN_RAMDOM(0),
	MAX_RAMDOM(9)
	;

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
