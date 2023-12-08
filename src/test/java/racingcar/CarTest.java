package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
	@BeforeEach
	void setUp() {
		car = new Car("Test");
		car.addMove(true);
	}
	Car car;
	@Test
	void testAddMove(){
		assertEquals(car.moved.get(0), "-");
	}
	@Test
	void testHowManyMoved(){
		assertEquals(car.howManyMoved(), 1);
	}
}
