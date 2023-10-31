package racingcar.domain;

public class Car {
	public static final String WRONG_NAME_LENGTH_EXCEPTION_MESSAGE = "자동차 이름이 올바르지 않습니다. (5자 이하의 이름을 입력해주세요.)";
	public static int INIT_DISTANCE = 0;

	private final String name;
	private int distance;

	private Car(String name) {
		validateName(name);

		this.name = name;
		this.distance = INIT_DISTANCE;
	}

	public static Car from(String name) {
		return new Car(name);
	}

	public void move() {
		distance += 1;
	}

	public String getName() {
		return name;
	}

	public int getDistance() {
		return distance;
	}

	public void validateName(String name){
		if (name.length() > 5 || name.length() < 1) {
			throw new IllegalArgumentException(WRONG_NAME_LENGTH_EXCEPTION_MESSAGE);
		}
	}
}
