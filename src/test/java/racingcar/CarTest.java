package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
public class CarTest extends NsTest {

	/**
	 * 차가 이동하기 전의 스코어를 받고 이동한 후의 스코어를 받아서
	 *  이동했다면 스코어가 다르고 이동하지 않았다면 스코어 같음을 테스트
	 */
	@Test
	void testMoveFunctionWhenCantMove() {
		Car car = new Car("김락윤");
		boolean canMove = car.canMove(1);
		car.move(canMove);
		int score = car.getScore();

		assertEquals(score, 0);
	}

	@Test
	void testMoveFunctionWhenCanMove() {
		Car car = new Car("김락윤");
		boolean canMove = car.canMove(5);
		car.move(canMove);
		int score = car.getScore();

		assertEquals(score, 1);
	}



	@Test
	void testDisplayFunction(){
		Car car = new Car("김락윤");
		assertEquals(car.display(),"김락윤 : ");
	}

	@Test
	void testCarConstructor(){
		Car car = new Car("김락윤");
		assertEquals(car.name,"김락윤");
	}


	@Override
	protected void runMain() {

	}
}
