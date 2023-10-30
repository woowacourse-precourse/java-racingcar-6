package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.generator.NumberGenerator;

class MoveStrategyTest {
	@Test
	@DisplayName("4이상인 값이 들어오면 움직일 수 있는 상태이다.")
	void move_state(){
		// given
        MoveStrategy moveStrategy = new MoveStrategy();
		NumberGenerator numberGenerator = () -> 4;

        // when
		int actual = moveStrategy.move(numberGenerator);

        // then
        assertEquals(1, actual);
	}

	@Test
	@DisplayName("4이하의 값이 들어오면 움직일 수 없는 상태이다.")
	void not_move_state(){
		// given
		MoveStrategy moveStrategy = new MoveStrategy();
		NumberGenerator numberGenerator = () -> 3;

		// when
		int actual = moveStrategy.move(numberGenerator);

		// then
		assertEquals(0, actual);
	}
}