package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoveStateTest {
	@Test
	@DisplayName("4이상인 값이 들어오면 움직일 수 있는 상태이다.")
	void move_state(){
		// given
        NumberGenerator numberGenerator = () -> 4;
        MoveState moveState = new MoveState(numberGenerator);

        // when
        boolean result = moveState.canMove();

        // then
        assertTrue(result);
	}

	@Test
	@DisplayName("4이하의 값이 들어오면 움직일 수 없는 상태이다.")
	void not_move_state(){
		// given
		NumberGenerator numberGenerator = () -> 3;
		MoveState moveState = new MoveState(numberGenerator);

		// when
		boolean result = moveState.canMove();

		// then
		assertFalse(result);
	}
}