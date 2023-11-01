//CarTest.java
package racingcar;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import camp.nextstep.edu.missionutils.Randoms;

class CarTest {
	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;

	//연습삼아 만든 mock을 활용한 테스트
	@Test
	void testMove_1() {
		try(final MockedStatic<Randoms> mock = mockStatic(Randoms.class)){
			mock.when(()->Randoms.pickNumberInRange(0, 9)).thenReturn(MOVING_FORWARD);
			Car car = new Car("TestCar");
			int initialMoveCount = car.getMoveCount();

			car.move();

			assertTrue(car.getMoveCount() >= initialMoveCount);
		}
	}

	@Test
	void testMove_2() {
		TestCar car = new TestCar("Car", MOVING_FORWARD);
		int initialMoveCount = car.getMoveCount();

		car.move();

		assertTrue(car.getMoveCount() > initialMoveCount);
	}

	@Test
	void testCheckIsFaster() {
		TestCar car1 = new TestCar("Car1", MOVING_FORWARD);
		TestCar car2 = new TestCar("Car2", STOP);

		car1.move();
		car2.move();

		assertTrue(car1.getMoveCount() > car2.getMoveCount());
	}

	@Test
	void testCheckIsSame(){
		TestCar car1 = new TestCar("Car1", MOVING_FORWARD);
		TestCar car2 = new TestCar("Car2", MOVING_FORWARD);

		car1.move();
		car2.move();

		assertTrue(car1.getMoveCount() == car2.getMoveCount());
	}
}
