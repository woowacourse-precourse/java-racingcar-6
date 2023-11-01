package racingcar.domain.car;

import java.util.Objects;

public class Position implements Comparable<Position> {

	private static final int MIN_CAR_POSITION = 0;
	private final int position;

	public Position() {
		this(MIN_CAR_POSITION);
	}

	public Position(int position) {
		validate(position);
		this.position = position;
	}

	private void validate(int position) {
		if (position < MIN_CAR_POSITION) {
			throw new IllegalArgumentException("자동차 위치는 음수 값을 가질 수 없습니다.");
		}
	}

	public Position add(int position) {
		return new Position(this.position + position);
	}

	public int getPosition() {
		return position;
	}


	@Override
	public int compareTo(Position o) {
		return this.position - o.position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Position position = (Position) o;
		return getPosition() == position.getPosition();
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}
}
