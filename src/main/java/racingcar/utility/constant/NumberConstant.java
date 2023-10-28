package racingcar.utility.constant;

public enum NumberConstant {
	MIN_NUMBER(0),
	MAX_NUMBER(9),
	FORWARD_POINT(4),
	MIN_LENGTH(1),
	MAX_LENGTH(5);


	private final int value;

	NumberConstant(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
