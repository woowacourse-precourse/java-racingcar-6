package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {
	@Test
	@DisplayName("자동차는 0 이하의 위치를 가질 수 없다.")
	void position_cannot_under_zero() {
		assertThrows(IllegalArgumentException.class, ()-> new Position(-1));
	}

	@Test
	@DisplayName("위치를 추가하여 새로운 위치 객체를 생성할 수 있다.")
	void add_position() {
		// given
		Position position = new Position(0);

		// when
		Position movedPosition = position.add(1);

		// then
        assertEquals(1, movedPosition.getPosition());
	}
}