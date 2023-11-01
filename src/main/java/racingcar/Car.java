package racingcar;

public final class Car {
	private final String name;
	private final StringBuilder current;
	private int distance;

	public Car(final String playerName) {
		if (playerName.length() > 5) {
			throw new IllegalArgumentException("사용자의 이름은 5글자 이하여야 합니다.");
		}
		this.name = playerName;
		this.current = new StringBuilder(String.format("%s : ", playerName));
		this.distance = 0;
	}

	public String name() {
		return name;
	}

	public int distance() {
		return distance;
	}

	public void advance(final int hold) {
		if (hold < 4) {
			return;
		}
		this.current.append('-');
		this.distance++;
	}

	@Override
	public String toString() {
		return current.toString();
	}
}
