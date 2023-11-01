package racingcar;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class RacingCarGameTest {
	@Mock
	Car car1, car2, car3;

	@Test
	void 유효하지_않은_이름() {
		RacingCarGame game = new RacingCarGame();
		assertThrows(IllegalArgumentException.class, () -> {
			game.checkCar("carNameThatIsTooLong");
		});
	}

	@Test
	void 유효하지_않은_loop() {
		RacingCarGame game = new RacingCarGame();
		assertThrows(IllegalArgumentException.class, () -> {
			game.checkLoop("invalidInput");
		});
	}

	@Test
	void showWinner_DisplaysWinner() {
		RacingCarGame game = new RacingCarGame();
		List<Car> cars = new ArrayList<>();

		Car car1 = Mockito.mock(Car.class);
		Car car2 = Mockito.mock(Car.class);
		Car car3 = Mockito.mock(Car.class);

		when(car1.getName()).thenReturn("car1");
		when(car2.getName()).thenReturn("car2");
		when(car3.getName()).thenReturn("car3");

		cars.add(car1);
		cars.add(car2);
		cars.add(car3);

		when(cars.get(0).getDistance()).thenReturn(2);
		when(cars.get(1).getDistance()).thenReturn(3);
		when(cars.get(2).getDistance()).thenReturn(5);

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		game.showWinner(cars);

		String expectedOutput = "최종 우승자 : car3\n";
		assertEquals(expectedOutput, outContent.toString());
	}
}