package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CarTest {
	Car car;
	@Test
	void testAddMove(){
		car = new Car("Test");
		car.addMove(true);
		assertEquals(car.moved.get(0), "-");
	}
}
