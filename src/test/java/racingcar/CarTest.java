package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
	Car car;
	@BeforeEach
	void setUp() {
		car = new Car("Test");
		car.addMove(true);
	}
	@Test
	void testAddMove(){
		assertEquals(car.moved.get(0), "-");
	}
	@Test
	void testHowManyMoved(){
		assertEquals(car.howManyMoved(), 1);
	}
}
